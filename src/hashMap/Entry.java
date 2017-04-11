package hashMap;

/**
 * Created by annakertesz on 4/10/17.
 */
public class Entry<K,V> {

    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
