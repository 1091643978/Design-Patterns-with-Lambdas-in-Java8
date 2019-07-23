package designpatterns.demo;

import java.util.Objects;

/**
 * @author: liubo
 * @date: 2019-07-22 18:13
 * @description:
 **/
@FunctionalInterface
public interface MyConsumer<T> {

    void accept(T t);

    default MyConsumer<T> andThen(MyConsumer<T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }
}
