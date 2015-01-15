import java.awt.Color;

public class SceneObject implements SceneElement{

	public SceneObject() {

	}
	@Override
	public boolean isLambert() {
		return true;
	}
	@Override
	public int getLambert() {
		return 1;
	}

	@Override
	public Color elemColor() {
		return Color.red;
	}

	@Override
	public double intersectWith(Ray ray) {
		// TODO Auto-generated method stub
		return inf;
	}


	@Override
	public Vector normal(Vector pos) {
		// TODO Auto-generated method stub
		return new Vector();
	}

}
