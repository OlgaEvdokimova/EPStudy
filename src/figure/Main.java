package figure;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1 - програмно, 2 - через консоль, 3 - через файл");
        String choice = scanner.nextLine();

        List<Figure> figures = new ArrayList<>();
        try {
            if (choice.equals("1")) {
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
            } else if (choice.equals("2")) {
                Input input = new Input();
                input.callFigures(figures);

            } else if (choice.equals("3")) {
                FileUtils fileUtils = new FileUtils();
                fileUtils.getFigures(figures);
            } else if (choice.equals("4")) {
                Figure circle1 = new Circle(1);
                Figure rectangle1 = new Rectangle(3, 2);
                System.out.println(circle1.contains(rectangle1));

                Figure circle2 = new Circle(4);
                System.out.println(circle2.contains(circle2));

                Figure rectangle2 = new Rectangle(4, 2);
                System.out.println(rectangle2.contains(rectangle1));

                System.out.println(rectangle1.contains(circle1));

            } else {
                throw new WrongDataException("1 or 2 or 3");
            }
//            System.out.println("Сортировка по площади");
//            Comparator<Figure> compare1 = new Compare1();
//            Collections.sort(figures, compare1);
//            for (Figure figure : figures) {
//                System.out.println(figure);
//            }
//            System.out.println();
//            System.out.println("Сортировка по периметру");
//            Comparator<Figure> compare2 = new Compare2();
//            Collections.sort(figures, compare2);
//            for (Figure figure : figures) {
//                System.out.println(figure);
//            }
//
//            System.out.println();
//            System.out.println("Сортировка по типу и площади");
//            Comparator<Figure> compare3 = new Compare3();
//            Collections.sort(figures, compare3);
//            for (Figure figure : figures) {
//                System.out.println(figure);
//            }
        } catch (WrongDataException e) {
            e.printStackTrace();
        }
    }
}