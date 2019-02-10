/*
 * 의존성 주입의 좋지 못한 방법
 * 사전에 따라 spellChecker가 바뀌기 때문에 Dictionary를변경하기 어렵게 설계되어 있음
 * 특징으로 
 * 메서드가 static만 존재해  dictionary를 static으로 선언함
 * 또 생성자를 private으로 지정해 인스턴스화를 못하게?! 막음
 */

package effectivejava3rd.item05.usecase1;

import java.util.List;



public class SpellChecker {

	private static final Lexicon dictionary = new KoreanDicationry();

	private SpellChecker() {
		// Noninstantiable
	}

	public static boolean isValid(String word) {
		throw new UnsupportedOperationException();
	}

	public static List<String> suggestions(String typo) {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		SpellChecker.isValid("hello");
	}
}

interface Lexicon {
}

class KoreanDicationry implements Lexicon {
}