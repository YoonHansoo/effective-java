package effectivejava3rd.item09;

public class AppRunner {

    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        try {
            myResource.doSomething();
        } catch (FirstError error) {
            System.out.println("first error");
            throw error;
        } finally {
            myResource.close();
        }
        
        
        //try-catch-resource 구문 
        //괄호 안은 AutoCloseable을 상속받은 객체만 올 수있다.
        //주로 입출력에서 사용함
        
        try (MyResource myResource1 = new MyResource()){
        	
        }        
        
    }
}
