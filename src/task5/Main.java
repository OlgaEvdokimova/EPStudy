package task5;


import java.lang.reflect.Array;
import java.util.*;

public class Main {
    //На входе имеем строку текста, в ней слова разной длины при помощи коллекций типа map и set посчитать:
    //1) Сколько раз каждое слово встречается в тексте (отсортировать по убыванию частоты встречание)
    //2) Сколько в тексте слов различной длины (отсортировать вывод от меньшей длины к большей)
    //Пример текста:
    //один два три четыре пять один привет один два три
    //вывод
    //1)
    //один - 3
    //два - 2
    //три - 2
    //четыре - 1
    //пять - 1
    //привет - 1
    //2)
    //3 - 4
    //4 - 4
    //6 - 2
    //
    //ну и ещё 3) - в задании 2 в выводе в скобках указывать слова этой длины
    //3)
    //3 - 4 (два три)
    //4 - 4 (один, пять)
    //6 - 2 (привет, четыре)

    private static final String TEXT = "один два три четыре пять один привет один два три";

    public static void main(String[] args) {
        String[] splitText = TEXT.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
// 1)
        for (int i = 0; i < splitText.length; i++) {
            if (!(map.containsKey(splitText[i]))) {
                map.put(splitText[i], 0);
            }
            map.put(splitText[i], map.get(splitText[i]) + 1);
        }
        System.out.println("Map");
        System.out.println(map);

// descending sort by values
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> comp1 = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        Collections.sort(list1, comp1);

        System.out.println("отсортировать по убыванию частоты встречание");
        for (Map.Entry<String, Integer> el : list1) {
            System.out.println(el.getKey() + " - " + el.getValue());
        }

// 2)
// ascending sort
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> comp2 = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };
        Collections.sort(list2, comp2);

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < splitText.length; i++) {
            if (!(map2.containsKey(splitText[i].length()))) {
                map2.put(splitText[i].length(), 0);
            }
            map2.put(splitText[i].length(), map2.get(splitText[i].length()) + 1);

        }

        System.out.println("отсортировать вывод от меньшей длины к большей");
        for (Map.Entry<Integer, Integer> el : map2.entrySet()) {
            System.out.println(el.getKey() + " - " + el.getValue());
        }

// 3)

        Set<String> set = new HashSet<>();
        System.out.println("добавить сами слова");
        for (Map.Entry<Integer, Integer> el : map2.entrySet()) {

            for (int i = 0; i < splitText.length; i++) {
                if (splitText[i].length() == el.getKey()) {
                    set.add(splitText[i]);
                }
            }
            System.out.println(el.getKey() + " - " + el.getValue() + " (" + set + " )");
            set.clear();
        }
    }

}




