package designpatterns.strategy;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 
 * @author Manoel Campos da Silva Filho
 */
public class Example {
    public static void main(String[] args) {
        new Example();
    }
    
    public Example(){
        final String text = "a text   TO bE printed usIng diFfErent given sTrategieS";

        StringPrinter printer2 = new StringPrinter(String::toUpperCase);
        printer2.print(text);
        
        StringPrinter printer1 = new StringPrinter(String::toLowerCase);
        printer1.print(text);
        
        StringPrinter printer3 = new StringPrinter(this::camelCase);
        printer3.print(text);
    }

    /**
     * Gets an string and convert it to Camel Case, where it word starts
     * with an upper case letter.
     * 
     * @param s string to be converted
     * @return The Given String In Camel Case Format
     */
    private String camelCase(final String s) {
        if(s == null || s.trim().isEmpty())
            return s;
        //
        return Stream.of(s.split(" "))
                .filter(word -> !word.isEmpty())
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .reduce((word1, word2) -> word1 + " " + word2)
                .orElse("");
    }
}
