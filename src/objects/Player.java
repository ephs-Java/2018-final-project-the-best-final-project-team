package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.Game;
import game.GlobalPosition;

public class Player extends GlobalPosition{
	
	private String playerimage = "/images/Green_square.png";	//selects the player image from the image folder
	
	int velX = 0;
	int velY = 0;
	int prvX = 0;
	int prvY = 0;
	public JFrame frame;
	Food f;
	int length = 1;
	int IDIndex;
	public static int ID = 0;
	Player p;

	public Player(int x, int y, JFrame frame, Food f) {
		super(x, y);
		this.frame = frame;
		this.f = f;
		IDIndex = ID;
		ID++;
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getPrvX(){
		return prvX;
	}
	
	public int getPrvY(){
		return prvY;
	}
	
	public void setX(int h){
		this.x = h;
	}
	
	public void setY(int h){
		this.y = h;
	}
	
	public void printTail(){
	
	}
	
//	public ArrayList<Player> addTail(ArrayList<Player> length){
//		for(int i = 0; i < 3; i++){
//			if(length.size() == 0){
//				length.add(new Player(this.x,this.y,frame,f));
//			}
//			length.add(new Player(length.get(length.size() - 1).getPrvX() ,
//					length.get(length.size() - 1).getPrvY() , frame , f));
//		}
//	return length;	
//
//	}
//	
//	// shifts all items in the array list to the previous spot.
//	public ArrayList<Player> printTail(ArrayList<Player> length){
//		
//		//Game k = new Game();
//		length.get(0).setX(this.x);
//		length.get(0).setY(this.y);
//		for(int i = length.size() - 1; i > 0; i--){
//			length.set(i , length.get(i-1));
//		}
//		
//	return length;	
//		
//	}
	//updates the player
	
public void updateTail(){
	
		Game player = new Game();
		
		prvX = x;
		
		prvY = y;
		
		x = player.getPrvX();
		
		y = player.getPrvY();	
		
		
}
	
	
	public void update(){
		
//		Game player = new Game();
//		
//		p = player.getplayer();
		
		prvX = x;
		prvY = y;
		
		x += velX;
		y += velY;
		
		//Collision with the boarder
		if(x < 0){
			x = 0;
		}
		if(x > frame.getWidth() - getPlayerImageWidth()){
			x = frame.getWidth() - getPlayerImageWidth();
		}
		if(y < 0){
			y = 0;
		}
		if(y > frame.getHeight() - getPlayerImageHeight() - 30){
			y = frame.getHeight() - getPlayerImageHeight() - 30;
		}
		
		
		
		//Collision with Food
		if(x == f.getX() && y == f.getY()){
			
			//increase tail		ERROR
			
//			ArrayList<Player> len = new ArrayList<Player>();
//			
//			if(length == 1){
//				len.add(new Player(0, 0, frame, f));
//				length = 0;
//			}
//	
//			for(int i = 0 ; i < 3 ; i++){
//			len.add(new Player(0, 0, frame, f));
//			} 
			
			Game player = new Game();
			
			player.addToLen();
			
			//Reposition food
			int temp = (int)(Math.random() * frame.getWidth());
			f.setX(temp - temp%10);
			temp = (int)(Math.random() * frame.getHeight());
			f.setY(temp - temp%10 - 30);
			if( f.getY() < 0){
				f.setY(0);
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			velY = 0;
			velX = 10;
		}
		else if(key == KeyEvent.VK_LEFT){
			velY = 0;
			velX = -10;
		}
		else if(key == KeyEvent.VK_DOWN){
			velX = 0;
			velY = 10;
		}
		else if(key == KeyEvent.VK_UP){
			velX = 0;
			velY = -10;
		}
	}
	
//	public void keyReleased(KeyEvent e){
//		int key = e.getKeyCode();
//		
//		if(key == KeyEvent.VK_RIGHT){
//			velX = 0;
//		}
//		else if(key == KeyEvent.VK_LEFT){
//			velX = 0;
//		}
//		else if(key == KeyEvent.VK_DOWN){
//			velY = 0;
//		}
//		else if(key == KeyEvent.VK_UP){
//			velY = 0;
//		}
//	}
	
	//draws the player image at x y
	public void draw(Graphics2D g2d){
		g2d.drawImage(getPlayerImage(), x, y, null);	
		
	}
	
	//turns String Green Square into an image
	public Image getPlayerImage(){	
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
	
	//player image height
	public int getPlayerImageHeight(){
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getIconHeight();
	}
	
	//player image width
	public int getPlayerImageWidth(){
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getIconWidth();
	}

}
