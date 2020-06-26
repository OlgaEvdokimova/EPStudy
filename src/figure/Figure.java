package figure;

public interface Figure {

     double getArea();

     double getPerimeter();

     boolean contains(Figure figure);
     boolean contains(double x, double y);
     boolean collide(Figure figure);
}
