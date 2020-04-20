package com.lea.leet.datastructure.interfaces;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class BTree<T extends Comparable<T>> implements ITree<T> {

    //默认是 2-3 树
    private int minKeySize = 1;
    private int minChildrenSize = minKeySize + 1; //2
    private int maxKeySize = 2 * minKeySize; // 2
    private int maxChildrenSize = maxKeySize + 1; //3

    private Node<T> root = null;
    private int size = 0;

    public BTree() {

    }

    public BTree(int order) {
        this.minKeySize = order;
        this.minChildrenSize = minKeySize + 1;
        this.maxKeySize = 2 * minKeySize;
        this.maxChildrenSize = maxKeySize + 1;
    }

    @Override
    public boolean add(T value) {
        if (root == null) {
            root = new Node<>(null, maxKeySize, maxChildrenSize);
            root.addKey(value);
        } else {
            Node<T> node = root;
            while (node != null) {

                //当前是子节点了
                if (node.numberOfChildren() == 0) {
                    node.addKey(value);
                    if (node.numberOfKeys() <= maxKeySize) {
                        // A-Ok
                        break;
                    }

                    split(node);
                    break;
                }

                //Navigate

                // Lesser or equal
                T lesser = node.getKey(0);
                if (value.compareTo(lesser) <= 0) {
                    node = node.getChild(0);
                    continue;
                }

                //Greater
                int numberOfKeys = node.numberOfKeys();
                int last = numberOfKeys - 1;
                T greater = node.getKey(last);
                if (value.compareTo(greater) > 0) {
                    node = node.getChild(numberOfKeys);
                    continue;
                }

                //search internal nodes;
                for (int i = 1; i < node.numberOfKeys(); i++) {
                    T pre = node.getKey(i - 1);
                    T next = node.getKey(i);
                    if (value.compareTo(pre) > 0 && value.compareTo(next) >= 0) {
                        node = node.getChild(i);
                        break;
                    }
                }
            }
        }

        size++;
        return true;
    }

    private void split(Node<T> nodeToSplit) {
        Node<T> node = nodeToSplit;
        int numberOfKeys = node.numberOfKeys();
        int medianIndex = numberOfKeys / 2;
        T medianValue = node.getKey(medianIndex);

        Node<T> left = new Node<T>(null, maxKeySize, maxChildrenSize);
        for (int i = 0; i < medianIndex; i++) {
            left.addKey(node.getKey(i));
        }
        if (node.numberOfChildren() > 0) {
            for (int j = 0; j <= medianIndex; j++) {
                Node<T> c = node.getChild(j);
                left.addChild(c);
            }
        }

        Node<T> right = new Node<T>(null, maxKeySize, maxChildrenSize);
        for (int i = medianIndex + 1; i < numberOfKeys; i++) {
            right.addKey(node.getKey(i));
        }
        if (node.numberOfChildren() > 0) {
            for (int j = medianIndex + 1; j < node.numberOfChildren(); j++) {
                Node<T> c = node.getChild(j);
                right.addChild(c);
            }
        }

        if (node.parent == null) {

            //new root, height of tree increased
            Node<T> newRoot = new Node<>(null, maxKeySize, maxChildrenSize);
            newRoot.addKey(medianValue);
            node.parent = newRoot;
            root = newRoot;
            node = root;
            node.addChild(left);
            node.addChild(right);
        } else {
            Node<T> parent = node.parent;
            parent.addKey(medianValue);
            parent.removeChild(node);

            parent.addChild(left);
            parent.addChild(right);

            if(parent.numberOfKeys() > maxKeySize){
                split(parent);
            }
        }



    }


    @Override
    public T remove(T value) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Collection<T> toCollection() {
        return null;
    }


    private static class Node<T extends Comparable<T>> {
        private T[] keys = null;
        private int keySize = 0;
        private Node<T>[] children = null;
        private int childrenSize = 0;

        private Comparator<Node<T>> comparator = new Comparator<Node<T>>() {
            @Override
            public int compare(Node<T> o1, Node<T> o2) {
                return o1.getKey(0).compareTo(o2.getKey(0));
            }
        };

        protected Node<T> parent = null;

        private Node(Node<T> parent, int maxKeySize, int maxChildrenSize) {
            this.parent = parent;
            this.keys = (T[]) new Comparable[maxKeySize + 1];
            this.keySize = 0;
            this.children = new Node[maxChildrenSize + 1];
            this.childrenSize = 0;
        }

        private T getKey(int index) {
            return keys[index];
        }

        private int indexOf(T value) {
            for (int i = 0; i < keySize; i++) {
                if (keys[i].equals(value)) {
                    return i;
                }
            }
            return -1;
        }

        private void addKey(T value) {
            keys[keySize++] = value;
            Arrays.sort(keys, 0, keySize);
        }

        private T removeKey(T value) {
            T removed = null;
            boolean found = false;
            if (keySize == 0) {
                return null;
            }
            for (int i = 0; i < keySize; i++) {
                if (keys[i].equals(value)) {
                    found = true;
                    removed = keys[i];
                } else if (found) {
                    keys[i - 1] = keys[i];
                }
            }

            if (found) {
                keySize--;
                keys[keySize] = null;
            }
            return removed;
        }

        private T removeKey(int index) {
            if (index >= keySize) {
                return null;
            }
            T value = keys[index];
            for (int i = index + 1; i < keySize; i++) {
                keys[i - 1] = keys[i];
            }
            keySize--;
            keys[keySize] = null;
            return value;
        }

        private int numberOfKeys() {
            return keySize;
        }

        private Node<T> getChild(int index) {
            if (index >= childrenSize) {
                return null;
            }
            return children[index];
        }

        private int indexOf(Node<T> child) {
            for (int i = 0; i < childrenSize; i++) {
                if (children[i].equals(child)) {
                    return i;
                }
            }
            return -1;
        }

        private boolean addChild(Node<T> child) {
            child.parent = this;
            children[childrenSize++] = child;
            Arrays.sort(children, 0, childrenSize, comparator);
            return true;
        }

        private boolean removeChild(Node<T> child) {
            boolean found = false;
            if (childrenSize == 0) {
                return found;
            }
            for (int i = 0; i < childrenSize; i++) {
                if (children[i].equals(child)) {
                    found = true;
                } else if (found) {
                    children[i - 1] = children[i];
                }
            }

            if (found) {
                childrenSize--;
                children[childrenSize] = null;
            }

            return found;
        }

        private Node<T> removeChild(int index) {
            if (index >= childrenSize) {
                return null;
            }
            Node<T> value = children[index];
            children[index] = null;
            for (int i = index + 1; i < childrenSize; i++) {
                children[i - 1] = children[i];
            }
            childrenSize--;
            children[childrenSize] = null;
            return value;
        }

        private int numberOfChildren() {
            return childrenSize;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("keys=[");
            for (int i = 0; i < numberOfKeys(); i++) {
                T value = getKey(i);
                builder.append(value);
                if (i < numberOfKeys() - 1)
                    builder.append(", ");
            }
            builder.append("]\n");

            if (parent != null) {
                builder.append("parent=[");
                for (int i = 0; i < parent.numberOfKeys(); i++) {
                    T value = parent.getKey(i);
                    builder.append(value);
                    if (i < parent.numberOfKeys() - 1)
                        builder.append(", ");
                }
                builder.append("]\n");
            }

            if (children != null) {
                builder.append("keySize=").append(numberOfKeys()).append(" children=").append(numberOfChildren()).append("\n");
            }

            return builder.toString();
        }

    }

}
