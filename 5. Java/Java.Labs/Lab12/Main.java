package ru.mitzury;

import java.io.*;
import java.util.*;

public class Main {

    public static <K, V> void main(String[] args) throws IOException {
        SearchFileStory sfs=new SearchFileStory();
        String fname="src/com/company/Text3.txt";
        sfs.func1(fname);
        //_______________________________
        Task2 ts= new Task2();
        ts.collect();
        //_______________________________
        AddMillionItems ad = new AddMillionItems();
        long start = System.currentTimeMillis();
        ad.addAR();
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);
        long start2 = System.currentTimeMillis();
        ad.addLL();
        long duration2 = System.currentTimeMillis() - start;
        System.out.println(duration2);
        ad.info();
        //__________________________________________
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name= sc.nextLine();
        User user =new User(name);
        Map<User, Integer>  map  = new HashMap<>();
        User user1=new User("Вася");
        User user2=new User("Петя");
        User user3=new User("Коля");
        User user4=new User("Женя");
        User user5=new User("Андрей");
        User user6=new User("Сергей");
        map.put(user1, 1);
        map.put(user2, 2);
        map.put(user3, 3);
        map.put(user4, 4);
        map.put(user5, 5);
        map.put(user6, 6);
        final int min = 100;
       final int max = 1000;
        int counts= user.rnd(min, max);
      // User.map(user, counts);
        for (User key: map.keySet()){
            if(key.getName().equals(name)){
                System.out.print("Игрок существует:" +" "+ user.getName()+" "+ "очки:"+" "+ counts);
            }
            else {System.out.print("Игрок не существует!" );}
        }

        //____________________________________
        Task5 ts5=new Task5();
        String[] myArray = new String[]{"Вася", "Петя","Коля","Женя","Андрей"};

        System.out.print(ts5.arrayToMap(myArray));


//______________________________________
//        File file= new File("src/com/company/file2.txt");
//        Scanner scanner=new Scanner(file);
//        StringBuilder stringb =new StringBuilder();
//        List<String> list =new ArrayList<>();
//        Map<String, Integer> wordCount1 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
//        while (scanner.hasNextLine()){
//            stringb.append(scanner.nextLine()).append(' ');
//        }
//        scanner.close();
//        for (int i=0; i<stringb.length(); ){
//            list.add(stringb.substring(i, stringb.toString().indexOf(' ',i)));
//            i=stringb.toString().indexOf(' ', i)+1;
//        }
//        for (int k=0; k<list.size(); k++){
//            int a=0;
//            for (String s :list){
//                if(list.get(k).equals(s)) {
//                    a++;
//                }
//            }
//            wordCount1.put(list.get(k), a);
//        }
//        for (Map.Entry<String, Integer> word2: wordCount1.entrySet())
//        {
//            System.out.printf("слово: %s количество: %d \n", word2.getKey(), word2.getValue());
//        }
    }
}
