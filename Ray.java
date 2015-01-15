
public class Ray {

	private Vector startPoint;
	private Vector direction;
	
	public Ray (){
		startPoint = new Vector (0,0,0);
		direction = new Vector(1,1,1);
		new Ray(startPoint, direction);
	}
    
    public Ray (Vector point, Vector direction){
    	this.startPoint = point;
    	this.direction = direction;
    }

	public Vector getPoint() {
		// TODO Auto-generated method stub
		return startPoint;
	}

	public Vector getDirection() {
		// TODO Auto-generated method stub
		return direction;
	}



}
