package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.GlobalPosition;

public class Player extends GlobalPosition{
	
	private String playerimage = "/images/Green_square.png";	//selects the player image from the image folder
	
	int velX = 0;
	int velY = 0;
	public JFrame frame;
	Food f;
	int length = 1;
	public  ArrayList<Tail> len;

	public Player(int x, int y, JFrame frame, Food f) {
		super(x, y);
		this.frame = frame;
		this.f = f;
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void printTail(){
	
	}
	//updates the player
	public void update(){
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
			if(length == 1){
				len.add(new Tail(x,y));
			}
	
//			for(int i = 0 ; i < 3 ; i++){
//			Tail g = new Tail(len.get(len.size() - 1).getX(), len.get(len.size() - 1).getY());
//			len.add(g);
//			length++;
//			} 
			
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
