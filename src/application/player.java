package application;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

class player {
	
	private int desx;
	private int desy;
	private int start_posx;
	private int start_posy;
	private int curr_posx;
	private int curr_posy;
	
	public int getDesx() {
        return desx;
    }

    public void setDesx(int desx) {
        this.desx = desx;
    }

    public int getDesy() {
        return desy;
    }

    public void setDesy(int desy) {
        this.desy = desy;
    }

    public int getStart_posx() {
        return start_posx;
    }

    public void setStart_posx(int start_posx) {
        this.start_posx = start_posx;
    }

    public int getStart_posy() {
        return start_posy;
    }

    public void setStart_posy(int start_posy) {
        this.start_posy = start_posy;
    }

    public int getCurr_posx() {
        return curr_posx;
    }

    public void setCurr_posx(int curr_posx) {
        this.curr_posx = curr_posx;
    }

    public int getCurr_posy() {
        return curr_posy;
    }

    public void setCurr_posy(int curr_posy) {
        this.curr_posy = curr_posy;
    }

    boolean tok_free[]=new boolean[4];
	int tok_positionx[]=new int[4];
	int tok_positiony[]=new int[4];
	boolean tok_completed[]=new boolean[4];
	int[][] tok_Pos_Ininial=new int[2][4];
	boolean tok_alive[]=new boolean[4];
	int tok_indx[]=new int[4];
	Circle[] tokens = new Circle[4];
	String name;
	String color;
	boolean won;
	
	player(String name,String color) {
		this.name=name;
		this.color=color;
		won=false;
	}
	
	public void ask2move(MouseEvent event) {
		desx=(int) event.getSceneX();
		desy=(int) event.getSceneY();
	}
}
