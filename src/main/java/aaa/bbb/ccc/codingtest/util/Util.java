/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.util;

import aaa.bbb.ccc.codingtest.config.AppConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author kelvin
 */
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
@Component
public class Util {
    public Util(String _url, String _city, String _country, String _appId) {
        URL_Template = _url;
        defaultCity = _city;
        defaultCountry = _country;
        AppId = _appId;
    }
    
    private String URL_Template;

    private String defaultCity;

    private String defaultCountry;
    
    private String AppId;

    
    public String getURL(String city, String country){
        String result = URL_Template;
        
        result = !StringUtils.isEmpty(city) 
                    ? result.replace("<<City>>", city)
                    : result.replace("<<City>>", defaultCity);
        result = !StringUtils.isEmpty(country) 
                    ? result.replace("<<Country>>", country)
                    : result.replace("<<Country>>", defaultCountry);
        result = result.replace("<<AppId>>", AppId);
        return result;
    }
}
