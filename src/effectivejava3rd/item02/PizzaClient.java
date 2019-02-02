package effectivejava3rd.item02;

import effectivejava3rd.item02.Pizza.Topping;

public class PizzaClient {
	public static void main(String[] args) {
		NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
				.addTopping(Pizza.Topping.HAM)
				.addTopping(Pizza.Topping.ONION).build();
		
		Calzone calzone = new Calzone.Builder()  //필수적인 파라미터는 여기서 선언하고
							.addTopping(Topping.HAM)  //부가적인 것들은 add를 통해서 추가한다.
							.sauceInde()
							.build();
		
	}
}
