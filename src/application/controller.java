
package application;

import java.time.Duration;
import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;




public class controller extends Main {
	
	static int curr_player;

	
	@FXML private Label label9;
	
	@FXML private Button button;
	@FXML private Button roll_dice_2;
	 @FXML private Button backtomenu;
	
	@FXML private Button Start_Button;

	
	
    @FXML private ImageView roll_dice1;
    @FXML private ImageView roll_dice2;
    

    @FXML private ImageView img;

    @FXML private Label lab1;

    @FXML private Label lab2;
    @FXML private Label labb;

    @FXML private Circle rb1;
    @FXML private Circle rb2;
    @FXML private Circle rb3;
    @FXML private Circle rb4;

    @FXML private Circle yb1;
    @FXML private Circle yb2;
    @FXML private Circle yb3;
    @FXML private Circle yb4;
    


    boolean win=false;


    int path_red[][]= {{276,276,276,276,276,248,224,196,171,142,116,116,116,143,170,197,223,250,278,278,278,278,278,278,306,330,330,330,330,330,330,358,382,410,438,463,491,491,491,462,436,410,382,356,328,328,328,328,328,328,302,302,302,302,302,302,302},
    			       {358,334,307,279,254,228,228,228,228,228,228,201,174,174,174,174,174,174,146,120,92,66,38,13,13,13,39,66,94,124,146,174,174,174,174,174,174,198,226,226,226,226,226,226,254,280,307,337,359,388,388,362,333,307,278,252,222}};

    int path_yellow[][]= {{330,330,330,330,330,358,382,410,438,463,491,491,491,462,436,410,382,356,328,328,328,328,328,328,302,278,276,276,276,276,276,248,224,196,171,142,116,116,116,143,170,197,223,250,278,278,278,278,278,278,306,302,302,302,302,302,302},
    					{39,66,94,124,146,174,174,174,174,174,174,198,226,226,226,226,226,226,254,280,307,337,359,388,388,388,358,334,307,279,254,228,228,228,228,228,228,201,174,174,174,174,174,174,146,120,92,66,38,13,13,39,66,95,120,146,178}};
     static int start_pos[][]= {{226,330},{358,39}};
    static player[] play = new player[2];

    
    
    public void initialize() {
    	
    	rb1.setVisible(false);
    	rb2.setVisible(false);
    	rb3.setVisible(false);
    	rb4.setVisible(false);
    	yb1.setVisible(false);
    	yb2.setVisible(false);
    	yb3.setVisible(false);
    	yb4.setVisible(false);
    	img.setVisible(false);
    	
    	
    	
     
    	roll_dice1.setVisible(false);
    	roll_dice2.setVisible(false);
    	roll_dice_2.setVisible(false);
    	button.setVisible(false);
    	lab1.setVisible(false);
    	lab2.setVisible(false);
    	backtomenu.setVisible(false);

    	
    	
    	
    	
    	
    	curr_player=0;
    	
    	
    }
    

    public int getMoved_no1() {
        return moved_no1;
    }

    public void setMoved_no1(int moved_no) {
        this.moved_no1 = moved_no;
    }

    private int moved_no1;
    private int moved_no2;
    public int getMoved_no2() {
        return moved_no2;
    }

    
    
    
    
    void Roll_dice(int rndm) {
    	Thread thread =new rooldice().setRandom(rndm);
    	thread.start();
    	
    }
    
    
    
    public void Roll_dice2(int rndm){

        RotateTransition rotate6 =new RotateTransition();
        rotate6.setNode(roll_dice2);
        //rotate6.setDuration(Duration.millis(800));
        rotate6.setCycleCount(2);
        rotate6.setInterpolator(Interpolator.LINEAR);
        rotate6.setByAngle(360);
        rotate6.setAxis(Rotate.Z_AXIS);
        rotate6.setAutoReverse(true);

       
        moved_no2=rndm;



        ScaleTransition scale =new ScaleTransition();
        scale.setNode(roll_dice2);
        //scale.setDuration(Duration.millis(800));
        scale.setCycleCount(2);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setAutoReverse(true);
        scale.setByX(2.0);
        scale.setByY(2.0);
        ParallelTransition pt=new ParallelTransition(roll_dice2,rotate6,scale);
        pt.play();

        Image myImage= new Image(getClass().getResourceAsStream("image/D_"+rndm+".png"));
        roll_dice2.setImage(myImage);

//        System.out.println("dice 2 rolled");
    }

	
    public int getRandomNumber(int min, int max) {
        int x=(int) ((Math.random() * (max - min)) + min);
    	return x;
    }
    
   

    
   //for starting the game
    //intialised the player and token
    @FXML
    void Start_Game() {
    	
    	System.out.println(" Game started");
    	String color="#FF0000";
		String name;
		play[0] = new player("Ujjwal","RED");
		play[0].tokens[0]=rb1;
		play[0].tokens[1]=rb2;
		play[0].tokens[2]=rb3;
		play[0].tokens[3]=rb4;
		
		play[0].tok_Pos_Ininial[0][0]=214;
		play[0].tok_Pos_Ininial[1][0]=319;
		play[0].tok_Pos_Ininial[0][1]=185;
		play[0].tok_Pos_Ininial[1][1]=354;
		play[0].tok_Pos_Ininial[0][2]=150;
		play[0].tok_Pos_Ininial[1][2]=321;
		play[0].tok_Pos_Ininial[0][3]=186;
		play[0].tok_Pos_Ininial[1][3]=289;
		
		for(int i=0;i<4;i++) {
			play[0].tok_alive[i]=false;
			play[0].tok_completed[i]=false;
			play[0].tok_free[i]=false;
			play[0].tok_indx[i]=-1;
		}
		
		play[0].setStart_posx(276);
		play[0].setStart_posy(358);
		
//		System.out.println("Player 1 intialised");
		
		
		// for player 2
		
		String color2="#FFFF00";
		String name2;
		play[1] = new player("Shivam","Yellow");
		play[1].tokens[0]=yb1;
		play[1].tokens[1]=yb2;
		play[1].tokens[2]=yb3;
		play[1].tokens[3]=yb4;
		 
		play[1].tok_Pos_Ininial[0][0]=388;
		play[1].tok_Pos_Ininial[1][0]=83;
		play[1].tok_Pos_Ininial[0][1]=424;
		play[1].tok_Pos_Ininial[1][1]=112;
		play[1].tok_Pos_Ininial[0][2]=425;
		play[1].tok_Pos_Ininial[1][2]=46;
		play[1].tok_Pos_Ininial[0][3]=456;
		play[1].tok_Pos_Ininial[1][3]=82;
		
		for(int i=0;i<4;i++) {
			play[1].tok_alive[i]=false;
			play[1].tok_completed[i]=false;
			play[1].tok_free[i]=false;
			play[1].tok_indx[i]=-1;
		}
		
		play[1].setStart_posx(330);
		play[1].setStart_posy(39);
		
//		System.out.println("Player 2 intialised");
		
		
		
		Start_Button.setVisible(false);
		rb1.setVisible(true);
    	rb2.setVisible(true);
    	rb3.setVisible(true);
    	rb4.setVisible(true);
    	yb1.setVisible(true);
    	yb2.setVisible(true);
    	yb3.setVisible(true);
    	yb4.setVisible(true);
    	img.setVisible(true);
    	roll_dice1.setVisible(true);
    	roll_dice2.setVisible(true);
    	roll_dice_2.setVisible(true);
    	button.setVisible(true);
    	lab1.setVisible(true);
    	lab2.setVisible(true);
    	backtomenu.setVisible(true);
    	label9.setVisible(false);
    	
    	

    	
   }
    
    // return the token to intial point and game start again
    
    public void Backto_menu() {
    	move_to_start(play[0],1);
    	move_to_start(play[0],2);
    	move_to_start(play[0],3);
    	move_to_start(play[0],4);
    	move_to_start(play[1],1);
    	move_to_start(play[1],2);
    	move_to_start(play[1],3);
    	move_to_start(play[1],4);
    	
    	for(int i=0;i<4;i++) {
			play[1].tok_alive[i]=false;
			play[1].tok_completed[i]=false;
			play[1].tok_free[i]=false;
			play[1].tok_indx[i]=-1;
		}
    	for(int i=0;i<4;i++) {
			play[0].tok_alive[i]=false;
			play[0].tok_completed[i]=false;
			play[0].tok_free[i]=false;
			play[0].tok_indx[i]=-1;
			
		}
    	
//    	System.out.println("back to menu");
    	
    }
    
    // changes the image of dice
    public void changeDice(int x) {
		
		if(play[curr_player].name=="Shivam") {
			Roll_dice2(x);
			lab2.setText(""+x);
//			System.out.println("change dice called for player 2");
		}
		else {
			Roll_dice(x);
			lab1.setText(""+x);
//			System.out.println("change dice called for player 1");
		}
		
		
	}
	
    // rolling the dice
    @FXML
    public void roll() {
    win=false;
    
    int x=getRandomNumber(1,7);
   if(play[curr_player].name=="Ujjwal") {
	   changeDice(x);
	   button_visible();
//	   System.out.println("inside roll function for ujjwal");
	   
   }
   if(play[curr_player].name=="Shivam") {
	   changeDice(x);
	   button_visible();
//	   System.out.println("inside roll function for shivam");
   }
    
    int alive = 0;
    for(int i=0;i<4;i++) {
    	if(play[curr_player].tok_alive[i]==true) {
    		alive++;
    	}
    }
    
    if(x==6) {
    
    		if(alive>1 && alive<4){
        		
        		int g = 0;
        		for(int i=0;i<4;i++) {
        			if(!play[curr_player].tok_free[i]) {
        				g=i;
        			}
        		}
        		win=movetoken(play[curr_player],g,x);

        	}
        	int k=0;
        	if(alive==4) {
        		for(int i=0;i<4;i++) {
        			if(!play[curr_player].tok_completed[i]) {
        				k=i;
        			}
        		}
        		win=movetoken(play[curr_player],k,x);
        		changeplayer();

        	}
        	if(alive==1 ) {
        		int p = 0;
        		for(int i=0;i<4;i++) {
        			if(!play[curr_player].tok_alive[i] ) {
        				p=i;
        				break;
        			}
        		}
        		win=movetoken(play[curr_player],p,x);

        	}
    	
    	
    	
    	//roll()
    	if(alive==0) {
    		int z=0;
    		for(int i=0;i<4;i++) {
            	if(play[curr_player].tok_alive[i]==false) {
            		z=i;
            		break;
            	}
            }
    		play[curr_player].tokens[z].setLayoutX(play[curr_player].getStart_posx());
    		play[curr_player].tokens[z].setLayoutY(play[curr_player].getStart_posy());
    		play[curr_player].tok_alive[z]=true;
    		play[curr_player].tok_free[z]=true;
    		play[curr_player].tok_positionx[z]=play[curr_player].getStart_posx();
    		play[curr_player].tok_positiony[z]=play[curr_player].getStart_posy();
    		play[curr_player].tok_indx[z]=0;
//    		System.out.println("token index changed to zero for token no "+z);
//    		System.out.println("token moved to start for"+ play[curr_player]);
    		changeplayer();
    		button_visible();
    		
    		
    	}
    		
    }else {
    
     if(alive==1 ) {
    	int y=0;
    	for(int i=0;i<4;i++) {
        	if(play[curr_player].tok_alive[i]==true && !play[curr_player].tok_completed[i]) {
        		y=i;
        		break;
        	}
        }
    	win=movetoken(play[curr_player],y,x);
    	
    	System.out.println("token 1 moved to start for"+ play[curr_player]);
    	
    	
    }
     if(alive>1 && alive<4){
 		
 		int g = 0;
 		for(int i=0;i<4;i++) {
 			if(play[curr_player].tok_free[i] && !play[curr_player].tok_completed[i] ) {
 				g=i;
 			}
 		}
 		win=movetoken(play[curr_player],g,x);
 	}
 	int k=0;
 	if(alive==4) {
 		for(int i=0;i<4;i++) {
 			if(!play[curr_player].tok_completed[i] && !play[curr_player].tok_completed[i]) {
 				k=i;
 			}
 		}
 		win=movetoken(play[curr_player],k,x);
 	}
 	

 
    }
    if(win) {
    	play[curr_player].won=true;
    	
    }
    
    int l=0;
	for(int i=0;i<4;i++) {
		if(play[curr_player].tok_completed[i]) {
			l++;
		}
	}
	if(l==4) {
		rb1.setVisible(false);
    	rb2.setVisible(false);
    	rb3.setVisible(false);
    	rb4.setVisible(false);
    	yb1.setVisible(false);
    	yb2.setVisible(false);
    	yb3.setVisible(false);
    	yb4.setVisible(false);
    	img.setVisible(false);
    	
    	
    	
     
    	roll_dice1.setVisible(false);
    	roll_dice2.setVisible(false);
    	roll_dice_2.setVisible(false);
    	button.setVisible(false);
    	lab1.setVisible(false);
    	lab2.setVisible(false);
    	backtomenu.setVisible(false);
    	
    	Start_Button.setText(play[curr_player].name+" won");
    	Start_Button.setVisible(true);
//		System.out.println(play[curr_player].name+" won");
		return;
	}
    changeplayer();
//    System.out.println("[player changed");
    
    }
    
    //changes player
    private void changeplayer() {
    	if(curr_player==1) {
    		curr_player=0;
//    		System.out.println("curr player is now ujjwal");
    	}else  {
    		curr_player=1;
//    		System.out.println("curr player is now shivam");
    	}
	}

    // moves the token to the required value
	public boolean movetoken(player pl,int tok,int x) {
    	win=false;
//    	System.out.println("inside move toekn function");

    	
    	if(!play[curr_player].tok_free[tok]) {
    		
    		if(x!=6) {
//    			System.out.println("token not free and 6 is not ");
    			
    			
    		}
    		if(x==6) {
    			if(pl.name=="Ujjwal") {
    				pl.tokens[tok].setLayoutX(276);
    				pl.tokens[tok].setLayoutY(358);
    				pl.setStart_posx(276);
    				pl.setStart_posy(358);;
    				pl.tok_free[tok]=true;
    				pl.tok_alive[tok]=true;
    				pl.tok_indx[tok]=0;
    				
    			}
    			if(pl.name=="Shivam") {
    				pl.tokens[tok].setLayoutX(330);
    				pl.tokens[tok].setLayoutY(39);
    				pl.setStart_posx(330);
    				pl.setStart_posy(39);;
    				pl.tok_free[tok]=true;
    				pl.tok_alive[tok]=true;
    				pl.tok_indx[tok]=0;
    			}
    			System.out.println("token not free and dice =6");
    			check_eatables(tok);
    			changeplayer();
    			button_visible();
    		}
    	}
    	else {
//    		bool t=false;
    		
    		int a=pl.tok_indx[tok];
    		int b=pl.tok_indx[tok];
//    		System.out.println(a);
//    		System.out.println(b);
//    		System.out.println(path_red[0].length);
    		if(a+x<57 && b+x<57){
    			if(pl.name=="Ujjwal") {
    				pl.tokens[tok].setLayoutX(path_red[0][a+x]);
    				pl.tokens[tok].setLayoutY(path_red[1][b+x]);
    				pl.tok_indx[tok]+=x;
    				check_eatables(tok);
    				
//    				a=play[curr_player].tok_positionx[path_red[0][a+x]];
//    				b=play[curr_player].tok_positiony[path_red[0][b+x]];
//    				System.out.println("ujjwal alive and dice="+ x);
    				
    			}
    			else {
        			pl.tokens[tok].setLayoutX(path_yellow[0][a+x]);
        			pl.tokens[tok].setLayoutY(path_yellow[1][b+x]);
        			pl.tok_indx[tok]+=x;
        			check_eatables( tok);
//    				a=play[curr_player].tok_positionx[path_yellow[0][a+x]];
//    				b=play[curr_player].tok_positiony[path_yellow[0][b+x]];
//        			System.out.println("shivam alive and dice="+ x);
    			}
        		if(a+x==56 && b+x==56) {
        			pl.tok_completed[tok]=true;
        			pl.tok_alive[tok]=false;
        			changeplayer();
//        			t=true;
        		}
    		}
    		
    	
    		
    	}
    	int d=0;
    	for(int i=0;i<4;i++) {
    		if(play[curr_player].tok_completed[i]==true) d++;
    	}
    	if(d==4) {
    		win=true;
    	}
//    	else return false;
    	return win;
    }
	
	@FXML
    void token_button_clicked(MouseEvent event) {
		
		//getting the token number of the clicked token
		Circle circ=(Circle) event.getSource();
		String id=circ.getId();
		String k;
		k=id.substring(2,3);
		int i=Integer.parseInt(k);
		
		int y=0;  
		int m=0;
		
		String dice_no=id.substring(0,1);
		System.out.println("dice no is "+ dice_no);
		if(dice_no=="y") {
			y=1;
			m=Integer.parseInt(lab1.getText());
		}else {
			y=0;
			m=Integer.parseInt(lab2.getText());
		}
		
		
		// i= token number
		//y= player no.
		//m= dice no you got
//		System.out.println("inside token button movement finction");
//		System.out.println("token no."+ i);
//		System.out.println("player "+y);
//		System.out.println("dice no "+ m);
		
		
			
			win=movetoken(play[y],i-1,m);
		
			
		
		if(win) {
			int d=0;
	    	for(int i1=0;i1<4;i1++) {
	    		if(play[y].tok_completed[i1]==true) d++;
	    	}
	    	if(d==4) {
//	    		System.out.println(play[y].name +"won");
	    	}
		}
		
		
		
		
    }
	
	void move_to_start(player p,int tok) {
	
			if(p.name=="Ujjwal") {
				if(tok==1) {
					p.tokens[0].setLayoutX(214);
					p.tokens[0].setLayoutY(319);
				}
				if(tok==2) {
					p.tokens[1].setLayoutX(185);
					p.tokens[1].setLayoutY(354);
				}
				if(tok==3) {
					p.tokens[2].setLayoutX(150);
					p.tokens[2].setLayoutY(321);
				}
				if(tok==4) {
					p.tokens[3].setLayoutX(186);
					p.tokens[3].setLayoutY(289);
				}
			}
			if(p.name=="Shivam") {
				if(tok==1) {
					p.tokens[0].setLayoutX(388);
					p.tokens[0].setLayoutY(83);
				}
				if(tok==2) {
					p.tokens[1].setLayoutX(424);
					p.tokens[1].setLayoutY(112);
				}
				if(tok==3) {
					p.tokens[2].setLayoutX(425);
					p.tokens[2].setLayoutY(46);
				}
				if(tok==4) {
					p.tokens[3].setLayoutX(456);
					p.tokens[3].setLayoutY(82);
				}
			}
			
		
	}
	
	void button_visible() {
		
			if(play[curr_player].name=="Ujjwal") {
				
				roll_dice_2.setDisable(false);
				button.setDisable(true);
				
			}
			else{
				button.setDisable(false);
				roll_dice_2.setDisable(true);
			}
		
	}
	void check_eatables(int tok) {
		
		for(int i=0;i<4;i++) {
			if(play[curr_player].tokens[tok].getLayoutX()==play[curr_player^1].tokens[i].getLayoutX()&&
					play[curr_player].tokens[tok].getLayoutY()==play[curr_player^1].tokens[i].getLayoutY()) {
				play[curr_player^1].tokens[tok].setLayoutX(play[curr_player^1].tok_Pos_Ininial[0][tok]);
				play[curr_player^1].tokens[tok].setLayoutY(play[curr_player^1].tok_Pos_Ininial[1][tok]);
				break;

			}
			

		}
	}
    class rooldice extends Thread {
        private int rndm;
        public rooldice setRandom(int rndm){
            this.rndm = rndm;
            return this;
        }
        public void run(){
            RotateTransition rotate6 =new RotateTransition();
        rotate6.setNode(roll_dice1);
        //rotate6.setDuration(Duration.millis(800));
        rotate6.setCycleCount(2);
        rotate6.setInterpolator(Interpolator.LINEAR);
        rotate6.setByAngle(360);
        rotate6.setAxis(Rotate.Z_AXIS);
        rotate6.setAutoReverse(true);

       
        moved_no1=rndm;



        ScaleTransition scale =new ScaleTransition();
        scale.setNode(roll_dice1);
        //scale.setDuration(Duration.millis(800));
        scale.setCycleCount(2);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setAutoReverse(true);
        scale.setByX(2.0);
        scale.setByY(2.0);
        ParallelTransition pt=new ParallelTransition(roll_dice1,rotate6,scale);
        pt.play();

        Image myImage= new Image(getClass().getResourceAsStream("image/D_"+rndm+".png"));
        roll_dice1.setImage(myImage);
        // System.out.println("dice 1 rolled");
            
        }
    
    
    
    
    
    
    }
    

}

