package com.lea.leet.design.composite;

public class File implements IFile {

    private String name;

    private int deep;

    public File(String name) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        //根下文件及文件夹
        Folder root = new Folder("树根");

        Folder b1_1 = new Folder("1_枝1");
        Folder b1_2 = new Folder("1_枝2");
        Folder b1_3 = new Folder("1_枝3");
        File l1_1 = new File("1_叶1");
        File l1_2 = new File("1_叶2");
        File l1_3 = new File("1_叶3");

        //b1_2下的文件及文件夹
        Folder b2_1 = new Folder("2_枝1");
        Folder b2_2 = new Folder("2_枝2");
        File l2_1 = new File("2_叶1");

        //缔造树的层次关系（简单测试，没有重复添加的控制）
        root.add(b1_1);
        root.add(b1_2);
        root.add(l1_1);
        root.add(l1_2);

        b1_2.add(b2_1);
        b1_2.add(b2_2);
        b1_2.add(l2_1);
        root.add(l1_3);
        root.add(b1_3);


    }
}
