package cn.wxy.algorithms.datastructure.tree;

import cn.wxy.datastructure.tree.BinaryTree;
import cn.wxy.utils.BinaryTreeUtils;
import org.junit.Before;
import org.junit.Test;

public class TestBinaryTree {

  //           A
  //          / \
  //         B   C
  //        / \  /
  //        D E  F
  private BinaryTree.Node<String> root = new BinaryTree.Node<>("A");

  @Before
  public void init() {
    BinaryTree.Node<String> node1 = new BinaryTree.Node<>("B");
    BinaryTree.Node<String> node2 = new BinaryTree.Node<>("C");
    BinaryTree.Node<String> node3 = new BinaryTree.Node<>("D");
    BinaryTree.Node<String> node4 = new BinaryTree.Node<>("E");
    BinaryTree.Node<String> node5 = new BinaryTree.Node<>("F");
    root.left=node1;
    root.right = node2;
    node1.left=node3;
    node1.right = node4;
    node2.left = node5;
  }

  @Test
  public void testPreOrder() {
    System.out.println(BinaryTreeUtils.preOrder(root));
  }

  @Test
  public void testInOrder(){
    System.out.println(BinaryTreeUtils.inOrder(root));
  }

  @Test
  public void testPostOrder(){
    System.out.println(BinaryTreeUtils.postOrder(root));
  }
}
