/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 *
 * @author klu
 */
public class CacheFactory {

    private static final Logger logger = Logger.getLogger(CacheFactory.class);

    private class  CacheEntry<T>  {

        CacheLoader<String, T> cacheLoader;
        LoadingCache<String, T> cacheInstance;

        CacheEntry(CacheLoader<String, T> _cacheLoader) {
            cacheLoader = _cacheLoader;
            cacheInstance = CacheBuilder
                    .newBuilder()
                    .maximumSize(1000)
                    .initialCapacity(30)
                    .recordStats()
                    .refreshAfterWrite(15, TimeUnit.MINUTES)
                    .build(_cacheLoader);
        }
    }
    private static final ConcurrentHashMap<CacheNames, CacheEntry> cacheRegistery = new ConcurrentHashMap();

    public <T> void registerCache(CacheNames cacheName, CacheLoader<String, T> cacheLoader) {
        if (null ==cacheName || null == cacheLoader) {
            throw new IllegalArgumentException();
        } else if (cacheRegistery.containsKey(cacheName)) {
            logger.info("Cache " + cacheName + " already registered.");
        } else {
            CacheEntry cacheEntry = new CacheEntry(cacheLoader);
            cacheRegistery.put(cacheName, cacheEntry);
            logger.info("Cache " + cacheName + " successfully registered. There're totally " + cacheRegistery.size() + " caches.");
        }
    }

    public static Set<CacheNames> getAllCaches() {
        return cacheRegistery.keySet();
    }

    public static <T>  LoadingCache<String, T> getCache(CacheNames cacheName) {
        CacheEntry entry = cacheRegistery.get(cacheName);
        return (null == entry
                    ? null
                    : entry.cacheInstance);
    }

}
