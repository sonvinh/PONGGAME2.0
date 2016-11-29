import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sun.scenario.Settings;

public class SecondWindow extends JDialog {
	public int ballNumber;
	public MyDialogResult dialogResult;
	public int result;
	
	public String sPlayer1, sPlayer2;

	private JTextField txtPlayer1;
	private JTextField txtPlayer2;

	public SecondWindow() {
		setPreferredSize(new Dimension(400, 400));
		setTitle("Second Window");
		getContentPane().setLayout(null);
		setModal(true);
		

		dialogResult = MyDialogResult.DEFAULT;
		pack();
		setLayout(null);
		inputPlayername();
		
		
		JLabel lblChoose = new JLabel("Choose The Ball");
		ImageIcon imageBall1 = new ImageIcon("ImagesBall/ball1.png");
		ImageIcon imageBall2 = new ImageIcon("ImagesBall/ball2.png");
		ImageIcon imageBall3 = new ImageIcon("ImagesBall/ball3.png");
		ImageIcon imageBall4 = new ImageIcon("ImagesBall/ball4.png");
		ImageIcon imageBall5 = new ImageIcon("ImagesBall/ball5.png");
		JButton btnImage1 = new JButton(imageBall1);
		JButton btnImage2 = new JButton(imageBall2);
		JButton btnImage3 = new JButton(imageBall3);
		JButton btnImage4 = new JButton(imageBall4);
		JButton btnImage5 = new JButton(imageBall5);
		
		JLabel lblType = new JLabel("Type your name");
		JLabel lbl4 = new JLabel("Your name should be least 4 letter");
		
		
		lblType.setBounds(100, 10, 200, 30);
		lblType.setFont(new Font("Type your name", Font.BOLD, 25));
		getContentPane().add(lblType);

		lblChoose.setBounds(100, 160, 200, 30);
		lblChoose.setFont(new Font("Choose The Ball", Font.BOLD, 25));
		getContentPane().add(lblChoose);

		lbl4.setBounds(20, 50, 300, 30);
		lbl4.setFont(new Font("Your name should be least 4 letter", Font.ITALIC, 13));
		getContentPane().add(lbl4);

		btnImage1.setBounds(10, 210, 64, 64);
		getContentPane().add(btnImage1);
		btnImage1.setContentAreaFilled(false);
		btnImage1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage1.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage2.setBounds(85, 210, 64, 64);
		getContentPane().add(btnImage2);
		btnImage2.setContentAreaFilled(false);
		btnImage2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage2.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage3.setBounds(160, 210, 64, 64);
		getContentPane().add(btnImage3);
		btnImage3.setContentAreaFilled(false);
		btnImage3.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage3.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage4.setBounds(235, 210, 64, 64);
		getContentPane().add(btnImage4);
		btnImage4.setContentAreaFilled(false);
		btnImage4.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage4.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage5.setBounds(310, 210, 64, 64);
		getContentPane().add(btnImage5);
		btnImage5.setContentAreaFilled(false);
		btnImage5.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage5.setBorderPainted(false);
		btnImage1.setFocusable(false);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dialogResult = MyDialogResult.YES;
				setVisible(false);
				sPlayer1 = getSetting_player().getPlayer1();
				sPlayer2 = getSetting_player().getPlayer2();
			}
		});
		btnSave.setBounds(90, 295, 100, 30);
		getContentPane().add(btnSave);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialogResult = MyDialogResult.CANCEL;
				setVisible(false);
				
			}
		});
		btnCancle.setBounds(200, 295, 100, 30);
		getContentPane().add(btnCancle);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();

		btnImage1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ball is choosed");
				ballNumber=1;
			}
		});
		
		btnImage2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ball is choosed");
				ballNumber=2;
			}
		});
		
		btnImage3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ball is choosed");
				ballNumber=3;
			}
		});
		
		btnImage4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ball is choosed");
				ballNumber=4;
			}
		});
		
		btnImage5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ball is choosed");
				ballNumber=5;
			}
		});
		

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				int result = JOptionPane.showConfirmDialog(SecondWindow.this, "Exit?");
				if (result == JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});
		
	}
	public void inputPlayername() {
		dialogResult = MyDialogResult.DEFAULT;
		txtPlayer1 = new JTextField(10);
		txtPlayer2 = new JTextField(10);
		getContentPane().add(txtPlayer1);
		getContentPane().add(txtPlayer2);
		txtPlayer1.setBounds(110, 80, 180, 30);
		txtPlayer2.setBounds(110, 120, 180, 30);

		JLabel lblPlayer_1 = new JLabel("Player 1");
		lblPlayer_1.setBounds(20, 80, 90, 30);
		lblPlayer_1.setFont(new Font("Player 1", Font.BOLD, 20));
		getContentPane().add(lblPlayer_1);

		JLabel lblPlayer_2 = new JLabel("Player 2");
		lblPlayer_2.setBounds(20, 120, 90, 30);
		lblPlayer_2.setFont(new Font("Player 2", Font.BOLD, 20));
		getContentPane().add(lblPlayer_2);
	}
	
	public Setting_player getSetting_player() {
		Setting_player st = new Setting_player();
		st.setPlayer1(txtPlayer1.getText());
		st.setPlayer2(txtPlayer2.getText());
		return st;
	}
}
