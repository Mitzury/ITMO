package ru.mitzury;

import java.io.*;

public class AddString {
    public static void AddToFile(String file, String newStr) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.write("\n"+newStr);
        out.close();
    }
    public static void AddFileToFile(String file, String file2) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file,  true));
        BufferedReader bb = null;
        bb = new BufferedReader(new FileReader("src/ru/mitzury/file2.txt"));
        String Line;
        String result="";
        while ((Line = bb.readLine()) != null)
        {
           result+= Line +"\n";
        }
        out.write("\n"+result);
        out.close();
    }
}