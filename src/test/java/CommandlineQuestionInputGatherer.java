import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CommandlineQuestionInputGatherer implements QuestionInputGatherer {

    private final PrintStream out;
    private final BufferedReader in;

    public CommandlineQuestionInputGatherer(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public Double getUserInputForQuestion(String question) throws InvalidUserInputException {
        out.println(question);

        try {
            return Double.parseDouble(in.readLine());
        } catch (IOException e) {
            return null;
        } catch (NumberFormatException nfe) {
            throw new InvalidUserInputException();
        }

    }
}
