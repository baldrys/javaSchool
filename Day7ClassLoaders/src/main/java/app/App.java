package app;

import api.Calculator;
import impl.CalculatorImpl;

public class App {
    //public CalculatorImpl calculatorImpl;

    public App() {
    }

    public int doCalc(int a, int b){
        Calculator calculator = new CalculatorImpl();
        return calculator.calculate(a, b);
    }
}
