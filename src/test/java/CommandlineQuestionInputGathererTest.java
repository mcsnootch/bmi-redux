import org.junit.Test;

import java.io.*;

import static java.lang.System.in;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CommandlineQuestionInputGathererTest {


    @Test
    public void sends_question_to_output_stream() throws InvalidUserInputException, IOException {
        PrintStream out = mock(PrintStream.class);
        BufferedReader in = mock(BufferedReader.class);
        when(in.readLine()).thenReturn("2.2");
        CommandlineQuestionInputGatherer inputGatherer = new CommandlineQuestionInputGatherer(out, in);

        inputGatherer.getUserInputForQuestion("What is the melting point of people?");

        verify(out).println("What is the melting point of people?");
    }

    @Test
    public void captures_user_input_for_question() throws InvalidUserInputException, IOException {
        PrintStream out = mock(PrintStream.class);
        BufferedReader in = mock(BufferedReader.class);
        CommandlineQuestionInputGatherer inputGatherer = new CommandlineQuestionInputGatherer(out, in);

        when(in.readLine()).thenReturn("2.2");

        Double userInput = inputGatherer.getUserInputForQuestion("What is the melting point of people?");

        assertEquals(new Double(2.2), userInput);

    }

    @Test( expected = InvalidUserInputException.class )
    public void throws_exception_on_invalid_input() throws InvalidUserInputException, IOException {
        PrintStream out = mock(PrintStream.class);
        BufferedReader in = mock(BufferedReader.class);
        CommandlineQuestionInputGatherer inputGatherer = new CommandlineQuestionInputGatherer(out, in);

        when(in.readLine()).thenReturn("foobar");

        Double userInput = inputGatherer.getUserInputForQuestion("What is the melting point of people?");

    }
}