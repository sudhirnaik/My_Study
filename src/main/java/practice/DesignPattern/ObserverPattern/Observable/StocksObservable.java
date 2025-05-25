package practice.DesignPattern.ObserverPattern.Observable;

import practice.DesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {
    void add (NotificationAlertObserver observer);
    void remove (NotificationAlertObserver observer);
    void notifySubscriber();
    public Integer getStockCount();

}
