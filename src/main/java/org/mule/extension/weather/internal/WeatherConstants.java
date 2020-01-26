package org.mule.extension.weather.internal;

import org.mule.runtime.api.util.MultiMap;

public class WeatherConstants {
    public static final String ZIP = "Get weather by ZIP";
    public static final String chYahoo = "Yahoo";
    public static final String chOpenWthr = "OpenWeather";
    public static final String chApixu = "APIXU";

    public static final String chOpenWthrKey = "fdfd2cd1083b8f8c795c37f373c1c3e1"; // these are they keys linked to the open weather account for retreiving weather data
    public static final String chApixuKey = "7c0919f035ac477b0b3f6f7599cd48f6"; // these keys are linked to apixu for the purpose of retrieving the live data


    private WeatherConstants() {

    }

    /**
     *
     * @param channel
     * @return
     */
    public static String getUrl(String channel) {
        switch (channel) {
            case chYahoo:
                return ("https://query.yahooapis.com/v1/public/yql"); // endpoint of yahoo api
            case chOpenWthr:
                return ("http://api.openweathermap.org/data/2.5/forecast"); // endpoint of openweather api for forecasting
            case chApixu:
                return ("http://api.apixu.com/v1/current.json"); // endpoint of api xu
        }
        return null;
    }


    /**
     *
     * @param wChannel
     * @param zip
     * @return
     */
    public static MultiMap<String, String> getQueryForZip(String wChannel, int zip) {
        MultiMap<String, String> q = new MultiMap<String, String>();
        if(wChannel.equals(chYahoo)) {
            q.put("q", "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text='" + zip + "')");
            q.put("format", "json");
            q.put("env", "store://datatables.org/alltableswithkeys");
        }

        if(wChannel.equals(chOpenWthr)) {
            q.put("zip", zip+ ",in"); // here we are constructing request by appending the zip code and country code
            q.put("APPID", chOpenWthrKey); // here we are appending the api key for particular api like yahoo, open weather and api xu
        }

        if(wChannel.equals(chApixu)) {
            q.put("q", Integer.toString(zip)); // here we are constructing request by using the zip code
            q.put("key", chApixuKey); // adding the chapixukey in the query param
        }
        return q;
    }

}
