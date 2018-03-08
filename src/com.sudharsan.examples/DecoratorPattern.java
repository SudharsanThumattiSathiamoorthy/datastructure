package com.sudharsan.examples;

abstract class Beverage {
    protected String description = "unknown";

    protected String getDescription() {
        return description;
    }

    public abstract double getCost();
}

class Espresso extends Beverage {

    @Override
    protected String getDescription() {
        return "Expresso";
    }

    @Override
    public double getCost() {
        return 0.8;
    }
}

abstract class BeverageDecorator extends Beverage {
    public abstract String getDescription();
}

class Mocha extends BeverageDecorator {

    private Beverage beverage;

    Mocha(final Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return 0.9 + this.beverage.getCost();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }
}

public class DecoratorPattern {
    public static void main(final String[] args) {
        final Beverage beverage = new Espresso();

        System.out.println(beverage.getDescription() + " " + beverage.getCost());
        final Beverage mocha = new Mocha((beverage));

        System.out.println(mocha.getDescription() + " " + mocha.getCost());
    }
}
