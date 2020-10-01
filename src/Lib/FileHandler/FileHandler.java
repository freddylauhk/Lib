package Lib.FileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    /**
     * Delete the file if exist
     * @param FilePath
     * @throws IOException
     */
    public static void DeleteFile(String FilePath) throws IOException {
        File file = new File(FilePath);
        Files.deleteIfExists(file.toPath());
    }

    /**
     * Write file with StringBuilder, overwrite if file already exist
     * @param FilePath
     * @param Builder
     * @throws IOException
     */
    public static void WriteToFile(String FilePath, StringBuilder Builder) throws IOException{
        WriteToFile(FilePath, Builder, false);
    }

    /**
     * Write file with StringBuilder, optional appending if file exists
     * @param FilePath
     * @param Builder
     * @param AppendFlag
     * @throws IOException
     */
    public static void WriteToFile(String FilePath, StringBuilder Builder, boolean AppendFlag) throws IOException{

        File file = new File(FilePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, AppendFlag))) {
            writer.append(Builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
