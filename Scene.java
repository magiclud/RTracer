import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scene {

	private Camera cameraLens;
	BufferedImage image;
	ArrayList<SceneObject> sceneElement = new ArrayList<SceneObject>();
	ArrayList<Light> sceneLight = new ArrayList<Light>();

	Map<Color, Boolean> pair = new HashMap<Color, Boolean>();

	private ArrayList<Vector> lights = new ArrayList<Vector>();
	private ArrayList<Sphere> obiects = new ArrayList<Sphere>();

	/*
	 * private double angleRadians; private double aspectRadio; private int
	 * noObjects; private int setNoLights;
	 */

	public Scene() {
		Camera camera = new Camera();
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < 800; ++x) {
			for (int y = 0; y < 600; ++y) {
				image.setRGB(x, y, new Color(100, 100, 100).getRGB());
			}
		}
		new Scene(camera, image);
	}

	public Scene(Camera camera, BufferedImage image) {
		this.cameraLens = camera;
		this.image = image;
	}

	BufferedImage render() {
		int displayWidth = cameraLens.getDisplayWidth();
		int displayHeight = cameraLens.getDisplayHeight();
		Ray ray;
		for (int x = 0; x < displayWidth; ++x) {
			for (int y = 0; y < displayHeight; ++y) {
				ray = cameraLens.throwRay(x, y);
				pair = trace(ray, 0);
				image.setRGB(x, y, new Color(100, 100, 100).getRGB());
			}
		}
		return image;
	}

	private Map<Color, Boolean> trace(Ray ray, int depth) {
		if (depth > 3) {
			pair.put(Color.white, false);
			return pair;
		}
		SceneElement zero = new SceneObject();
		Map<Integer, SceneElement> distObject = intersectScene(zero, ray);
		 if(distObject.keySet().iterator().next()>= SceneElement.inf){
		pair.put(Color.white, true);//BACKGROUND
		 return pair;
		 }
		 double dist = distObject.keySet().iterator().next();
		 SceneElement obj = new SceneObject();
		 obj = distObject.get(distObject.keySet().iterator().next());
		 Vector pointAtTimeV = ray.getPoint().add(ray.getDirection().scale(dist));
		 Vector pointAtTime = new Vector(pointAtTimeV.getX(),pointAtTimeV.getY(),pointAtTimeV.getZ());
		Color surface = getSurfaceColor(obj,pointAtTime, ray, depth);
		
		 pair.put(surface, true);
		return pair;
	}

	private Color getSurfaceColor(SceneElement obj, Vector pointAtTime,
			Ray ray, int depth) {
		Color elemColor = obj.elemColor();
		Vector b  = new Vector(elemColor.getRed(), elemColor.getGreen(), elemColor.getBlue());
		
		double lambertAmount = 0; 
		
		if(obj.isLambert()){
			for (Light it : sceneLight) {
				Light lightPoint = it;
				
				if(!isLightVisible(obj,pointAtTime, lightPoint.getPoint())){ 
					continue;
					
				}
				Vector contrV = lightPoint.getPoint().subtract(pointAtTime);
				contrV.normalize();
				
				double contribution = contrV.dotProduct(obj.normal(pointAtTime));
				
				if(contribution >0){
					lambertAmount += contribution;
				}

			}
			
		}
		if(lambertAmount > 1){
			lambertAmount = 1;
		}
		b = b.scale(lambertAmount*obj.getLambert()) ;
		if(b.getX()>255){
			b.setX( 255);
		}
		if(b.getY()>255){
			b.setY( 255);
		}
		if(b.getZ()>255){
			b.setZ( 255);
		}
		return new Color((int)b.getX(),(int)b.getY(),(int)b.getZ());
	}

	private boolean isLightVisible(SceneElement obj, Vector pointAtTime,
			Vector lightPonit) {
		Vector rayV = lightPonit.subtract(pointAtTime);
		rayV.normalize();
		Ray ray = new Ray(pointAtTime,rayV);
		Map<Integer, SceneElement> distObj = intersectScene(obj, ray);
		int first = distObj.keySet().iterator().next();
		if((distObj.get(first) ==null && first<0) ){
			System.out.println("First "+ first);
		}
		if(distObj.get(first)==null || first>0){
			return true;
		}
		return false;
	}

	private Map<Integer, SceneElement> intersectScene(SceneElement from, Ray ray) {
		Map<Integer, SceneElement> closest = new HashMap<>();
		closest.put(SceneElement.inf, new SceneObject());
		ArrayList<SceneElement> iterator = new ArrayList<SceneElement>();
		for (SceneElement object : sceneElement) {
			if (!sceneElement.equals(from)) {
				int dist = (int) object.intersectWith(ray);
				if (dist < SceneElement.inf
						&& dist < closest.keySet().iterator().next()) {
					closest.put(dist, object);

				}
			}

		}
		return closest;
	}

	void addSceneLight(Light sl){
		sceneLight.add(sl);
	}
	void addSceneElement(SceneObject s1){
		sceneElement.add(s1);
	}
//	class Closest{
//		   private int first;
//		    private SceneElement second;
//
//		    // Constructor or setter
//		    public void Stuff(Integer first, SceneElement second) {
//		        
//		        this.first = first;
//		        this.second = second;
//		    }
//
//		    // getters
//
//		    public Integer first() {
//		        return this.first;
//		    }
//
//		    public SceneElement second() {
//		        return this.second;
//		    }
//		}
	}

