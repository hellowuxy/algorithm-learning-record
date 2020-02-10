package cn.wxy.utils;

import cn.wxy.datastructure.tree.BinaryTree.Node;

public class BinaryTreeUtils {

  /**
   * PreOrder traversal
   *
   * @param node
   * @return
   */
  public static  <T> String preOrder(Node<T> node) {
    if (node == null) {
      return "";
    }
    StringBuilder str = new StringBuilder();
    doPreOrder(str, node);
    return str.substring(0, str.lastIndexOf("->"));
  }

  private static <T> void doPreOrder(StringBuilder str, Node<T> node) {
    if (node == null) {
      return;
    }
    str.append(node.value).append("->");
    doPreOrder(str, node.left);
    doPreOrder(str, node.right);
  }

  /**
   * in-order traversal
   *
   * @param node
   * @return
   */
  public static <T> String inOrder(Node<T> node) {
    if (node == null) {
      return "";
    }
    StringBuilder str = new StringBuilder();
    doInOrder(str, node);
    return str.substring(0, str.lastIndexOf("->"));
  }

  private static <T> void doInOrder(StringBuilder str, Node<T> node) {
    if (node == null) {
      return;
    }
    doInOrder(str, node.left);
    str.append(node.value).append("->");
    doInOrder(str, node.right);
  }

  /**
   * post-order traversal
   *
   * @param node
   * @return
   */
  public static <T> String postOrder(Node<T> node) {
    if (node == null) {
      return "";
    }
    StringBuilder str = new StringBuilder();
    doPostOrder(str, node);
    return str.substring(0, str.lastIndexOf("->"));
  }

  private static <T> void doPostOrder(StringBuilder str, Node<T> node) {
    if (node == null) {
      return;
    }
    doPostOrder(str, node.left);
    doPostOrder(str, node.right);
    str.append(node.value).append("->");
  }
}
