package practice.DesignPattern.ObserverPattern.Observable;

import practice.DesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IphoneObservable implements StocksObservable{
    Integer stockCount;

    List<NotificationAlertObserver> subscribers = new ArrayList<>();

    @Override
    public void add(NotificationAlertObserver observer) {
        subscribers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for (NotificationAlertObserver subscriber: subscribers) {
            subscriber.update();
        }
    }

    public void setStockCount(int num) {
        stockCount = num;
        notifySubscriber();
    }
    public Integer getStockCount() {
        return this.stockCount;
    }
}
