package cmsc420_s22;

// YOU SHOULD NOT MODIFY THIS FILE

/**
 * A 2-dimensional point with a string label.
 */
public interface LabeledPoint2D {
	double getX(); // get point's x-coordinate

	double getY(); // get point's y-coordinate

	double get(int i); // get point's i-th coordinate (0=x, 1=y)

	Point2D getPoint2D(); // get the point itself

	String getLabel(); // get the label
}
