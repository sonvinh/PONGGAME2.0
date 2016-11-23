import java.awt.Color;
import java.awt.Dimension;
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

public class SecondWindow extends JDialog {
	public int ballNumber;
	public MyDialogResult dialogResult;
	public int result;
	
	private JTextField txtPlay1;
	private JTextField txtPlay2;
	
	public SecondWindow() {
		setPreferredSize(new Dimension(400, 400));
		setTitle("Second Window");
		getContentPane().setLayout(null);
		setModal(true);
		

		dialogResult = MyDialogResult.DEFAULT;
		pack();
		setLayout(null);
		
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
		
		
		lblChoose.setBounds(140, 170, 150, 30);
		getContentPane().add(lblChoose);

		btnImage1.setBounds(10, 210, 64, 64);
		getContentPane().add(btnImage1);
		btnImage1.setContentAreaFilled(false);
		btnImage1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage1.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage2.setBounds(90, 210, 64, 64);
		getContentPane().add(btnImage2);
		btnImage2.setContentAreaFilled(false);
		btnImage2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage2.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage3.setBounds(170, 210, 64, 64);
		getContentPane().add(btnImage3);
		btnImage3.setContentAreaFilled(false);
		btnImage3.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage3.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage4.setBounds(240, 210, 64, 64);
		getContentPane().add(btnImage4);
		btnImage4.setContentAreaFilled(false);
		btnImage4.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		btnImage4.setBorderPainted(false);
		btnImage1.setFocusable(false);

		btnImage5.setBounds(318, 210, 64, 64);
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
}
