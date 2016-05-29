import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class LoginScreen extends JPanel {
	static JTextField id;
	static JPasswordField pw;
	static JPanel bg;
	ImageIcon icon;
	static JScrollPane scrollPane;

	LoginScreen() {
		Image img = null;
		icon = new ImageIcon("로그인.jpg");
		bg = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bg.setSize(300, 575);
		bg.setLayout(null);
		login ml = new login();
		JButton login = new JButton("login");
		login.addActionListener(ml);
		login.setLocation(180, 400);
		login.setSize(70, 50);
		bg.add(login);
		
		JButton 회원가입 =  new JButton("회원가입");
		회원가입.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			LoginScreen.bg.setVisible(false);
			RegiScreen ms = new RegiScreen();
		}});
		회원가입.setSize(190,25);
		회원가입.setLocation(60,450);
		bg.add(회원가입);
		
		scrollPane = new JScrollPane(bg);
		id = new JTextField();
		pw = new JPasswordField();
		id.setHorizontalAlignment(JTextField.RIGHT);
		pw.setHorizontalAlignment(JPasswordField.RIGHT);
		id.setSize(120, 25);
		pw.setSize(120, 25);
		id.setLocation(60, 400);
		pw.setLocation(60, 425);
		bg.add(id);
		bg.add(pw);
		JLabel idl = new JLabel("   ID");
		JLabel pwl = new JLabel("PW");
		idl.setSize(50, 25);
		pwl.setSize(50, 25);
		idl.setLocation(30, 400);
		pwl.setLocation(30, 425);
		pw.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_ENTER){
					if(DataBase.user.containsKey(LoginScreen.id.getText())){
						if (DataBase.user.get(LoginScreen.id.getText()).equals(LoginScreen.pw.getText())){
								LoginScreen.bg.setVisible(false);
								DataBase.Loginid = LoginScreen.id.getText();
								MainScreen ms = new MainScreen();
						} else {
							JOptionPane.showMessageDialog(null, "PW오류", "Warring", JOptionPane.ERROR_MESSAGE);
							LoginScreen.id.setText("");
							LoginScreen.pw.setText("");
						}
						}
						else if(DataBase.manager.containsKey(LoginScreen.id.getText())){
						if (DataBase.manager.get(LoginScreen.id.getText()).equals(LoginScreen.pw.getText())){
								LoginScreen.bg.setVisible(false);
								DataBase.Loginid = LoginScreen.id.getText();
								GMainScreen Gms = new GMainScreen();
						} else {
							JOptionPane.showMessageDialog(null, "PW오류", "Warring", JOptionPane.ERROR_MESSAGE);
							LoginScreen.id.setText("");
							LoginScreen.pw.setText("");
						}
						}
						else{
							JOptionPane.showMessageDialog(null, "ID오류", "Warring", JOptionPane.ERROR_MESSAGE);
						
						}
					
				}
			}
		});
		bg.add(idl);
		bg.add(pwl);
		Frame.scr.add(bg);
	}
}

class login implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		if(DataBase.user.containsKey(LoginScreen.id.getText())){
		if (DataBase.user.get(LoginScreen.id.getText()).equals(LoginScreen.pw.getText())){
				LoginScreen.bg.setVisible(false);
				DataBase.Loginid = LoginScreen.id.getText();
				MainScreen ms = new MainScreen();
		} else {
			JOptionPane.showMessageDialog(null, "PW오류", "Warring", JOptionPane.ERROR_MESSAGE);
			LoginScreen.id.setText("");
			LoginScreen.pw.setText("");
		}
		}
		else if(DataBase.manager.containsKey(LoginScreen.id.getText())){
		if (DataBase.manager.get(LoginScreen.id.getText()).equals(LoginScreen.pw.getText())){
				LoginScreen.bg.setVisible(false);
				DataBase.Loginid = LoginScreen.id.getText();
				GMainScreen Gms = new GMainScreen();
		} else {
			JOptionPane.showMessageDialog(null, "PW오류", "Warring", JOptionPane.ERROR_MESSAGE);
			LoginScreen.id.setText("");
			LoginScreen.pw.setText("");
		}
		}
		else{
			JOptionPane.showMessageDialog(null, "ID오류", "Warring", JOptionPane.ERROR_MESSAGE);
		
		}
	}
}
