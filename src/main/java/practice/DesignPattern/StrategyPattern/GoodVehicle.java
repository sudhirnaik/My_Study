package practice.DesignPattern.StrategyPattern;

import practice.DesignPattern.StrategyPattern.Strategy.DriveStrategy;
import practice.DesignPattern.StrategyPattern.Strategy.NormalDriveStrategy;

public class GoodVehicle extends Vehicle{


    public GoodVehicle() {
        super(new NormalDriveStrategy());
    }
}
