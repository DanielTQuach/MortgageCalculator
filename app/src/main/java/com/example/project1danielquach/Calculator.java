package com.example.project1danielquach;

public class Calculator {
    public static double calculate(double P, double J, int N, double T) {
        if (J == 0.0) {
            return P / N + T;
        }
        else {
            double temp = 1 - Math.pow(1 + J, -N);
            return P * J / temp + T;
        }
    }
}
