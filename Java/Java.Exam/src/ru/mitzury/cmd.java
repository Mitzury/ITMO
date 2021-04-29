package ru.mitzury;

public class cmd extends Bot {

    public static Object inputmsg(String msg)  {
        String bananaEmoji = "\uD83C\uDF4C";
        // https://core.telegram.org/blackberry/chat-emoji

        return switch (msg) {
            case ("/start") -> "Добро пожаловать." + bananaEmoji + "Чтобы узнать все команды набери /help";
            case ("hi") -> "Привет друг";
            case ("bye") -> "Прощай друг";
            case ("Узнать погоду на сейчас") -> weather.parseWeather().toString();
            default -> "Я не знаю чем помочь";
        };
    }

}
