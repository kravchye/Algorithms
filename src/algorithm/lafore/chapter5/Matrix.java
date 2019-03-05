package algorithm.lafore.chapter5;
// Programming project 5.6
public class Matrix {
    private class MatrixLink {
        long data;
        MatrixLink nextRow;
        MatrixLink nextCol;

        MatrixLink(long d) {
            this.data = d;
        }

        void display() {
            System.out.print(data + " ");
        }
    }

    private int nCols;
    private int nRows;
    private MatrixLink first;
    private MatrixLink current;

    public Matrix(int nCols, int nRows) {
        this.nCols = nCols;
        this.nRows = nRows;

        first = new MatrixLink(0);
        current = first;

        MatrixLink temp;
        for (int i = 0; i < nRows; i++) {
            temp = current;
            for (int j = 1; j < nCols; j++) {
                temp.nextCol = new MatrixLink(0);
                temp = temp.nextCol;
            }
            if (i < nRows - 1) { // don't create the new row
                current.nextRow = new MatrixLink(0);
                current = current.nextRow;
            }
        }
    }
    public void insert(int row, int col, long data) {
        if (row > nRows || col > nCols || row < 0 || col < 0) {
            throw new IllegalArgumentException("Wrong matrix coordinates");
        }
        current = first;
        for (int i=0; i < row; i++) {
            current = current.nextRow;
        }
        for (int i=0; i < col; i++) {
            current = current.nextCol;
        }
        current.data = data;
    }

    public void display() {
        current = first;
        MatrixLink temp;
        while (current != null) {
            temp = current;
            while (temp != null) {
                temp.display();
                temp = temp.nextCol;
            }
            System.out.println();
            current = current.nextRow;
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3,3);
        matrix.insert(0,0,0);
        matrix.insert(1,0,1);
        matrix.insert(2,0,2);

        matrix.insert(0,1,3);
        matrix.insert(1,1,4);
        matrix.insert(2,1,5);

        matrix.insert(0,2,6);
        matrix.insert(1,2,7);
        matrix.insert(2,2,8);


        matrix.display();
    }
}
