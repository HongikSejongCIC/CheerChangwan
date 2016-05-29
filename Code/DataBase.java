import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class DataBase {
	static String Loginid;
	static JList board;
	static JList best;
	static JList Gong;
	static int[] I;
	static DefaultListModel listModel = new DefaultListModel();
	static DefaultListModel listModel2 = new DefaultListModel();
	static DefaultListModel listModel3 = new DefaultListModel();
	static HashMap<String,String> h;
	static HashMap<String,String> user;
	static HashMap<String,String> manager;
	
	public DataBase(){
		I = new int[100];
		h = new HashMap<String,String>();
		user = new HashMap<String,String>();
		manager = new HashMap<String,String>();
		user.put("user", "1234");
		manager.put("manager", "123");
	}
	void Save(String t, String s){
		h.put(t, s);
	}
	void Delete(String t){
		h.remove(t);
	}
}
