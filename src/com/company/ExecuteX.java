package com.company;

public class ExecuteX extends Matrix {
    private Object[][] matrixL;
    private Object[][] matrixU;
    private Object[][] matrixResult;
    private Object[][] QTb;
    ExecuteX(Object[][] matrix , Object[][] matrixResult ,int n){
        this.n = n;
        matrixX = new Object[n][1];
        this.matrix = new Object[n][n];
        this.matrixResult = new Object[n][1];
        CopyMatrix copyMatrix = new CopyMatrix(this.matrix,matrix,n,n);
        CopyMatrix copyMatrix1 = new CopyMatrix(this.matrixResult,matrixResult,n,1);
    }
    public void executeLU(Object[][] matrix , Object[][] matrixResult , Object[][] matrixU , Object[][] matrixL , int n){
        this.matrixU = new Object[n][n];
        this.matrixL = new Object[n][n];
        this.matrixY = new Object[n][1];
        CopyMatrix copyMatrix = new CopyMatrix(this.matrixU,matrixU,n,n);
        CopyMatrix copyMatrix1 = new CopyMatrix(this.matrixL,matrixL,n,n);
        setMatrixY();
        setMatrixX(matrixU,matrixX,matrixY);
    }
    public void executeQR(Object[][] matrix , Object[][] matrixResult , Object[][] matrixQ , Object[][] matrixR , int n){

        // QRx = b => Rx = QTb
        this.QTb = new Object[n][1];
        this.QTb = multipleMatrix(matrixQ,n,n,matrixResult,n,1);
        // Rx = QTb
        // پس ماتریس x باید به صورت پسرو حساب شود
        setMatrixX(matrixR,matrixX,QTb);
    }

    public Object[][] getQTb() {
        return QTb;
    }

    private void setMatrixX(Object[][] matrixU , Object[][] matrixX , Object[][] matrixY){
        matrixX[n-1][0] = Double.parseDouble(matrixY[n-1][0]+"") / Double.parseDouble(matrixU[n-1][n-1]+"");
        for (int i = n-2; i >= 0 ; i--) {
            double sum = 0 ;
            for (int j = i+1; j < n ; j++) {
                sum += Double.parseDouble(matrixU[i][j]+"")*Double.parseDouble(matrixX[j][0]+"");
            }
            matrixX[i][0] = (Double.parseDouble(matrixY[i][0]+"") - sum) / Double.parseDouble(matrixU[i][i]+"");
        }
    }
    public Object[][] getMatrixX(){
        return matrixX;
    }

    private void setMatrixY (){
        for (int i = 0; i < n; i++) {
            double sum = 0 ;
            for (int j = 0; j <= i - 1; j++) {
                sum += Double.parseDouble(matrixL[i][j]+"")*Double.parseDouble(matrixResult[j][0]+"");
            }
            matrixY[i][0] = Double.parseDouble(matrixResult[i][0]+"") - sum ;
        }
    }
    public Object[][] getMatrixY(){
        return this.matrixY;
    }
}