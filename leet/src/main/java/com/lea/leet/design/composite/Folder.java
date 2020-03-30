package com.lea.leet.design.composite;

import java.util.Vector;


public class Folder implements IFile {

    //文件名
    private String name;

    //深度
    private int deep;

    private Vector<IFile> componentVector = new Vector<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public IFile getComposite() {
        return this;
    }

    @Override
    public void sampleOperation() {
        System.out.println("执行了某个商业方法");
    }

    @Override
    public int getDeep() {
        return deep;
    }

    @Override
    public void setDeep(int x) {
        this.deep = x;
    }

    public void add(IFile iFile) {
        componentVector.add(iFile);
        iFile.setDeep(this.deep + 1);
    }

    public void remove(IFile iFile){
        componentVector.removeElement(iFile);
    }

    public Vector getAllComponent(){
        return componentVector;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<IFile> getComponentVector() {
        return componentVector;
    }

    public void setComponentVector(Vector<IFile> componentVector) {
        this.componentVector = componentVector;
    }
}
