/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.driver;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author kelvin
 */
public class OpenWeatherMapRESTService implements WeatherProviderService 
{
    @Override
    public void connect(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    @Override
    public String getCurrent(String city, String country){
        Client client = Client.create();

        WebResource webResource = client
           .resource("http://api.openweathermap.org/data/2.5/weather?q=2031,au&appid=96b5628bb8851ba401a3712a6cf06e25");

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
