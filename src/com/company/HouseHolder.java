package com.company;
import java.util.Formatter;

public class HouseHolder extends Matrix {
    public Matrix [] matrices;
    private Object[][] Q;
    private Object[][] R;
    int n;
    int matrixLength;
    HouseHolder(Object[][] matrix , int n){
        this.n = n;
        matrixLength = n ;
        this.matrix = new Object[n][n];
        CopyMatrix copyMatrix = new CopyMatrix(this.matrix , matrix , n , n);
        Q = new Object[n][n];
        R = new Object[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Q[i][j] = 0;
                R[i][j] = 0;
            }
        }

        matrices = new Matrix[n-1];
        for (int i = 0; i < n - 1; i++) {
            // تمام object های داخل کلاس Matrix را باید new  کنم.

            matrices[i] = new Matrix();
//            matrices[i].matrix = new Object[n][n];
//            matrices[i].matrixX = new Object[n][n];
//            matrices[i].matrixY = new Object[n][n];
            matrices[i].matrixH = new Object[n][n];
            matrices[i].matrixHBar = new Object[n][n];
            matrices[i].matrixU = new Object[n][n];
            setMatrixH(this.matrix,i);
        }
        R = this.matrix;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Formatter formatter = new Formatter();
                formatter.format("%.3f", Double.parseDouble(R[i][j].toString()));
                R[i][j] = formatter;
                if ( Double.parseDouble(R[i][j].toString()) == 0.0 ){
                    R[i][j]=0.0;
                }
            }
        }
    }

    public void calculateQ(){
        int n = matrices.length;
        int N = matrices[n-1].matrixH.length;
        CopyMatrix copyMatrix = new CopyMatrix(Q , matrices[n-1].matrixH,N,N);
        for (int i = n-2; i >=0 ; i--) {
            Object[][] multiple = multipleMatrix(Q,N,N,matrices[i].matrixH,N,N);
//            Q = multipleMatrix(Q,this.n,this.n,multiple,this.n,this.n);
            Q = multiple;
        }
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                Formatter formatter = new Formatter();
                formatter.format("%.3f",Double.parseDouble(Q[i][j].toString()));
                Q[i][j] = formatter;
                if ( Double.parseDouble(Q[i][j].toString()) == 0.0 ){
                    Q[i][j]=0.0;
                }
            }
        }
    }
    public Object[][] getQ() {
        return Q;
    }

    public Object[][] getR() {
        return R;
    }

    public void setMatrixH(Object[][] A , int j) {
        matrices[j].matrix = new Object[n][n];
        CopyMatrix copyMatrix = new CopyMatrix(this.matrix , A , n , n);
        setMatrixU(this.matrix,j);
        setMatrixHBar(this.matrix ,j);
        matrices[j].matrixH = getI(n);

        for (int row = j , row1=0; row < n; row++ , row1++) {
            for (int col = j , col1=0; col < n; col++ , col1++) {
                matrices[j].matrixH[row][col] = matrices[j].matrixHBar[row1][col1];
            }
        }
        this.matrix = multipleMatrix(matrices[j].matrixH,n,n,matrix,n,n);
        // باید با دقت 3 رقم اعشار حساب کنه تا 0 بشه.
    }

    private void setMatrixHBar(Object[][] A , int j) {
        matrixLength-=j;
        matrices[j].matrixHBar = new Object[matrixLength][matrixLength];

        Object[][] I = getI(matrixLength);
        // U = X + sgn(X1)* ||X|| * e1
        // HBar = I - (2*U*Ubar / norm2(U))
        Object[][] UUTranspose = multipleMatrix(matrices[j].matrixU,matrixLength,1,transpose(matrices[j].matrixU),1,matrixLength);
        Object[][] UTransPoseU = multipleMatrix(transpose(matrices[j].matrixU),1,matrixLength,matrices[j].matrixU,matrixLength,1) ;
        Double UTU = Double.parseDouble(UTransPoseU[0][0].toString());
        Object[][] U = multipleScaller(UUTranspose,2);
        U = multipleScaller(U,(1/UTU));

        matrices[j].matrixHBar = minuesMatrix(I,U);

    }

    private void setMatrixU(Object[][] A , int j){
        // U = X + sgn(X1) * ||X|| * e1
//        int n = this.n - j;
        Object[][] X = subMatrix(A,j,j,n,j+1);
        int m = X.length;
        Object[][] e = new Object[m][1];
        e[0][0]=1;
        for (int i = 1; i < m; i++) {
            e[i][0]=0;
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(X[i][0]+ "    "+e[i][0]);
//        }
        matrices[j].matrixU = sumMatrix(X,multipleScaller(e,norm2(X,0)*sgn(Double.parseDouble(X[0][0]+""))));
//        for (int i = 0; i < m; i++) {
//            System.out.println(matrices[j].matrixU[i][0]);
//        }
    }
    public Object[][] getmatrixH() {
        return matrixH;
    }
    private Object[][] subMatrix(Object[][] A , int startRow , int startCol , int endRow,int endCol){
        int n , m ;
        n = endRow - startRow;
        m = endCol - startCol;

        Object[][] result = new Object[n][m];
        for (int i = 0 , row = startRow; i < n; i++ , row++) {
            for (int j = 0 , col = startCol; j < m; j++,col++) {
                result[i][j] = A[row][col];
            }
        }
        return result;
    }
}
