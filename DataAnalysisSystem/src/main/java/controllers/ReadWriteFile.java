package controllers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ReadWriteFile {
    private static String OUTPUT_FILE_NAME = "report.dat";

    private ReadWriteFile(){}

    public static void readFile(){
        String ARCHIVE_NAME = "file.txt";
        String SEPARATOR = "ç";
        System.out.println(getFileDat());
        try (FileReader reader = new FileReader(ARCHIVE_NAME)){
            BufferedReader buffer = new BufferedReader(reader);
            TypeData typeData = TypeData.getInstance();
            String line = buffer.readLine();
            while (line != null){
                List<String> listSpitedData = Arrays.asList(line.trim().split(SEPARATOR));
                typeData.setTypeData(listSpitedData);
                line = buffer.readLine();
            }
            writeFileReport();
        } catch (IOException e) {
            System.err.println("File not found " + e.getMessage());
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

    private static List<File> getFileDat(){
        String EXTENSION = ".dat";
        try {
            return Files.walk(Paths.get("/home/ilegra/Documentos/dataAnalysisSystem/")).
                    filter(Files::isRegularFile).map(Path::toFile).
                    filter(file -> file.getName().endsWith(EXTENSION)).
                    filter(file -> !file.getName().equals(OUTPUT_FILE_NAME)).
                    collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("directory not found " + e.getMessage());
            return null;
        }
    }
}
