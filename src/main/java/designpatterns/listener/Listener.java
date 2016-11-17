package designpatterns.listener;


/**
 * A {@link FunctionalInterface} that provides a listener for events
 * that are expected to happen in a specific observable object.
 * These observable objects can
 * have different attributes from the Listener class, each one to 
 * listen for a different event. The observables are responsible to 
 * call the {@link #notifyObserver(java.lang.Object, java.lang.Object)} method
 on each Listener in order to notifyObserver Observer objects that an event happend.
 
 <p>
 * Observer objects may provide an implementation of this functional interface
 * to Observable objects in order to be notified when an event happen.
 * </p>
 * 
 * 
 * @author Manoel Campos da Silva Filho
 * @param <T> the class that represents the object being listened to, that fired the event.
 * It is useful to enable the same Listener implementation to be used for different
 * instance of the same Observable object. By this way, a parameter of this
 * type can be passed when notifying Observer objects about a fired event,
 * informing in which Observable object the event was fired (the sender).
 * @param <U> the class of object to be passed to the Listener when the event is fired.
 * It represents additional data about the fired event and is completely dependent
 * of the object implementing such a interface.
 */
@FunctionalInterface
public interface Listener<T extends Object, U extends Object> {
    /**
     * Notifies an Observer that an expected event happened,
     * executing the method implementation provided by the Observer.
     *      
     * @param sender the Observable object that fired the event
     * @param data additional data about the event that has just happened
     */
    void notifyObserver(T sender, U data);
}
