
public class Mapper<K, V> {

    private K key;
    private V value;

    public Mapper(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        if (key != null) {
            this.key = key;
        }
    }

    public K getKey() {
        return this.key;
    }

    public V get(K key) {
        if (key != null) {
            return this.value;
        } else {
            return null;
        }
    }

    public V getValue() {
        return this.value;
    }

}
