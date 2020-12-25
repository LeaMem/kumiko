package com.lea.leet.datastructure.tree;


public class AVLTree<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;

    public AVLTree() {
        this.mRoot = null;
    }

    public int height(AVLTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
        if (x == null) {
            return x;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        } else if (cmp > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }

    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public T minimum() {
        AVLTreeNode<T> p = minimum(mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    //LL 左单旋转
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        return k1;
    }

    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {

        AVLTreeNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(k1.height, height(k2.right)) + 1;

        return k2;
    }

    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }

    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
        k1.right = leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }

    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            //新建节点
            tree = new AVLTreeNode<>(key, null, null);
        } else {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {
                tree.left = insert(tree.left, key);
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0) {
                        tree = leftLeftRotation(tree);
                    } else {
                        tree = leftRightRotation(tree);
                    }
                }
            } else if (cmp > 0) {
                tree.right = insert(tree.right, key);
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) > 0) {
                        tree = rightRightRotation(tree);
                    } else {
                        tree = rightLeftRotation(tree);
                    }
                }
            } else {
                throw new Error("不允许节点相同");
            }
        }

        tree.height = max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }


    /**
     * 删除节点
     *
     * @param tree
     * @param z
     * @return
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {

        //删除节点z,返回根节点
        if (tree == null || z == null) {
            return null;
        }

        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {
            //待删除的节点在 tree 的左子树中
            tree.left = remove(tree.left, z);
            //删除节点后，维持平衡
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode<T> r = tree.right;
                if (height(r.left) > height(r.right)) {
                    tree = rightLeftRotation(tree);
                } else {
                    tree = rightRightRotation(tree);
                }
            }
        } else if (cmp > 0) {

            tree.right = remove(tree.right, z);
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode<T> l = tree.left;
                if (height(l.right) > height(l.left)) {
                    tree = leftRightRotation(tree);
                } else {
                    tree = leftLeftRotation(tree);
                }
            }

        } else {

            //tree是要删除的节点
            //tree 左右孩子都是非空节点
            if (tree.left != null && tree.right != null) {
                if (height(tree.left) > height(tree.right)) {
                    /**
                     *    如果tree的左子树比右子树搞
                     *    1. 找出左子树中最大的节点
                     *    2. 将该最大的几点赋值给tree
                     *    3. 删除该最大节点
                     */
                    AVLTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {

                    AVLTreeNode<T> min = minimum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);

                }

            } else {
                AVLTreeNode<T> tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                tmp = null;
            }

        }
        return tree;
    }

    public static class AVLTreeNode<T extends Comparable<T>> {

        public T key;

        public int height;

        public AVLTreeNode<T> left;

        public AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

    }

}
