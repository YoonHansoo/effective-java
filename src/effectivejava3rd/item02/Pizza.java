package effectivejava3rd.item02;

import java.util.EnumSet;
import java.util.Objects;
/*
 *1.생성자의 단점 : 매개변수가 무엇을 의미하는 지 알기 어럽다.
 * -> setter/gertter를 사용 
 *   -> 단점: 자바빈이 중간에 사용되는 경우 안정적이지 않은 상태로 사용될 여지가 있다
 * ->해결책 Builder Pattern
 * 
 * Builder Pattern
 * 필수적인 매개변수와 부가적인 매개변수 조합으로 여러 생성자를 만들 수 있다. 
 * 생성자의 안정성과 자바빈을 사용할때 얻을 수 있었던 가독성을 모두 취할 수 있는 대안
 *
 * 빌더 패턴은 만들려는 객체를 바로 만들지 않고 클라이언트는 빌더(생성자 또는 static 팩토리)에 필수적인 매개변수를 주면서
 * 호출해 Builder 객체를 얻은 다음 빌더 객체가 제공하는 세터와 비슷한 메소드를 사용해서 부가적인 필드를 채워넣고 
 * 최종적으로 build라는 메소드를 호출해서 만들려는 객체를 생성한다.
 * 
 * 단점:단점으로는 객체를 만들기 전에 먼저 빌더를 만들어야 하는데 성능에 민감한 상황에서는 그점이 문제가 될 수도 있다. 
 * 그리고 생성자를 사용하는 것보다 코드가 더 장황하다. 
 * 따라서 빌더 패턴은 매개변수가 많거나(4개 이상?) 또는 앞으로 늘어날 가능성이 있는 경우에 사용하는것이 좋다.
 * 
 *  -> 코드가 어려움 : lbok(롬복)에 @Builder 어노테이션을 사용하면 builderPattern을 쉽게 사용할 수 있다.
 */


public abstract class Pizza {  

    public enum Topping {
        HAM, MUSHROOM, ONION
    }

    final EnumSet<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class); //처음에 아무것도 없음

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings;
    }

}
