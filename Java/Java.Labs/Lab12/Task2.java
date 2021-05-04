package ru.mitzury;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Task2 {

    public void collect(){
        Set<String> col1= new HashSet<>();
        col1.add("element 1");
        col1.add("element 2");
        col1.add("element 3");
        col1.add("element 3");
        col1.add("element 2");
        List list = new ArrayList();
        list.addAll(col1);

       System.out.println(list);
    }

}
