
public class Board {
	Board content;
	boolean 레시피등록(String title, String content){
		//등록이 완료되면
		return true;
		//그렇지않으면
		//return false;
	}
	boolean 레시피수정(String pw,String title, String content){
		//레시피가 수정되면
		//true 리턴
		//그렇지 않으면
		return false;
		
	}
	Board 레시피조회(){
		//레시피가 조회되면 null이 아닌 레시피 리턴
		return null;
		
	}
	boolean 레시피삭제(String pw){
		//레시피가 삭제되면 true 리턴
		//실패하면 false 리턴
		return false;
		
	}
	boolean 공지사항등록(String title, String content){
		//공지사항이 등록되면 true 리턴
		//실패하면 false 리턴
		return false;
		
	}
	boolean 공지사항수정(String pw,String title, String content){
		//공지사항이 수정되면 true 리턴
		//실패하면 false 리턴
		return false;
		
	}
	boolean 공지사항삭제(String pw,String id){
		//공지사항이 삭제되면 true 리턴
		//실패하면 false 리턴
		return false;
		
	}
	Board 공지사항조회(String title, String content){
		//공지사항이 조회되면 공지사항 반환
		return null;
		
	}
	boolean 게시판내검색(String keyward){
		//게시판내 같은 내용을 검색하게 되면 true 리턴
		//실패하면 false 리턴
		return true;
		
	}
	boolean 비밀번호확인(String pw,String id){
		//추가로 입력된 비밀 번호와 초기 로그인한 비밀번호 비교 
		return false;
	}
}
