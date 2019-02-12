package effectivejava3rd.item06;

import java.util.regex.Pattern;

/*
 * 만드는데 메모리나 시간이 오래 걸리는 객체 즉 "비싼 객체"를 반복적으로 만들어야 한다면 캐시해두고 재사용할 수 있는지 고려하는 것이 좋다.
 * String.matches가 가장 쉽게 정규 표현식에 매치가 되는지 확인하는 방법이긴 하지만 성능이 중요한 상황에서 반복적으로 사용하기에 적절하지 않다.
 * String.matches는 내부적으로 Pattern 객체를 만들어 쓰는데 그 객체를 만들려면 정규 표현식으로 유한 상태 기계로 컴파일 하는 과정이 필요하다. 즉 비싼 객체다.
 * 성능을 개선하려면 Pattern 객체를 만들어 재사용하는 것이 좋다.
 */
public class RomanNumber { //안좋은 방법
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"); //비싼객체를 비싸게 만드는 방법임...
       
    }

    
}

	 class RomanNumber1 { //좋은방법

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
    	
        return ROMAN.matcher(s).matches();
        
    }

}