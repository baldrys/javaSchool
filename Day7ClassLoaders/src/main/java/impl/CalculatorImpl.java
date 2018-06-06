package impl;

import api.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
