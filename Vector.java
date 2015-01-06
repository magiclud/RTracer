public class Vector {

	private double x =0;
	private double y=0;
	private double z=0;

	public Vector() {
	}

	public Vector(double a, double b, double c) {
		this.x = a;
		this.y = b;
		this.z = c;
	}

	public Vector(Vector v) {
		x = v.x;
		y = v.y;
		z = v.z;
	}

	private double dotProduct(Vector b) {
		return (this.x * b.x + this.y * b.y + this.z * b.z);
	}

	Vector crossProduct(Vector b) {
		return new Vector(this.y * b.z - this.z * b.y, this.z * b.x - this.x
				* b.z, this.x * b.y - this.y * b.x);
	}

	Vector scale(double b) {
		return new Vector(this.x * b, this.y * b, this.z * b);
	}

	private double lengthVector() {
		return Math.sqrt(this.dotProduct(this));
	}

	Vector normalize() {
		return scale(1 / this.lengthVector());
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	Vector add(Vector b) {
		return new Vector(this.x + b.x, this.y + b.y, this.z + b.z);
	}

	Vector addThreeVec(Vector b, Vector c) {
		return new Vector(this.x + b.x + c.x, this.y + b.y + c.y, this.z + b.z
				+ c.z);
	}

	Vector subtract(Vector b) {
		return new Vector(this.x - b.x, this.y - b.y, this.z - b.z);
	}

	private Vector reflect(Vector n) {
		return this.subtract(n.scale(2 * this.dotProduct(n)));
	}

	private Vector sphereNormal(Sphere sphere, Vector pkt) {
		Vector pom = pkt.subtract(sphere.getPoint());
		return pom.scale(sphere.rInverse);
	}

	private double sphereIntersection(Sphere sphere, Ray ray) {
		Vector ec = sphere.getPoint().subtract(ray.getPoint());
		double v = ec.dotProduct(ray.getDirection());
		double d2 = ec.dotProduct(ec);
		double delta = sphere.rSQuare - d2 + v * v;
		
		if (delta < 0) {
			return 0;
		}
		
		double sD = Math.sqrt(delta);
		
		if (v > sD) {
			return v - sD;
		}
		return 0;

	}

	public String toString() {
		return new String("[" + x + ", " + y + ", " + z + "]");
	}

	public static Vector eZ() {
		return new Vector(0,0,1);
	}

}
