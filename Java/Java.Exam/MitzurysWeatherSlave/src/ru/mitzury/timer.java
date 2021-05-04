package ru.mitzury;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class timer {

    public void run() {
        System.out.println("TimerTask начал свое выполнение в:" + new Date());
        completeTask();
        System.out.println("TimerTask закончил свое выполнение в:" + new Date());
    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 20 секунд
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}