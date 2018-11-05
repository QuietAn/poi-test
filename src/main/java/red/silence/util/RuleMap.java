package red.silence.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangDongling
 * @version 1.0
 * @date 2018-11-05
 */
public class RuleMap<K extends RuleMap.Entry<String, RuleKey>, V>{

    private Map<String, Entry<K,V>> keyK = new HashMap<>();
    private Map<RuleKey, Entry<K,V>> keyV = new HashMap<>();

    public Entry<K,V> put(K key, V val) {

        if(null == key) {
            throw new IllegalArgumentException("key can't be null");
        }
        if(null == key.getKey()) {
            throw new IllegalArgumentException("key.k can't be null");
        }
        if(null == key.getValue()) {
            throw new IllegalArgumentException("key.val can't be null");
        }

        Entry entry = new Entry(key, val);
        keyK.put(key.getKey(), entry);
        keyV.put(key.getValue(), entry);

        return entry;
    }

    public Entry<K,V> getValByEntryKey(String kK) {
        return keyK.get(keyK);
    }

    public Entry<K,V> getValByEntryVal(RuleKey kV) {
        return keyV.get(kV);
    }

    public static class Entry<K, V> {
        private final K key;
        private final V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return this.value;
        }
    }


}
