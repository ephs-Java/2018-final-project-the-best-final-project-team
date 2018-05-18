package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

public class Game extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String background = "/images/blackBackground.png";
	
	Timer gameLoopTimer;
	Player p;
	Food f;
	Tail t;
	int x;
	int y;
	ArrayList<Tail> len;
	
	public Game(){
		x = p.getX();
		y = p.getY();
	}
	
	
	public Game(JFrame frame){
		setFocusable(true);
		gameLoopTimer = new Timer(50, this);
		gameLoopTimer.start();				//start the game loop, which activates the event handler
		
		f = new Food((int) (Math.random() * frame.getWidth()), (int) (Math.random() * frame.getHeight()),
				frame);
		
		p = new Player(0, 0, frame, f);
		
		
		addKeyListener(new KeyInput(p));	//detects when a key is pressed
	}
	
	public void paint(Graphics g){			//allows me to paint things onto the screen
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;	//converts Graphics into Graphics2D
											//Graphics2D is better than Graphics
											//this is what makes the image appear on the frame
		
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		
		p.draw(g2d);
		
		f.draw(g2d);
		
	//	t = new Tail(0, 0);
		
	//	len = t.addTail(len);
		
	//	len = t.printTail(len);
		
	//	for(int i = 1; i > len.size() - 1; i--){
	//		len.get(i).draw(g2d);
	//	}
		
		
		
	}
	
	public Image getBackgroundImage(){		//converts String background into an image
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	//event handler
		repaint();									//calls the paint method
		
		p.update();									//calls update method in Player
													//which controls the player
		
		
		
		

	}

}
