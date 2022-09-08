import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class OutputTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    FizzBuzz fizzBuzz = null;
    @Before
    public void setUpStreams() {
        FizzBuzzService fizzBuzzService = Mockito.mock(FizzBuzzService.class);
        fizzBuzz = new FizzBuzz(fizzBuzzService);
        when(fizzBuzzService.convertor(0,1)).thenReturn(Arrays.asList());
        when(fizzBuzzService.convertor(2,3)).thenReturn(Arrays.asList("Fizz"));
        when(fizzBuzzService.convertor(2,5)).thenReturn(Arrays.asList("Fizz", "Buzz"));
        when(fizzBuzzService.convertor(2,15)).thenReturn(Arrays.asList("Fizz", "Buzz", "Fizz", "Fizz", "Buzz", "Fizz", "FizzBuzz"));
        when(fizzBuzzService.convertor(14,15)).thenReturn(Arrays.asList("FizzBuzz"));
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    public void out1() {
        fizzBuzz.range_return(0,1);
        assertEquals("[]" ,  outputStreamCaptor.toString().trim());
    }

    @Test
    public void out2() {
        fizzBuzz.range_return(2,3);
        assertEquals("[Fizz]",  outputStreamCaptor.toString().trim());
    }

    @Test
    public void out3() {
        fizzBuzz.range_return(2,5);
        assertEquals("[Fizz, Buzz]",  outputStreamCaptor.toString().trim());
    }

    @Test
    public void out4() {
        fizzBuzz.range_return(2,15);
        assertEquals("[Fizz, Buzz, Fizz, Fizz, Buzz, Fizz, FizzBuzz]",  outputStreamCaptor.toString().trim());
    }

    @Test
    public void out5() {
        fizzBuzz.range_return(14,15);
        assertEquals("[FizzBuzz]",  outputStreamCaptor.toString().trim());
    }

}
