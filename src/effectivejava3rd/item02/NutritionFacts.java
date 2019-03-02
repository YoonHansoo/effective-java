package effectivejava3rd.item02;

/*
 * 생성자가 많아지면 이 값이 무엇을 의미하는 지 모를 수 있다.
 *  -> settter/getter를 만든다.
 *    ->단점: 쓰레드에 안정성이 없다 / setter를 하다가 사용할 수 있다.   
 * 
 */

public class NutritionFacts {

	private int servingSize;
	private int sodium;
	private int carbohydrate;
	private int servings;

	public int getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public NutritionFacts(int servingSize, int sodium, int carbohydrate, int servings) {
		super();
		this.servingSize = servingSize;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
		this.servings = servings;
	}

	public static void main(String[] args) {

	}

}
