import java.util.Date;

class Member {
	String id;
	String passwd;
}

public class UnderstandDI {

	public static void main(String[] args) {
		Date date = new Date(); // 강한 결합
		System.out.println(date);
	}
	
	public static void getDate(Date d) {
		Date date = d; // 약한 결합 --> 의존성 주입 (Dependency Injection)
		System.out.println(date);
	}
	
	public static void memberUse1() {
		// 객체를 직접 생성 : 강한 결합
		Member member1 = new Member();
	}
	
	public static void memberUse2(Member m) {
		// 생성된 것을 주입받음 : 약한 결합 --> 의존성 주입 (Dependency Injection)
		Member member2 = m;
	}

}
