package com.lea.kumiko.juc.lang.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public interface Map<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void putAll(Map<? extends K, ? extends V> m);

    void clear();

    Set<K> keySet();

    Collection<V> values();

    Set<Map.Entry<K, V>> entrySet();

    /**
     * 返回此映射的哈希码值。映射的哈希码定义为此映射 entrySet() 视图中每个项的哈希码之和。
     * 这确保 m1.equals(m2) 对于任意两个映射 m1 和 m2 而言，都意味着 m1.hashCode()==m2.hashCode()，
     * 正如 Object.hashCode() 常规协定的要求。
     *
     * @return
     */
    int hashCode();


    default V getOrDefault(Object key, V defaultValue) {
        V v;
        return (((v = get(key)) != null) || containsKey(key)) ? v : defaultValue;
    }

    default V putIfAbsent(K key, V value) {
        V v = get(key);
        if (v == null) {
            v = put(key, value);
        }
        return v;
    }

    default boolean remove(Object key, Object value) {
        Object curValue = get(key);

        //就是不包含这个
        //value不一样 或者 (value是null,但是不包含这个key)
        if (!Objects.equals(curValue, value) || (curValue == null && !containsKey(key))) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(K key, V oldValue, V newValue) {
        Object curValue = get(key);

        if (!Objects.equals(curValue, oldValue) || (curValue == null && !containsKey(key))) {
            return false;
        }

        put(key, newValue);
        return true;
    }

    default V replace(K key, V value) {
        V curValue;

        // curValue ！= null 这个 curValue == null 但是不存在 value
        if (((curValue = get(key)) != null) || containsKey(key)) {
            curValue = put(key, value);
        }

        return curValue;
    }


    interface Entry<K, V> {

        K getKey();

        V getValue();

        V setValue(V value);

        boolean equals(Object o);

        int hashCode();

        public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K, V>> comparingByKey() {
            return new Comparator<Entry<K, V>>() {
                @Override
                public int compare(Entry<K, V> c1, Entry<K, V> c2) {
                    return c1.getKey().compareTo(c2.getKey());
                }
            };
        }

        public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K, V>> comparingByValue() {
            return (Comparator<Map.Entry<K, V>> & Serializable)
                    (c1, c2) -> c1.getValue().compareTo(c2.getValue());
        }


        public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
            Objects.requireNonNull(cmp);
            return new Comparator<Entry<K, V>>() {
                @Override
                public int compare(Entry<K, V> c1, Entry<K, V> c2) {
                    return cmp.compare(c1.getKey(), c2.getKey());
                }
            };
        }

        public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
            Objects.requireNonNull(cmp);
            return new Comparator<Entry<K, V>>() {
                @Override
                public int compare(Entry<K, V> c1, Entry<K, V> c2) {
                    return cmp.compare(c1.getValue(), c2.getValue());
                }
            };
        }
    }


}
