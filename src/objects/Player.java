package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.Game;
import game.GlobalPosition;

public class Player extends GlobalPosition{
	
	private String playerimage = "/images/Green_square.png";	//selects the player image from the image folder
	
	//ints
	int velX = 0;
	int velY = 0;
	int prvX = 0;
	int prvY = 0;
	int length = 1;
	int IDIndex;
	public static int ID = 0;
	
	//JFrame
	public JFrame frame;
	
	//Food
	Food f;
	
	//Player
	Player p;


	public Player(int x, int y, JFrame frame, Food f) {
		super(x, y);
		this.frame = frame;
		this.f = f;
		IDIndex = ID;
		ID++;
		
		prvX = 0;
		prvY = 0;
		
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
	
	public void updateTail(int i){
	
		Game player = new Game();
		
		prvX = x;
		
		prvY = y;
		
		x = player.getPrvX(i);
		
		y = player.getPrvY(i);	
		
		
}
	
	public void update(){
		
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
			
			//adds to len
			Game player = new Game();
			player.addToLen();
			
			//Reposition food
			int temp = (int)(Math.random() * frame.getWidth());
			f.setX(temp - temp%10);
			temp = (int)(Math.random() * frame.getHeight());
			if( temp > 22){
				temp -= 22;
			}
			f.setY(temp - temp%10 - 30);
			if( f.getY() < 0){
				f.setY(0);
			} //if
			
		} //Collision with Food
		
	} //update
	
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
		
	} //keyPressed
	
	public void draw(Graphics2D g2d){		//draws the player image at x y
		g2d.drawImage(getPlayerImage(), x, y, null);	
		
	}
	
	public Image getPlayerImage(){			//turns String Green Square into an image
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
	
	public int getPlayerImageHeight(){		//player image height
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getIconHeight();
	}
	
	public int getPlayerImageWidth(){		//player image width
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getIconWidth();
	}

}
