import java.awt.Color;



public interface SceneElement {

	int inf = 2147483647;
	
		double intersectWith(Ray ray);
		Vector normal(Vector pos);
		int getLambert();
		boolean isLambert();
		Color elemColor();
}