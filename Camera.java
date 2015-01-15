
public class Camera {

	private Vector point;//standPoint -> PointR3 standPoint
	private Vector point2;//destPoint
	private int fieldOfView;

	private Vector vpUp; 
	private Vector vpRight;
	private Vector eyeVector;
	
	private double halfWidth;
	private double halfHeight;
	private double cameraWidth;  //  -> unitWidth;
	private double cameraHeight; 
	private int pixelDw; // ->displayWidth;
	private int pixelDh;
	
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
	//void setCameraLens(int displayWidth, int displayHeight)
	void setCameraLens(int displayWidth, int displayHeight) {
	   
		this.pixelDw = displayWidth;
		this.pixelDh = displayHeight;
		
		double fovRadians = 3.14 * (fieldOfView / 2) / 180;
	    double hwRadio = (double) displayHeight / displayWidth;

	    halfWidth = Math.tan(fovRadians);
	    halfHeight = hwRadio * halfWidth;

	    //unitHeight
	    cameraWidth = 2*halfWidth / (displayWidth - 1);
	    cameraHeight = 2*halfHeight / (displayHeight - 1);
	}
	
/**************************88?????????????????????*****************/
	//Ray CameraLens::throwRay(int x, int y) {
	Ray throwRay(int x, int y){
		   Vector xVect = getVpRight().scale( (x*cameraWidth) - halfWidth );
		    Vector yVect = getVpUp().scale( (y*cameraHeight) - halfHeight );
		    Vector direct = getEyeVector().addThreeVec(xVect,yVect);
		    direct.normalize();
		    return  new Ray(getPoint(), direct);
	}

	public Vector getEyeVector() {
	return eyeVector;
}

	public Vector getVpUp() {
	return vpUp;
}

public Vector getVpRight() {
	return vpRight;
}

	int getDisplayWidth()
	{
	    return pixelDw;
	}
	int getDisplayHeight()
	{ 
		return pixelDh;
	}
}
