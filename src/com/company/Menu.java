package com.company;


import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

class Menu {
    private JFrame menuFrame;
    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JRadioButton radioButtonLU;
    private JRadioButton radioButtonLUAxis;
    private JRadioButton radioButtonQRHouseHolder;
    private JRadioButton radioButtonLessSquareSVD;
    private JRadioButton radioButtonLessSquareQR;
    private JList listRowCol;
    private JScrollPane jScrollPane;
    private JTable jTableZarib;
    private JTable jTableResult;

    private int n;
    private String [] columnTitle;

    enum enumPanel { chPanel1 , chPanel2 , chPanel3 }

    private void addPanel(enumPanel choicePanel ,int x , int y , int width ,int height ) throws java.io.IOException {
        switch ( choicePanel ) {
            case chPanel1 :
                panel1.setBackground(new Color(190,190,190));
                panel1.setBounds(x,y,width-7,height);
                panel1.setLayout(null);
                panel1.setBorder(new LineBorder(Color.BLACK,2,true));
                panel0.add(panel1);
                break;
            case chPanel2 :
                panel2.setBackground(new Color(140,140,140));
                panel2.setBounds(x,y,width-7,height);
                panel2.setPreferredSize(new Dimension(width-7,height));
                panel2.setLayout(null);
                panel2.setBorder(new LineBorder(Color.BLACK,2,true));
                panel0.add(panel2);
                break;
            case chPanel3:
                panel3.setBackground(new Color(140,140,140));
                panel3.setBounds(x, y, width-7, height);
                panel3.setLayout(null);
                panel3.setBorder(new LineBorder(Color.BLACK,2 , true));
                panel0.add(panel3);
                break;
            default:
            JOptionPane.showMessageDialog( panel1 ,"Please select correct panel");
            break;
        }
    }
    private void addLabel(enumPanel choicePanel ,int x,int y,int width,int height , String txt ,int fontSize){
        JLabel label = new JLabel(txt);
        label.setFont(new Font(Font.SERIF, Font.BOLD, fontSize));
        label.setBounds(x,y,width,height);
        switch ( choicePanel ) {
            case chPanel1:
               panel1.add(label);
               panel1.revalidate();
               break;
            case chPanel2:
                panel2.add(label);
                panel2.revalidate();
                break;
            default:
                JOptionPane.showMessageDialog( panel1 ,"Please select correct panel");
                break;
        }
    }
    private void addRadioButton(){
        radioButtonLU.setText("تجزیه ی LU بدون محورگیری");
        radioButtonLU.setSelected(true);
        radioButtonLUAxis.setText("تجزیه ی LU با محورگیری");
        radioButtonQRHouseHolder.setText("تجزیه ی QR به روش HouseHolder");
        radioButtonLessSquareSVD.setText("کمترین مربعات به کمک تجزیه ی SVD");
        radioButtonLessSquareQR.setText("کمترین مربعات به کمک تجزیه ی QR");
        radioButtonLU.setFont(new Font(Font.SERIF ,Font.BOLD , 20));
        radioButtonLUAxis.setFont(new Font(Font.SERIF,Font.BOLD,20));
        radioButtonQRHouseHolder.setFont(new Font(Font.SERIF,Font.BOLD,20));
        radioButtonLessSquareSVD.setFont(new Font(Font.SERIF,Font.BOLD,20));
        radioButtonLessSquareQR.setFont(new Font(Font.SERIF,Font.BOLD,20));
        radioButtonLU.setBounds(400,20,430,30);
        radioButtonLU.setBackground(new Color(190,190,190));
        radioButtonLUAxis.setBackground(new Color(190,190,190));
        radioButtonLUAxis.setBounds(400,60,430,30);
        radioButtonQRHouseHolder.setBounds(400,100,430,30);
        radioButtonQRHouseHolder.setBackground(new Color(190,190,190));
        radioButtonLessSquareSVD.setBounds(400,140,430,30);
        radioButtonLessSquareSVD.setBackground(new Color(190,190,190));
        radioButtonLessSquareQR.setBounds(400,180,430,30);
        radioButtonLessSquareQR.setBackground(new Color(190,190,190));

        panel1.add(radioButtonLU);
        panel1.add(radioButtonLUAxis);
        panel1.add(radioButtonQRHouseHolder);
        panel1.add(radioButtonLessSquareSVD);
        panel1.add(radioButtonLessSquareQR);

    }
    private void addList( int x,int y,int width,int height ){
        jScrollPane.setBounds(x,y,width,height);
        panel1.add(jScrollPane);
    }
    private void addTable(Object [][] array , Object[][] resultArr , Object[][] xArr ,int n,int x,int y,int width,int height) {
        columnTitle = new String[n];
        for (int i=0 ; i<n ; i++){
            columnTitle[i] = "ستون"+(i+1) +" ام" ;
        }

        ManageTable objManageTable = new ManageTable();
        objManageTable.setTable(array,columnTitle,n,n);
        jTableZarib = objManageTable.getTable();
        String [] title = new String[1];
        title[0]="متغیر ها";
        objManageTable.setTable(xArr,title,n,1);
        JTable jTableX = objManageTable.getTable();
        String [] resultTitle = {"مقدار ثابت"};
        objManageTable.setTable(resultArr,resultTitle,n,1);
        jTableResult = objManageTable.getTable();

        JScrollPane jScrollPaneTable = new JScrollPane(jTableZarib);
        jScrollPaneTable.setBounds(x,y,width,height);
        jScrollPaneTable.setBorder(new LineBorder(Color.BLACK , 2));

        JScrollPane jScrollPaneX = new JScrollPane(jTableX);
        jScrollPaneX.setBounds(x+290,y,60,height);
        jScrollPaneX.setBorder(new LineBorder(Color.BLACK , 2));

        JScrollPane jScrollPaneResult = new JScrollPane(jTableResult);
        jScrollPaneResult.setBounds(x+450,y,60,height);
        jScrollPaneResult.setBorder(new LineBorder(Color.BLACK , 2));

        JLabel multipleLabel = new JLabel(new ImageIcon("D:\\java\\Matrix\\multiple.png"));
        multipleLabel.setBounds(x+220,y+100,60,60);
        JLabel equaleLable = new JLabel(new ImageIcon("D:\\java\\Matrix\\equale.png"));
        equaleLable.setBounds(x+370,y+100,60,60);

        JButton solveButton = new JButton("Execute");
        solveButton.setFont(new Font(Font.SERIF,Font.BOLD,19));
        solveButton.setBounds(570,y+100,100,50);
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object [][] matrix = new Object[n][n];
                Object [][] matrixResult = new Object[n][n];
                Object [][] matrixX ;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (jTableZarib.getValueAt(i,j) != null) {
                            matrix[i][j] = jTableZarib.getValueAt(i,j);
                        }
                        else {
                            JOptionPane.showMessageDialog(menuFrame,"لطفا ماتریس ضرایب را کامل کنید.","Warnning",JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    if (jTableResult.getValueAt(i,0)!=null){
                        matrixResult[i][0] = jTableResult.getValueAt(i,0);
                    }
                    else{
                        JOptionPane.showMessageDialog(menuFrame,"لطفا ماتریس ثابت ها را کامل کنید.","Warnning",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                if (radioButtonLU.isSelected()){
                    CreateLU objMatrixLU = new CreateLU(matrix , matrixResult , n);
                    objMatrixLU.solveLU();
                    Object [][] matrixU = objMatrixLU.getMatrixU();
                    for (int i = 0; i < n; i++) {
                        if (Double.parseDouble(matrixU[i][i]+"") == 0){
                            JOptionPane.showMessageDialog(null,"این ماتریس تجزیه ی LU ندارد.","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    ExecuteX objExecuteX = new ExecuteX(matrix,matrixResult,n);
                    objExecuteX.executeLU(matrix,matrixResult,objMatrixLU.getMatrixU(),objMatrixLU.getMatrixL(),n);
                    matrixX = objExecuteX.getMatrixX();
                    addTable(array , resultArr , matrixX ,n,x,y,width,height);
                    showDecomposition(objMatrixLU.getMatrixL(),objMatrixLU.getMatrixU(),n , "L=","U=");
                    String label = "L         *         Y         =   B     &      U      *       X     =    Y ";
                    execute(matrix,matrixResult,objMatrixLU.getMatrixL(),objMatrixLU.getMatrixU(),objExecuteX.getMatrixY(),objExecuteX.getMatrixX(),n,label);
                }
                else if (radioButtonLUAxis.isSelected()){
                    CreateLUAxis createLUAxis = new CreateLUAxis(matrix,matrixResult,n);
                    createLUAxis.solveLUAxis();
                    Object [][] matrixU = createLUAxis.getMatrixU();
                    showDecomposition(createLUAxis.getMatrixL(),createLUAxis.getMatrixU(),n,"L=","U=");
                    for (int i = 0; i < n; i++) {
                        if (Double.parseDouble(matrixU[i][i]+"") == 0){
                            JOptionPane.showMessageDialog(null,"با این ماتریس نمیتوان دستگاه حل کرد.","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    ExecuteX executeX = new ExecuteX(matrix,matrixResult,n);
                    executeX.executeLU(matrix,matrixResult,createLUAxis.getMatrixU(),createLUAxis.getMatrixL(),n);
                    matrixX = executeX.getMatrixX();
                    addTable(array,resultArr,matrixX,n,x,y,width,height);
                    showDecomposition(createLUAxis.getMatrixL(),createLUAxis.getMatrixU(),n,"L=","U=");
                    String label = "L         *         Y         =   B     &      U      *       X     =    Y ";
                    execute(matrix,matrixResult,createLUAxis.getMatrixL(),createLUAxis.getMatrixU(),executeX.getMatrixY(),executeX.getMatrixX(),n,label);
                }
                else if (radioButtonQRHouseHolder.isSelected()){
                    HouseHolder houseHolder = new HouseHolder(matrix , n);
                    houseHolder.calculateQ();
                    Object[][] QT = houseHolder.getQ();
                    Object[][] Q = houseHolder.transpose(QT);
                    Object[][] R = houseHolder.getR();
                    ExecuteX executeX = new ExecuteX(matrix,matrixResult,n);
                    executeX.executeQR(matrix,matrixResult,QT,R,n);
                    matrixX = executeX.getMatrixX();
                    addTable(array,resultArr,matrixX,n,x,y,width,height);
                    showDecomposition(Q , R , n ,"Q=" , "R=");
                    String label = "Q  *  R  *  X  =  b      ===>      R  *  X  =  Q^T  *  b";
                    execute(matrix , matrixResult, Q , R , executeX.getQTb(),executeX.getMatrixX(),n,label);
                }
                else if (radioButtonLessSquareSVD.isSelected()){

                }
                else if (radioButtonLessSquareQR.isSelected()){

                }
            }
        });
        panel2.removeAll();
        panel3.removeAll();
        JLabel label = new JLabel("A          *          X    =    B");
        label.setFont(new Font(Font.SERIF,Font.ITALIC,50));
        label.setBounds(5,5,700,50);
        panel2.add(label);
        panel2.add(jScrollPaneTable);
        panel2.add(multipleLabel);
        panel2.add(jScrollPaneX);
        panel2.add(equaleLable);
        panel2.add(jScrollPaneResult);
        panel2.add(solveButton);
        panel2.repaint();
        panel2.revalidate();

    }
    private void showDecomposition(Object[][] matrix1 , Object[][] matrix2 , int n , String label1 , String label2) {
        // وقتی که ماتریس اصلی تجزیه میشود آن را به طور جداگانه نیز نشان میدهد.
        columnTitle = new String[n];
        for (int i=0 ; i<n ; i++){
            columnTitle[i] = "ستون"+(i+1) +" ام" ;
        }
        ManageJScrollPane manageJScrollPaneL = new ManageJScrollPane(matrix1,columnTitle,n,n,750,10,210,230);
        JScrollPane scrollPaneTableL = manageJScrollPaneL.getScrollPane();
        ManageJScrollPane manageJScrollPaneU = new ManageJScrollPane(matrix2,columnTitle,n,n,1050,10,210,230);
        JScrollPane scrollPaneTableU = manageJScrollPaneU.getScrollPane();

        JLabel labelL = new JLabel(label1);
        labelL.setFont(new Font(Font.SERIF , Font.ITALIC , 50));
        labelL.setBounds(680,100,70,70);
        JLabel labelU = new JLabel(label2);
        labelU.setFont(new Font(Font.SERIF,Font.ITALIC,50));
        labelU.setBounds(960,100,80,80);

        panel2.remove(scrollPaneTableL);
        panel2.remove(scrollPaneTableU);
        panel2.remove(labelL);
        panel2.remove(labelU);
        panel2.add(scrollPaneTableL);
        panel2.add(scrollPaneTableU);
        panel2.add(labelL);
        panel2.add(labelU);
        panel2.repaint();
        panel2.revalidate();
    }
    private void execute(Object[][] matrix , Object [][] matrixResult , Object[][] matrixL , Object[][] matrixU , Object[][] matrixY , Object[][] matrixX , int n , String label){
        columnTitle = new String[n];
        for (int i=0 ; i<n ; i++){
            columnTitle[i] = "ستون"+(i+1) +" ام" ;
        }
        String [] title = {"ماتریس Y ها"};
        String [] resultTitle = {"ماتریس ثابت ها"};
        String [] titleX = {"ماتریس X ها"};

        JLabel labelMultiple = new JLabel(new ImageIcon("D:\\java\\Matrix\\multiple.png"));
        labelMultiple.setBounds(230,200,70,70);
        JLabel labelEqual = new JLabel(new ImageIcon("D:\\java\\Matrix\\equale.png"));
        labelEqual.setBounds(420,200,70,70);
        JLabel labelLY = new JLabel(label);
        labelLY.setFont(new Font(Font.SERIF,Font.ITALIC,50));
        labelLY.setBounds(20,10,1200,100);
        JLabel labelMultiple1 = new JLabel(new ImageIcon("D:\\java\\Matrix\\multiple.png"));
        labelMultiple1.setBounds(860,200,70,70);
        JLabel labelEqual1 = new JLabel(new ImageIcon("D:\\java\\Matrix\\equale.png"));
        labelEqual1.setBounds(1060,200,70,70);
        ManageJScrollPane manageJScrollPaneY = new ManageJScrollPane(matrixY,title,n,1,320,100,100,230);
        JScrollPane scrollPaneTableY = manageJScrollPaneY.getScrollPane();
        ManageJScrollPane manageJScrollPaneResult = new ManageJScrollPane(matrixResult,resultTitle,n,1,500,100,100,230);
        JScrollPane scrollPaneTableResult = manageJScrollPaneResult.getScrollPane();
        ManageJScrollPane manageJScrollPaneU1 = new ManageJScrollPane(matrixU,columnTitle,n,n,640,100,210,230);
        JScrollPane scrollPaneTableU1 = manageJScrollPaneU1.getScrollPane();
        ManageJScrollPane manageJScrollPaneX = new ManageJScrollPane(matrixX,titleX,n,1,950,100,100,230);
        JScrollPane scrollPaneTableX = manageJScrollPaneX.getScrollPane();
        ManageJScrollPane manageJScrollPaneY1 = new ManageJScrollPane(matrixY,title,n,1,1140,100,100,230);
        JScrollPane scrollPaneTableY1 = manageJScrollPaneY1.getScrollPane();
        ManageJScrollPane manageJScrollPaneL1 = new ManageJScrollPane(matrixL,columnTitle,n,n,10,100,210,230);
        JScrollPane scrollPaneTableL1 = manageJScrollPaneL1.getScrollPane();

        panel3.removeAll();

        panel3.add(labelLY);
        panel3.add(scrollPaneTableY);
        panel3.add(labelMultiple);
        panel3.add(scrollPaneTableL1);
        panel3.add(labelEqual);
        panel3.add(scrollPaneTableResult);
        panel3.add(scrollPaneTableU1);
        panel3.add(labelMultiple1);
        panel3.add(scrollPaneTableX);
        panel3.add(labelEqual1);
        panel3.add(scrollPaneTableY1);
        panel3.repaint();
        panel3.revalidate();
    }
    Menu () throws java.io.IOException {
        menuFrame = new JFrame();
        panel0 = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        radioButtonLU = new JRadioButton();
        radioButtonLUAxis = new JRadioButton();
        radioButtonQRHouseHolder = new JRadioButton();
        radioButtonLessSquareSVD = new JRadioButton();
        radioButtonLessSquareQR = new JRadioButton();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonLU);
        buttonGroup.add(radioButtonLUAxis);
        buttonGroup.add(radioButtonQRHouseHolder);
        buttonGroup.add(radioButtonLessSquareSVD);
        buttonGroup.add(radioButtonLessSquareQR);
        String [] array = new String [10000];
        for (int i=0 ; i<10000 ; i++) {
            array[i] = i+1 + "" ;
        }
        listRowCol = new JList(array);
        jScrollPane = new JScrollPane(listRowCol);
        listRowCol.setFocusable(false);
        listRowCol.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String rowCol = listRowCol.getSelectedValue().toString();
                n = Integer.parseInt(rowCol);
                Object [][] array = new Object[n][n];
                Object [][] resultArr = new Object[n][1];
                Object [][] xArr = new Object[n][1] ;
                for (int i = 0; i < n; i++) {
                    xArr[i][0] = "X"+i ;
                }
                addTable(array , resultArr , xArr , n,10,90,210,230);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        menuFrame.setTitle("Equation solver");
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setBounds(20,20,1300,700);
        menuFrame.setVisible(true);
        menuFrame.setResizable(false);
        menuFrame.setLayout(new GridLayout(1,1));

        panel0.setLayout(new GridLayout(3,1));
        panel0.setPreferredSize(new Dimension(1270,1000));
        JScrollPane scrollPane = new JScrollPane(panel0);
        menuFrame.add(scrollPane);

        addPanel(enumPanel.chPanel1 ,0,0,1300,150 );
        addPanel(enumPanel.chPanel2 ,0,200,1300,260 );
        addPanel(enumPanel.chPanel3 , 0,460,1300,200);

        addLabel(enumPanel.chPanel1 ,900,50,400,30,"لطفا عمل مورد نظر را انتخاب کنید.",30);
        addRadioButton();
        addLabel(enumPanel.chPanel1 , 100,20,200,30,"تعداد سطرهای ماتریس (n*n)",20);

        addList(5,5,90,60);
    }
}
