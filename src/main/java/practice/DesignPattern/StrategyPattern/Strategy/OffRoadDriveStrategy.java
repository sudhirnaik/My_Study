package practice.DesignPattern.StrategyPattern.Strategy;

public class OffRoadDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("offRoad drive capability");
    }
}
