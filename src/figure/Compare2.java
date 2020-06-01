package figure;

import java.util.Comparator;

public class Compare2 implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        if (o1.getPerimeter() > o2.getPerimeter()) {
            return 1;
        }
        if (o1.getPerimeter() < o2.getPerimeter()){
            return -1;
        }else {
            return 0;
        }
    }
}
