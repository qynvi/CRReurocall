package com;

import com.optionsim.crreurocall;
import java.util.List;
import java.util.Scanner;

// Dummy main for OptionSim packages
public class OptionSim {
  public static void main( String[] args )
  {
    Scanner reader = new Scanner(System.in);
    System.out.println("r: ");
    double r = reader.nextDouble();
    System.out.println("sigma: ");
    double sigma = reader.nextDouble();
    System.out.println("K: ");
    double K = reader.nextDouble();
    System.out.println("S: ");
    double S = reader.nextDouble();
    System.out.println("T: ");
    double T = reader.nextDouble();
    System.out.println("n: ");
    int n = reader.nextInt();

    // Instantiate new option
    crreurocall option_0 = new crreurocall(r,sigma,K,S,T,n);

    // Test vector: 0.07, 0.3, 100, 100, 0.5, 500

    System.out.println("Call option's price: " + option_0.estimatePrice().get(0));
  }
}
