package ru.mitzury;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class cmd extends Bot {

    public static Object inputmsg(String msg, String chatId, String uName, String uSecondName, String uNick, double lat, double lon) {
        String mark = "\u2755"; // Серый восклицательный знак
        String coff = "\u2668"; // Чашка кофе
        String darr = "\u2198"; // Стрелочка вниз
        String WelcomeMessage = mark + "Добро пожаловать" + mark + "\n"
                + "Я Java " + coff + "Telegram бот." + "\n"
                + "Жми на кнопки " + darr + " и узнай погоду" + "\n"
                + "Для справки нажми /help";
        // https://core.telegram.org/blackberry/chat-emoji
        String HelpMessage = mark + "Я могу подсказать погоду 'на сейчас', 'на завтра' так же могу отсылать каждое утро";

        return switch (msg) {
            case ("/start") -> WelcomeMessage;
            case ("/help") -> HelpMessage;
            case ("Погода сейчас: локация") -> inputloc(msg, chatId, uName, uSecondName, uNick, lat, lon);
            case ("subscribe") -> service.subscribe(chatId, uName, uSecondName, uNick,lat,lon);
            case ("unsubscribe") -> service.unsubscribe(chatId, uName, uSecondName, uNick,lat,lon);
            case ("Погода сейчас: Санкт Петербург") -> weather.parseWeather(lat, lon, "Saint%20Petersburg").toString();
            case ("Погода сейчас: Москва") -> weather.parseWeather(lat, lon, "Moscow").toString();

            default -> "Я не знаю чем помочь, для справки введи /help";
        };
    }
    public static Object inputloc(String msg, String chatId, String uName, String uSecondName, String uNick, double lat, double lon) {
        return  service.getUserLoc(chatId, uName, uSecondName, uNick, lat,lon);

    }
    public static ReplyKeyboardMarkup welcomeKeyboard() {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Создаем кнопки в первую строчку клавиатуры
        KeyboardButton keySPB = new KeyboardButton();
        keySPB.setText("Погода сейчас: Санкт Петербург");
        KeyboardButton keyMSK = new KeyboardButton();
        keyMSK.setText("Погода сейчас: Москва");
        // Добавляем кнопки в первую строку клавиатуры
        keyboardFirstRow.add(keySPB);
        keyboardFirstRow.add(keyMSK);
        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        KeyboardButton keyLOC = new KeyboardButton();
        keyLOC.setText("Погода сейчас: локация");
        keyboardSecondRow.add(keyLOC);
        keyLOC.getRequestLocation();
        keyLOC.setRequestLocation(true);
        // Третья строчка клавиатуры
        KeyboardRow keyboardRow3 = new KeyboardRow();
        //Создаем кнопки для третьей строчки
        KeyboardButton subscribe = new KeyboardButton();
        subscribe.setText("subscribe");
        KeyboardButton unsubscribe = new KeyboardButton();
        unsubscribe.setText("unsubscribe");
        //Добавляем кнопки в третью строку
        keyboardRow3.add(subscribe);
        keyboardRow3.add(unsubscribe);
        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardRow3);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
