package task4;

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
        String[] elementsOfText = TEXT.split("\\s+");
        Set<String> set = new HashSet<>(Arrays.asList(elementsOfText));
        List<String> list = new ArrayList<>(Arrays.asList(elementsOfText));
        HashMap<String, Integer> map = new HashMap<>();
        Iterator<String> i = set.iterator();
        int count;
        while (i.hasNext()) {
            String elemOfSet = i.next();
            count = 0;
            for (int k = 0; k < list.size(); k++) {
                if (elemOfSet.compareTo(list.get(k)) == 0) {
                    count++;
                }
            }
            map.put(elemOfSet, count);
        }


// descending sort by values
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(map.entrySet());
        for (int j = 0; j < list1.size(); j++) {
            for (int n = 0; n < list1.size() - j - 1; n++) {
                if (list1.get(n).getValue() < list1.get(n + 1).getValue()) {
                    Collections.swap(list1, n, n + 1);
                }
            }
        }
        System.out.println("отсортировать по убыванию частоты встречание");
        for (Map.Entry<String , Integer> el : list1){
            System.out.println(el.getKey() + " - " + el.getValue());
        }


// ascending sort
        for (int j = 0; j < list1.size(); j++) {
            for (int n = 0; n < list1.size() - j - 1; n++) {
                if (list1.get(n).getValue() > list1.get(n + 1).getValue()) {
                    Collections.swap(list1, n, n + 1);
                }
            }
        }

        int length = 0;
        int countWord;
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        Iterator<Map.Entry<String, Integer>> iterator = list1.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> elemOfIterator = iterator.next();
            length = elemOfIterator.getKey().length();
            countWord = 0;
            for (int n = 1; n < list1.size(); n++) {
                if (length == list1.get(n).getKey().length()) {
                    countWord = elemOfIterator.getValue() + list1.get(n).getValue();
                }
            }
            map2.put(length, countWord);
        }
        System.out.println("отсортировать вывод от меньшей длины к большей");
        for (Map.Entry<Integer, Integer> el : map2.entrySet()){
            System.out.println(el.getKey() + " - " + el.getValue());
        }
        //System.out.println(map2);



    }


}


