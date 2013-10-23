/*
 * Assignment #3 - Mark A. Tyler II
 * Due: 3/20/2013
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Scanner;
import java.util.StringTokenizer;

class rational{
	//Use integer variables to represent the private instance variables - 
	//the numerator and the denominator.
    private int numerator = 0;
    private int denominator = 0;
    
    //*************************** Constructors ******************************
    //Parameterized constructor
    //When the constructor is called...automatically reduces the fraction 
    //to its reduced form.
    public rational(int top, int bottom){
        numerator = top;
        denominator = bottom;
        //The numbers should be stored in reduced form. 
        
        //A rational number is in reduced form if the greatest 
        //common divisor of the numerator and the denominator is 1. 
        //(The fraction 2/4 is equivalent to 1/2 and would be 
        //stored in the object as 1 in the numerator and 2 in the denominator.)
        //Refer to the function reduce-->
        reduce();
    }
    
    //Default constructor without any arguments being passed
    public rational(){
    	//if numerator and denominator is not given or passed through the constructor
    	//set the numerator and denominator equal to zero because nothing was given
    	numerator = 0;
    	denominator = 0;
    }
    //************************** End Of Constructors **********************************
    
    //toString that returns a string representation of the calling class
    public String toString(){
    	//In this case the toString method returns a rational number or a fraction
    	return (Integer.toString(numerator) + "/" + Integer.toString(denominator));
    }
    
    //*************************** Getter Methods **************************************
    //Get numerator - mutator method / Does what it says
    public int getNum(){
        return numerator;
    }

    //Get denominator - mutator method / Does what it says.
    public int getDen(){
        return denominator;
    }
    
    //Retrieves the GCD Function
    int getGCD(int n, int d){ 
    	//Algorithm for finding the GCD of a fraction. Used primarily in the reduce function
    	int temp;
    	//while the denominator is not equal to zero
        while(d != 0){
            temp = d;
            d = n % d;
            n = temp;
        }
        return n;
    }
    //********************End of getter methods********************
    
    
    
    //Function that reduces the fraction to it's lowest terms using the GCD function. 
    void reduce(){
    	//declare a variable gcd that holds the greatest common denominator.
        int gcd = getGCD(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    //Add function of type
    rational Add(rational r){
        rational theAnswer;
        //just in case other values get thrown in.
        int den = 0, num = 0;
       
        //If the denominator
        if(denominator == r.denominator && r.divByZero(r)){
            theAnswer = new rational(r.numerator + numerator, denominator);
        }
        else{
        	
        	den = denominator * r.getDen();
        	num = numerator * r.getNum();
        	num = num + r.getNum() * denominator;
        	theAnswer = new rational(num, den);

        }
     return theAnswer;
    }

    //rational Sub Method that Sub from it.
    rational Sub(rational r){
        rational theAnswer;
        int den = 0, num = 0;
        
        if(r.denominator == denominator && r.divByZero(r)){
            theAnswer = new rational(numerator - r.numerator, denominator);
        }
        else{
            den = denominator / r.getDen();
            num = numerator / r.getNum();
            theAnswer = new rational((r.getNum() - num) * denominator, den);
        }
        return theAnswer;
    }
    //Divide by zero error check
    //Additional method to check if denominator is zero 
    public boolean divByZero(rational x){
    	if(x.denominator !=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    //rational Multiply Method
    rational multiply(rational x){
        rational product;
        int num = x.numerator * numerator;
        int den = x.denominator * denominator;
        
        product = new rational(num, den);
        return product;
    }

    //rational Divide Method
    rational divide(rational x){
        rational quotient;
        
        int num = x.numerator * denominator;
        int den = x.denominator * numerator;
        //
        quotient = new rational(den,num);
        return quotient;
    }
    
    //Main Method
    public static void main(String[]args){
        System.out.println("Enter fraction in this form( i.e. 5/20):");
        //
        Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		//tokens are the strings before and after "/"
		StringTokenizer extractDigits = new StringTokenizer(s, "/");
    	
		int j = Integer.parseInt(extractDigits.nextToken());
		int k = Integer.parseInt(extractDigits.nextToken());
		
		String t = scan.nextLine();
		
		//tokens are the strings before and after "/" ... allows 
		//us to read in values in the form A / B - fraction
		StringTokenizer extract2Digits = new StringTokenizer(t, "/");
    	
		int l = Integer.parseInt(extract2Digits.nextToken());
		int m = Integer.parseInt(extract2Digits.nextToken());
		//holds the answer and is overridden line by line.
		rational theAnswer;
        rational fractionOne = new rational(j,k);
        rational fractionTwo = new rational(l,m);
        //Variable of type rational that holds theAnswer - numerator and denominator
        
        System.out.println("The fraction you entered in it's reduced form: " + fractionOne.toString());
        System.out.println("The fraction you entered in it's reduced form: " + fractionTwo.toString());
        System.out.println("\n");
        //stores the product and quotient of fraction 1 and fraction 2 in the variable theAnswer
        System.out.println("******** PRODUCT & QUOTIENT ********");
        theAnswer = fractionOne.divide(fractionTwo);
        System.out.println("fraction 1 / fraction 2: " + fractionOne.toString() + " / " + fractionTwo.toString() + " = " + theAnswer.toString());
        theAnswer = fractionOne.multiply(fractionTwo);
        System.out.println("fraction 1 * fraction 2: " + fractionOne.toString() + " * " + fractionTwo.toString() + " = " + theAnswer.toString());
        System.out.println("\n");
        //stores the sum and difference of fraction 1 and fraction 2 in the variable theAnswer
        System.out.println("******** SUM AND DIFFERENCE ********");
        theAnswer = fractionOne.Add(fractionTwo);
        System.out.println("fraction 1 + fraction 2: " + fractionOne.toString() + " + " + fractionTwo.toString() + " = " + theAnswer.toString());
        theAnswer = fractionOne.Sub(fractionTwo);
        System.out.println("fraction 1 - fraction 2: " + fractionOne.toString() + " - " + fractionTwo.toString() + " = " + theAnswer.toString());
           
    }
}