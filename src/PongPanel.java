/*
 * PONG GAME REQUIREMENTS
 * This simple "tennis like" game features two paddles and a ball, 
 * the goal is to defeat your opponent by being the first one to gain 3 point,
 *  a player gets a point once the opponent misses a ball. 
 *  The game can be played with two human players, one on the left and one on 
 *  the right. They use keyboard to start/restart game and control the paddles. 
 *  The ball and two paddles should be red and separating lines should be green. 
 *  Players score should be blue and background should be black.
 *  Keyboard requirements:
 *  + P key: start
 *  + Space key: restart
 *  + W/S key: move paddle up/down
 *  + Up/Down key: move paddle up/down
 *  
 *  Version: 0.5
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Invisible Man
 *
 */
public class PongPanel extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = -1097341635155021546L;

	private boolean showTitleScreen = true;
	private boolean playing;
	private boolean gameOver;

	/** Background. */
	private Color backgroundColor = Color.BLACK;
	ImageIcon background1 = new ImageIcon("Background/milky-way-galaxy.jpg");
	ImageIcon background2 = new ImageIcon("Background/Beautiful-Galaxy-Space-Wallpaper-Background.jpg");
	

	/** State on the control keys. */
	private boolean upPressed;
	private boolean downPressed;
	private boolean wPressed;
	private boolean sPressed;

	/** The ball: position, diameter */
	private int ballX = 200;
	private int ballY = 200;
	private int diameter = 20;
	private int ballDeltaX = -1;
	private int ballDeltaY = 3;

	/** Player 1's paddle: position and size */
	private int playerOneX = 0;
	private int playerOneY = 250;
	private int playerOneWidth = 10;
	private int playerOneHeight = 60;

	/** Player 2's paddle: position and size */
	private int playerTwoX = 483;
	private int playerTwoY = 250;
	private int playerTwoWidth = 10;
	private int playerTwoHeight = 60;
	

	/** Speed of the paddle - How fast the paddle move. */
	private int paddleSpeed = 5;

	/** Player score, show on upper left and right. */
	private int playerOneScore;
	private int playerTwoScore;
	private Sound Startgame,Overgame;

	/** Construct a PongPanel. */
	public PongPanel() {
		Startgame = new Sound(new File("Sound/StartGame.wav"));
		Overgame = new Sound(new File("Sound/OverGame.wav"));
		setBackground(backgroundColor);
		
		// listen to key presses
		setFocusable(true);
		addKeyListener(this);

		Startgame.play();
		Startgame.playMusic();
		// call step() 60 fps
		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}

	/** Implement actionPerformed */
	public void actionPerformed(ActionEvent e) {
		step();
	}

	/** Repeated task */
	public void step() {

		if (playing) {
			Startgame.stop();

			/* Playing mode */

			// move player 1
			// Move up if after moving, paddle is not outside the screen
			if (wPressed && playerOneY - paddleSpeed > 0) {
				playerOneY -= paddleSpeed;
			}
			// Move down if after moving paddle is not outside the screen
			if (sPressed && playerOneY + playerOneHeight + paddleSpeed < getHeight()) {
				playerOneY += paddleSpeed;
			}

			// move player 2
			// Move up if after moving paddle is not outside the screen
			if (upPressed && playerTwoY - paddleSpeed > 0) {
				playerTwoY -= paddleSpeed;
			}
			// Move down if after moving paddle is not outside the screen
			if (downPressed && playerTwoY + playerTwoHeight + paddleSpeed < getHeight()) {
				playerTwoY += paddleSpeed;
			}

			/*
			 * where will the ball be after it moves? calculate 4 corners: Left,
			 * Right, Top, Bottom of the ball used to determine whether the ball
			 * was out yet
			 */
			int nextBallLeft = ballX + ballDeltaX;
			int nextBallRight = ballX + diameter + ballDeltaX;
			// FIXME Something not quite right here
			int nextBallTop = ballY+ ballDeltaY;
			int nextBallBottom = ballY + diameter+ ballDeltaY;

			// Player 1's paddle position
			int playerOneRight = playerOneX + playerOneWidth;
			int playerOneTop = playerOneY;
			int playerOneBottom = playerOneY + playerOneHeight;

			// Player 2's paddle position
			float playerTwoLeft = playerTwoX;
			float playerTwoTop = playerTwoY;
			float playerTwoBottom = playerTwoY + playerTwoHeight;

			// ball bounces off top and bottom of screen
			if (nextBallTop < 0 || nextBallBottom > getHeight()) {
				ballDeltaY *= -1;
				SoundPG.play("Sound/paddleSound.wav");
			}

			// will the ball go off the left side?
			if (nextBallLeft < playerOneRight) {
				ballDeltaY = -3;
				// is it going to miss the paddle?
				if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop) {

					playerTwoScore++;
					SoundPG.play("Sound/ballhitSound.wav");		

					// Player 2 Win, restart the game
					if (playerTwoScore == 3) {
						Overgame.play();
						Overgame.playMusic();
						playing = false;
						gameOver = true;
					}
					ballX = 250;
					ballY = 250;
				} else {
					// If the ball hitting the paddle, it will bounce back
					// FIXME Something wrong here
					ballDeltaX *= -1;
					SoundPG.play("Sound/paddleSound.wav");	
				}
			}

			// will the ball go off the right side?
			if (nextBallRight > playerTwoLeft) {
				ballDeltaX = 3;
				// is it going to miss the paddle?
				if (nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop) {

					playerOneScore++;
					SoundPG.play("Sound/ballhitSound.wav");
					
					// Player 1 Win, restart the game
					if (playerOneScore == 3) {
						Overgame.play();
						Overgame.playMusic();
						playing = false;
						gameOver = true;
					}
					ballX = 250;
					ballY = 250;
				} else {

					// If the ball hitting the paddle, it will bounce back
					// FIXME Something wrong here
					ballDeltaX *= -1;
					SoundPG.play("Sound/paddleSound.wav");
				}
			}

			// move the ball
			ballX += ballDeltaX;
			ballY += ballDeltaY;
		}

		// stuff has moved, tell this JPanel to repaint itself
		repaint();
	}

	/** Paint the game screen. */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (showTitleScreen) {

			/* Show welcome screen */
			// background
			g.drawImage(background2.getImage(),0,0,getWidth(),getHeight(),null);
			// Draw game title and start message
			g.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 36));
			g.setColor(Color.green);
			g.drawString("Welcome to Pong Game", 30, 100);
			g.drawString("Let's play!", 130, 200);
			

			// FIXME Welcome message below show smaller than game title
			g.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 36));
			g.drawString("Press 'P' to play.", 80, 300);
		} else if (playing) {

			/* Game is playing */
			
			// set the coordinate limit
			int playerOneRight = playerOneX + playerOneWidth;
			int playerTwoLeft = playerTwoX;
			// background
			g.drawImage(background1.getImage(),0,0,getWidth(),getHeight(),null);
			// draw dashed line down center
			g.setColor(Color.GREEN);
			for (int lineY = 0; lineY < getHeight(); lineY += 50) {
				g.drawLine(250, lineY, 250, lineY + 25);
			}

			// draw "goal lines" on each side
			g.setColor(Color.RED);
			g.drawLine(playerOneRight, 0, playerOneRight, getHeight());
			g.drawLine(playerTwoLeft, 0, playerTwoLeft, getHeight());

			// draw the scores
			g.setColor(Color.BLUE);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
			g.drawString(String.valueOf(playerOneScore), 100, 100); // Player 1
																	// score
			g.drawString(String.valueOf(playerTwoScore), 352, 100); // Player 2
																	// score

			// draw the ball
			g.setColor(Color.RED);
			g.fillOval(ballX, ballY, diameter, diameter);
			

			// draw the paddles
			g.fillRect(playerOneX, playerOneY, playerOneWidth, playerOneHeight);
			g.fillRect(playerTwoX, playerTwoY, playerTwoWidth, playerTwoHeight);
		} else if (gameOver) {

			/* Show End game screen with winner name and score */
			// background
			g.drawImage(background2.getImage(),0,0,getWidth(),getHeight(),null);
			// Draw scores
			// TODO Set Blue color
			g.setColor(Color.white);
			g.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 36));
			g.drawString(String.valueOf(playerOneScore), 100, 120);
			g.drawString(String.valueOf(playerTwoScore), 365, 120);
			

			// Draw the winner name
			g.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 36));
			g.setColor(Color.green);
			
			if (playerOneScore > playerTwoScore) {
				g.drawString("Congratulations!", 90, 200);
				g.drawString("Player 1 Wins!", 125, 280);
				
				
			} else {
				g.drawString("Congratulations!", 90, 200);
				g.drawString("Player 2 Wins!", 125, 280);
			}
			

			// Draw Restart message
			g.setColor(Color.GREEN);
			g.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 30));
			// TODO Draw a restart message
			g.drawString("Press 'Space' to restart", 45, 360);
		}
		

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (showTitleScreen) {
			if (e.getKeyCode() == KeyEvent.VK_P) {
				showTitleScreen = false;
				playing = true;
			}
		} else if (playing) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				upPressed = true;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				downPressed = true;
			} else if (e.getKeyCode() == KeyEvent.VK_W) {
				wPressed = true;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				sPressed = true;
			}
		} else if (gameOver && e.getKeyCode() == KeyEvent.VK_SPACE) {
			Startgame.play();
			Startgame.playMusic();
			Overgame.stop();
			gameOver = false;
			showTitleScreen = true;
			playerOneY = 250;
			playerTwoY = 250;
			ballX = 250;
			ballY = 250;
			playerOneScore = 0;
			playerTwoScore = 0;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			wPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			sPressed = false;
		}
	}

}
