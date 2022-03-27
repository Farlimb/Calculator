package Calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        try {
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(System.in)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }

}
