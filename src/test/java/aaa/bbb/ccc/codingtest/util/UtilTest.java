/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.util;

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
public class UtilTest {
    @Autowired
    private Util stub;
    
    private String EXPECTED_URL = "http://api.openweathermap.org/data/2.5/weather?q=Melbourne,USA&appid=96b5628bb8851ba401a3712a6cf06e25";
    private Object EXPECTED_URL_WithoutCity = "http://api.openweathermap.org/data/2.5/weather?q=Sydney,USA&appid=96b5628bb8851ba401a3712a6cf06e25";;
    private Object EXPECTED_URL_WithoutCountry = "http://api.openweathermap.org/data/2.5/weather?q=Melbourne,AU&appid=96b5628bb8851ba401a3712a6cf06e25";;
    
    public UtilTest() {
    }

    /**
     * Test of getURL method, of class Util.
     */
    @Test
    public void testGetURL() {
        String result = stub.getURL("Melbourne", "USA");
        System.out.println(result);
        assertEquals("",EXPECTED_URL,result);
    }
    @Test
    public void testGetURLWithoutCity() {
        String result = stub.getURL(null, "USA");
        System.out.println(result);
        assertEquals("",EXPECTED_URL_WithoutCity,result);
    }
    @Test
    public void testGetURLWithoutCountry() {
        String result = stub.getURL("Melbourne", null);
        System.out.println(result);
        assertEquals("",EXPECTED_URL_WithoutCountry,result);
    }
}
