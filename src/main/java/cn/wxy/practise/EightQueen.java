package cn.wxy.practise;

/**
 * 回溯算法的应用：八皇后问题
 */
public class EightQueen {

  // 下标表示行，值表示queen存储在哪一列
  private int[] result = new int[8];

  public void cal8Queen(int row) {
    if (row == 8) {
      printQueen();
      return;
    }
    for (int column = 0; column < 8; column++) {
      if (isOk(row, column)) {
        // 在第row行第column列放置棋子
        result[row] = column;
        cal8Queen(row + 1);
      }
    }
  }

  private boolean isOk(int row, int column) {
    int leftUp = column - 1;
    int rightUp = column + 1;
    for (int i = row - 1; i >= 0; i--) {
      if (result[i] == column) return false; // 正上方有旗子
      if (leftUp >= 0 && result[i] == leftUp) return false;  // 左上角有旗子
      if (rightUp < 8 && result[i] == rightUp) return false;  // 左上角有旗子
      leftUp--;
      rightUp++;
    }
    return true;
  }

  public void printQueen() {
    for (int row = 0; row < 8; row++) {
      for (int column = 0; column < 8; column++) {
        if (result[row] == column) System.out.print("Q ");
        else System.out.print("* ");
      }
      System.out.println(); // 换行
    }
    System.out.println(); // 换行
  }

  public static void main(String[] args) {
    EightQueen queen = new EightQueen();
    queen.cal8Queen(0);
  }
}
