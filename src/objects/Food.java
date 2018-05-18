package objects;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.GlobalPosition;

public class Food extends GlobalPosition{
	
	private String foodImage = "/images/Red_square.jpg";
	
	JFrame frame;
	
	
	public Food(int x, int y, JFrame frame){
		
		super(x - x%10, y - y%10);
		this.frame = frame;
		
	}
	
	//updates the food
	public void update(){
		int temp = (int)(Math.random() * frame.getWidth());
		x = temp - temp%10;
		
		temp = (int)(Math.random() * frame.getHeight());
		y = temp - temp%10;
	}
	
	//draws the food image at x y
	public void draw(Graphics2D g2d){
		g2d.drawImage(getFoodImage(), x, y, null);
	}
	
	//turns food string into an image
	public Image getFoodImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(foodImage));
		return i.getImage();
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
		
}
