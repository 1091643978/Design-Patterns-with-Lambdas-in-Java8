package designpatterns.demo;

/**
 * @author: liubo
 * @date: 2019-07-23 13:16
 * @description:
 **/
public class MyPredictTest {
    public static void main(String[] args) {
        Predict<String> p1 = s -> s != null;
        Predict<String> p2 = s -> s != null;

        Predict<String> p3 = p1.and(p2);

        System.out.println(p3.test(null));
        System.out.println(p3.test(""));
        System.out.println(p3.test("hello"));

    }
}
