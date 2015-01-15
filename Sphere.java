import java.awt.Color;




public class Sphere implements SceneElement{

	private Vector pointCenter;
	private double r;
	private boolean lambert;
	private boolean spectacular;
	
	public Sphere(){}
	
	Sphere(Vector pointCenter, double r){
		this.pointCenter = pointCenter; 
		this.r = r;
	}
	@Override
	public Vector normal(Vector pos) {
		Vector temp = pos.subtract(pointCenter);
		temp.normalize();
		return temp;
	}

	private void move(){
		pointCenter.setX(pointCenter.getX()+0.01);
		pointCenter.setZ(pointCenter.getZ()+0.01);
		
	}
	@Override
	public double intersectWith(Ray ray) {
		Vector eyeToCenter = pointCenter.subtract(ray.getPoint());
		double v = eyeToCenter.dotProduct(ray.getDirection());
		double ec_dot = eyeToCenter.dotProduct(eyeToCenter);
		
		double discriminant = r*r + v*v - ec_dot;
		
		if(discriminant < 0){
			return inf;
		}else{
			return v - Math.sqrt(discriminant);
		}
	}

	@Override
	public int getLambert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLambert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Color elemColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
