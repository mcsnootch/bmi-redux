import java.io.PrintStream;

public class CommandlineUserOuptut implements UserOutput {
    private final PrintStream out;

    public CommandlineUserOuptut(PrintStream out) {
        this.out = out;
    }

    @Override
    public void informUser(String information) {
        out.println(information);
    }
}
