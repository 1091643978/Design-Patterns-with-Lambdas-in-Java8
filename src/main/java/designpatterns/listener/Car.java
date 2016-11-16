package designpatterns.listener;

/**
 * A class that represents a Car and takes the role of an Observable
 * that an Observer will keep track. 
 * 
 * <p>The car's engine can be {@link #start() started}
 * and {@link #stop() stopped} and when such events happen (when the respective methods
 * are called), the class notifies possible observer objects about such events.
 * Each event such as the car start and car stop is defined
 * as an attribute from the {@link Listener} functional interface.</p>
 * 
 * @author Manoel Campos da Silva Filho
 */
public class Car {    
    private final int id;
    private boolean started;
    
    /**
     * An Listener that will be notified when a car is started,
     * providing the started car instance and the start time.
     */
    private Listener<Car, Long> onCarStart;
    
    /**
     * An Listener that will be notified when a car is stopped,
     * providing the started car instance and the stop time.
     */
    private Listener<Car, Long> onCarStop;
    
    public Car(int id){
        this.id = id;
        
        /*
        Sets an empt lambda to avoid NullPointerException in case that
        the attribute is not set by the user.
        By this way, there is no need to check if the attributes are null 
        before using them.
        */
        this.onCarStart = (c,t) -> {};
        this.onCarStop = (c,t) -> {};
    }
    
    public int getId() {
        return id;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
    
    /**
     * Starts the car's engine.
     */
    public void start(){
        this.started = true;
        onCarStart.notify(this, System.currentTimeMillis());
    }
    
    /**
     * Stops the car's engine.
     */
    public void stop(){
        this.started = false;
        onCarStop.notify(this, System.currentTimeMillis());
    }

    public void setOnCarStart(Listener<Car, Long> onCarStart) {
        this.onCarStart = onCarStart;
    }

    public void setOnCarStop(Listener<Car, Long> onCarStop) {
        this.onCarStop = onCarStop;
    }

    @Override
    public String toString() {
        return String.format("Car %d", id);
    }
    
}
