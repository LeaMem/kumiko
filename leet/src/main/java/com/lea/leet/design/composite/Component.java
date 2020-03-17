package com.lea.leet.design.composite;

public interface Component {

    //某个商业方法
    void sampleOperation();

    //返回自己的示例
    Composite getComposite();

    //删除子构件对象
    void remove(Component component);

    //添加
    void add(Component component);


}
