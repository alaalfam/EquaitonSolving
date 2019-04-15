package com.company;

public class CopyMatrix {
    CopyMatrix(Object[][] matrixCopy , Object[][] matrix , int n , int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixCopy[i][j] = matrix[i][j];
            }
        }
    }
}
