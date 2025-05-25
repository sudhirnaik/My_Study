package practice.DesignPattern.ObserverPattern.Observer;

import practice.DesignPattern.ObserverPattern.Observable.StocksObservable;

public class EmailAlert implements NotificationAlertObserver{

    String mailId;
    StocksObservable observable;

    public EmailAlert(String mailId, StocksObservable observable) {
        this.mailId = mailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Email sent to : "+mailId + ": stock count" + observable.getStockCount());
    }
}
