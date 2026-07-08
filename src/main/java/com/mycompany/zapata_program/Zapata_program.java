/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zapata_program;
import java.util.Scanner;
/**
 *
 * @author CL2-PC
 */
public class Zapata_program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello World!");
        System.out.println("Zapata, Sharmel");
        System.out.println("Enter a number.");
        int x = input.nextInt();
        System.out.println("Enter a number.");
        int y = input.nextInt();
        
        int sum,diff,prod,quot;
        
        sum = x + y;
        diff = x - y;
        prod = x * y;
        quot = x / y;
        
        System.out.println("sum is :"+sum);
        System.out.println("diff is :"+diff);
        System.out.println("prod is :"+prod);
        System.out.println("quot is :"+quot);
    }
}
