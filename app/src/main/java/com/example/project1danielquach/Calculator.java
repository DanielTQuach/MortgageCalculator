package com.example.project1danielquach;

import android.util.Log;

public class Calculator {
    public static double calculate(double P, double J, int N, double T) {
        if (J == 0.0) {
            Log.d("Calculator", "P: " + P + ", J: " + J + ", N: " + N + ", T: " + T);
            return P / N + T;
        }
        else {
            Log.d("Calculator", "P: " + P + ", J: " + J + ", N: " + N + ", T: " + T);
            double temp = 1 - Math.pow(1 + J, -N);
            return P * J / temp + T;
        }
    }
}
