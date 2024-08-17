package com.boj.gcdlcm;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;


public class Main {
    private final MyFunction myFunction = () -> {};

    interface MyFunction {
        void MyFunction();

        /************************************************************************
         * 최대공약수 GCD(Greatest Common Divisor) : 두 자연수의 공통된 약수 중 가장 큰 수
         *  - 유클리드호제법: 2개의 자연수  a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 (단 a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
         *  - ex) 72와   30의 최대공약수
         *      = 30과   12의 최대공약수
         *      = 12와   8의  최대공약수
         *      = 8과    4의  최대공약수
         *      = 4와    0의  최대공약수
         *      = min(8, 4) = 4
         * 최소공배수 LCM(Least Common Multiple)   : 두 자연수의 공통된 배수 중 가장 작은 수
         *  - LCM = (A * B) / GCD
         ************************************************************************/
        default Integer gcd (Integer A, Integer B) {
            if (B == 0) { return A; }
            return gcd(B, A % B);
        }
    }

    private void solution() {
        int A = 72;
        int B = 30;

        int gcd = myFunction.gcd(A, B);    // A > B
        int lcm = A * B / gcd;
        System.out.println("GCD of " + A + " and " + B + " is " + gcd);
        System.out.println("LCM of " + A + " and " + B + " is " + lcm);
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
