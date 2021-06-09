package ru.mitzury;

import javax.sound.sampled.Line;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bb = null;
        bb = new BufferedReader(new FileReader("src/ru/mitzury/file.txt"));
        String Line;
        String result=" ";
        while ((Line = bb.readLine()) != null)
        {
           result= Line +"\n";
            System.out.println(result);
        }
        bb.close();
        //____________________________________
        String file= "src/com/company/file.txt";
        String newStr = "Лишняя строка";
        AddString.AddToFile(file, newStr);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string1;
        String result;
        while ((string1 = br.readLine()) != null) {
            result= string1;
            System.out.println(result);
        }
        //____________________________________________
        String file= "src/ru/mitzury/file.txt";
        String file2= "src/ru/mitzury/file2.txt";
        AddString.AddFileToFile(file, file2);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string1;
        String result;
        while ((string1 = br.readLine()) != null) {
            result= string1;
            System.out.println(result);
        }
       //________________________________________________
        String file= "src/ru/mitzury/file.txt";
        File f1= new File(file);
        String file2= "src/ru/mitzury/file2.txt";
        File f2= new File(file2);
        CopyFile.copyFileMethod(f1, f2);
//        //_____________________________________
        SearchFileName sf= new SearchFileName();
        sf.func("C:\\Users\\Mitzury\\IdeaProjects\\Java\\Java.Labs\\Lab10", "file.txt");
        //___________________________________________
        SearchTextInFile st= new SearchTextInFile();
        String filePath = "C:\\Users\\Mitzury\\IdeaProjects\\Java\\Java.Labs\\Lab10";

    }
}
