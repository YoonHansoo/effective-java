/*
 * 싱글톤으로 구현되어 있지만 1번과 마찬가지로 dictionary를 바꾸기 어렵게 설계 되어있음
 */

package effectivejava3rd.item05.usecase2;

import java.util.List;

public class SpellChecker {

    private final Lexicon dictionary = new KoreanDicationry();

    private SpellChecker() {
    }

    public static final SpellChecker INSTANCE = new SpellChecker() {
    };

    public boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }


    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        SpellChecker.INSTANCE.isValid("hello");
    }

}


interface Lexicon {}

class KoreanDicationry implements Lexicon {}
