public class Sys {
	static Frame f;
	static DataBase db;
	static RankingSystem rs;
	public static void main(String[] args) {
		db = new DataBase();
		rs = new RankingSystem();
		f = new Frame();
	}
}