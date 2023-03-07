package main.java.com.ubo.tp.twitub.datamodel.model;

public interface Observable {
     void addObserver(Observer observer);
     void removeObserver(Observer observer);
     void notifyObservers();
}
