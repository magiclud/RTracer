
public class Camera {

	private Vector point;
	private Vector point2;
	private int angle;
	
	public Camera(Vector point, Vector point2, int angle) {
		setPoint(point);
		setPoint2(point2);
		setAngle(angle);
	}

	public Vector getPoint2() {
		return point2;
	}

	public void setPoint2(Vector point2) {
		this.point2 = point2;
	}

	public Vector getPoint() {
		return point;
	}

	public void setPoint(Vector point) {
		this.point = point;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

}
