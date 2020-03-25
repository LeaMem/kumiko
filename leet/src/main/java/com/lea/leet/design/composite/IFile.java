package com.lea.leet.design.composite;

public interface IFile {

    //返回自己的实例
    IFile getComposite();

    //某个商业方法
    void sampleOperation();

    //获取深度
    int getDeep();

    //设置深度
    void setDeep(int x);

}
