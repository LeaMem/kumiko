//package com.lea.leet.replay;
//
//import com.lea.leet.datastructure.tree.AVLTree;
//import com.lea.leet.datastructure.tree.AVLTree.AVLTreeNode;
//
//
////https://ysw1912.github.io/post/cc++/rbtree_delete/
//public class ReAVLTree<T extends Comparable<T>> {
//
//	private AVLTreeNode<T> mRoot;
//
//	public ReAVLTree() {
//		this.mRoot = null;
//	}
//
//	public int height(AVLTreeNode<T> tree) {
//		if (tree != null) {
//			return tree.height;
//		}
//		return 0;
//	}
//
//	public int height() {
//		return height(mRoot);
//	}
//
//	private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
//		if (tree == null || z == null) {
//			return null;
//		}
//		int cmp = z.key.compareTo(tree.key);
//		if (cmp < 0) {
//			//删除左子树
//			tree.left = remove(tree.left, z);
//			//重平衡
//			if (height(tree.right) - height(tree.left) == 2) {
//				AVLTreeNode<T> r = tree.right;
//				if (height(r.left) > height(r.right)) {
//					tree = rightLeftRotation(tree);
//				} else {
//					tree = rightRightRotation(tree);
//				}
//			}
//		} else if (cmp > 0) {
//			tree.right = remove(tree.right, z);
//			if (height(tree.left) - height(tree.right) == 2) {
//				AVLTreeNode<T> l = tree.left;
//				if (height(l.right) - height(l.left) == 2) {
//					tree = leftRightRotation(tree);
//				} else {
//					tree = leftLeftRotation(tree);
//				}
//			}
//		} else {
//			//要删除的节点
//			if (tree.left != null && tree.right != null) {
//
//				//赋予
//
//			} else {
//				tree = (tree.left != null) ? tree.left : tree.right;
//			}
//		}
//	}
//
//
//	public AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
//		if (tree == null) {
//			tree = new AVLTreeNode<>(key, null, null);
//		} else {
//			int cmp = key.compareTo(tree.key);
//			if (cmp < 0) {
//				tree.left = insert(tree.left, key);
//				if (height(tree.left) - height(tree.right) == 2) {
//					if (key.compareTo(tree.left.key) < 0) {
//						//ll旋转
//						tree = leftLeftRotation(tree);
//					} else {
//						//lr选传
//						tree = leftRightRotation(tree);
//					}
//				}
//			} else if (cmp > 0) {
//				tree.right = insert(tree.right, key);
//				if (height(tree.right) - height(tree.left) == 2) {
//					if (key.compareTo(tree.right.key) > 0) {
//						//rr旋转
//						tree = rightRightRotation(tree);
//					} else {
//						//rl选传
//						tree = rightLeftRotation(tree);
//					}
//				}
//			}
//		}
//		tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
//		return tree;
//	}
//
//
//	public AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
//		AVLTreeNode<T> k1 = k2.left;
//		k2.left = k1.right;
//		k1.right = k2;
//
//		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
//		k1.height = Math.max(height(k1.left), k2.height) + 1;
//
//		return k1;
//	}
//
//	public AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {
//		AVLTreeNode<T> k2 = k1.right;
//		k1.right = k2.left;
//		k2.left = k1;
//
//		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
//		k2.height = Math.max(k1.height, height(k2.right)) + 1;
//
//		return k2;
//	}
//
//	public AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
//		k3.left = rightRightRotation(k3.left);
//		return leftLeftRotation(k3);
//	}
//
//	public AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
//		k1.right = leftLeftRotation(k1.right);
//		return rightRightRotation(k1);
//	}
//
//}
