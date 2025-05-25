package practice.DesignPattern.StrategyPattern;

import practice.DesignPattern.StrategyPattern.Strategy.DriveStrategy;
import practice.DesignPattern.StrategyPattern.Strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
