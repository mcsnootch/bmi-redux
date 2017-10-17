import java.io.BufferedReader;
import java.io.InputStreamReader;

class BmiApplication {


    private final QuestionInputGatherer inputGatherer;
    private final UserOutput userOutput;

    public BmiApplication(QuestionInputGatherer inputGatherer, UserOutput userOutput) {
        this.inputGatherer = inputGatherer;
        this.userOutput = userOutput;
    }

    public void run() {
        try {
            Double userHeight = inputGatherer.getUserInputForQuestion("What is your height?");
            Double userWeight = inputGatherer.getUserInputForQuestion("What is your weight?");
            if (userWeight / (userHeight * userHeight) < 18.5) {
                userOutput.informUser("You are underweight. You should see your doctor.");
            } else {
                userOutput.informUser("I can't say anything about your weight.");
            }
        } catch (InvalidUserInputException e) {
            userOutput.informUser("Height and weight should be numbers.");
        }

    }

    public static void main(String[] args) {
        CommandlineQuestionInputGatherer inputGatherer = new CommandlineQuestionInputGatherer(System.out, new BufferedReader(new InputStreamReader(System.in)));
        CommandlineUserOuptut userOutput = new CommandlineUserOuptut(System.out);
        BmiApplication application = new BmiApplication(inputGatherer, userOutput);
        application.run();
    }
}
