package figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    List<Figure> figures = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public List<Figure> input() throws IncorrectFigure {
        while (true) {
            System.out.println("Введите фигуру");
            String strFigure = scan.nextLine();

            if (strFigure.equals("Circle")) {
                System.out.println("Введите параметры x, y, radius");
                String x = scan.nextLine();
                String y = scan.nextLine();
                String radius = scan.nextLine();
                try {
                    double radiusC = Double.parseDouble(radius);
                    Figure figure = new Circle(radiusC);
                    figures.add(figure);
                }catch (NumberFormatException ex){
                    throw new IncorrectFigure("Incorrect data");
                }

            } else if (strFigure.equals("Rectangle")) {
                System.out.println("Введите параметры x, y, width, height");
                String x = scan.nextLine();
                String y = scan.nextLine();
                String width = scan.nextLine();
                String height = scan.nextLine();
                try {
                    double widthR = Double.parseDouble(width);
                    double heightR = Double.parseDouble(height);
                    Figure figure = new Rectangle(widthR, heightR);
                    figures.add(figure);
                } catch (NumberFormatException ex) {
                    throw new IncorrectFigure("Incorrect data");
                }

            } else {
                break;
            }

        }
        return figures;
    }
}
