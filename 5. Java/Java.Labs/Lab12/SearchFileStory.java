package ru.mitzury;

import java.io.*;
import java.security.Key;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;



public class SearchFileStory {
    public void func1(String fname) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fname));
        List<String> list ;
       String string1;
        String[] result;
 //____________________________________________________________
        while ((string1 = br.readLine()) != null) {
            string1 = string1.replaceAll("[()?:!.,;{}]+", "").replaceAll("\\s+", " ").replaceAll("[1-9]", "").replaceAll("[\\n|\\u00A0]+", "");
           result = string1.split(" ");
            for (int i = 0; i < result.length; i++)
                result[0] = result[i];
            Map<String, Integer> wordCount = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            list = Arrays.asList(result);
            Collections.sort(list);
            for (String word : (list)) {
                if (wordCount.containsKey(word) && word.length() > 3) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
            for (Map.Entry<String, Integer> word1 : wordCount.entrySet())
                if (word1.getValue().intValue() > 1) {
                    System.out.printf("слово: %s количество: %d \n", word1.getKey().toLowerCase(Locale.ROOT), word1.getValue());
                }
        }
    }
}






