package darksword.jit;

import darksword.console.Config;
import darksword.interpreter.error.InternalError;
import masterball.debug.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LibReader {

    private String builtnCode = null;

    public LibReader() throws IOException {
        String path = (String) Config.getArgValue(Config.Option.Builtin);
        if (path.length() > 0) {
            builtnCode = Files.readString(Path.of(path));
            Log.info("Builtin-Lib founded in path:", path);
        } else {
            Log.info("No Builtin-Lib founded. Continue.");
        }
    }

    public String getLib() {
        if (builtnCode != null) return builtnCode;
        throw new InternalError("No path for builtin.s. GetLib failed.");
    }

}
