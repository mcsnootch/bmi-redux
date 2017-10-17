import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BmiApplicationTest {

    private BmiApplication application;
    private QuestionInputGatherer inputGatherer;
    private UserOutput userOutput;

    @Before
    public void setUp() throws Exception {
        inputGatherer = mock(QuestionInputGatherer.class);
        userOutput = mock(UserOutput.class);
        application = new BmiApplication(inputGatherer, userOutput);
    }

    @Test
    public void asks_user_for_height() throws InvalidUserInputException {
        application.run();
        verify(inputGatherer).getUserInputForQuestion("What is your height?");
    }

    @Test
    public void asks_the_user_for_weight() throws InvalidUserInputException {
        application.run();
        verify(inputGatherer).getUserInputForQuestion("What is your weight?");
    }

    @Test
    public void tells_user_they_are_underweight() throws InvalidUserInputException {
        when(inputGatherer.getUserInputForQuestion("What is your height?")).thenReturn(1.7);
        when(inputGatherer.getUserInputForQuestion("What is your weight?")).thenReturn(40d);

        application.run();

        verify(userOutput).informUser("You are underweight. You should see your doctor.");
    }

    @Test
    public void informs_user_that_input_is_invalid_when_not_numeric() throws InvalidUserInputException {
        when(inputGatherer.getUserInputForQuestion("What is your height?")).thenThrow(new InvalidUserInputException());

        application.run();

        verify(userOutput).informUser("Height and weight should be numbers.");
    }

}
