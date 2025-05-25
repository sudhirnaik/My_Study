package practice.DesignPattern.ObserverPattern;

import practice.DesignPattern.ObserverPattern.Observable.IphoneObservable;
import practice.DesignPattern.ObserverPattern.Observer.EmailAlert;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        IphoneObservable iphone = new IphoneObservable();

        EmailAlert myAlert = new EmailAlert("sudhir@mail", iphone);
        EmailAlert myAlert2 = new EmailAlert("sudhi2r@mail", iphone);
        iphone.add(myAlert);
        iphone.add(myAlert2);
        iphone.setStockCount(10);
    }

}
