/**
 * This work is marked with CC0 1.0 Universal
 */
package shapes;

/**
 * Class to represent a circle shape - as this is a circle it does not
 * contain any vertices
 */
public class Circle extends Shape2D {

    /**
     * The radius of the circle
     */
    private double radius;

    /**
     * Get the radius of the circle
     * @return The radius of the circle
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Set the radius of the circle
     * @param radius The radius of the circle
     */
    private void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Get the perimeter of the circle
     * @return The perimeter of the circle
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Get the area of the circle
     * @return The area of the circle
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Constructor for Circle shape object
     * @param centre The centre of the circle represented as a Point object
     * @param radius The radius of the circle created
     */
    public Circle(Point centre, double radius) {
        super(centre);
        this.radius = radius;
    }

    /**
     * Check if the point is contained within the circle
     * @param point The point to check
     * @return True if the point is contained within the circle, false otherwise
     */
    @Override
    public boolean containsPoint(Point point) {
        return centre.distanceBetween(point) <= radius;
    }

    /**
     * Get the vertices of the circle
     * @return The vertices of the circle
     */
    @Override
    public Point[] getVertices() {
        return new Point[0];
    }
}
