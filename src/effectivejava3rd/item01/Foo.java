 package effectivejava3rd.item01;

import java.util.EnumSet;

/*public static method 장점
 * 1.이름을 가질 수 있다. => 코드의 가독성이 높아짐  
 * 2.생성자의 제약사항에 구애받지 않는다
 * 3.반드시 새로운 객체를 만들 필요가 없다. 
 * 4.리턴 타입의 하위 타입 인스턴스를 만들 수도 있다.
 * 5.리턴하는 객체의 클래스가 public static 팩토리 메소드를 작성할 시점에 반드시 존재하지 않아도 된다.
 * 
 * 
 * public static method 단점 
 * 1.public 또는 protected 생성자 없이 static public 메소드만 제공하는 클래 스는 상속할 수 없다.
 * 2.프로그래머가 static팩토리 메소드를 찾는게 어렵다. (API문서를 볼 때)
 * 
 */
 
public class Foo {
	String name;
	String address;
	
	public Foo() {
		
	}
	
	public Foo(String name) {
		this.name = name;
	}

	private static final Foo GOOD_NIGHT  = new Foo();
	
	public static Foo withAddress(String address) { 
		Foo foo  = new Foo();
		foo.address = address;
		return foo;
	}
	 
	public static Foo withName(String name) {
		return new Foo(name);
	}
	
	public static Foo getFoo() {
		return GOOD_NIGHT;
	}
	public static Foo getFoo(boolean flag) {
		Foo foo = new Foo();
		
		//TODO 특정 약속되어 있는 텍스트 파일에서 Foo의 구현체의 FQCN(Full Qualified ClassName)을 읽어온다.
		//TODO FQCN에 해당하는 인스턴스를 생성한다.
		//TODO foo변수를 해당 인스턴스를 가리키도록 수정한다.
		
		return foo; 
	}
	
	public static void main(String[] args) {
		Foo foo = new Foo("hansoo");
		
		Foo foo1 = Foo.withName("hansoo");  //1번에 해당
		
		Foo foo2 = Foo.getFoo();  // 3번에 해당함
 		 
		Foo foo3 = Foo.getFoo(false); //4번
		
		 EnumSet<Color> colors = EnumSet.allOf(Color.class);
		// EnumSet<Color> blueWhite = EnumSet.of(BLUE, WHITE);
	}
	
	/*static class BarFoo extends Foo{
		 
	}*/
	
	enum Color{
		RED, BLUE, WHITE
	}
	
	//private static method가 필요한 이유
		public static void doSomething() {
			//TODO 청소를 한다.
			//TODO 애들이랑 놀아준다.
			//TODO 저녁약속에 간다.
			게임을하고잔다();
		
		}
		
		public void doSomethingTomorrow() {
			//TODO 애들 데리고 수영장에 간다
			//TODO 밥을 먹는다.
			게임을하고잔다();
		}
		
		private static void 게임을하고잔다() {
			//TODO 게임을 한다.
			//TODO 잔다.
		}
		
}
