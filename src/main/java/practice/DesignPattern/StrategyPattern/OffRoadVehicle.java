package practice.DesignPattern.StrategyPattern;

import practice.DesignPattern.StrategyPattern.Strategy.DriveStrategy;
import practice.DesignPattern.StrategyPattern.Strategy.OffRoadDriveStrategy;
import practice.DesignPattern.StrategyPattern.Strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle() {
        super(new OffRoadDriveStrategy());
    }
}
