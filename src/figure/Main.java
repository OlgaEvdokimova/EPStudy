package figure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Figure circle1 = new Circle(1);
        Figure rectangle1 = new Rectangle(3, 2);

        Figure circle2 = new Circle(2);
        Figure rectangle2 = new Rectangle(4, 2);
        Figure circle3 = new Circle(7);
        Figure rectangle3 = new Rectangle(1, 2);

        List<Figure> figures = new ArrayList<>();
        figures.add(circle1);
        figures.add(rectangle1);
        figures.add(circle2);
        figures.add(rectangle2);
        figures.add(circle3);
        figures.add(rectangle3);

        System.out.println("Сортировка по площади");
        Comparator<Figure> compare1 = new Compare1();
        Collections.sort(figures, compare1);
        for (Figure figure : figures) {
            System.out.println(figure);
        }
        System.out.println();
        System.out.println("Сортировка по периметру");
        Comparator<Figure> compare2 = new Compare2();
        Collections.sort(figures, compare2);
        for (Figure figure : figures) {
            System.out.println(figure);
        }

        System.out.println();
        System.out.println("Сортировка по типу и площади");
        Comparator<Figure> compare3 = new Compare3();
        Collections.sort(figures, compare3);
        for (Figure figure : figures) {
            System.out.println(figure);
        }
    }
}



//         double areaOfCircle = circle.getArea();
//        System.out.printf("Area of circle : %.3f", areaOfCircle);
//        System.out.println();
//        double perimeterOfCircle = circle.getPerimeter();
//        System.out.printf("Perimeter of circle : %.3f", perimeterOfCircle);
//        System.out.println();
//        double areaOfRectangle = rectangle.getArea();
//        System.out.println("Area of rectangle " + areaOfRectangle);
//
//        double perimeterOfRectangle = rectangle.getPerimeter();
//        System.out.println("Perimeter of rectangle " + perimeterOfRectangle);