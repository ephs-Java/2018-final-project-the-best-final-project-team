package objects;

import java.util.ArrayList;

import javax.swing.JFrame;

public class TailList {

	public static ArrayList<Player> len;
	
	public static int count;
	
	public JFrame frame;
	
	public Food f;
	
		public TailList(){
			
			if( count == 0){
				
				len.add(new Player(0,0,frame,f));
				
			}
			
			count++;
			
		}
		
		public ArrayList<Player> getTail(){
			
			return len;
			
		}
		
		public void setTail(public ArrayList<Player> tail){
		
			len = tail;
			
		}
		
		public void addTail(Player temp){
			
			len.add(temp);
			
		}
		
		public int getLen(){
			
			return len.size();
			
		}
		
		public Player getItem( int x){
			
			return len.get(x);
			
		}

}
