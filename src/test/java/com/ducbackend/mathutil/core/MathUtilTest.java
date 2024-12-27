/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */
package com.ducbackend.mathutil.core;

import static com.ducbackend.mathutil.core.MathUtil.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.MethodSources;


/**
 *
 * @author Admin
 */
public class MathUtilTest {
    @Test
    public void  testFactorialGivenRightArgreturnsWell(){
        assertEquals(24,getfactorial(4));
    }
    // Bat ngoai le khi dua data ca chon exception
    @Test
    public void  testFactorialGivenWrongArgthrowException(){
        // xai bieu thuc LAMBDA
        // ham nhan tham so thu 2  cua 1  cai object/ co code implement cai
        // functional interface ten la Executable - co 1 ham dyu nhat ko code
        // ten la execute()
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getfactorial(-5);
//            }
//        };
        Executable exObject = () -> {getfactorial(-5);};
        
        assertThrows(IllegalArgumentException.class , () -> getfactorial(-5));
    }
    // choi voi DDT
    public static Object[][] initData(){
        return new Integer[][]{
                {1,1},
                {2,2},
                {4,24},
                {5,120}
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData") //  tên hàm cung cấp data, ngầm định thứ tự
    // của các phần tử mảng, map vào tham số hàm 
    public void  testFactorialGivenRightArgreturnsWell( int input, long expected) {
        assertEquals(expected, getfactorial(input));
    }
}
