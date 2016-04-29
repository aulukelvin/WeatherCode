/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.config;

import aaa.bbb.ccc.codingtest.driver.OpenWeatherMapRESTService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import aaa.bbb.ccc.codingtest.driver.WeatherProviderService;

/**
 *
 * @author kelvin
 */
	
@Configuration
public class AppConfig {
    @Bean
    public WeatherProviderService getWeatherProviderService() {
        return new OpenWeatherMapRESTService();
    }

}
