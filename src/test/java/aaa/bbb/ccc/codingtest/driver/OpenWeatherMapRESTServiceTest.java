/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.driver;

import aaa.bbb.ccc.codingtest.config.AppConfig;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author kelvin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class OpenWeatherMapRESTServiceTest {
    
    public OpenWeatherMapRESTServiceTest() {
    }
    
    @Autowired
    private WeatherProviderService stub;

    /**
     * Test of getCurrent method, of class OpenWeatherMapRESTDriver.
     */
    @Test
    public void testGetCurrent() {
        assertNotNull(stub.getCurrent("Sydney", "au"));
    }

    
    
}
