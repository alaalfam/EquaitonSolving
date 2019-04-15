package com.company;

public class CreateQR extends Matrix {
    private Object[][] matrixQ;
    private Object[][] matrixR;
    private HouseHolder [] HArr;

    CreateQR( Object[][] matrix ){
        n = matrix.length;

        this.matrix = new Object[n][n];
        CopyMatrix copyMatrix = new CopyMatrix(this.matrix , matrix , n , n);

        this.matrixQ = new Object[n][n];
        this.matrixR = new Object[n][n];

        this.HArr = new HouseHolder[n-1];

    }

    public void setMatrix(Object[][] matrix) {
        CopyMatrix copyMatrix = new CopyMatrix(this.matrix , matrix , n , n);
    }

    public Object[][] getMatrix() {
        return matrix;
    }

    public void setMatrixQ(Object[][] matrixQ) {
        this.matrixQ = matrixQ;
    }

    public Object[][] getMatrixQ() {
        return matrixQ;
    }

    public void setMatrixR(Object[][] matrixR) {
        this.matrixR = matrixR;
    }

    public Object[][] getMatrixR() {
        return matrixR;
    }
}
