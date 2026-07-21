/**
 * This work is marked with CC0 1.0 Universal
 */
package shapes;

/**
 * Shape2D is an Abstract Class and acts as a base class for all the 2D shapes
 * which includes Equilateral Triangle, Circle, Rectangle amd Square.
 * Shape2D is a shared common ancestor between the shape classes as each of these classes subclass
 * Shape2D
 */
public abstract class Shape2D {

    /**
     * The centre of the shape
     */
    protected Point centre;

    /**
     * Get the area of the shape
     * @return the area of the shape
     */
    public abstract double getArea();

    /**
     * Get the perimeter of the shape
     * @return the perimeter of the shape
     */
    public abstract double getPerimeter();

    /**
     * Constructor for the Shape2D class
     * @param centre the centre of the shape
     */
    public Shape2D(Point centre) {
        this.centre = centre;
    }

    /**
     * Translate the shape by the given amount
     * @param moveX the amount to move the shape in the x direction
     * @param moveY the amount to move the shape in the y direction
     */
    public void translate(double moveX, double moveY) {
        this.centre.translatePoint(moveX, moveY);
    }

    /**
     * Check if the shape contains the given point
     * @param point the point to check
     * @return true if the shape contains the point, false otherwise
     */
    public abstract boolean containsPoint(Point point);
    
    /**
     * Get the vertices of the shape
     * @return the vertices of the shape
     */
    public abstract Point[] getVertices();
}
