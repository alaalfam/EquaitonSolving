package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws java.io.IOException{
	// write your code here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (UnsupportedLookAndFeelException e){

        }catch (ClassNotFoundException e) {

        }catch (InstantiationException e) {

        }catch (IllegalAccessException e) {

        }
        Menu menu = new Menu();
    }
}
