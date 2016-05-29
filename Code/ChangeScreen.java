
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class ChangeScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg;
	
	ChangeScreen(String str){
		Image img = null;
		icon = new ImageIcon("메인.jpg");
		bg = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bg.setSize(300,575);
		bg.setLayout(null);
		
		JLabel jl = new JLabel("제목");
		jl.setSize(100,100);
		jl.setLocation(10,-30);
		bg.add(jl);
		
		JTextField title = new JTextField(str);
		title.setSize(270,30);
		title.setLocation(10,40);
		Font font = new Font("arian",Font.BOLD,15);
		title.setFont(font);
		bg.add(title);
		
		JLabel j2 = new JLabel("내용");
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
		
		JButton 수정 =  new JButton("수정");
		수정.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DataBase.h.remove(str);
				DataBase.h.put(title.getText(),content.getText());
				String resultStr = null;
				Sys.db.Delete((String) DataBase.board.getSelectedValue());
				int index = DataBase.board.getSelectedIndex();
				DataBase.listModel2.remove(index);
				if(index == DataBase.listModel2.getSize()){
					index--;  
				}   
				DataBase.board.setSelectedIndex(index);
				DataBase.board.ensureIndexIsVisible(index);
				DataBase.listModel2.addElement(title.getText());
				Sys.db.Save(title.getText(),content.getText());
				ChangeScreen.bg.setVisible(false);
				MainScreen ns = new MainScreen();
			}
		}
			);
		수정.setSize(130,50);
		수정.setLocation(10,475);
		bg.add(수정);
		
		JButton 뒤로 =  new JButton("뒤로");
		뒤로.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			ChangeScreen.bg.setVisible(false);
			MainScreen ns = new MainScreen();	
		}});
		뒤로.setSize(130,50);
		뒤로.setLocation(150,475);
		bg.add(뒤로);
		
		Sys.f.newScreen(bg);
	}
}