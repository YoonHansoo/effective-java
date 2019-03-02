package effectivejava3rd.item07;

import java.util.Map;
import java.util.WeakHashMap;

public class CacheSample {

    public static void main(String[] args) {
        Object key1 = new Object();
        Object value1 = new Object();

        Map<Object, Object> cache = new WeakHashMap<>();
        cache.put(key1, value1);
    }

}
