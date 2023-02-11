package 子矩形查询;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/23/19:09
 * @Description:1476题
 */
class SubrectangleQueries {
    private int[][] rec = null;
    public SubrectangleQueries(int[][] rectangle) {
        this.rec = rectangle;

    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (rec != null){
            for (int i = row1; i <= row2 ; i++) {
                for (int j = col1; j < col2; j++) {
                    rec[i][j] = newValue;
                }

            }
        }
    }

    public int getValue(int row, int col) {
        if (rec != null){
            return rec[row][col];
        }
        return -1;
    }


}