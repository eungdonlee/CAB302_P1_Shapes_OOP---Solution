/**
 * This work is marked with CC0 1.0 Universal
 */
package shapes;

/**
 * Class to represent an Equilateral Triangle shape - contains 3 sides of equal length and
 * contains 3 vertices
 */
public class EquilateralTriangle extends Shape2D {

    /**
     * The length of each side of the equilateral triangle
     */
    private double sideLength;

    /**
     * Get the length of each side of the equilateral triangle
     * @return The length of each side of the equilateral triangle
     */
    public double getSideLength() {
        return sideLength;
    }
    
    /**
     * Set the length of each side of the equilateral triangle
     * @param sideLength The length of each side of the equilateral triangle
     */
    private void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Get the perimeter of the equilateral triangle
     * @return The perimeter of the equilateral triangle
     */
    @Override
    public double getPerimeter() {
        return 3 * sideLength;
    }

    /**
     * Get the area of the equilateral triangle
     * @return The area of the equilateral triangle
     */
    @Override
    public double getArea() {
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }

    /**
    * Constructor for Equilateral Triangle  shape object
    * @param centre The centre of the Equilateral Triangle represented as a Point object
    * @param sideLength The length of each side (all same as equilateral)
    */
    public EquilateralTriangle(Point centre, double sideLength) {
        super(centre);
        setSideLength(sideLength);
    }

    /**`
     * Check if the point is contained within the equilateral triangle
     * @param point The point to check
     * @return True if the point is contained within the equilateral triangle, false otherwise
     */`
    @Override
    public boolean containsPoint(Point point) {
        double dx = point.getXCord() - centre.getXCord();
        double dy = point.getYCord() - centre.getYCord();

        return dy <= Math.sqrt(3) * (dx + sideLength / 3)
            && dy <= -Math.sqrt(3) * (dx - sideLength / 3)
            && dy >= -(Math.sqrt(3) / 6) * sideLength;
    }

    /**
     * Get the vertices of the equilateral triangle
     * @return The vertices of the equilateral triangle
     */
    @Override
    public Point[] getVertices() {
        double eqTXCord = centre.getXCord();
        double eqTYCord = centre.getYCord();

        Point v1 = new Point(eqTXCord, eqTYCord + ((Math.sqrt(3) / 3) * sideLength));
        Point v2 = new Point(eqTXCord - sideLength / 2, eqTYCord - ((Math.sqrt(3) / 6) * sideLength));
        Point v3 = new Point(eqTXCord + sideLength / 2, eqTYCord - ((Math.sqrt(3) / 6) * sideLength));

        return new Point[] { v1, v2, v3 };
    }

}
