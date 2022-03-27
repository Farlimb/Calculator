package Calculator;

public class CalculatorException extends RuntimeException{
        private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CalculatorException(String message) {
            super(message);
            this.message=message;
        }

        public CalculatorException(String message, Throwable cause) {
            super(message, cause);
            this.message=message;
        }
    }
