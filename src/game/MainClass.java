package game;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.pack();
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(new Game());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		System.out.println("hi");
	}

}
