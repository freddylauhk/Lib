package Lib.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    /**
     * Check whether directory exists and create one if not exist
     * @param DirectoryPath
     */
    public static void CheckDirectory(String DirectoryPath){
        CheckDirectory(DirectoryPath, true);
    }

    /**
     * Check whether directory exists and optional create if not exist
     * @param DirectoryPath
     */
    public static void CheckDirectory(String DirectoryPath, boolean CreateDirectory){

        System.out.println(String.format("Checking directory %s", DirectoryPath));
        Path directory = Paths.get(DirectoryPath);
        if (Files.isDirectory(directory)){
            return;
        }
        else {
            if(CreateDirectory) {
                try {
                    // Creating new Directory
                    Files.createDirectories(directory);
                    System.out.println(String.format("%s created successfully", DirectoryPath));
                } catch (IOException e) {
                    System.out.println(String.format("Problem Occured While Creating Directory %s", DirectoryPath) + e.getMessage());
                }
            }
        }
    }

    /**
     * Check whether file exists and create one if not exist
     * @param FilePath
     */
    public static void CheckFile(String FilePath) {
        CheckFile(FilePath, true);
    }

    /**
     * Check whether directory exists and optional create if not exist
     * @param FilePath
     * @param CreateFile
     */
    public static void CheckFile(String FilePath, boolean CreateFile){
        System.out.println(String.format("Checking File %s", FilePath));
        Path file = Paths.get(FilePath);
        if(!Files.isDirectory(file)) {
            System.out.println(String.format("%s exists successfully", FilePath));
        }
        else {
            try{
                Files.createFile(file);
                System.out.println(String.format("%s created successfully", FilePath));
            }
            catch (IOException e){
                System.out.println(String.format("Problem Occured While Creating File %s", FilePath) + e.getMessage());
            }
        }
    }

}
