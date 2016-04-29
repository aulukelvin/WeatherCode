/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.frontend;

import aaa.bbb.ccc.codingtest.config.AppConfig;
import aaa.bbb.ccc.codingtest.driver.WeatherProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author kelvin
 */
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class FrontEndService {
    @Autowired
    WeatherProviderService providerService;
    
    public String getCurrentWeatherByCityName(String _cityName) {
        return providerService.getCurrent(_cityName, null);
    }
}
