package org.training.samples.Naming;

public class namingExample {

    public static void main(String[] args) {
        Point mainPoint = new Point(10, 10);
        Rectangle rect = new Rectangle(mainPoint, 5, 3);

        rect.getEndPoints();
        rect.draw('*');
    }
}

class Point {
    private int xCoordinate;
    private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
}

class Rectangle {
    private Point startingPoint;
    private int breadth;
    private int high;

    public Rectangle(Point startingPoint, int breadth, int high) {
        this.startingPoint = startingPoint;
        this.breadth = breadth;
        this.high = high;
    }

    public double getArea() {
        return breadth * high;
    }

    public void getEndPoints() {
        int topRightX = startingPoint.getXCoordinate() + breadth;
        int topRightY = startingPoint.getYCoordinate();
        int bottomLeftX = startingPoint.getXCoordinate();
        int bottomLeftY = startingPoint.getYCoordinate() + high;

        System.out.println("Starting Point (X): " + startingPoint.getXCoordinate());
        System.out.println("Starting Point (Y): " + startingPoint.getYCoordinate());
        System.out.println("Top Right (X): " + topRightX);
        System.out.println("Top Right (Y): " + topRightY);
        System.out.println("Bottom Left (X): " + bottomLeftX);
        System.out.println("Bottom Left (Y): " + bottomLeftY);
    }
    public void draw(char borderChar) {
        // Top border
        for (int i = 0; i < breadth + 2; i++) {
            System.out.print(borderChar);
        }
        System.out.println();

        // Middle lines
        for (int i = 0; i < high; i++) {
            System.out.print(borderChar);
            // Fill with spaces
            for (int j = 0; j < breadth; j++) {
                System.out.print(' ');
            }
            System.out.println(borderChar);
        }

        // Bottom border
        for (int i = 0; i < breadth + 2; i++) {
            System.out.print(borderChar);
        }
        System.out.println();
    }

}

