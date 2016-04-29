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
import aaa.bbb.ccc.codingtest.frontend.FrontEndService;
import aaa.bbb.ccc.codingtest.util.Util;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author kelvin
 */
	
@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
            return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public WeatherProviderService getWeatherProviderService() {
        return new OpenWeatherMapRESTService();
    }
    @Bean
    public Util getUtil() {
        return new Util(URL_Template,defaultCity,defaultCountry,AppId);
    }
    @Bean
    public FrontEndService getFronEndService() {
        return new FrontEndService();
    }
    
    @Value("${OpenWeatherMap.Curret.URL_Template}")
    private String URL_Template;

    @Value("${OpenWeatherMap.Curret.Default_City}")
    private String defaultCity;

    @Value("${OpenWeatherMap.Curret.Default_Country}")
    private String defaultCountry;
    
    @Value("${OpenWeatherMap.AppId}")
    private String AppId;

    
}
