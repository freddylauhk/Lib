import Lib.FileHandler.*;
import Lib.Logger.*;

import java.io.IOException;

public class Program {
    // Testing Programme
    public static void main(String args[]) throws IOException {
        Logger logger = new Logger();
        logger.WriteLog("Testing Log");
        logger.WriteLog("Debug Log", Logger.LogLevel.DEBUG);
        logger.WriteLog("Error Log", Logger.LogLevel.ERROR);
        logger.WriteLog("Info Log", Logger.LogLevel.INFO);

        String testPath = "D:\\Programme\\logs\\Test";
        FileHandler.CheckDirectory(testPath);
        logger.SetDebugLogPath(String.format("%s\\%s", testPath, "Debug.txt"));
        logger.SetErrorLogPath(String.format("%s\\%s", testPath, "Error.txt"));
        logger.SetInfoLogPath(String.format("%s\\%s", testPath, "Info.txt"));

        logger.WriteLog("Testing Log");
        logger.WriteLog("Debug Log", Logger.LogLevel.DEBUG);
        logger.WriteLog("Error Log", Logger.LogLevel.ERROR);
        logger.WriteLog("Info Log", Logger.LogLevel.INFO);
    }
}
