package ru.mitzury;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws TelegramApiException, InterruptedException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        try
        {
            telegramBotsApi.registerBot(bot);
            //Выводим в консоль что бот запустился.
            System.out.println("Bot running...");
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

        /*
        int lt = LocalDateTime.now().getHour();
        while (lt != 6) {
            Thread.sleep(2000);
            
        }
        */
    }


}
