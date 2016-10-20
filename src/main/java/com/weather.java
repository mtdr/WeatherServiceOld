package com;


import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;


public class weather {

    // 2122265 - moscow
    // 2123260 - saint-p
    public static void main(String[] args) throws JAXBException, IOException {
        YahooWeatherService service = new YahooWeatherService();
//            Channel result = service.getForecast("2123260", DegreeUnit.CELSIUS);
//            System.out.println(result.getDescription());
//            System.out.println(result.getTitle());
//            System.out.println(result.getWind());
//            System.out.println(result.getAtmosphere());
//            System.out.println(result.getLink());
//            System.out.println(result.getItem().getForecasts());
//            System.out.println(result.getItem().getCondition());
        String id = "Moscow";

        List<Channel> channels = service.getForecastForLocation(id, DegreeUnit.CELSIUS).first(1);
        for (Channel channel:channels){
            System.out.println(channel.getTitle());
            System.out.println(channel.getItem().getCondition());
        }
    }

    public static String showWeather(String idCity) throws JAXBException, IOException {
        String res = "";
        YahooWeatherService service = new YahooWeatherService();
        List<Channel> channels = service.getForecastForLocation(idCity, DegreeUnit.CELSIUS).first(1);
        for (Channel channel:channels)
            res = channel.getItem().getCondition().toString();
        return res;
    }

}
