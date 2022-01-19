package application;

import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;

public class tokens {
	public int argx;
	public int argy;
	public int currx;
	public int curry;
	public Circle circ;
	 
	tokens(Circle circ){
		 Bounds bis=circ.localToScene(circ.getBoundsInLocal());
		 this.circ=circ;
		 argx=(int) bis.getMinX();
		 argy=(int) bis.getMinY();
		 
		 currx=argx;
		 curry=argy;
	 }
	 
	void makeAmove(player p,Circle circ) {
		circ.setTranslateX(p.getDesx()-argx);
		circ.setTranslateY(p.getDesy()-argy);
	}
}
