package com.lea.kumiko.juc.lang.map;

import java.io.Serializable;
import java.util.Set;

public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable {

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //16

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;




    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
