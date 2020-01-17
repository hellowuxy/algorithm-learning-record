package cn.wxy.datastructure.tree;

public class BinaryTree<T> {
  /**
   * root node
   */
  private Node<T> root;

  /**
   * pre-order traversal
   *
   * @return traversal result
   */
  public String preOrder() {
    if (root == null) {
      return "";
    }
    StringBuilder str = new StringBuilder();
    doPreOrder(str, root);
    return str.substring(0, str.lastIndexOf("->"));
  }

  private void doPreOrder(StringBuilder str, Node<T> node) {
    if (node == null) {
      return;
    }
    str.append(node.value).append("->");
    doPreOrder(str, node.left);
    doPreOrder(str, node.right);
  }

  /**
   * in-order traversal
   * @return traversal result
   */
  public String inOrder() {
    if (root == null) {
      return "";
    }
    StringBuilder str = new StringBuilder();
    doInOrder(str, root);
    return str.substring(0, str.lastIndexOf("->"));
  }

  private void doInOrder(StringBuilder str, Node<T> node) {
    if (node == null) {
      return;
    }
    doInOrder(str, node.left);
    str.append(node.value).append("->");
    doInOrder(str, node.right);
  }

  /**
   * in-order traversal
   * @return traversal result
   */
  public String postOrder() {
    if (root == null) {
      return "";
    }
    StringBuilder str = new StringBuilder();
    doPostOrder(str, root);
    return str.substring(0, str.lastIndexOf("->"));
  }

  private void doPostOrder(StringBuilder str, Node<T> node) {
    if (node == null) {
      return;
    }
    doPostOrder(str, node.left);
    doPostOrder(str, node.right);
    str.append(node.value).append("->");
  }

  public static class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public T value;

    public Node(T value) {
      this.value = value;
    }
  }
}
