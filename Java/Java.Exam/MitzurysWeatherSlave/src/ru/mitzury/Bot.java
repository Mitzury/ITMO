package ru.mitzury;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

public class Bot extends TelegramLongPollingBot {
    public String chatId;
    public String uName;
    public String mytime;
    public String message;
    public String uSecondName;
    public String uNick;

    public void sndMsg(String uChatId) throws InterruptedException {
        Thread.sleep(5000);
        service.sending();
        SendMessage msg = new SendMessage();
        msg.setChatId(uChatId);
        msg.setText((String) "Test рассылка");
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    //Прием сообщений. Лонгпулю Очередь ожидающих запросов. Запрос отправляется на сервер пока не появится новое событие.
    public void onUpdateReceived(Update update) {
        // Проверка на сообщение
        if (update.hasMessage()) {
            // Проверка что оно текст
            if (update.getMessage().hasText()) {
                // Принимаем текст от пользователя
                this.message = update.getMessage().getText().trim();
                this.chatId = update.getMessage().getChatId().toString();
                this.mytime = new Date((long) update.getMessage().getDate() * 1000).toString();
                //Данные о пользователе
                User user = update.getMessage().getFrom();
                this.uName = user.getFirstName();
                this.uSecondName = user.getLastName();
                this.uNick = user.getUserName();
                double lat = 0;
                double lon = 0;
                //Пишем лог в консоль бота.
                System.out.println("Пользователь: " + user.getFirstName() + " " + user.getLastName() + " aka " + user.getUserName() + " написал: "
                        + message + " at " + mytime + " " + chatId);
                SendMessage msg = new SendMessage();
                msg.setChatId(chatId);
                msg.setText((String) cmd.inputmsg(message, chatId, uName, uSecondName, uNick, lat, lon));
                // Добавляем клавиатуру
                msg.setReplyMarkup(cmd.welcomeKeyboard());

                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                // Если геолокация.
            } else if (update.getMessage().hasLocation()) {

                this.chatId = update.getMessage().getChatId().toString();
                User user = update.getMessage().getFrom();
                this.uName = user.getFirstName();
                this.uSecondName = user.getLastName();
                this.uNick = user.getUserName();
                double lat = update.getMessage().getLocation().getLatitude();
                double lon = update.getMessage().getLocation().getLongitude();
                SendMessage msg = new SendMessage();
                msg.setChatId(chatId);
                msg.setText((String) cmd.inputloc(message, chatId, uName, uSecondName, uNick, lat, lon));
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "WSMitzurysBot";
    }

    @Override
    public String getBotToken() {
        return "1711549871:AAG2NqTMMseHZ9OYleVUNI8E0gyZCG8O3VA";
    }
}