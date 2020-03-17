package main.java.wangyunpeng.concurrency;

import main.java.wangyunpeng.concurrency.pojo.TaxCalculator;
import main.java.wangyunpeng.concurrency.pojo.TaxCalculatorStrategy;

public class TaxCalculatorMain {

    public static void main(String[] args) {
//        TaxCalculator calculator = new TaxCalculator(10000d,2000d){
//            // 这种写法。如果需要改变税率，之后就会很麻烦，将这个方法抽象出来会更好
//            @Override
//            public double calcTax() {
//                return getBonus()*0.15+getSalary()*0.1;
//            }
//        };
//        System.out.println(calculator.getTax());
        TaxCalculator calculator = new TaxCalculator(10000d,2000d);
        calculator.setCalculatorStrategy(new TaxCalculatorStrategy());
        System.out.println(calculator.getTax());
    }
}
