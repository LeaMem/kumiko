package com.lea.leet.datastructure.tree;


import javafx.scene.Parent;

/**
 * https://www.bilibili.com/video/BV17J411P7aJ?p=4
 * <p>
 * 节点删除
 * https://segmentfault.com/a/1190000012115424
 * <p>
 * <p>
 * https://segmentfault.com/a/1190000018248335
 * <p>
 * https://segmentfault.com/a/1190000012728513
 * <p>
 * https://segmentfault.com/a/1190000020118044
 *
 * @param <T>
 */
public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

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

    /**
     * 查找最小节点
     */
    private RBTNode<T> minimum(RBTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /**
     * 查找最大节点
     */
    private RBTNode<T> maximum(RBTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    /**
     * 查找 x 的前驱节点
     */
    public RBTNode<T> predecessor(RBTNode<T> x) {
        //如果 x 存在左节点，就是左节点的最大值
        if (x.left != null) {
            return maximum(x.left);
        }
        RBTNode<T> y = x.parent;
        while (y != null && y.left == x) {
            x = y;
            y = x.parent;
        }
        return y;
    }

    /**
     * 查找 x 的后继节点
     */
    public RBTNode<T> successor(RBTNode<T> x) {

        if (x.right != null) {
            return minimum(x.right);
        }

        RBTNode<T> y = x.parent;
        while (y != null && y.right == x) {
            x = y;
            y = x.parent;
        }
        return y;
    }

    /**
     * 左旋，不涉及到颜色
     *
     * @param x
     */
    private void leftRotate(RBTNode<T> x) {

        RBTNode<T> y = x.right;

        x.right = y.left;
        //这里要判断非空
        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = x;
            }
        }

        //设置x
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBTNode<T> y) {

        RBTNode<T> x = y.left;

        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        //这是parent
        if (y.parent == null) {
            this.mRoot = y;
        } else {
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }

        //这是x
        x.right = y;
        y.parent = x;

    }

    /**
     * 红黑树插入修正函数
     * 双红修正
     */
    private void insertFixUP(RBTNode<T> node) {
        RBTNode<T> parent, gparent;

        //如果父节点存在且父节点的颜色是红色
        while ((parent = parentOf(node)) != null && isRed(parent)) {

            //如果是双红冲突，祖父节点一定存在，因为 root 节点一定是黑色
            gparent = parentOf(parent);

            //如果父节点是祖父节点的左孩子
            if (parent == gparent.left) {

                RBTNode<T> uncle = gparent.right;
                //case 1 : 叔叔节点是红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case2: 叔叔节点是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case3: 叔叔节点是黑色，且当前节点是左孩子
                // 这个旋转就结束了
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {

                RBTNode<T> uncle = gparent.left;

                //case1: 叔叔节点是红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case2: 叔叔节点是黑色，且当前节点是左孩子
                if (parent.left == node) {
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case3: 叔叔是黑色，且当前节点是右孩子
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        setBlack(this.mRoot);
    }


    private void insert(RBTNode<T> node) {
        int cmp;

        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {

            //维护根节点
            this.mRoot = node;
        }

        //设置节点的颜色是红色
        node.color = RED;

        //将它重新修正为一颗红黑树
        insertFixUP(node);
    }

    public void insert(T key) {
        RBTNode<T> node = new RBTNode<>(key, BLACK, null, null, null);
        insert(node);
    }


    /**
     * 红黑树删除修正函数
     * <p>
     * 在从红黑树中删除插入节点之后（红黑树失去平衡）,再调用该函数
     * 目的是将它重塑成一颗红黑树
     *
     * @param node
     * @param parent
     */
    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;
        while ((node == null || isBlack(node)) && (node != this.mRoot)) {
            if (parent.left == node) {
                other = parent.right;

                if (isRed(other)) {
                    //case 1: x 的兄弟 w 是红色的
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {

                    //case2 : x的兄弟节点是黑色，并且w的两个孩子也是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);

                } else {

                    if (other.right == null || isBlack(other.right)) {
                        //case3 : x的兄弟节点是黑色的，并且w的左孩子是红色，右孩子是黑色
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }

                    //case4: x的兄弟节点是黑色的，并且w的右孩子是红色，左孩子任意颜色
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.mRoot;
                    break;
                }

            } else {
                other = parent.left;

                if (isRed(other)) {

                    //case 1 x的兄弟节点是红色
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {

                    //case2: x的兄弟节点是黑色，且w的两个孩子都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);

                } else {
                    if (other.left == null || isBlack(other.left)) {

                        //case3: x 的兄弟节点 w 是黑色，并且w的左节点是红色
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    //case4: x的兄弟节点w是黑色，并且 w 的右孩子是红色的，左孩子任意颜色
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.mRoot;
                    break;
                }
            }
        }

        if (node != null) {
            setBlack(node);
        }
    }

    private void remove(RBTNode<T> node) {

        RBTNode<T> child, parent;
        boolean color;

        //被删除的节点左右孩子都不为空
        if (node.left != null && node.right != null) {
            //被删节点的后继节点，
            RBTNode<T> replace = node;

            //获取后继节点
            replace = replace.right;
            while (replace.left != null) {
                replace = replace.left;
            }

            if (parentOf(node) != null) {
                if (parentOf(node).left == node) {
                    parentOf(node).left = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                this.mRoot = replace;
            }

            //child 是取代节点的右孩子，也是需要调整的节点
            // 取代节点肯定不存在左孩子，因为它是一个后继节点
            child = replace.right;
            parent = parentOf(replace);
            //保存取代节点的颜色
            color = colorOf(replace);

            ///被删除节点 是 它后继节点的父节点
            if (parent == node) {
                parent = replace;
            } else {
                //child不为空
                if (child != null) {
                    setParent(child, parent);
                }
                parent.left = child;
                replace.right = node.right;
                setParent(node.right, replace);
            }
        }
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

        @Override
        public String toString() {
            return "" + key + (this.color == RED ? "(R)" : "B");
        }
    }
}
