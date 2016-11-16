package designpatterns.strategy;

import java.util.function.UnaryOperator;

/**
 *
 * @author Manoel Campos da Silva Filho
 */
public class StringPrinter {
    private final UnaryOperator<String> unaryOperator;
    
    public StringPrinter(UnaryOperator<String> unaryOperator){
        this.unaryOperator = unaryOperator;
    }
    
    public void print(String s){
        System.out.println(unaryOperator.apply(s));
    }
}
