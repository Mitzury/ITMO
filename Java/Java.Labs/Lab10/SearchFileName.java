package ru.mitzury;

import java.io.File;

public class SearchFileName
{
    public void func(String path, String find) {
        File f = new File(path);
        String[] list = f.list();

        for (String file : list) {
            if (find.equals(file))
            {
                System.out.println(path + "Путь:"+"  " + file +"   "+ "Файл найден ");
                return;
            }

        }
    }
}