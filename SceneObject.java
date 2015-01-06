import java.awt.Color;
import java.util.Vector;

public class SceneObject {
	private int inf = 2147483647;

	/*
	 * public: SceneElement(); virtual double intersectWith(Ray& ray); virtual
	 * ~SceneElement(); static const int INF;
	 * 
	 * bool isLambert(); int getLambert(); bool isSpecular(); sf::Color
	 * elemColor(); virtual VectorR3 normal(PointR3 pos);
	 */

	public SceneObject() {

	}

	boolean isLambert() {
		return true;
	}

	int getLambert() {
		return 1;
	}

	Color elemColor() {
		return Color.red;
	}

	Vector normal(Vector pos) {
		return new Vector();
	}

}
