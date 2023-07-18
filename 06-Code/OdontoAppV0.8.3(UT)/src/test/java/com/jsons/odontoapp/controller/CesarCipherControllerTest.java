/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.jsons.odontoapp.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author wfcad
 */
public class CesarCipherControllerTest {
    
    public CesarCipherControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of encrypt method, of class CesarCipherController.
     */
    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        String plainText = "";
        int shift = 0;
        String expResult = "";
        String result = CesarCipherController.encrypt(plainText, shift);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of decrypt method, of class CesarCipherController.
     */
    
    @Test
    public void testEncryptWithNegativeShift() {
        System.out.println("decrypt");
        String cipherText = "OpenAI";
        int shift = 100;
        String expResult = "9ZOX+3";
        String result = CesarCipherController.decrypt(cipherText, shift);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testEncryptWithNonAlphabeticCharacters() {
        System.out.println("decrypt");
        String cipherText = "Hello, @World!";
        int shift = 2;
        String expResult = "Fcjjm, @Umpjb!";
        String result = CesarCipherController.decrypt(cipherText, shift);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testEncrypt3() {
        System.out.println("decrypt");
        String cipherText = "ABC";
        int shift = 4;
        String expResult = "WXY";
        String result = CesarCipherController.decrypt(cipherText, shift);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
