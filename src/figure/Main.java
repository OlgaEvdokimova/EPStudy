package figure;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1 - програмно, 2 - через консоль, 3 - через файл");
        int choice = scanner.nextInt();

        List<Figure> figures = new ArrayList<>();

        if (choice == 1) {
            Figure circle1 = new Circle(1);
            Figure rectangle1 = new Rectangle(3, 2);

            Figure circle2 = new Circle(4);
            Figure rectangle2 = new Rectangle(4, 2);
            Figure circle3 = new Circle(7);
            Figure rectangle3 = new Rectangle(1, 2);


            figures.add(circle1);
            figures.add(rectangle1);
            figures.add(circle2);
            figures.add(rectangle2);
            figures.add(circle3);
            figures.add(rectangle3);
        } else if (choice == 2) {
            Input input = new Input();
            try {
                input.callFigures(figures);

            } catch (WrongDataException ex) {
                ex.printStackTrace();
            }
        } else if (choice == 3) {
            FileUtils fileUtils = new FileUtils();
            try {
               fileUtils.getFigures(figures);
            } catch (WrongDataException e) {
                e.printStackTrace();
            }
        } else {
            scanner.close();
        }

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


//
//        System.out.println("Сортировка по площади Input");
//            Collections.sort(figuresInput, compare1);
//            for (Figure figure : figuresInput) {
//                System.out.println(figure);
//            }
//
//            System.out.println("Сортировка по периметру Input");
//            Collections.sort(figuresInput, compare2);
//            for (Figure figure : figuresInput) {
//                System.out.println(figure);
//            }
//
//            System.out.println("Сортировка по типу и площади");
//            Collections.sort(figuresInput, compare3);
//            for (Figure figure : figuresInput) {
//                System.out.println(figure);
//            }


    }
}

