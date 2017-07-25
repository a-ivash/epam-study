package com.ivashchenko.home1.converter;

/**
 * This class is used to demonstrate work with NumberConverter class.
 * @version 0.01
 * @author Alex Ivashchenko
 */
public class NumberConverterDemo {
    public static void main(String[] args) {
        int number = 21;
        System.out.println("Binary representation: " + NumberConverter.getBinaryRepresentation(number));
        System.out.println("Octal representation: " + NumberConverter.getOctalRepresentation(number));
        System.out.println("Hex representation: " + NumberConverter.getHexRepresentation(number));
    }
}


