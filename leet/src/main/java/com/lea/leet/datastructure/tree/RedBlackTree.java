package com.lea.leet.datastructure.tree;

import java.util.Comparator;
import java.util.Map;

public class RedBlackTree<K, V> {

    private transient Entry<K, V> root;
    private final Comparator<? super K> comparator;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RedBlackTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }


    public V remove(Object key) {
        Entry<K, V> p = getEntry(key);
        if (p == null) {
            return null;
        }

        V oldValue = p.value;

        return oldValue;
    }

    final Entry<K, V> getEntry(Object key) {

        if (comparator != null) {
            return getEntryUsingComparator(key);
        }
        if (key == null) {
            throw new NullPointerException();
        }
        Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K, V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }

        return null;
    }

    final Entry<K, V> getEntryUsingComparator(Object key) {
        K k = (K) key;
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            Entry<K, V> p = root;
            while (p != null) {
                int cmp = cpr.compare(k, p.key);
                if (cmp < 0) {
                    p = p.left;
                } else if (cmp > 0) {
                    p = p.right;
                } else {
                    return p;
                }
            }
        }
        return null;
    }


    private void deleteEntry(Entry<K, V> p) {

        //如果有两个孩子
        if (p.left != null && p.right != null) {
            Entry<K, V> s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        }

        //开始修复代替节点
        Entry<K, V> replacement = (p.left != null ? p.left : p.right);

        if(replacement != null){

        }

    }

    static <K, V> Entry<K, V> successor(Entry<K, V> t) {
        if (t == null) {
            return null;
        } else if (t.right != null) {
            Entry<K, V> p = t.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            Entry<K, V> p = t.parent;
            Entry<K, V> ch = t;
            while (p != null && p.right == ch) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }


    static final class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;
        boolean color = BLACK;

        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
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

    }
}
