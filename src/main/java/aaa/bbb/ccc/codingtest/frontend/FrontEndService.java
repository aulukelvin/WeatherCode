/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.frontend;

import aaa.bbb.ccc.codingtest.config.AppConfig;
import aaa.bbb.ccc.codingtest.driver.WeatherProviderService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author kelvin
 */
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
@Component
@Path("/weather")
public class FrontEndService {
    @Autowired
    WeatherProviderService providerService;
    
    @GET
    @Path("/current/{city}")
    @Produces({ MediaType.APPLICATION_JSON })
    public String getCurrentWeatherByCityName(@PathParam("city") String _cityName) {
        return providerService.getCurrent(_cityName, null);
    }
    
    @GET
    @Path("/current")
    @Produces({ MediaType.APPLICATION_JSON })
    public String getCurrentWeatherByCityName() {
        return providerService.getCurrent(null, null);
    }
}
