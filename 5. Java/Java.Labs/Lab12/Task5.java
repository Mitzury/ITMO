package ru.mitzury;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Task5<K>
{

    public <K> Map<Integer,K> arrayToMap(K[] ks) {

        for (K element : ks)
        {
            System.out.println(element);
        }
        Object element = null;
        HashMap<Integer, K> map = new HashMap<Integer, K>();
        for (K i : ks)map.put(i.hashCode(), i);
        return (Map<Integer, K>) map;
    }

}
