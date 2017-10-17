import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

import static java.lang.System.in;
import static java.lang.System.out;

public class QuestionerTest {

    public static void main(String... args) throws IOException {
        Function<String, Height> fun = new Function<String, Height>() {
            @Override
            public Height apply(String s) {
                return new Height( Double.parseDouble(s));
            }
        };
        Questioner<Height> heightQuestioner = new Questioner<Height>("What's your height?", fun, out, new BufferedReader(new InputStreamReader(in)));

        Height h = heightQuestioner.askQuestion();
        System.out.println("Your height is " + h.height() + " metres");

    }

}