package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){
            {
                add(2);
                add(4);
                add(1);
                add(3);
                add(5);
            }
        };

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               // if(o1 > o2)
                return o1.compareTo(o2) ;
            }
        };
        Collections.sort(list, comparator);
        System.out.println(list);

    }
}
