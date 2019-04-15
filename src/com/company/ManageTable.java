package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ManageTable {
    private JTable table;
    private Object[][] matrix;
    private String [] title;
    private int n;
    private DefaultTableCellRenderer cellRenderer;

    ManageTable(){
        this.cellRenderer = new DefaultTableCellRenderer() ;
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setTable( Object[][] matrix , String[] title , int n,int m){
        this.n = n;
        this.matrix = new Object[n][m];
        this.title = new String[n];
        CopyMatrix copyMatrix = new CopyMatrix(this.matrix,matrix,n,m);
        for (int i = 0; i < m; i++) {
            this.title[i] = title[i];
        }
        this.table = new JTable(matrix , title);
        this.table.setFont(new Font(Font.SERIF,Font.BOLD,15));
        for (int i = 0; i < m; i++) {
            this.table.getColumnModel().getColumn(i).setPreferredWidth(60);
            this.table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        this.table.setRowHeight(60);
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.table.setFillsViewportHeight(true);
    }
    public JTable getTable(){
        return this.table;
    }
}
