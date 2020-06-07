package figure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public List<Figure> getFigures(List<Figure> figures) throws WrongDataException {
        String line;
        Figure figure = null;
        try {
            BufferedReader bf = new BufferedReader(new FileReader("E:\\JavaOlya\\EpTasks\\EPStudy\\src\\figure\\figure"));
            while ((line = bf.readLine()) != null) {
                String[] splitLine = line.split("\\s+");
                if (splitLine[0].equals("Circle")) {
                    if (splitLine.length == 4) {
                        double radius = Double.parseDouble(splitLine[3]);
                        figure = new Circle(radius);
                    }
                } else if (splitLine[0].equals("Rectangle")) {
                    if (splitLine.length == 5) {
                        double width = Double.parseDouble(splitLine[4]);
                        double height = Double.parseDouble(splitLine[4]);
                        figure = new Rectangle(width, height);
                    }
                }
                figures.add(figure);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            throw new WrongDataException("Incorrect data");
        }
        return figures;
    }
}
