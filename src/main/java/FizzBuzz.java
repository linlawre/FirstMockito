import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    FizzBuzzService fizzBuzzService;
    List<String> list = new ArrayList<>();

    public FizzBuzz(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    public void range_return(int i, int j) {
        list = fizzBuzzService.convertor(i, j);
        System.out.println( list );
    }
}
