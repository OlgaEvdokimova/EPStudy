package figure;

import java.util.Comparator;
import java.util.List;

public class Compare3 implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {

        if (o1 instanceof Circle & o2 instanceof Circle) {
            if (o1.getArea() > o2.getArea()) {
                return 1;
            }
            if (o1.getArea() < o2.getArea()) {
                return -1;
            } else {
                return 0;
            }

        } else if (o1 instanceof Rectangle & o2 instanceof Rectangle) {
            if (o1.getArea() > o2.getArea()) {
                return 1;
            }
            if (o1.getArea() < o2.getArea()) {
                return -1;
            } else {
                return 0;
            }
        } else if (o1 instanceof Circle & o2 instanceof  Rectangle){
            return -1;
        }
        else {
            return 0;
        }
    }
}
