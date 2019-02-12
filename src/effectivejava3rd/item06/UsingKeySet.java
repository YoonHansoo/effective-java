package effectivejava3rd.item06;

/*
 * 불변 객체인 경우에 안정하게 재사용하는 것이 매우 명확하다 하지만 몇몇 경우에 분명하지 않은 경우가 있다. 
 * 오히려 반대로 보이기도 한다. 어댑터를 예로 들면, 어댑터는 인터페이스를 통해서 뒤에 있는 객체로 연결해주는 객체라 여러개 만들 필요가 없다.
 *	Map 인터페이스가 제공하는 keySet은 Map이 뒤에 있는 Set 인터페이스의 뷰를 제공한다. 
 *	keySet을 호출할 때마다 새로운 객체가 나올거 같지만 사실 같은 객체를 리턴하기 때문에 리턴 받은 Set 타입의 객체를 변경하면, 결국에 그 뒤에 있는 Map 객체를 변경하게 된다.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsingKeySet {

    public static void main(String[] args) {
        Map<String, Integer> menu = new HashMap<>();
        menu.put("Burger", 8);
        menu.put("Pizza", 9);

        Set<String> names1 = menu.keySet();
        Set<String> names2 = menu.keySet();

        
        //keySet을 호출할 때마다 새로운 객체가 나올거 같지만 사실 같은 객체를 리턴하기 때문에 리턴 받은 Set 타입의 객체를 변경하면, 결국에 그 뒤에 있는 Map 객체를 변경하게 된다.
        //즉 같은 객체를 참조
        names1.remove("Burger");
        System.out.println(names2.size()); // 1
        System.out.println(menu.size()); // 1
    }
}