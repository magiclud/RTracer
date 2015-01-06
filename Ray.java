
public class Ray {

	private Vector point;
	private Vector direction;
	
	public Ray (){
		point = new Vector (0,0,0);
		direction = new Vector(1,1,1);
		new Ray(point, direction);
	}
    
    public Ray (Vector point, Vector direction){
    	this.point = point;
    	this.direction = direction;
    }
	public Vector getPoint() {
		return point;
	}

	public Vector getDirection() {
		return direction;
	}


}
