package com.company;

import javafx.beans.binding.ObjectExpression;

import javax.swing.*;

public class Matrix {
    protected Object[][] matrix;
    protected Object[][] matrixX;
    protected Object[][] matrixY;
    protected Object[][] matrixH;
    protected Object[][] matrixHBar;
    protected Object[][] matrixU;
    protected int n;
    protected Object [][] multipleMatrix (Object[][] A ,int n1,int m1 , Object[][] B,int n2,int m2){
        Object[][] result = new Object[n1][m2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                double sum=0;
                for (int k = 0; k < m1; k++) {
                    double a = Double.parseDouble(A[i][k]+"");
                    double b = Double.parseDouble(B[k][j]+"");
                    sum += a*b;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    protected Object[][] multipleScaller(Object[][] A ,double scaller){
        int n = A.length;
        int m = A[0].length;
        Object[][] result = new Object[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Double.parseDouble(A[i][j]+"") * scaller;
            }
        }
        return result;
    }
    protected Object[][] sumMatrix(Object[][] A , Object[][] B){
        int n = A.length;
        int m = A[0].length;
        Object[][] result = new Object[n][m];
        if (n == B.length && m == B[0].length){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    double a = Double.parseDouble(A[i][j]+"");
                    double b = Double.parseDouble(B[i][j]+"");
                    result[i][j] = a+b;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"ماتریس A و ماتریس B هم طول نیستند.");
        }
        return result;
    }
    protected Object[][] minuesMatrix(Object[][] A , Object[][] B){
        int n = A.length;
        int m = A[0].length;
        Object[][] result = new Object[n][m];
        if (n == B.length && m == B[0].length){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    double a = Double.parseDouble(A[i][j]+"");
                    double b = Double.parseDouble(B[i][j]+"");
                    result[i][j] = a-b;
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"ماتریس A و ماتریس B هم طول نیستند.");
        }
        return result;
    }
    protected Object[][] getI(int n){
        Object[][] I = new Object[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == j ){
                    I[i][j]=1;
                }
                else{
                    I[i][j]=0;
                }
            }
        }
        return I;
    }
    protected Object[][] transpose(Object[][] A){
        int n = A.length;
        int m = A[0].length;
        Object[][] AT = new Object[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                AT[j][i] = A[i][j];
            }
        }
        return AT;
    }
    protected double sgn(double x){
        if (x == 0){
            return 0 ;
        }
        return x/Math.abs(x);
    }
    protected double norm2 (Object[][] A , int column){
        double norm2=0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            norm2 += Math.pow(Double.parseDouble(A[i][column]+"") , 2);
        }
        norm2 = Math.sqrt(norm2);
        return norm2;
    }
    protected double norm2 (Object[][] A){
        double norm2=0 ;
        int n = A.length;
        Object[][] result = multipleMatrix(transpose(A),1,n,A,n,1);
        norm2 = Double.parseDouble(result[0][0].toString());
        return norm2;
    }
}
