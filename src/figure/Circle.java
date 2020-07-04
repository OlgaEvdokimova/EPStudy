package figure;

public class Circle implements Figure {
    private double radius;
    private double x;
    private double y;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }



    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Circle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Circle " + getArea() + " " + getPerimeter();
    }

    @Override

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean contains(Figure figure) {
        if (figure instanceof Circle) {
            Circle figure2 = (Circle) figure;
            return ((radius) - figure2.radius > Math.sqrt(Math.pow(x - figure2.x, 2) + Math.pow(y - figure2.y, 2)));

        } else if (figure instanceof Rectangle) {
            Rectangle figure2 = (Rectangle) figure;
// x & y right top angle
            double xRT = figure2.getX() + figure2.getWidth() / 2;
            double yRT = figure2.getY() + figure2.getHeight() / 2;
// x & y right bottom angle
            double xRB = figure2.getX() + figure2.getWidth() / 2;
            double yRB = figure2.getY() - figure2.getHeight() / 2;
// x & y left top angle
            double xLT = figure2.getX() - figure2.getWidth() / 2;
            double yLT = figure2.getY() + figure2.getHeight() / 2;
// x & y left bottom angle
            double xLB = figure2.getX() - figure2.getWidth() / 2;
            double yLB = figure2.getY() - figure2.getHeight() / 2;
            if (contains(xRT, yRT) && contains(xRB, yRB) && contains(xLT, yLT) && contains(xLB, yLB)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(double xP, double yP) {
        // c - the distance between two centres
        double c = Math.sqrt(Math.pow(xP - x, 2) + Math.pow(yP - y, 2));
        return c < radius;
    }

    @Override
    public boolean collide(Figure figure) {
        if (figure instanceof Circle) {
            Circle figure2 = (Circle) figure;
            return ((radius) + figure2.radius >= Math.sqrt(Math.pow(x - figure2.x, 2) + Math.pow(y - figure2.y, 2)))  ||
                    ((radius) - figure2.radius >= Math.sqrt(Math.pow(x - figure2.x, 2) + Math.pow(y - figure2.y, 2)));
        } else if (figure instanceof Rectangle) {
            Rectangle figure2 = (Rectangle) figure;

            // A -  rectangle
            //x right
            double xRightA = figure2.getX() + figure2.getWidth() / 2;
            //x left
            double xLeftA = figure2.getX() - figure2.getWidth() / 2;
            //y bottom
            double yBottomA = figure2.getY() - figure2.getHeight() / 2;
            //y top B
            double yTopA = figure2.getY() + figure2.getHeight() / 2;

            // find the distance between Circle center and Rect center
            double dx = Math.abs(figure2.getX() - x);
            double dy = Math.abs(figure2.getY() - y);
            // now check the distance to horizontal(verticle) Rectangle axis , if it less width(height)/2 -> so
            // the center of Circle is inside of Rectangle --> collision
            if (dx <= figure2.getWidth() / 2 && dy <= figure2.getHeight() / 2) {
                return true;
                // check the corners, if the circle centers lie with in them
            } else if ((x > xRightA && y < yBottomA) || (x > xRightA && y > yTopA) ||
                    (x < xLeftA && y < yBottomA) || x < xLeftA && y > yTopA) {
                double d = Math.sqrt(Math.pow(dx - figure2.getWidth() / 2, 2) + Math.pow(dy - figure2.getHeight() / 2, 2));
                return d <= radius;

            } else if (x < xRightA && y < yBottomA) {
                return  (yBottomA - y) < radius;
            } else  if (x < xRightA && y >yTopA){
                return (y - yTopA) < radius;
            }else  if (x > xRightA && y > yBottomA){
                return (x - xRightA) < radius;
            }else if (x < xLeftA&& y > yBottomA){
                return xLeftA - x < radius;
            }
        }
        return false;
    }


}
