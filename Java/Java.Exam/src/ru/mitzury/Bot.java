package ru.mitzury;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    // Инициализируем клавиатуру


    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
                // Принимаем текст от пользователя
                String message = update.getMessage().getText().trim();
                String chatId = update.getMessage().getChatId().toString();
                String mytime = new Date((long) update.getMessage().getDate()*1000).toString();
                User user = update.getMessage().getFrom();
                //Пишем лог в консоль бота.
                System.out.println("Пользователь: " + user.getFirstName() + " " + user.getLastName() + " aka " + user.getUserName() + " написал: "
                        + message + " at " + mytime + " "  );

            // Создаем клавиуатуру
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);
            // Создаем список строк клавиатуры
            List<KeyboardRow> keyboard = new ArrayList<>();
            // Первая строчка клавиатуры
            KeyboardRow keyboardFirstRow = new KeyboardRow();
            // Добавляем кнопки в первую строчку клавиатуры
            KeyboardButton keyboardButton = new KeyboardButton();
            KeyboardButton keyboardButton1 = new KeyboardButton();
            keyboardButton.setText("Узнать погоду на сейчас");
            keyboardButton1.setText("Узнать погоду на завтра");
            keyboardFirstRow.add(keyboardButton);
            keyboardFirstRow.add(keyboardButton1);
            // Добавляем все строчки клавиатуры в список
            keyboard.add(keyboardFirstRow);
            // и устанваливаем этот список нашей клавиатуре
            replyKeyboardMarkup.setKeyboard(keyboard);

                    SendMessage msg = new SendMessage();
                    msg.setReplyMarkup(replyKeyboardMarkup);
                    msg.setChatId(chatId);
                    msg.setText((String) cmd.inputmsg(update.getMessage().getText()));
                    try {
                        execute(msg);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
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
