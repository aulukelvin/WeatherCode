/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.driver;

import aaa.bbb.ccc.codingtest.util.Util;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kelvin
 */
public class OpenWeatherMapRESTService implements WeatherProviderService 
{
    @Autowired
    Util util;
    @Override
    public void connect(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    @Override
    public String getCurrent(String city, String country){
        Client client = Client.create();
        String url = util.getURL(city, country);
        WebResource webResource = client
           .resource(url);

        ClientResponse response = webResource.accept("application/json")
           .get(ClientResponse.class);

        if (response.getStatus() != 200) {
           throw new RuntimeException("Failed : HTTP error code : "
                + response.getStatus());
        }

        String output = response.getEntity(String.class);

        return output;

    }

    @Override
    public String get5DaysForecast(String city, String country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get16DaysForecast(String city, String country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
