package main.java.wangyunpeng.concurrency.pojo;

import main.java.wangyunpeng.concurrency.pojo.impl.CalculatorStrategy;

public class TaxCalculatorStrategy implements CalculatorStrategy {
    private final double SALARY_RATE = 0.1;
    private final double BONUS_RATE = 0.15;
    @Override
    public double calTax(double salary, double bonus) {
        return salary*SALARY_RATE+bonus*BONUS_RATE;
    }
}
