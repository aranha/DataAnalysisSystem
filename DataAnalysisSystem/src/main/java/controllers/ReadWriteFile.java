package controllers;

import models.DirectoryEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ReadWriteFile {
    private static String OUTPUT_FILE_NAME = "report.done.dat";

    private ReadWriteFile(){}
    
    public static void readFile(String separator) {
    	getAllFileDat().forEach(file -> processFile(file.getPath(), separator));
        writeFileReport();
    }
    
    private static void processFile(String file, String delimiter){
        try (FileReader reader = new FileReader(file)){
            BufferedReader buffer = new BufferedReader(reader);
            TypeData typeData = TypeData.getInstance();
            String line = buffer.readLine();
            while (line != null){
                List<String> listSpitedData = Arrays.asList(line.trim().split(delimiter));
                typeData.setTypeData(listSpitedData);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            System.err.println("Files not found " + e.getMessage());
            System.exit(0);
        }
    }

    private static void writeFileReport(){
        ReportOutput reportOutput = new ReportOutput();
        String HOME_PATH_OUT = System.getProperty("user.home") + "/data/out/";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HOME_PATH_OUT + OUTPUT_FILE_NAME, false))){
            writer.write(reportOutput.getReport());
        } catch (IOException e) {
            System.err.println("Cannot write a file, cause happened an error + " + e.getMessage());
        }
    }

    private static List<File> getAllFileDat(){
        String EXTENSION = ".dat";
        String HOME_PATH_IN = System.getProperty("user.home") + "/data/in/";
        List<File> filesInPath = new ArrayList<>();
        try (Stream<Path> path = Files.walk(Paths.get(HOME_PATH_IN))){
            filesInPath = path.
                    filter(Files::isRegularFile).map(Path::toFile).
                    filter(file -> !file.getName().equals(OUTPUT_FILE_NAME)).
                    filter(file -> file.getName().endsWith(EXTENSION)).
                    collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("directory not found " + e.getMessage());
        }
        if(filesInPath.isEmpty()){
            throw new DirectoryEmptyException("don't have a files in directory");
        }
        return filesInPath;
    }
}
