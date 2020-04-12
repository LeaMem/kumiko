package com.lea.leet.datastructure.interfaces;

import java.util.Collection;

public interface ITree<T> {

    /**
     * 添加节点，可以又重复的
     *
     * @param value
     * @return
     */
    boolean add(T value);

    /**
     * 移除第一个相等的元素
     *
     * @param value
     * @return
     */
    T remove(T value);

    void clear();

    boolean contains(T value);

    int size();

    boolean validate();

    Collection<T> toCollection();
}
