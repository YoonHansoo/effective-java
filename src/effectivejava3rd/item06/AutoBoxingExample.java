package effectivejava3rd.item06;


/*
 * 참조타입 변수보다 원시타입 변수를 가지고 for문을 돌리는 것이 훨씬 빠르다.(10배정도)
 * 
 */
public class AutoBoxingExample {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0l;
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);
    }
}