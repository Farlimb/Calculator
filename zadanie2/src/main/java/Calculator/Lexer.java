package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Lexer {
    private int current;
    private int value;
    private final Reader input;

    public Lexer(BufferedReader input){
        this.input = input;
        consume();
    }
    private void consume(){
        try{
            current = input.read();
        }
        catch (IOException e) {
            System.out.print("Neplatny znak");
        }
    }

    public int getValue(){
        return  value;
    }
    public Token nextToken(){
        switch (current) {
            case '+' -> {
                consume();
                value = 0;
                return Token.PLUS;
            }
            case '-' -> {
                consume();
                value = 0;
                return Token.MINUS;
            }
            case '*' -> {
                consume();
                value = 0;
                return Token.MUL;
            }
            case '/' -> {
                consume();
                value = 0;
                return Token.DIV;
            }
            case '(' -> {
                consume();
                value = 0;
                return Token.LPAR;
            }
            case ')' -> {
                consume();
                value = 0;
                return Token.RPAR;
            }
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                value = current- 48;
                consume();
                while (current== '0'|| current=='1' || current=='2' || current=='3'|| current=='4'|| current=='5'|| current=='6'|| current=='7'|| current=='8'|| current=='9'){
                    value = value * 10;
                    value = current + value - 48;
                    consume();
                }
                return Token.NUMBER;
            }
        }
        return Token.EOF;
    }
}