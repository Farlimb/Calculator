package Calculator;

public class Parser
{
    private final Lexer lexer;
    private Token symbol;
    private int currentValue;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public int statement() {
        nextToken();
        return expression();
    }

    private int expression() {
        int value = 0;
        if (consume(Token.MINUS)) {
            value = -mul();
        } else {
            consume(Token.PLUS);
            value = mul();
        }
        for (boolean moreTerms = true; moreTerms;) {
            if (consume(Token.PLUS)) {
                value += mul();
            } else if (consume(Token.MINUS)) {
                value -= mul();
            } else {
                moreTerms = false;
            }
        }
        return value;
    }

    private int mul() {
        int value = term();
        for (boolean moreFactors = true; moreFactors; ) {
            if (consume(Token.MUL)) {
                value *= term();
            } else if (consume(Token.DIV)) {
                try {
                    value /= term();
                }
                catch (ArithmeticException e){
                    throw new CalculatorException("delenie 0");
                }
            } else {
                moreFactors = false;
            }
        }
        return value;
    }

    private int term() {
        if (check(Token.NUMBER)) {
            int value = currentValue;
            nextToken();
            if(symbol == Token.LPAR) {
                throw new CalculatorException("Nemozes dat cislo alebo ( za )");
            }
            return value;
        }
        match(Token.LPAR);
        int value = expression();
        match(Token.RPAR);
        if(symbol == Token.NUMBER || symbol == Token.LPAR) {
            throw new CalculatorException("Nemozes dat cislo alebo ( za )");
        }
        return value;
    }

    private void nextToken() {
        symbol = lexer.nextToken();
        if (symbol == Token.NUMBER) {
            currentValue = lexer.getValue();
        }
    }

    private boolean check(Token token) {
        return (this.symbol == token);
    }

    private boolean consume(Token token) {
        if (check(token)) {
            nextToken();
            return true;
        }
        return false;
    }

    private void match(Token token) {
        if (this.symbol == token) {
            nextToken();
        } else {
            throw new CalculatorException("Unexpected token " + this.symbol);
        }
    }

}