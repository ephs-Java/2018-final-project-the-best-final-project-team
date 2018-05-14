package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import input.KeyInput;
import objects.Player;

public class Game extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String background = "/images/blueBackground.jpg";
	
	Timer gameLoopTimer;
	Player p;
	
	
	public Game(){
		setFocusable(true);
		gameLoopTimer = new Timer(10, this);
		gameLoopTimer.start();				//start the game loop, which activates the event handler
		p = new Player(0, 0);
		
		addKeyListener(new KeyInput(p));	//detects when a key is pressed
	}
	
	public void paint(Graphics g){			//allows me to paint things onto the screen
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;	//converts Graphics into Graphics2D
											//Graphics2D is better than Graphics
		
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		
		p.draw(g2d);
		
	}
	
	public Image getBackgroundImage(){		//converts String background into an image
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	//event handler
		repaint();									//calls the paint method
		
		p.update();									//calls update method in player
													//which controls the player
		

	}

}
