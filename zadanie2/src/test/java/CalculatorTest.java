import Calculator.CalculatorException;
import Calculator.Lexer;
import Calculator.Parser;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void Test1()
    {
        try {
            String example = "(5*1)-((3/(1+1))*2)-10";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(-7, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
    @Test
    public void Test2()
    {
        try {
            String example = "5";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(5, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
    @Test
    public void Test3()
    {
        try {
            String example = "((((((((((5))))))))))/5*10";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(10, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
    @Test
    public void Test4()
    {
        try {
            String example = "-(-5)-5";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(0, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }

    @Test
    public void Test5()
    {
        try {
            String example = "((((2))+4))*((5))";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(30, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
    @Test
    public void Test6()
    {
        try {
            String example = "0/3";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(0, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
    @Test
    public void Test7()
    {
        try {
            String example = "(2)+(17*2-30)*(5)+2-(8/2)*4";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(8, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }

    @Test
    public void Test8()
    {
        try {
            String example = "(50)-5";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            int result = new Parser(lexer).statement();
            System.out.printf("\nResult %d\n", result);
            assertEquals(45, result,"Nepreslo daco zle");
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
    @Test
    public void Test9()
    {
        try {
            String example = "5(";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            Exception exception = assertThrows(CalculatorException.class, () -> new Parser(lexer).statement());
            assertEquals("Nemozes dat cislo alebo ( za )", exception.getMessage());
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
    @Test
    public void Test10()
    {
        try {
            String example = "50-";
            InputStream stream = new ByteArrayInputStream((example+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            System.setIn(stream);
            Lexer lexer = new Lexer(new BufferedReader(new InputStreamReader(stream)));
            Exception exception = assertThrows(CalculatorException.class, () -> new Parser(lexer).statement());
            assertEquals("Unexpected token EOF", exception.getMessage());
        } catch (Exception e) {
            throw new CalculatorException("Problem while in main", e);
        }
    }
}
