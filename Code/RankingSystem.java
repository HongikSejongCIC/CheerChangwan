import javax.swing.JOptionPane;

public class RankingSystem {
	static String str[];
	static String best[];
	static String sss[];
	static String ID[];
	static int vote[];
	static int i;
	static int n;
	int num[];
	int max[];

	RankingSystem() {
		str = new String[100];
		ID =  new String[100];
		vote = new int[100];
		best = new String[100];
		max = new int[3];
		num = new int[3];
		best[0]="1위 공석";
		best[1]="2위 공석";
		best[2]="3위 공석";
		for (int j = 0; j < 100; j++) {
			str[j] = "";
			vote[j] = 0;
		}
		for (int j = 0; j < 3; j++) {
			max[j] = 0;
			num[j] = 0;
			DataBase.listModel.addElement(best[j]);
		}
		
		i = n = 0;
	}

	void vote(String str) {
		for(int j=0; j<i; j++){
			if(ID[j].equals(DataBase.Loginid)){
				JOptionPane.showMessageDialog(null, "투표는 한번만 가능합니다.", "Warring", JOptionPane.ERROR_MESSAGE);
			return;
			}
		}
		ID[i] = DataBase.Loginid;
		for(int j=0; j<100; j++){
			if(this.str[j].equals("")){
				this.str[j] = str;
				vote[j]++;
				break;
			}
			else if(this.str[j].equals(str)){
				vote[j]++;
				break;
			}
		}
		i++;
	}

	void max() {
		while(true){
		for(int j=0; j<100; j++){
			if(vote[j]>max[0]){
				max[0] = vote[j];
				num[0] = j;
				best[0] = this.str[j];
			}
		}
		for(int j=0; j<100; j++){
			if(max[1]<vote[j]&&vote[j]<max[0]){
				max[1] = vote[j];
				num[1] = j;
				best[1] = this.str[j];
				
			}
		}
		for(int j=0; j<100; j++){
			if(max[2]<vote[j]&&vote[j]<max[1]){
				max[2] = vote[j];
				num[2] = j;
				best[2] = this.str[j];
				
			}
		}
		if(best[0]!=best[1]&&best[1]!=best[2]&&best[0]!=best[2])
			break;
		else
			continue;
		}
		for(int i=0; i<3; i++){
		num[i] = max[i] = 0;
		}
	}

	void best() {
		DataBase.listModel.removeAllElements();
		for(int i=0; i<3; i++){
			DataBase.listModel.addElement(best[i]);
		}
	}
}
