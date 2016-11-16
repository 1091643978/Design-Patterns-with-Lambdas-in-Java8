package designpatterns.listener;

/**
 * An example that shows how to use lambda expressions to provide
 * an implementation for {@link Car} listeners.
 * 
 * <p>This {@link Example} class takes the role of an Observer that will
 * be notified by {@link Car} objects being observed, when
 * specific events happen (namely car's start and stop).
 * This notification happens by executing the lambda expression 
 * provided to a {@link Listener} attribute of the {@link Car}.
 * </p>
 * 
 * @author Manoel Campos da Silva Filho
 */
public class Example {
    public static void main(String[] args) {
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        
        /*
        Uses lambda expression to set a listener to be notified when
        a car starts.
        */
        car1.setOnCarStart((c, t) -> System.out.println(c + " started at time " + t));
        /*
        Uses lambda expression to set a listener to be notified when
        a car stop.
        */
        car1.setOnCarStop((c, t) -> System.out.println(c + " stopped at time " + t));
        
        /*
        Declares objects to reference a lambda expression that can be
        reused by different cars.
        */
        Listener<Car, Long> onCarStart = (c, t) -> 
            System.out.println(
                "Using the same lambda for different listeners: " + 
                c + " started at time " + t);

        Listener<Car, Long> onCarStop = (c, t) -> 
            System.out.println(
                "Using the same lambda for different listeners: " + 
                c + " stopped at time " + t);
        
        /*
        Sets the Listener attributes of the cars to use the same Listener objects
        declared above.
        */
        car2.setOnCarStart(onCarStart);
        car2.setOnCarStop(onCarStop);
        car3.setOnCarStart(onCarStart);
        car3.setOnCarStop(onCarStop);
        
        //Call the methods that will make the listeners to be fired
        car1.start();
        car2.start();
        car1.stop();
        car3.start();
        car2.stop();
        car3.stop();
        
        /*
        Car with no defined listeners.
        */
        Car car4 = new Car(4);
        car4.start();
        car4.stop();
    }
}
