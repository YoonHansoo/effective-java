/*
 * UtilClass는 static으로만 이루어져 있기때문에
 * instance가 만들어 질 필요가 없음
 * -> 이것을 강제하기 위한 방법
 *    1.absctact class로 선언 
 *      -이 클래스를 상속해서 사용하면 instance를 생성 할 수 있음 
 *    2.private 생성자에 예외를 만든다.
 * 
 */

package effectivejava3rd.item04;


public abstract class UtilClass {

	//인스턴스화를 막이주기 위한 생성자
	private UtilClass() {
		throw new AssertionError();
	}
	
	public static String getName() {
		return "keesun";
	}

	public static void main(String[] args) {

	}

}
