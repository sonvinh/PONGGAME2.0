/*
 * 
 * 
 * 
 * 
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * 
 * @author Invisible Man
 *
 */
public class MainGameUI extends JFrame {
	private static final int _HEIGHT = 500;
	private static final int _WIDTH = 500;
	private PongPanel PongPanel;

	public MainGameUI() {
		setPreferredSize(new Dimension(_WIDTH, _HEIGHT));
		setLocation(getWidth(), 200);
		setLayout(new BorderLayout());
		setTitle("Pong Game - K21T Ltd.");
		PongPanel = new PongPanel();
		getContentPane().add(PongPanel, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);

	}

	public static void main(String[] args) {
		MainGameUI mainFrame = new MainGameUI();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}