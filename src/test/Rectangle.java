package test;


public class Rectangle implements Figure {
    private double width;
    private double height;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectangle(double a, double height) {
        this.width = a;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle " + getArea() + " " + getPerimeter();
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean contains(Figure figure) {


        return true;
    }


}


