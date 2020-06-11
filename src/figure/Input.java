package figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public List<Figure> callFigures(List<Figure> figuresInput) throws WrongDataException {
        while (true) {
            Figure figure = getFigure();
            if (figure == null) {
                break;
            } else {
                figuresInput.add(figure);
            }
        }
        return figuresInput;
    }


    public Figure getFigure() throws WrongDataException {
        Scanner scan = new Scanner(System.in);
        Figure figure = null;
        System.out.println("Введите фигуру");
        String strFigure;
        try {
            strFigure = scan.nextLine();
            if (strFigure.equals("Circle")) {
                System.out.println("Введите параметры x, y, radius");
                String x = scan.nextLine();
                String y = scan.nextLine();
                String radius = scan.nextLine();
                double xC = Double.parseDouble(x);
                double yC = Double.parseDouble(y);
                double radiusC = Double.parseDouble(radius);
                figure = new Circle(radiusC);

            } else if (strFigure.equals("Rectangle")) {
                System.out.println("Введите параметры x, y, width, height");
                String x = scan.nextLine();
                String y = scan.nextLine();
                String width = scan.nextLine();
                String height = scan.nextLine();
                double xR = Double.parseDouble(x);
                double yR = Double.parseDouble(y);
                double widthR = Double.parseDouble(width);
                double heightR = Double.parseDouble(height);
                figure = new Rectangle(widthR, heightR);

            } else {
                throw new WrongDataException("Incorrect figure");
            }
        } catch (NumberFormatException ex) {
            throw new WrongDataException("Incorrect data");
        }

        return figure;


    }
}
