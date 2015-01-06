
import java.util.ArrayList;


public class Scene  {

	private Camera camera;
	private ArrayList<Vector> lights = new ArrayList<Vector>();
	private ArrayList<Sphere> obiects = new ArrayList<Sphere>();
/*	private Vector eyeVector;  -> in Camera
	private Vector vpRight;	-> in Camera
	private Vector vpUp;	-> in Camera
	private double angleRadians;
	private double aspectRadio;
	private double halfWidth;
	private double halfHeight;
	private double cameraWidth;
	private double cameraHeight; 
	private double pixelDw;
	private double pixelDh;
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
/*
	public double getPixelDh() {
		return pixelDh;
	}

	public Vector getEyeVector() {
		return eyeVector;
	}

	public void setEyeVector(Vector eyeVector) {
		this.eyeVector = eyeVector;
	}*/

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

	/*public void setVpRight(Vector vpRight) {
		this.vpRight = vpRight;
		
	}

	public Vector getVpRight() {
		return vpRight;
	}

	public void setVpUp(Vector vpUp) {
		this.vpUp=vpUp;
		
	}
	public Vector getVpUp() {
		return vpUp;
	}

	public void setAngleRadians(double d) {
		this.angleRadians =d;
		
	}

	public double getAngleRadians() {
		return angleRadians;
	}

	public void setAspectRadio(double d) {
		this.aspectRadio = d;
		
	}

	public double getAspectRadio() {
		return aspectRadio;
	}

	public void setHalfWidth(double tan) {
		this.halfWidth =tan;
		
	}

	public double getHalfWidth() {
		return halfWidth;
	}

	public void setHalfHeight(double d) {
		this.halfHeight = d;
		
	}

	public double getHalfHeight() {
		return halfHeight;
	}

	public void setCameraWidth(double d) {
		this.cameraWidth = d;
		
	}

	public double getCameraWidth() {
		return cameraWidth;
	}

	public void setCameraHeight(double d) {
		this.cameraHeight =d;
	}

	public double getCameraHeight() {
		return cameraHeight;
	}

	public void setPixelDw(double d) {
		this.pixelDw = d;
		
	}

	public double getPixelDw() {
		return pixelDw;
	}

	public void setPixelDh(double d) {
		this.pixelDh = d;
		
	}

	public void setNoObjects(int size) {
		this.noObjects = size;
		
	}

	public int getNoObjects() {
		return noObjects;
	}

	public void setNoLights(int size) {
		this.setNoLights = size;
		
	}

	public int getSetNoLights() {
		return setNoLights;
	}

	public void setSetNoLights(int setNoLights) {
		this.setNoLights = setNoLights;
	}*/


}
