import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen extends JFrame{
	ImageIcon icon;
	static JPanel bg ;
	MainScreen(){
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
		
		JLabel j = new JLabel("�˻�");
		j.setSize(30,100);
		j.setLocation(10,-30);
		bg.add(j);
		
		JTextField search = new JTextField();
		search.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_ENTER){
					if(DataBase.h.containsKey(search.getText())){
						MainScreen.bg.setVisible(false);
						SeeScreen s = new SeeScreen(search.getText());
						}
					else
						JOptionPane.showMessageDialog(null, "ã�� �� �����ϴ�!", "Warring", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		search.setSize(230,20);
		search.setLocation(50,10);
		bg.add(search);
		
		JLabel jl = new JLabel("������ Best");
		jl.setSize(100,100);
		jl.setLocation(10,55);
		bg.add(jl);
		
		JLabel j3 = new JLabel("��������");
		j3.setSize(100,100);
		j3.setLocation(10,0);
		bg.add(j3);
		
		DataBase.Gong = new JList(DataBase.listModel3);
		DataBase.Gong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DataBase.Gong.setSelectedIndex(0);
		JScrollPane Gongs = new JScrollPane(DataBase.Gong);
		Gongs.setSize(270,30);
		Gongs.setLocation(10,60);
		bg.add(Gongs);
		DataBase.Gong.clearSelection();
		
		DataBase.best = new JList(DataBase.listModel);
		DataBase.best.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DataBase.best.setSelectedIndex(0);
		javax.swing.border.Border line = BorderFactory.createLineBorder(Color.black,1);
		javax.swing.border.Border empty = BorderFactory.createEmptyBorder(7,7,7,7);
		DataBase.best.setBorder(BorderFactory.createCompoundBorder(line,empty));
		DataBase.best.setSize(270,70);
		DataBase.best.setLocation(10,115);
		bg.add(DataBase.best);
		DataBase.best.clearSelection();
		
		JLabel j2 = new JLabel("���� ������");
		j2.setSize(100,100);
		j2.setLocation(10,150);
		bg.add(j2);
		
		DataBase.board = new JList(DataBase.listModel2);
		DataBase.board.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DataBase.board.setSelectedIndex(0);
		JScrollPane boards = new JScrollPane(DataBase.board);
		boards.setSize(270,220);
		boards.setLocation(10,210);
		bg.add(boards);
		JButton ��ȸ =  new JButton("��ȸ");
		��ȸ.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(DataBase.board.isSelectionEmpty()&&DataBase.best.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null,"���õ� ���� �����ϴ�.");
				}
				else if(DataBase.board.isSelectedIndex(DataBase.board.getSelectedIndex())){
					String s = (String) DataBase.board.getSelectedValue();
					MainScreen.bg.setVisible(false);
					SeeScreen ss = new SeeScreen(s);
				}
				else if(DataBase.best.isSelectedIndex(DataBase.best.getSelectedIndex())){
					String s = (String) DataBase.best.getSelectedValue();
					MainScreen.bg.setVisible(false);
					SeeScreen ss = new SeeScreen(s);	
				}
				else if(DataBase.Gong.isSelectedIndex(DataBase.Gong.getSelectedIndex())){
					String s = (String) DataBase.Gong.getSelectedValue();
					MainScreen.bg.setVisible(false);
					SeeScreen ss = new SeeScreen(s);	
				}
			}
		});
		��ȸ.setSize(60,50);
		��ȸ.setLocation(10,450);
		bg.add(��ȸ);
		DataBase.board.clearSelection();
		
		JButton ��� =  new JButton("���");
		���.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainScreen.bg.setVisible(false);
				RegisterScreen rs = new RegisterScreen();	
			}
		});
		���.setSize(60,50);
		���.setLocation(80,450);
		bg.add(���);
		
		JButton �α׾ƿ� =  new JButton("�α׾ƿ�");
		�α׾ƿ�.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainScreen.bg.setVisible(false);
				LoginScreen ls = new LoginScreen();	
			}
		});
		�α׾ƿ�.setSize(270,30);
		�α׾ƿ�.setLocation(10,510);
		bg.add(�α׾ƿ�);
		
		JButton ���� =  new JButton("����");
		����.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(DataBase.board.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null,"���õ� ���� �����ϴ�.");
				}
				else{
					String resultStr = null;
					resultStr = JOptionPane.showInputDialog("��� ��ȣ�� �Է��ϼ���.");
					if(resultStr.equals("123")){
						int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?","Change",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if(result == 0){
						MainScreen.bg.setVisible(false);
						ChangeScreen rs = new ChangeScreen((String) DataBase.board.getSelectedValue());	
					}
				}
					else{
						JOptionPane.showMessageDialog(null,"��й�ȣ ����","Warring",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		����.setSize(60,50);
		����.setLocation(150,450);
		bg.add(����);
		
		JButton ���� =  new JButton("����");
		����.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(DataBase.board.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null,"���õ� ���� �����ϴ�.");
				}
				else{
					String resultStr = null;
					resultStr = JOptionPane.showInputDialog("��� ��ȣ�� �Է��ϼ���.");
					if(resultStr.equals("123")){
						int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?","Delete",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if(result == 0){
						Sys.db.Delete((String) DataBase.board.getSelectedValue());
						int index = DataBase.board.getSelectedIndex();
						DataBase.listModel2.remove(index);
						if(DataBase.listModel2.getSize()==0){ 
						    ����.setEnabled(false);
						   }
						   if(index == DataBase.listModel2.getSize()){
						    index--;  
						   }   
						   DataBase.board.setSelectedIndex(index);
						   DataBase.board.ensureIndexIsVisible(index);
					}
				}
					else{
						JOptionPane.showMessageDialog(null,"��й�ȣ ����","Warring",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		����.setSize(60,50);
		����.setLocation(220,450);
		bg.add(����);
		
		Sys.f.newScreen(bg);
	}
}

