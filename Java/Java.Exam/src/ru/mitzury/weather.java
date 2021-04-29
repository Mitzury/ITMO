package ru.mitzury;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class weather {

    public static String getWeather () {

       String url ="http://api.openweathermap.org/data/2.5/weather?q=Saint%20Petersburg,RU?&APPID={app-id}&lang=RU&units=metric";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputline;
            StringBuffer response = new StringBuffer();
            while ((inputline = in.readLine()) != null) {
                response.append(inputline);
            }
            in.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static result parseWeather () {
       JSONObject weather = new JSONObject(getWeather());
      String cityname = weather.getString("name");
       double citytemp = weather.getJSONObject("main").getDouble("temp");
        double feeltemp = weather.getJSONObject("main").getDouble("feels_like");
        double humidity = weather.getJSONObject("main").getDouble("humidity");

        return new result(cityname,citytemp,feeltemp,humidity);
    }

}
