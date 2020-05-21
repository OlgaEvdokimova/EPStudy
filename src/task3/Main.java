package task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {


    public static void main(String[] args) {
        List<String> list1 = new LinkedList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new LinkedList<>();
        list2.add("7");
        list2.add("5");
        list2.add("6");
        List<String> list = new LinkedList<>();
        Iterator<String> i = list1.iterator();
        while (i.hasNext()) {
            String elem = i.next();
            list.add(elem);
            //List<String> list = list1.subList(0,list1.size());
        }
        list1.clear();
        list1.addAll(list2);
        System.out.println(list1);
        list2.clear();
        i = list.iterator();
        while (i.hasNext()) {

            list2.add(i.next());
        }
        //list2.addAll(list);
        System.out.println(list2);
    }
}

