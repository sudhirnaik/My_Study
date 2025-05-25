package practice.DesignPattern.StrategyPattern;

import practice.DesignPattern.StrategyPattern.Strategy.DriveStrategy;

public class Vehicle {
    private DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        this.driveStrategy.drive();
    }
}
