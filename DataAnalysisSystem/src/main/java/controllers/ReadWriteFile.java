package controllers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ReadWriteFile {
    private static String OUTPUT_FILE_NAME = "report.done.dat";

    private ReadWriteFile(){}

    private static void readFile(String file, String delimiter){
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, false))){
            writer.write(reportOutput.getReport());
        } catch (IOException e) {
            System.err.println("Cannot write a file, cause happened an error + " + e.getMessage());
        }
    }

    public static void setAFileWillBeRead(String separator) {
    	getAllFileDat().forEach(file -> readFile(file.getName(), separator));
        writeFileReport();
    }
    
    private static List<File> getAllFileDat(){
        String EXTENSION = ".dat";
        List<File> filesInPath = new ArrayList<>();
        try {
            filesInPath = Files.walk(Paths.get("")).
                    filter(Files::isRegularFile).map(Path::toFile).
                    filter(file -> !file.getName().equals(OUTPUT_FILE_NAME)).
                    filter(file -> file.getName().endsWith(EXTENSION)).
                    collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("directory not found " + e.getMessage());
        }
        return filesInPath;
    }
}
