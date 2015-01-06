
import java.util.ArrayList;


public class Scene  {

	private Camera camera;
	private ArrayList<Vector> lights = new ArrayList<Vector>();
	private ArrayList<Sphere> obiects = new ArrayList<Sphere>();
/*	
		private double angleRadians;
	private double aspectRadio;
	private int noObjects;
	private int setNoLights; */

public Scene(){
	
}
	public ArrayList getLights() {
		return lights;
	}

	public ArrayList getObiects() {
		return obiects;
	}

	public void addLight(Vector vector) {
		lights.add(vector);
		
	}

	public void addObiect(Sphere sphere) {
		obiects.add(sphere);
		
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}
