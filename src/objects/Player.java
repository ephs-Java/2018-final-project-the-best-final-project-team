package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import game.GlobalPosition;

public class Player extends GlobalPosition{
	
	private String playerimage = "/images/player.png";	//selects the player image from the image folder
	
	int velX = 0;
	int velY = 0;

	public Player(int x, int y) {
		super(x, y);
		
	}
	//updates the player
	public void update(){
		x += velX;
		y += velY;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			velX = 5;
		}
		else if(key == KeyEvent.VK_LEFT){
			velX = -5;
		}
		else if(key == KeyEvent.VK_DOWN){
			velY = 5;
		}
		else if(key == KeyEvent.VK_UP){
			velY = -5;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			velX = 0;
		}
		else if(key == KeyEvent.VK_LEFT){
			velX = 0;
		}
		else if(key == KeyEvent.VK_DOWN){
			velY = 0;
		}
		else if(key == KeyEvent.VK_UP){
			velY = 0;
		}
	}
	
	//draws the player image at x y
	public void draw(Graphics2D g2d){
		g2d.drawImage(getPlayerImage(), x, y, null);	
		
	}
	
	//turns String playerimage into an image
	public Image getPlayerImage(){	
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
		
	}

}
