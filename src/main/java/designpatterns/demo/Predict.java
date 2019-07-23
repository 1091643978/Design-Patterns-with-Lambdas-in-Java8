package designpatterns.demo;

import java.util.Objects;

@FunctionalInterface
public interface Predict<T> {

    boolean test(T t);

    default Predict<T> and(Predict<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> test(t) && other.test(t);

    }


}
