package com.jsons.odontoapp.controller;
/**
 *
 * @author yeshualinux
 */


public class CesarCipher {
    public static String encrypt(String plainText, int shift) {
        StringBuilder cipherText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            if (Character.isUpperCase(c)) {
                cipherText.append((char) ('A' + (c - 'A' + shift) % 26));
            } else if (Character.isLowerCase(c)) {
                cipherText.append((char) ('a' + (c - 'a' + shift) % 26));
            } else {
                cipherText.append(c);
            }
        }
        return cipherText.toString();
    }
    
    public static String decrypt(String cipherText, int shift) {
        StringBuilder plainText = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (Character.isUpperCase(c)) {
                plainText.append((char) ('A' + (c - 'A' - shift + 26) % 26));
            } else if (Character.isLowerCase(c)) {
                plainText.append((char) ('a' + (c - 'a' - shift + 26) % 26));
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }

//    public static void main(String[] args) {
//        String plainText = "OdontoApp";
//        int shift = 3;
//        String cipherText = encrypt(plainText, shift);
//        System.out.println("Texto cifrado: " + cipherText);
//    }
    
}

