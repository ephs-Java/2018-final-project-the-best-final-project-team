package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.GlobalPosition;

public class Tail extends GlobalPosition{
	
	private String tailImage = "/images/Green_square.png";

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
	
	//adds 3 items to length array list
	public ArrayList<Tail> addTail(ArrayList<Tail> length){
		for(int i = 0; i < 3; i++){
			length.add(new Tail(length.get(length.size() - 1).getX(),
					length.get(length.size() - 1).getY()));
		}
	return length;	

	}
	
	// shifts all items in the array list to the previous spot.
	public ArrayList<Tail> printTail(ArrayList<Tail> length){
		
		//Game k = new Game();
		length.get(0).setX(this.x);
		length.get(0).setY(this.y);
		for(int i = length.size() + 1; i > 0; i++){
			length.set(i , length.get(i-1));
		}
		
	return length;	
		
	}
}
