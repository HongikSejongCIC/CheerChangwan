
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class SeeScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg;
	
	SeeScreen(String str){
		Image img = null;
		icon = new ImageIcon("����.jpg");
		bg = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bg.setSize(300,575);
		bg.setLayout(null);
		
		JLabel jl = new JLabel("����");
		jl.setSize(100,100);
		jl.setLocation(10,-30);
		bg.add(jl);
		
		JTextField title = new JTextField(str);
		title.setSize(270,30);
		title.setLocation(10,40);
		title.setEditable(false); 
		Font font = new Font("arian",Font.BOLD,15);
		title.setFont(font);
		bg.add(title);
		
		JLabel j2 = new JLabel("����");
		j2.setSize(100,100);
		j2.setLocation(10,40);
		bg.add(j2);
		
		String str2 = DataBase.h.get(str);
		JTextArea content = new JTextArea(str2);
		javax.swing.border.Border line = BorderFactory.createLineBorder(Color.black,1);
		javax.swing.border.Border empty = BorderFactory.createEmptyBorder(7,7,7,7);
		content.setEditable(false); 
		content.setBorder(BorderFactory.createCompoundBorder(line,empty));
		JScrollPane contentj = new JScrollPane(content);
		contentj.setSize(270,365);
		contentj.setLocation(10,100);
		bg.add(contentj);
		
		JButton ��ǥ =  new JButton("��ǥ");
		��ǥ.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "��ǥ�Ͻðڽ��ϱ�?","Vote",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(result == 0){
					Sys.rs.vote(title.getText());
					Sys.rs.max();
					Sys.rs.best();
				}
			}});
		��ǥ.setSize(130,50);
		��ǥ.setLocation(10,475);
		bg.add(��ǥ);
		
		JButton �ڷ� =  new JButton("�ڷ�");
		�ڷ�.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			SeeScreen.bg.setVisible(false);
			MainScreen ns = new MainScreen();	
		}});
		�ڷ�.setSize(130,50);
		�ڷ�.setLocation(150,475);
		bg.add(�ڷ�);
		
		Sys.f.newScreen(bg);
	}
}