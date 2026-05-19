package es.upm.fibonacciapi.controller;

import es.upm.fibonacciapi.dto.FibonacciResponse;
import es.upm.fibonacciapi.exception.InvalidNumberException;
import es.upm.fibonacciapi.service.FibonacciService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {
 private final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/api/fibonacci/{n}")
    public FibonacciResponse getFibonacci(@PathVariable int n) throws InvalidNumberException{
        long result = fibonacciService.calculate(n);

        return new FibonacciResponse(
                n,
                result,
                FibonacciService.TYPE
        );
    }
}
