package com.ex.api.DataGenerate;

public class GenerateEmailAndName {

    public String generateEmail() {
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] tempValues = symbols.toCharArray();
        int temp;

        char[] valuesFinal = new char[10]; //задаем длину первой части email

        for (int i = 0; i < valuesFinal.length; i++) {
            temp = (int) (Math.random() * (tempValues.length));
            valuesFinal[i] = tempValues[temp];
        }

        return String.valueOf(valuesFinal) + "@goonby.com";
    }

    public String generateName() {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] tempValues = symbols.toCharArray();
        int temp;

        char[] valuesFinal = new char[6]; //задаем длину первой части email

        for (int i = 0; i < valuesFinal.length; i++) {
            temp = (int) (Math.random() * (tempValues.length));
            valuesFinal[i] = tempValues[temp];
        }
        return String.valueOf(valuesFinal) ;
    }

}
