/**
 * This work is marked with CC0 1.0 Universal
 */
package shapes;

public class Rectangle extends Shape2D {

    /**
     * The width of the Rectangle
     */
    private double width;

    /**
     * The length of the Rectangle
     */
    private double length;

    /**
     * Get the width of the Rectangle
     * @return The width of the Rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set the width of the Rectangle
     * @param width The width of the Rectangle
     */
    private void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get the length of the Rectangle
     * @return The length of the Rectangle
     */
    public double getLength() {
        return length;
    }

    /**
     * Set the length of the Rectangle
     * @param length The length of the Rectangle
     */
    private void setLength(double length) {
        this.length = length;
    }

    /**
     * Get the area of the Rectangle
     * @return The area of the Rectangle
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * Get the perimeter of the Rectangle
     * @return The perimeter of the Rectangle
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * Constructor for Rectangle shape object
     * @param centre The centre of the Rectangle represented as a Point object
     * @param width The width of rectangle
     * @param length The length of rectangle
     */
    public Rectangle(Point centre, double width, double length) {
        super(centre);
        setWidth(width);
        setLength(length);
    }

    /**
     * Check if the point is contained within the Rectangle
     * @param point The point to check
     * @return True if the point is contained within the Rectangle, false otherwise
     */
    @Override
    public boolean containsPoint(Point point) {
        double xCord = point.getXCord();
        double yCord = point.getYCord();

        return xCord >= centre.getXCord() - width / 2
            && xCord <= centre.getXCord() + width / 2
            && yCord >= centre.getYCord() - length / 2
            && yCord <= centre.getYCord() + length / 2;
    }

    /**
     * Get the vertices of the Rectangle
     * @return The vertices of the Rectangle
     */
    @Override
    public Point[] getVertices() {
        return new Point[] {
            new Point(centre.getXCord() - width / 2, centre.getYCord() + length / 2),
            new Point(centre.getXCord() + width / 2, centre.getYCord() + length / 2),
            new Point(centre.getXCord() - width / 2, centre.getYCord() - length / 2),
            new Point(centre.getXCord() + width / 2, centre.getYCord() - length / 2)
        };
    }
}
