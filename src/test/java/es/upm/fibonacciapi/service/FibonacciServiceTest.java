package es.upm.fibonacciapi.service;

import es.upm.fibonacciapi.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

public class FibonacciServiceTest {
    private FibonacciService fibonacciService;

    @BeforeAll
    static public void beforeAll() {
        System.out.println("Executed before any test has been run");
    }

    @AfterAll
    static public void afterAll() {
        System.out.println("Executed after all tests have been run");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Executed before each test");
        fibonacciService = new FibonacciService();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Executed after each test");
    }

    @DisplayName("The fibonacci of 0 is 0")
    @Test
    public void value_0_returns_0() throws InvalidNumberException {
        assertEquals(0, fibonacciService.calculate(0));
    }

    @Test
    public void value_1_returns_1() throws InvalidNumberException {
        assertEquals(1, fibonacciService.calculate(1));
    }

    @Test
    public void value_10_returns_55() throws InvalidNumberException {
        assertEquals(55, fibonacciService.calculate(10));
    }

    @Test
    public void value_47_returns_2971215073() throws InvalidNumberException {
        assumingThat(
                FibonacciService.TYPE.equals("Iterative"),
                () -> assertEquals(2971215073L, fibonacciService.calculate(47))
        );
    }


    @Disabled("Enabled later in the workshop")
    @Test
    public void value_93_throws_exception() {
        assertThrows(
                InvalidNumberException.class,
                () -> fibonacciService.calculate(93)
        );
    }

    @Disabled
    @Test
    public void value_minus_1_throws_exception() {
        assertThrows(
                InvalidNumberException.class,
                () -> fibonacciService.calculate(-1)
        );
    }


}
