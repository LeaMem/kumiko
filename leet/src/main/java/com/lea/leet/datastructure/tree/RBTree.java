package com.lea.leet.datastructure.tree;

/**
 * https://www.bilibili.com/video/BV17J411P7aJ?p=4
 *
 * @param <T>
 */
public class RBTree<T extends Comparable<T>> {

    private static final boolean RED = false;

    private static final boolean BLACK = true;

    private RBTNode<T> mRoot;

    public RBTree() {
        this.mRoot = null;
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return node != null && node.color == RED;
    }

    private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }

    private void setBlack(RBTNode<T> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    private void setRed(RBTNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setParent(RBTNode<T> node, RBTNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    private void setColor(RBTNode<T> node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    //对红黑树节点x进行左旋
    private void leftRotate(RBTNode<T> x) {
        RBTNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        //将y.parent 设置为x的parent
        y.parent = x.parent;

        if (x.parent == null) {
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;
    }

    //右旋
    private void rightRotate(RBTNode<T> y) {
        RBTNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;

        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    /**
     * 红黑树插入修正函数
     * 在向红黑树中插入节点之后 (失去平衡) 再调用该函数
     *
     * @param node
     */
    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent, gparent;
        /**
         *      双红修正
         */
        while ((parent = parentOf(node)) != null && isRed(parent)) {
            gparent = parentOf(parent);

            //若父节点是祖父节点的左孩子
            if (parent == parent.left) {

                RBTNode<T> uncle = gparent.right;
                //case 1 : 叔叔节点是红
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case 2: 叔叔是黑色，且当前节点是右孩子 [三角形]
                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case 3条件: 叔叔是黑色，且当前节点是左孩子 [line]
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {

                //右节点
                RBTNode<T> uncle = gparent.left;

                //case 1: 叔叔是红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case2: 叔叔是黑色，当前节点是左孩子 [三角形]
                if (parent.left == node) {
                    rightRotate(parent);
                    RBTNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case 3:  [直线]
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        //将根节点设置为黑色
        //第一次插入的时候
        setBlack(this.mRoot);
    }


    /**
     * 将节点插入到红黑树中
     *
     * @param node
     */
    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;

        //1. 将红黑树当做一颗二叉查找树,将节点添加到二叉查找树中
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        //双向绑定
        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {
            this.mRoot = node;
        }

        //2.将节点颜色设置为红色
        node.color = RED;

        //双红修正
        insertFixUp(node);
    }

    /**
     *      节点插入
     * @param key
     */
    public void insert(T key) {
        RBTNode<T> node = new RBTNode<>(key, BLACK, null, null, null);
        insert(node);
    }


    public static class RBTNode<T extends Comparable<T>> {
        //颜色
        boolean color;

        //键值
        T key;

        //左子树
        RBTNode<T> left;

        //右子树
        RBTNode<T> right;

        //父节点
        RBTNode<T> parent;

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        public String toString() {
            return "" + key + (this.color == RED ? "(R)" : "B");
        }
    }
}
