package com.semanticsquare.oop.c137; /**
 * @author Client Inc.
 */
import com.semanticsquare.oop.c137.C;

import java.util.*;
public class TestClient {
   public static int getVal() {
       return 42;
   }
 
   public static void main(String[] args) {
       // Interfaces demo
       C c = new X();
	   /*c.foo();
	   c.bar();
	   c.foobar();*/
	   
	   // Clone demo
	   /*C clone = ((X)c).clone();
	   if (clone != c) {
	      System.out.println("Clone created!!");
	   }*/
	   
	   // default method demo
       c.go();	   
   }
}