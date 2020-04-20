package com.lea.leet.datastructure.tree;


import java.util.Comparator;
import java.util.Map;

public class RedBlackTree<K, V> {

    private transient Entry<K, V> root;
    private final Comparator<? super K> comparator;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RedBlackTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }


    public V remove(Object key) {
        Entry<K, V> p = getEntry(key);
        if (p == null) {
            return null;
        }

        V oldValue = p.value;

        return oldValue;
    }

    final Entry<K, V> getEntry(Object key) {

        if (comparator != null) {
            return getEntryUsingComparator(key);
        }
        if (key == null) {
            throw new NullPointerException();
        }
        Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K, V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }

        return null;
    }

    final Entry<K, V> getEntryUsingComparator(Object key) {
        K k = (K) key;
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            Entry<K, V> p = root;
            while (p != null) {
                int cmp = cpr.compare(k, p.key);
                if (cmp < 0) {
                    p = p.left;
                } else if (cmp > 0) {
                    p = p.right;
                } else {
                    return p;
                }
            }
        }
        return null;
    }


    private void deleteEntry(Entry<K, V> p) {

        //如果有两个孩子
        if (p.left != null && p.right != null) {
            Entry<K, V> s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        }

        //开始修复代替节点
        Entry<K, V> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {

            //设置parent
            Entry<K, V> parent = p.parent;
            replacement.parent = parent;
            if (parent == null) {
                root = replacement;
            } else if (p == parent.left) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }

            //null out
            p.left = p.right = p.parent = null;

            //fix
            if (p.color == BLACK) {
                fixAfterDeletion(replacement);
            }
        } else if (p.parent == null) {
            root = null;
        } else {

            //没有孩子节点,将它自己当做幻影然后删除
            if (p.color == BLACK) {
                fixAfterDeletion(p);
            }

            if (p.parent != null) {
                if (p == p.parent.left) {
                    p.parent.left = null;
                } else if (p == p.parent.right) {
                    p.parent.right = null;
                }
                p.parent = null;
            }

        }

    }

    private void fixAfterDeletion(Entry<K, V> x) {

        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {

                Entry<K, V> sib = rightOf(parentOf(x));

                //case 1: 兄弟是红色
                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                //case 2: 兄弟没有红色的节点
                if (colorOf(leftOf(sib)) && colorOf(rightOf(sib))) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    //左边是红的
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }

                    //右边是红的
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else {
                Entry<K, V> sib = leftOf(parentOf(x));
                if (colorOf(sib) == RED) {
                    //右旋
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK && colorOf(leftOf(sib)) == RED) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        //sib 右节点是红色
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }

                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    private static <K, V> boolean colorOf(Entry<K, V> p) {
        return p == null ? BLACK : p.color;
    }

    private static <K, V> Entry<K, V> leftOf(Entry<K, V> p) {
        return p == null ? null : p.left;
    }

    private static <K, V> Entry<K, V> rightOf(Entry<K, V> p) {
        return p == null ? null : p.right;
    }

    private static <K, V> Entry<K, V> parentOf(Entry<K, V> p) {
        return p == null ? null : p.parent;
    }

    private void rotateLeft(Entry<K, V> p) {
        if (p != null) {
            Entry<K, V> r = p.right;
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = p;
            }
            r.left = p;
            p.parent = r;
        }
    }

    private void rotateRight(Entry<K, V> p) {
        if (p != null) {
            Entry<K, V> l = p.left;
            p.left = l.right;
            if (l.right != null) {
                l.right.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                root = p;
            } else if (p.parent.left == p) {
                p.parent.left = l;
            } else {
                p.parent.right = p;
            }

            l.right = p;
            p.parent = l;
        }
    }

    private static <K, V> void setColor(Entry<K, V> p, boolean c) {
        if (p != null) {
            p.color = c;

        }
    }


    static <K, V> Entry<K, V> successor(Entry<K, V> t) {
        if (t == null) {
            return null;
        } else if (t.right != null) {
            Entry<K, V> p = t.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            Entry<K, V> p = t.parent;
            Entry<K, V> ch = t;
            while (p != null && p.right == ch) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }


    static final class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;
        boolean color = BLACK;

        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

    }
}
