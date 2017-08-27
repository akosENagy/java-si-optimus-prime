//Finds prime numbers below n using the Sieve of Eratosthenes
//n is given as a terminal argument

package com.codecool;

import java.util.ArrayList;

public class PrimeFinder {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        System.out.println(findPrimes(n).toString());
    }

    static ArrayList<Integer> findPrimes(int n) {


        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i; j * i < n; j++) {
                    isPrime[j*i] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }
}