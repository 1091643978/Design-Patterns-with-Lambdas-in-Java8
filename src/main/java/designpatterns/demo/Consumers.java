package designpatterns.demo;

import java.util.function.Consumer;

/**
 * @author: liubo
 * @date: 2019-07-20 18:37
 * @description:
 **/
public class Consumers {

    public static void main(String[] args) {

        MyConsumer<String> c1 = s -> System.out.println("c1=" + s);
        MyConsumer<String> c2 = s -> System.out.println("c2=" + s);
        MyConsumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        MyConsumer<String> c4 = c1.andThen(null);


//        c3.accept("Hello");
        c4.accept("Hello2");

    }
}
