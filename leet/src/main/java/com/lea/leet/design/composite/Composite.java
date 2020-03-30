package com.lea.leet.design.composite;

import java.util.Enumeration;
import java.util.Vector;

public class Composite implements Component {

    private Vector componentVector = new Vector();

    @Override
    public void sampleOperation() {
        Enumeration enumeration = components();
        while (enumeration.hasMoreElements()) {
            ((Composite) enumeration.nextElement()).sampleOperation();
        }
    }

    @Override
    public Composite getComposite() {
        return this;
    }

    @Override
    public void remove(Component component) {
        componentVector.removeElement(component);
    }

    @Override
    public void add(Component component) {
        componentVector.addElement(component);
    }

    @Override
    public Enumeration components() {
        return componentVector.elements();
    }

}
