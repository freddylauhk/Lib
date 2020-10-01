# Lib
Lib is a Java Library for simplifying code by using pre-built code

## FileHandler
Import library content
```
import Lib.FileHandler.*;
```

Check Directory
```
FileHandler.CheckDirectory(DirectoryPath);
FileHandler.CheckDirectory(DirectoryPath, true);
FileHandler.CheckDirectory(DirectoryPath, false);
```
Check specific directory exists or not, optional create directory flag to create directory if not exists

Check File
```
FileHandler.CheckFile(FilePath);
FileHandler.CheckFile(FilePath), true);
FileHandler.CheckFile(FilePath, false);
```
Check specific File exists or not, optional create file flag to create file if not exists

Delete File
```
FileHandler.DeleteFile(FilePath);
```
Delete the file if exist

Write File
```
FileHandler.WriteToFile(FilePath, stringBuilder);
FileHandler.WriteToFile(FilePath, stringBuilder, true);
FileHandler.WriteToFile(FilePath, stringBuilder, false);
```
Write file with StringBuilder, overwrite if file already exist (false for overwrite if the file exist, default is false)

## Logger
Import library content
```
import Lib.Logger.*;
```
Constructor, to construct Logger object with default log path
```
Logger logger = new Logger();
```
There are 3 LogLevel (Default log level is DEBUG):
- DEBUG : All log messages will log in debug level log, including error print out and info message
- ERROR : Error messages or exception handling messages should go to ERROR level log
- INFO : Informative messages should go to INFO level log
```
logger.WriteLog("Testing Log");
logger.WriteLog("Debug Log", Logger.LogLevel.DEBUG);
logger.WriteLog("Error Log", Logger.LogLevel.ERROR);
logger.WriteLog("Info Log", Logger.LogLevel.INFO);
```

Set Log Path, to set specific log file path based on programme needs
```
logger.SetDebugLogPath(String.format("%s\\%s", LogFilePath, "Debug.txt"));
logger.SetErrorLogPath(String.format("%s\\%s", LogFilePath, "Error.txt"));
logger.SetInfoLogPath(String.format("%s\\%s", LogFilePath, "Info.txt"));
```