package com.lea.kumiko.juc.lang.map;

import java.io.Serializable;
import java.util.Set;

public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable {
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
