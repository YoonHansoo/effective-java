package effectivejava3rd.item03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

import org.apache.catalina.core.ApplicationContext;

public class SingleTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//방법 1
		Singleton1 singleton1 = Singleton1.instance;
		Singleton1 singleton2 = Singleton1.instance;
		//동일한 인스턴스를 참조함
		
		Constructor<Singleton1> constructor = Singleton1.class.getConstructor();
		constructor.setAccessible(true);
		Singleton1 singleton3 = constructor.newInstance();  
		//이런식으로  하면 리플렉션이 되어 생성자가 2개 만들어짐 
		
		//방법2
		Singleton2 singleton4 = Singleton2.getInstance();
		//이 방법이 코드의 유지보수가 더 편함
		//클라이언트 코드는 그대로하고 코드의 내용을 바꾸기 쉬움
		
		Supplier<Singleton2> supplier = Singleton2::getInstance; 
		//static 팩토리 메서드를 Supplier<Elvis>에 대한 메소드 레퍼런스로 사용할 수도 있다. 중요X
		
		
		//방법3. enum 
		//최선의방법(이상적으로)
		
		String name = Singleton3.INSTANCE.getName();
		
		
		/* 직렬화
		 * : 위에서 살펴본 두 방법 모두, 
		 * 직렬화에 사용한다면 역질렬화 할 때 같은 타입의 인스턴스가 여러개 생길 수 있다. 
		 * 그 문제를 해결하려면 모든 인스턴스 필드에 transient를 추가 (직렬화 하지 않겠다는 뜻) 하고
		 *  readResolve 메소드를 다음과 같이 구현하면 된다.
		 *   [private Object readResolve() {
         *		return INSTANCE;
    	 *				}
		 *  
		 * 직렬화는 언제 많이 사용할까? 
		 * 	-> 객체를 전달할 때
		 *      -> 네트워크  / 제이슨 변환 / XML 전환 / 파일로 만들어서 스트림으로 주고 받을 떼(자바에서)
		 *    
		 *  직렬화 과정에서 클래스가 업데이트 되었을 때 예외가 발생하는데 그떄 UID가 같으면 예외가 일어나지 않고
		 *  역직렬화가 됨
		 *    
		 *      	 
		 */    	
		
	}
}
