package com.ivashchenko.home1.squarematrix;

/**
 * This class is used to demonstrate work with Matrix class.
 * @version 0.01
 * @author Alex Ivashchenko
 */
public class MatrixDemo {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.printMatrix();
        matrix.removeColumnWithMaxElement();
        matrix.printMatrix();
    }
}



