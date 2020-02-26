package com.lea.leet.datastructure.tree;


public class AVLTree<T extends Comparable<T>> {

    //根节点
    private AVLTreeNode<T> mRoot;

    public AVLTree() {
        this.mRoot = null;
    }

    /**
     * 获取树的高度
     */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    /**
     * 比较两个值的大小
     *
     * @param a
     * @param b
     * @return
     */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 前序遍历
     *
     * @param tree
     */
    private void preOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            System.out.println(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }


    private void inOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    private void postOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder();
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
        }
        return x;
    }

    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return x;
    }

    public AVLTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找最小节点：返回tree为根节点的AVL树的最小节点
     *
     * @param tree
     * @return
     */
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

    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    public T maximum() {
        AVLTreeNode<T> p = maximum(mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    /**
     * 左旋
     *
     * @param k2
     * @return
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;
    }

    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;

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

                        if (key.compareTo(tree.left.key) < 0) {
                            tree = leftLeftRotation(tree);
                        } else {
                            tree = leftRightRotation(tree);
                        }

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
            }
        }

        tree.height = max(height(tree.left), height(tree.right) + 1);

        return tree;
    }

    /**
     * 删除节点 z, 返回根节点
     *
     * @param tree 树的根节点
     * @param z    待删除的节点
     * @return
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        if (tree == null || z == null) {
            return null;
        }
        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {
            tree.left = remove(tree.left, z);

            //删除节点后，如果失去平衡，进行平衡调节
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

            //tree是对应要删除的节点
            if (tree.left != null && tree.right != null) {
                if (height(tree.left) > height(tree.right)) {
                    //如果tree的左子树比右子树搞
                    //查询左子树中的最大系节点
                    //将该最大节点的值赋值给tree
                    //删除该最大节点
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

    private void destroy(AVLTreeNode<T> tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            destroy(tree.left);
        }
        if (tree.right != null) {
            destroy(tree.right);
        }

        tree = null;
    }

    public void destroy() {
        destroy(mRoot);
    }

    public static class AVLTreeNode<T extends Comparable<T>> {

        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

    }
}
