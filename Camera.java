
public class Camera {

	private Vector point;//standPoint -> PointR3 standPoint
	private Vector point2;//destPoint
	private int fieldOfView;

	private Vector vpUp; 
	private Vector vpRight;
	private Vector eyeVector;
	
	public Camera() {
	    new Camera(new Vector(0,0,0), new Vector(1,1,1), 45);
	}
	
	public Camera(Vector point, Vector point2, int fieldOfView) {
		this.point = point;
		this.point2 = point2;
		this.fieldOfView = fieldOfView;
		
		eyeVector = point2.subtract(point);
		vpRight = eyeVector.crossProduct(Vector.eZ());   // vpRight = eyeVector^VectorR3::eZ();
		vpUp = vpRight.crossProduct(eyeVector);

		eyeVector.normalize();
		vpRight.normalize();
		vpUp.normalize();
	}

	public Vector getPoint2() {
		return point2;
	}

	public Vector getPoint() {
		return point;
	}

	public int getFieldOfView() {
		return fieldOfView;
	}
}
