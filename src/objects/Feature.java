package objects;

/**
 * Created by Liam on 31-Mar-15.
 */
public class Feature {
    private int[] column;
    private int[] row;
    private boolean[] sign;

    public Feature(int[] column, int[] row, boolean[] sign) {
        this.column = column;
        this.row = row;
        this.sign = sign;
    }

    public int getColumnValue(int index) {
        return column[index];
    }

    public int getRowValue(int index) {
        return row[index];
    }

    public boolean getSignValue(int index) {
        return sign[index];
    }
}
