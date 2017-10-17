import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandlineUserOutputTest {


    @Test
    public void prints_output_to_stream() {
        PrintStream out = mock(PrintStream.class);
        CommandlineUserOuptut output = new CommandlineUserOuptut(out);
        output.informUser("I am a teapot");

        verify(out).println("I am a teapot");
    }
}