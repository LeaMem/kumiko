package com.lea.kumiko.juc.lang.map;

import java.io.Serializable;
import java.util.*;

public abstract class AbstractMap<K, V> implements Map<K, V> {

    protected AbstractMap() {
    }

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public boolean containsValue(Object value) {
        Iterator<Entry<K, V>> i = entrySet().iterator();

        if (value == null) {
            while (i.hasNext()) {
                Entry<K, V> e = i.next();
                if (e.getValue() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                Entry<K, V> e = i.next();
                if (value.equals(e.getValue())) {
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public boolean containsKey(Object key) {
        Iterator<Map.Entry<K, V>> i = entrySet().iterator();
        if (key == null) {
            while (i.hasNext()) {
                Entry<K, V> e = i.next();
                if (e.getKey() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                Entry<K, V> e = i.next();
                if (key.equals(e.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Iterator<Entry<K, V>> i = entrySet().iterator();
        if (key == null) {
            while (i.hasNext()) {
                Entry<K, V> e = i.next();
                if (e.getKey() == null) {
                    return e.getValue();
                }
            }
        } else {
            while (i.hasNext()) {
                Entry<K, V> e = i.next();
                if (key.equals(e.getValue())) {
                    return e.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(Object key) {
        Iterator<Entry<K, V>> i = entrySet().iterator();
        Entry<K, V> correctEntry = null;
        if (key == null) {
            while (correctEntry == null && i.hasNext()) {
                Entry<K, V> e = i.next();
                if (e.getKey() == null) {
                    correctEntry = e;
                }
            }
        } else {
            while (correctEntry == null && i.hasNext()) {
                Entry<K, V> e = i.next();
                if (key.equals(e.getKey())) {
                    correctEntry = e;
                }
            }
        }

        V oldValue = null;
        if (correctEntry != null) {
            oldValue = correctEntry.getValue();
            i.remove();
        }

        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        entrySet().clear();
    }

    transient Set<K> keySet;
    transient Collection<V> values;

    @Override
    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (ks == null) {
            ks = new AbstractSet<K>() {
                @Override
                public Iterator<K> iterator() {
                    return new Iterator<K>() {

                        private Iterator<Entry<K, V>> i = entrySet().iterator();

                        @Override
                        public boolean hasNext() {
                            return i.hasNext();
                        }

                        @Override
                        public K next() {
                            return i.next().getKey();
                        }

                        @Override
                        public void remove() {
                            i.remove();
                        }
                    };
                }

                @Override
                public int size() {
                    return AbstractMap.this.size();
                }

                @Override
                public boolean isEmpty() {
                    return AbstractMap.this.isEmpty();
                }

                @Override
                public void clear() {
                    AbstractMap.this.clear();
                }

                @Override
                public boolean contains(Object o) {
                    return AbstractMap.this.containsKey(o);
                }
            };
            keySet = ks;
        }

        return ks;
    }

    public Collection<V> values() {
        Collection<V> vals = values;
        if (vals == null) {
            vals = new AbstractCollection<V>() {
                @Override
                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        private Iterator<Entry<K, V>> i = entrySet().iterator();

                        @Override
                        public boolean hasNext() {
                            return i.hasNext();
                        }

                        @Override
                        public V next() {
                            return i.next().getValue();
                        }

                        @Override
                        public void remove() {
                            i.remove();
                        }
                    };
                }

                @Override
                public int size() {
                    return AbstractMap.this.size();
                }

                @Override
                public boolean isEmpty() {
                    return AbstractMap.this.isEmpty();
                }

                @Override
                public void clear() {
                    AbstractMap.this.clear();
                }

                @Override
                public boolean contains(Object o) {
                    return AbstractMap.this.containsValue(o);
                }
            };
            values = vals;
        }
        return vals;
    }

    @Override
    public abstract Set<Entry<K, V>> entrySet();

    private static boolean eq(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    public static class SimpleEntry<K, V> implements Entry<K, V>, Serializable {

        private final K key;

        private V value;

        public SimpleEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public SimpleEntry(Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        //todo 没有写 hashCode

    }

    public static class SimpleImmutableEntry<K, V> implements Entry<K, V>, Serializable {

        private final K key;

        private final V value;

        public SimpleImmutableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public SimpleImmutableEntry(Entry<? extends K, ? extends V> entry){
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }
    }

}
