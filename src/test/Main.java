package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Figure circle1 = new Circle(2);
        Figure circle2 = new Circle(2);
        Figure rectangle = new Rectangle(1, 2);
        List<Figure> figures = new ArrayList<>(){
            {
                add(circle1);
                add(circle2);
                add(rectangle);
            }
        };
        System.out.println(figures);
         for (Figure figure: figures){
             if (figure instanceof Circle){
                 System.out.println("circle");
             } else {
                 System.out.println("rectangle");
             }
         }





    }
}
