package Lib.Logger;
import Lib.FileHandler.FileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

import static Lib.FileHandler.FileHandler.CheckFile;

public class Logger {

    /**
     * Log Level options
     */
    public enum LogLevel{
        DEBUG,
        ERROR,
        INFO
    }

    private String debugLogPath;
    private String errorLogPath;
    private String infoLogpath;

    public Logger() throws IOException {
        FileHandler.CheckDirectory("Log");
        SetDebugLogPath("Log/Debug.txt");
        SetErrorLogPath("Log/Error.txt");
        SetInfoLogPath("Log/Info.txt");
    }

    /**
     * Log message with default log level DEBUG
     * @param Message
     * @throws IOException
     */
    public void WriteLog(String Message) throws IOException {
        WriteLog(Message, LogLevel.DEBUG);
    }

    /**
     * Log message with specified log level
     * @param Message
     * @param LogLevel
     * @throws IOException
     */
    public void WriteLog(String Message, LogLevel LogLevel) throws IOException {
        File debugLog = new File(this.debugLogPath);
        File infoLog = new File(this.infoLogpath);
        File errorLog = new File(this.errorLogPath);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s %s %s", timestamp, Message, System.lineSeparator()));

        if(LogLevel == Logger.LogLevel.DEBUG){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(debugLog, true))) {
                writer.append(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(LogLevel == Logger.LogLevel.INFO){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(debugLog, true))) {
                writer.append(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(infoLog, true))) {
                writer.append(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(LogLevel == Logger.LogLevel.ERROR){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(debugLog, true))) {
                writer.append(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(errorLog, true))) {
                writer.append(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set Debug log file path
     * @param FilePath
     */
    public void SetDebugLogPath(String FilePath){
        this.debugLogPath = FilePath;
    }

    /**
     * Set Info log file path
     * @param FilePath
     */
    public void SetInfoLogPath(String FilePath){
        this.infoLogpath = FilePath;
    }

    /**
     * Set Error log file path
     * @param FilePath
     */
    public void SetErrorLogPath(String FilePath){
        this.errorLogPath = FilePath;
    }
}
