package effectivejava3rd.item03;

public class Singleton1 {
	public static final Singleton1 instance = new Singleton1();
	static int count;
	
	private Singleton1() {
		count++;
		if(count != 1) {
			throw new IllegalStateException("this object should be singleton"); 
			//이렇게 함으로써 편법으로 싱글톤 패턴을 깨려는 것을 막을 수 있음
		}
	}
}
