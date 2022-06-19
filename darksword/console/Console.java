package darksword.console;

import masterball.console.error.NoArgumentValue;
import masterball.console.error.UnknownArgument;
import masterball.debug.Log;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.regex.Pattern;

public class Console {

    public boolean showVersion, showHelp, ojMode, jitMode;

    public static String getFileName(String path) {
        if (path == null) return "test";
        for (int i = path.length()-1; i >= 0; i--) {
            if (path.charAt(i) == '/') {
                return path.substring(i+1);
            }
        }
        return path;
    }

    private boolean argMatch(String argName) {
        for (var option : Config.argSetting.keySet()) {
            if (Objects.equals(Config.argSetting.get(option).argName, argName)) return true;
        }
        return false;
    }

    private void argParser(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            if (!argMatch(args[i])) throw new UnknownArgument(args[i]);

            for (var option : Config.argSetting.keySet()) {
                if (Objects.equals(Config.argSetting.get(option).argName, args[i])) {
                    if (Config.argSetting.get(option).needValue) {
                        if (i == args.length - 1) throw new NoArgumentValue(args[i]);

                        i++; // emit the value
                        if (argMatch(args[i])) throw new NoArgumentValue(args[i - 1]);

                        String path = args[i];
                        Config.argSetting.get(option).argValueStr = path;

                        switch (option) {
                            case Input: case Stdin: {
                                Config.argSetting.get(option).argValue = new FileInputStream(path);
                                break;
                            }
                            case LogOutput: case Stdout: {
                                Config.argSetting.get(option).argValue = new PrintStream(path);
                                break;
                            }
                            case OptLevel: {
                                Pattern pattern = Pattern.compile("[0-9]*");
                                if (!pattern.matcher(path).matches()) {
                                    throw new UnknownArgument(path);
                                }
                                Config.argSetting.get(option).argValue = Integer.parseInt(path);
                                break;
                            }
                            default: {
                                Config.argSetting.get(option).argValue = path;
                            }
                        }
                    } else {
                        Config.argSetting.get(option).argValue = true;
                    }
                    break;
                }
            }
        }
    }

    private void argMapping() {
         showHelp = (boolean) Config.argSetting.get(Config.Option.Help).argValue;
         showVersion = (boolean) Config.argSetting.get(Config.Option.Version).argValue;
         ojMode = (boolean) Config.argSetting.get(Config.Option.OJMode).argValue;
         jitMode = (boolean) Config.argSetting.get(Config.Option.JIT).argValue;
    }

    public Console(String[] args) throws Exception {
        argParser(args);
        argMapping();

        if (showHelp) {
            System.out.println(CmdDoc.help());
        }

        if (showVersion) {
            System.out.println(CmdDoc.version());
        }

        if (ojMode) {
            Log.setVerbose(Log.Verbose.off);
        }
        else {
            Log.setVerbose(Log.Verbose.all);
            Log.setPrintStream(
                    (PrintStream) Config.getArgValue(Config.Option.LogOutput)
            );
        }

        Log.track("Console started successfully.");
    }
}