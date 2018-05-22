package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import input.KeyInput;
import objects.Food;
import objects.Player;
import objects.Tail;
import objects.TailList;

public class Game extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String background = "/images/blackBackground.png";
	
	Timer gameLoopTimer;
	public static Player p;
	Player w;
	Food f;
	Player t;
	int x;
	int y;
	int length;
	public static ArrayList<Player> len;
	
	public JFrame frame;
	
	public Game(){
//		x = p.getX();
//		y = p.getY();
	}
	
	
	public Game(JFrame frame){
		setFocusable(true);
		gameLoopTimer = new Timer(50, this);
		gameLoopTimer.start();				//start the game loop, which activates the event handler
		
		f = new Food((int) (Math.random() * frame.getWidth()), (int) (Math.random() * frame.getHeight()),
				frame);
		
		p = new Player(0, 0, frame, f);
		
		w = new Player(0,0, frame, f);
		
		ArrayList<Player> blue = new ArrayList<Player>();
		
		blue.add(p);
		
		blue.add(w);
		
		len = blue;
		
	//	TailList pink = new TailList();
		
	//	ArrayList<Player> len = new ArrayList<Player>();
		
	//	pink.addTail(p);
		
	//	pink.addTail(w);
			
		addKeyListener(new KeyInput(p));	//detects when a key is pressed
	}
	
	public void paint(Graphics g){			//allows me to paint things onto the screen
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;	//converts Graphics into Graphics2D
											//Graphics2D is better than Graphics
//		TailList pink = new TailList();								//this is what makes the image appear on the frame
		
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		
//		for(int i = 0 ; i < len.size() ; i++){
//			len.get(i).draw(g2d);
//		}
		
//		for(int i = 0; i < pink.getLen() ; i++){
//			
//			pink.getItem(i).draw(g2d);
//			
//		}
		
		p.draw(g2d);
		
		f.draw(g2d);
		
		for(int i = 1; i < len.size(); i++){
		//	if(len.get(i) != null){
				len.get(i).draw(g2d);
		//	}
		}
		
	//	ArrayList<Player> len = new ArrayList<Player>();
		
//		if(len.size() == 0){
//			len.add(new Player(0,0,frame,f));
//		}
//		
//		t = new Player(0, 0, frame, f);
//		
//		len = t.addTail(len);
//		
//		len = t.printTail(len);
//		
//		for(int i = 1; i > len.size() - 1; i--){
//			len.get(i).draw(g2d);
//		}
		
		
		
	}
	
	public Image getBackgroundImage(){		//converts String background into an image
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}
	
	public void addToLen(){
		if(len.size() == 0){
			len.add(p);
		}
		len.add(new Player(len.get(len.size() - 1).getPrvX(), len.get(len.size() - 1
				).getPrvY(), frame, f ));
	}
	
	
	public int getPrvX(){
	//	if(len.size() > 2){
		if(len.size() == 0){
			len.add(p);
		}
		return len.get(len.size() - 2).getPrvX();
	}
	//	else
	//		return 0;
	//}
	
	public int getPrvY(){
		//if(len.size() > 2){
		if(len.size() == 0){
			len.add(p);
		}
			return len.get(len.size() - 2).getPrvY();
		//}
		//	else
		//		return 0;
		}

	@Override
	public void actionPerformed(ActionEvent e) {	//event handler
		
		repaint();									//calls the paint method
		
//		for(int i = 0 ; i < length ; i++){
//			
//		}
		
		p.update();		
													//calls update method in Player
		if(len.size() == 0){
				len.add(p);
		}	
													//which controls the player
		for(int i = 1; i < len.size(); i++){
			if(len.get(i) != null){
				len.get(i).updateTail();
			}
		}

	}

}
