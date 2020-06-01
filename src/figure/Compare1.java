package figure;

import java.util.Comparator;

public class Compare1 implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        if (o1.getArea() > o2.getArea()) {
            return 1;
        }
        if (o1.getArea() < o2.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
