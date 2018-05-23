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

public class Game extends JPanel implements ActionListener{
	
	//Timer
	Timer gameLoopTimer;
	
	//Players
	public static Player p;
	
	//Food
	Food f;
	
	//Int
	int x;
	int y;
	int length;
	
	//ArrayList
	public static ArrayList<Player> len;
	
	//JFrame
	public JFrame frame;
	
	//Other
	private static final long serialVersionUID = 1L;
	private String background = "/images/blackBackground.png";
	private String gameOver = "/images/gameOver.png";
	
	
	public Game(){
	}
	
	public Game(JFrame frame){
		this.frame = frame;
		
		setFocusable(true);
		gameLoopTimer = new Timer(50, this);
		gameLoopTimer.start();				//start the game loop, which activates the event handler
		
		f = new Food((int) (Math.random() * frame.getWidth()), (int) (Math.random() * frame.getHeight()),
				frame);
		
		p = new Player(0, 0, frame, f);
		
		ArrayList<Player> blue = new ArrayList<Player>();
		
		blue.add(p);
		
		len = blue;
	
		addKeyListener(new KeyInput(p));	//detects when a key is pressed
	}
	
	public void paint(Graphics g){			//allows me to paint things onto the screen
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;	//converts Graphics into Graphics2D
											//Graphics2D is better than Graphics
											//this is what makes the image appear on the frame
		
		g2d.drawImage(getBackgroundImage(), 0, 0, this);

		if(len.size() == 0){
			len.add(p);
		}
		
		f.draw(g2d);
		
		for( Player k : len){
			k.draw(g2d);
		}	
		if(hitSelf() || p.getIsDead()){
			gameLoopTimer.stop();
			f.setX(100000);
			g2d.drawImage(getGameOverImage(), frame.getWidth() / 2 - getGameOverImage().getWidth(null) / 2,
					frame.getHeight() / 2 - getGameOverImage().getHeight(null) / 2, null);
			
		}
		
	}
	
	public Image getBackgroundImage(){		//converts String background into an image
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}
	
	public Image getGameOverImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(gameOver));
		return i.getImage();
	}
	
	public void addToLen(){   				//adds to len
		
		ArrayList<Player> blue = new ArrayList<Player>();
		
		blue = len;
		
		blue.add(new Player(blue.get(blue.size() - 1).getPrvX(), blue.get(blue.size() - 1).getPrvY(),
				frame, f ));

		len = blue;
		
	}
	
	public int getPrvX(int i){					//return PrvX
	
		return len.get(i - 1).getPrvX();
	}
	
	public int getPrvY(int i){					//return PrvY
		
		return len.get(i - 1).getPrvY();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {	//event handler
		
		repaint();									//calls the paint method
		
		p.update();									//calls update method in Player

		
		for(int i = 1 ; i < len.size() ; i++){
			len.get(i).updateTail(i);
		}
		
		
	}
	
	//collision with self
	public boolean hitSelf(){
		for(int i = 1; i < len.size(); i++){
			if(len.get(0).getX() == len.get(i).getX() && len.get(0).getY() == len.get(i).getY()){
				return true;
			}
		}
		return false;
	}

	} //Game
