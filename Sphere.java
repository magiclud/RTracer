import java.awt.Color;


public class Sphere {

	private Vector point;
	public double rInverse;
	public double rSQuare;
	private double radius;
	private double spectacular;
	private double ambient;
	private String type;
	private double lambert;
	private Color color;

	Sphere(double x, double y, double z, int cR, int cG, int cB, double lightS, double lightL, double lightA, double sRadius){
		setType("sphere");
		setPoint(new Vector(x,y,z));
		color = new Color(cR,cG,cB);
		setSpectacular(lightS);
		setLambert(lightL);
		setAmbient(lightA);
		setRadius(sRadius);
		this.rSQuare = sRadius * sRadius; 
		this.rInverse = 1/sRadius;
	}

	public Vector getPoint() {
		return point;
	}

	public void setPoint(Vector point) {
		this.point = point;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getSpectacular() {
		return spectacular;
	}

	public void setSpectacular(double spectacular) {
		this.spectacular = spectacular;
	}

	public double getAmbient() {
		return ambient;
	}

	public void setAmbient(double ambient) {
		this.ambient = ambient;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getLambert() {
		return lambert;
	}

	public void setLambert(double lambert) {
		this.lambert = lambert;
	}
}
