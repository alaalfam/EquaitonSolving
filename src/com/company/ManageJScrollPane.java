package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ManageJScrollPane {
    JScrollPane scrollPane;
    ManageJScrollPane(Object[][] matrix , String [] title , int n , int m , int x,int y,int width,int height){
        ManageTable manageTable = new ManageTable();
        manageTable.setTable(matrix,title,n,m);
        JTable table = manageTable.getTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(x,y,width,height);
        scrollPane.setBorder(new LineBorder(Color.BLACK,2));
    }
    public JScrollPane getScrollPane(){
        return this.scrollPane;
    }

}
