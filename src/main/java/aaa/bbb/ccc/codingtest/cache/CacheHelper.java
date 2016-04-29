/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.cache;

import aaa.bbb.ccc.codingtest.config.AppConfig;
import aaa.bbb.ccc.codingtest.driver.WeatherProviderService;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author klu
 */
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class CacheHelper {
    private static final Logger logger = Logger.getLogger(CacheHelper.class);
    private CacheFactory cf = new CacheFactory();
    private static int counter=0;
    
    @Autowired
    private WeatherProviderService provider;
    
    {
        registerCurrentWeatherInfoCache();
    }
    
    private void registerCurrentWeatherInfoCache() {
        CacheLoader<String, String> cl = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                logger.debug("loading current weather information for " + key);
                
                return provider.getCurrent(key, null);
            }
            @Override
            public ListenableFuture<String> reload(final String key, String oldValue) throws Exception {
              ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));
              ListenableFuture<String> listenableFuture = pool.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                  System.out.println("Async reload event");
                  return load(key);
                }
              });
              return listenableFuture;
            }
        };
        cf.registerCache(CacheNames.Current, cl);
    }

    
    
    public LoadingCache<String,String> getCache(CacheNames cacheName) {
        if (counter++ >= 10) {
            counter =0;
            logger.info("Cache stats for " +cacheName + ": " + CacheFactory.getCache(cacheName).stats());
        }
        return CacheFactory.getCache(cacheName);
    }
}
