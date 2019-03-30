package com.engine.myapp;

import com.engine.calc.Adder;
import com.engine.calc.PowerOf;
import com.engine.calc.CalculateHelper;
import com.engine.calc.DynamicHelper;
import com.engine.calc.InvalidStatementException;
import com.engine.calc.MathEquation;
import com.engine.calc.MathProcessing;

public class Main extends Object{

    public static void main(String[] args) {
        //useMathEquation();
        //useCalculateHelper();

        String[] statements = {
                "power 5.0 5.0",
                "add 25.0 92.0",
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for(String statement:statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }

    }

    static void useCalculateHelper() {
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addx 0.0 0.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "substract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("  Original exception:" + e.getCause().
                            getMessage());
            }
        }
    }

    static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
            equations[0] = new MathEquation('d', 50.0d, 25.0d);
            equations[1] = new MathEquation('a', 7.0d, 13.0d);
            equations[2] = new MathEquation('s', 100.0d, 50.0d);
            equations[3] = new MathEquation('m', 3.0d, 9.0d);

        for(MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }
    }
}

//        System.out.println();
//        System.out.println("Using Overloads");
//        System.out.println();
//
//        double leftDouble = 9.0d;
//        double rightDouble = 4.0d;
//
//        MathEquation equationOverload = new MathEquation('d');
//
//        equationOverload.execute(leftDouble, rightDouble);
//        System.out.print("results = ");
//        System.out.println(equationOverload.getResult());
//
//        int leftInt = 9;
//        int rightInt = 4;
//
//        equationOverload.execute(leftInt, rightInt);
//        System.out.print("new results = ");
//        System.out.println(equationOverload.getResult());
//
//        equationOverload.execute((double)leftInt, rightInt);
//        System.out.print("results = ");
//        System.out.println(equationOverload.getResult());
//
//
//
//        System.out.println();
//        System.out.println("Using Inheritance");
//        System.out.println();
//
//        CalculateBase[] calculators = {
//                new Divider(100.0d, 50.0d),
//                new Adder(25.0d, 92.0d),
//                new Subtracter(225.0d, 17.0d),
//                new Multiplier(11.0d, 3.0d),
//                new Multiplier(11, 3)
//        };
//
//        for(CalculateBase calculator:calculators) {
//            calculator.calculate();
//            System.out.print("result = ");
//            System.out.println(calculator.getResult());
//        }
//
//    }
//
//    //    public static MathEquation creation(double leftVal, double rightVal, char opCode) {
////        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//        System.out.println("print LeftVal: " + equation.getLeftVal());
//        System.out.println("print RightVal: " + equation.getRightVal());
//        System.out.println("print RightVal: " + equation.getOpCode());
//        return equation;
//    }
