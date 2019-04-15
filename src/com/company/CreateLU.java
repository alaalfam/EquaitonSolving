package com.company;

public class CreateLU extends Matrix {
    private Object[][] matrixL;
    private Object[][] matrixU;
    protected Object[][] matrixResult;
    CreateLU(Object [][] matrix , Object[][] matrixResult , int n){
        this.n = n;
        this.matrix = new Object[n][n];
        this.matrixResult = matrixResult;
        this.matrixL = new Object[n][n];
        this.matrixU = new Object[n][n];
        CopyMatrix copyMatrix = new CopyMatrix(this.matrix , matrix , n , n);
    }

    public void solveLU(){
        if ( checkSolve() ){
            for (int i = 0; i < n; i++) {
                if (!zeroColumn(i)){
                    break;
                }
            }
        }
        setMatrixL();
        setMatrixU();
    }
    private boolean checkSolve(){
        for (int i = 0; i < n; i++) {
            if ( Double.parseDouble(matrix[i][i]+"") == 0 ) {
                return false;
            }
        }
        return true;
    }
    protected boolean zeroColumn(int j){
        for (int i = j+1; i < n; i++) {
            double a1 = Double.parseDouble(matrix[j][j]+"");
            if (a1 == 0){
                return false;
            }
            double a2 = Double.parseDouble(matrix[i][j]+"");
            double m = (-1)*a2 / a1 ;
            for (int k = j; k < n; k++) {
                matrix[i][k] = m*Double.parseDouble(matrix[j][k]+"") + Double.parseDouble(matrix[i][k]+"") ;
            }
            matrix[i][j] = (-1)*m;
        }
        return true;
    }

    protected void setMatrixU(){
        CopyMatrix copyMatrix = new CopyMatrix(matrixU,matrix,n,n);
        for (int j = 0; j < n; j++) {
            for (int i = j+1; i < n; i++) {
                matrixU[i][j] = 0 ;
            }
        }
    }
    public Object[][] getMatrixU (){
        return matrixU;
    }
    protected void setMatrixL(){
        CopyMatrix copyMatrix = new CopyMatrix(matrixL,matrix,n,n);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                matrixL[i][j] = 0 ;
            }
            matrixL[i][i] = 1 ;
        }
    }
    public Object[][] getMatrixL() {
        return matrixL;
    }
}
