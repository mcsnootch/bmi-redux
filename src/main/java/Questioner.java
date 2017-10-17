import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Function;

public class Questioner<T> {

    private final String question;
    private final Function<String, T> conversionFunction;
    private final PrintStream out;
    private final BufferedReader in;

    public Questioner(String question, Function<String, T> conversionFunction, PrintStream out, BufferedReader in) {
        this.question = question;
        this.conversionFunction = conversionFunction;
        this.out = out;
        this.in = in;
    }

    public T askQuestion() throws IOException {
        out.println(question);
        String response = in.readLine();
        return conversionFunction.apply(response);
    }

}
