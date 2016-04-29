/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa.bbb.ccc.codingtest.driver;

/**
 *
 * @author kelvin
 */
public interface WeatherProviderService {
    public void connect();
    public String getCurrent(String city, String country);
    public String get5DaysForecast(String city, String country);
    public String get16DaysForecast(String city, String country);
}
