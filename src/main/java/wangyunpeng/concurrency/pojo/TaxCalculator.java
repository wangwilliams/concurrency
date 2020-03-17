package main.java.wangyunpeng.concurrency.pojo;

import main.java.wangyunpeng.concurrency.pojo.impl.CalculatorStrategy;

public class TaxCalculator {
    private final double salary;
    private final double bonus;
    private CalculatorStrategy calculatorStrategy;
    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy){
        this.calculatorStrategy = calculatorStrategy;
    }

    public double getTax(){
        return calculatorStrategy.calTax(salary,bonus);
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}
