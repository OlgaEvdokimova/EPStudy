package figure;

public class Rectangle implements Figure {
    private double width;
    private double height;
    private double x;
    private double y;

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
        if (figure instanceof Circle) {
            Circle figure2 = (Circle) figure;
            // surface circle coordinates, right, left, top, bottom
            double xR = figure2.getX() + figure2.getRadius();
            double xL = figure2.getX() - figure2.getRadius();
            double yT = figure2.getY() + figure2.getRadius();
            double yB = figure2.getY() - figure2.getRadius();
            if (contains(xR, figure2.getY()) && contains(xL, figure2.getY()) && contains(figure2.getX(), yT) && contains(figure2.getX(), yB))
                ;
        } else if (figure instanceof Rectangle) {
            Rectangle figure2 = (Rectangle) figure;
            // B - internal rectangle
            //x & y right bottom B
            double xRBB = figure2.x + figure2.getWidth() / 2;
            double yRBB = figure2.y - figure2.getHeight() / 2;
            //x & y right top B
            double xRTB = figure2.x + figure2.getWidth() / 2;
            double yRTB = figure2.y + figure2.getHeight() / 2;
            //x & y left bottom B
            double xLBB = figure2.x - figure2.getWidth() / 2;
            double yLBB = figure2.y - figure2.getHeight() / 2;
            //x & y left top B
            double xLTB = figure2.x - figure2.getWidth() / 2;
            double yLTB = figure2.y + figure2.getHeight() / 2;
            if (contains(xRBB, yRBB) && contains(xRTB, yRTB) && contains(xLBB, yLBB) && contains(xLTB, yLTB)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(double xP, double yP) {
        return xP > x - width / 2 && xP < x + width / 2 && yP > y - height / 2 && yP < y + height / 2;
    }

    @Override
    public boolean collide(Figure figure) {
        // A - main rectangle
        //x right
        double xRightA = x + width / 2;
        //x left
        double xLeftA = x - width / 2;
        //y bottom
        double yBottomA = y - height / 2;
        //y top B
        double yTopA = y + height / 2;
        if (figure instanceof Rectangle) {
            Rectangle figure2 = (Rectangle) figure;
            // B - collide or internal rectangle,
            //x right
            double xRightB = figure2.x + figure2.getWidth() / 2;
            //x left
            double xLeftB = figure2.x - figure2.getWidth() / 2;
            //y bottom
            double yBottomB = figure2.y - figure2.getHeight() / 2;
            //y top B
            double yTopB = figure2.y + figure2.getHeight() / 2;

            if (xLeftB < xRightA && xRightB > xLeftA &&
                    yBottomB < yTopA && yTopB > yBottomA) {
                return true;
            }
        } else if (figure instanceof Circle) {
            Circle figure2 = (Circle) figure;
            // find the distance between Circle center and Rect center
            double dx = Math.abs(figure2.getX() - x);
            double dy = Math.abs(figure2.getY() - y);
            // now check the distance to horizontal(verticle) Rectangle axis , if it less width(height)/2 -> so
            // the center of Circle is inside of Rectangle --> collision
            if (dx <= width / 2 && dy <= height / 2) {
                return true;
                // check the corners, if the circle centers lie with in them
            } else if ((figure2.getX() > xRightA && figure2.getY() < yBottomA) || (figure2.getX() > xRightA && figure2.getY() > yTopA) ||
                    (figure2.getX() < xLeftA && figure2.getY() < yBottomA) || figure2.getX() < xLeftA && figure2.getY() > yTopA) {
                double d = Math.sqrt(Math.pow(dx - width / 2, 2) + Math.pow(dy - height / 2, 2));
                return d <= figure2.getRadius();

            } else if (figure2.getX() < xRightA && figure2.getY() < yBottomA) {
                return  (yBottomA - figure2.getY()) < figure2.getRadius();
            } else  if (figure2.getX() < xRightA && figure2.getY() >yTopA){
                return (figure2.getY() - yTopA) < figure2.getRadius();
            }else  if (figure2.getX() > xRightA && figure2.getY() > yBottomA){
                return (figure2.getX() - xRightA) < figure2.getRadius();
            }else if (figure2.getX() < xLeftA&& figure2.getY() > yBottomA){
                return xLeftA - figure2.getX() < figure2.getRadius();
            }
        }
        return false;
    }
}