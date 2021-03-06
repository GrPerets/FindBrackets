package com.grperets.main;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of pairs of brackets:  ");
        int n = 0;
        if ((scanner.hasNextInt())&&(n = scanner.nextInt())>0?true:false) {

        } else throw new NumberFormatException();


        /**
         *
         *
         * /\               /\            /\
         * 0 1            /\ /\          /  \      /\ /\
         *               0  1  2        0    2    0     2
         *
         *
         *
         *   This code finds the maximum number of paths
         */

        BigInteger[][] arrayWays = new BigInteger [n][];
        arrayWays[0] = new BigInteger[n];

        for ( int i=0; i<arrayWays[0].length; i++ ){
            arrayWays[0][i] = BigInteger.valueOf(1);

        }

        for (int i=1; i<n; i++){
            arrayWays[i] = new BigInteger[n-i];

            for(int j=0; j<n-i; j++){
                arrayWays[i][j]= BigInteger.valueOf(0);
                for(int k=0; k<j+2; k++){
                    arrayWays[i][j] = arrayWays[i][j].add(arrayWays[i-1][k]);

                    //An old method with int or long
                    //arrayWays[i][j] += arrayWays[i-1][k];
                }
            }
        }

        /*
        if yu want to see all the nodes
         */
        //System.out.println(Arrays.deepToString(arrayWays));


        System.out.printf("The number of correct brackets expressions: %d",arrayWays[n-1][0]);

    }
}
