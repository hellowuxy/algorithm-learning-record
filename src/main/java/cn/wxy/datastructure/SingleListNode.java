package cn.wxy.datastructure;

/**
 * 单链表节点
 *
 * @autor wxyidea
 * @create 2019-07-09
 **/
public class SingleListNode<T> {
  public T val;
  public SingleListNode next;

  public SingleListNode(){}

  public SingleListNode(T val){
    this .val = val;
  }

  public SingleListNode(T val,SingleListNode next){
    this.val = val;
    this.next = next;
  }
}
