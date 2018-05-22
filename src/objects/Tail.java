package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.GlobalPosition;

public class Tail extends GlobalPosition{
	
	
	//Frame
	public JFrame frame;
	
	//Food
	Food f;
	
	//String
	private String tailImage = "/images/Green_square.png";
	
	
	//Constructors
	public Tail(int x, int y) {
		super(x , y);
	}
	
	public Tail() {
		super(0,0);
	}
	
	
	//Getters & setters
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
	
	
	//updates the tail
	public void update(){
		
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getTailImage(), x, y, null);	

	}
	
	public Image getTailImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(tailImage));
		return i.getImage();
	}
	
}
