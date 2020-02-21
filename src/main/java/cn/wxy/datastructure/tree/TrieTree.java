package cn.wxy.datastructure.tree;

import cn.wxy.utils.AssertUtils;

/**
 * Trie 树，也叫“字典树”。顾名思义，它是一个树形结构。
 * 它是一种专门处理字符串匹配的数据结构，用来解决在一组字符串集合中快速查找某个字符串的问题。
 */
public class TrieTree {
  private TrieNode root;

  public TrieTree() {
    root = new TrieNode('/');
  }

  public void insert(String str) {
    char[] chars = str.toCharArray();
    TrieNode p = root;
    for (char aChar : chars) {
      int index = aChar - 'a';
      if (p.children[index] == null) {
        p.children[index] = new TrieNode(aChar);
      }
      p = p.children[index];
    }
    p.isEndingChar = true;
  }

  public boolean find(String str) {
    char[] chars = str.toCharArray();
    TrieNode p = root;
    for (char aChar : chars) {
      int index = aChar - 'a';
      if (p.children[index].data != aChar) {
        return false;
      }
      p = p.children[index];
    }
    return p.isEndingChar;
  }

  private class TrieNode {
    public char data;
    public boolean isEndingChar;
    public TrieNode[] children = new TrieNode[256];

    public TrieNode(char data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    TrieTree trieTree = new TrieTree();
    trieTree.insert("hello");
    trieTree.insert("hi");
    trieTree.insert("he");
    trieTree.insert("how");
    trieTree.insert("are");
    trieTree.insert("you");
    trieTree.insert("ok");

    AssertUtils.assertTrue(trieTree.find("hello"));
    AssertUtils.assertTrue(trieTree.find("hi"));
    AssertUtils.assertTrue(trieTree.find("he"));
    AssertUtils.assertFalse(trieTree.find("hel"));
    AssertUtils.assertTrue(trieTree.find("are"));
    AssertUtils.assertTrue(trieTree.find("you"));
    AssertUtils.assertTrue(trieTree.find("ok"));
  }
}
