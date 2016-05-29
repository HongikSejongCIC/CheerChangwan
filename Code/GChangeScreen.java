
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class GChangeScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg;
	
	GChangeScreen(String str){
		Image img = null;
		icon = new ImageIcon("G.jpg");
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
		content.setBorder(BorderFactory.createCompoundBorder(line,empty));
		JScrollPane contentj = new JScrollPane(content);
		contentj.setSize(270,365);
		contentj.setLocation(10,100);
		bg.add(contentj);
		
		JButton ���� =  new JButton("����");
		����.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DataBase.h.remove(str);
				DataBase.h.put(title.getText(),content.getText());
				String resultStr = null;
				Sys.db.Delete((String) DataBase.Gong.getSelectedValue());
				int index = DataBase.Gong.getSelectedIndex();
				DataBase.listModel3.remove(index);
				if(index == DataBase.listModel3.getSize()){
					index--;  
				}   
				DataBase.Gong.setSelectedIndex(index);
				DataBase.Gong.ensureIndexIsVisible(index);
				DataBase.listModel3.addElement(title.getText());
				Sys.db.Save(title.getText(),content.getText());
				GChangeScreen.bg.setVisible(false);
				GMainScreen ns = new GMainScreen();
			}
		}
			);
		����.setSize(130,50);
		����.setLocation(10,475);
		bg.add(����);
		
		JButton �ڷ� =  new JButton("�ڷ�");
		�ڷ�.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			GChangeScreen.bg.setVisible(false);
			GMainScreen ns = new GMainScreen();	
		}});
		�ڷ�.setSize(130,50);
		�ڷ�.setLocation(150,475);
		bg.add(�ڷ�);
		
		Sys.f.newScreen(bg);
	}
}