import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class RayTracer  extends JPanel {

	private static int alpha = 0;
	private static int beta = 0;
	private static int pR1 = 0;
	private static int pR2 = 0;
	static double	rozmiar = 0.75;
	   static final int CANVAS_WIDTH = 640;
	   static final int CANVAS_HEIGHT = 480;
	static double height=640*rozmiar;
	static double width = 480*rozmiar;
	public static final String TITLE = "Ray Tracer";
	BufferedImage image;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RayTracer(){
		
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		Scene scene = new Scene();
		setUp(scene,height, width);
		ustawPlanety(scene);
		render(scene,height, width);
		
	}
	 /** Custom painting codes on this JPanel */
	   @Override
	   public void paintComponent(Graphics g) {
	      super.paintComponent(g); 
	      Graphics2D g2d = (Graphics2D)g;
	  /*    BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	      for(int x = 0; x < 800; ++x) {
	    	  for(int y = 0; y < 600; ++y) {
	    		  image.setRGB(x, y, new Color(x%255,y%255,(x+y)%255).getRGB());
	    	  }
	      } */
	     g2d.drawImage(image, null, null);
	   }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  // Run the GUI codes on the Event-Dispatching thread for thread safety
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            JFrame frame = new JFrame(TITLE);
	            frame.setContentPane(new RayTracer());
	            frame.pack();
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setLocationRelativeTo(null); // center the application window
	            frame.setVisible(true);
	         }
	      });
	      
		}
	//TODO//RENDEROWANIE SCENY !!!!!!!!!!!!!
	private static void render(Scene scene, double height, double width) {
		//rozpakowuję scenę, aby wygodniej odwoływać się do obiektów
	/*	Vector eyeVector = scene.getEyeVector();
		Vector vpRight = scene.getVpRight();
		Vector vpUp = scene.getVpUp();
		double halfWidth = scene.getHalfWidth(); 
		double halfHeight = scene.getHalfHeight(); 
		double pixelDw = scene.getPixelDw();
		double pixelDh = scene.getPixelDh();
		
		Ray ray = new Ray();
		ray.setPoint(scene.getCamera().getPoint());//początek promienia
		
		for(int x =0; x<width; x++){
			//przeliczmy pixel znormalizowany od kamery do sceny
			
			Vector	xComponent = vpRight.scale(x*pixelDw-halfWidth); 
			for(int y=0; y<height; y++){
				Vector yComponent = vpUp.scale(y*pixelDh-halfHeight);
				Vector pom = eyeVector.addThreeVec(xComponent, yComponent);
				ray.setVector(pom.normalize(pom));
				//Vector color = trace(ray,scene,0);
				int index = (x+y*(int)width)*4;
//				data[index]= color.getX();
//				data[index]
				//TODO!!!!!!!!!!!!!!!!!!data.data ? 
			}
		}*/
		
	}


	
	private static void ustawPlanety(Scene scene) {
		Vector p0 = ((Sphere) scene.getObiects().get(0)).getPoint();
		Vector p1 =  ((Sphere) scene.getObiects().get(1)).getPoint();
		Vector p2 =  ((Sphere) scene.getObiects().get(2)).getPoint();
		p1.setX(Math.sin(alpha)*pR1 +p0.getX()) ;
		p1.setY(Math.cos(alpha)*pR1 +p0.getY()) ;
		p1.setZ(p0.getZ());
		p2.setX(p1.getX()+ Math.sin(beta)*pR2);
		p2.setY(p1.getY()+ Math.cos(beta)*pR2);
		p2.setZ(p0.getZ()+ Math.cos(beta)*pR2*0.5);
	}

	private static Scene setUp(Scene scene, double height, double width) {
		scene.setCamera(new Camera(new Vector(0,-20,5), new Vector(0,0,0),30));
		//scene.addLight(new Vector(-30,10,0));
		Vector nn = new Vector(10,0,0);
		scene.addLight(nn);
		scene.addObiect(new Sphere(0,0,0, 20,20,255, 0.5,0.7,0.2, 1.0));//planeta
		scene.addObiect(new Sphere(0,0,0, 255,255,0, 0.1,0.9,0.2, 0.5));//duzy Ksiezyc
		scene.addObiect(new Sphere(0,0,0, 255,0,0, 0.2,0.7,0.2, 0.2));//maly Ksiezyc
		return scene;

		/**wyznaczam reper kamery**/
	/*	Vector pom = scene.getCamera().getPoint2().subtract(scene.getCamera().getPoint());
	//	pom.subtract(scene.getCamera().getPoint()); 
		pom = pom.normalize(pom);
		scene.setEyeVector(pom);
		pom = pom.normalize(scene.getEyeVector().crossProduct(new Vector(0,0,1)));
		scene.setVpRight(pom);
		pom = pom.normalize(scene.getVpRight().crossProduct(scene.getEyeVector()));
		scene.setVpUp(pom);
		/*************************/
		
/*		scene.setAngleRadians(Math.PI*(scene.getCamera().getAngle()/2)/180);//zmiana stopni na radiany
		scene.setAspectRadio(height/width);
		scene.setHalfWidth(Math.tan(scene.getAngleRadians()));
		scene.setHalfHeight(scene.getAspectRadio()*scene.getHalfWidth());
		scene.setCameraWidth(scene.getHalfWidth()*2);
		scene.setCameraHeight(scene.getHalfHeight()*2);
		scene.setPixelDw(scene.getCameraWidth()/(width-1));
		scene.setPixelDh(scene.getCameraHeight()/(height-1));
		scene.setNoObjects(scene.getObiects().size()); 
		scene.setNoLights(scene.getLights().size());
		return scene;*/
	}

 
//
//    public void run() {
//        Graphics g = getGraphics();
//        long time = System.currentTimeMillis();
//        for (int j = 0; j < height; j++) {
//            showStatus("Scanline "+j);
//            for (int i = 0; i < width; i++) {
//                renderPixel(i, j);
//            }
//            g.drawImage(screen, 0, 0, this);        // doing this less often speed things up a bit
//        }
//        g.drawImage(screen, 0, 0, this);
//        time = System.currentTimeMillis() - time;
//        showStatus("Rendered in "+(time/60000)+":"+((time%60000)*0.001));
//        finished = true;
//    }


	
	


	
	
	

}
