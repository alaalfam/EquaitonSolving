package com.company;

public class CreateLUAxis extends CreateLU {
    CreateLUAxis(Object [][] matrix , Object[][] matrixResult , int n){
        super(matrix,matrixResult,n);
    }
    public void solveLUAxis(){
        for (int i = 0; i < n; i++) {
            swap(i , findMax(i));
            zeroColumn(i);
        }
        setMatrixL();
        setMatrixU();
    }
    private void swap (int i , int j){
        for (int k = 0; k < n; k++) {
            Object o = matrix[i][k];
            matrix[i][k] = matrix[j][k];
            matrix[j][k] = o;
        }
        Object o1 = matrixResult[i][0];
        matrixResult[i][0] = matrixResult[j][0];
        matrixResult[j][0] = o1;
    }
    private int findMax(int j){
        double max = Double.parseDouble(matrix[j][j]+"");
        int maxIndex = j;
        for (int i = j; i < n; i++) {
            double value = Double.parseDouble(matrix[i][j]+"");
            if (value>max){
                max = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
