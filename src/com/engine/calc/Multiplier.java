package com.engine.calc;

public class Multiplier extends CalculateBase {
    public Multiplier() {}

    public Multiplier(double leftVal, double rightVal) { super(leftVal, rightVal); }

    //public Multiplier(int leftVal, int rightVal) { super(leftVal, rightVal); }

    @Override
    public void calculate() {
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }

}