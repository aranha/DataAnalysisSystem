package controllers;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public final class ReadWriteFile {
    public static void readFile(){
        String ARCHIVE_NAME = "file.txt";
        String SEPARATOR = "ç";
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
        String OUTPUT_FILE_NAME = "report.dat";
        ReportOutput reportOutput = new ReportOutput();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, true))){
            writer.write(reportOutput.getReport());
        } catch (IOException e) {
            System.err.println("Cannot write a file, cause happened an error + " + e.getMessage());
        }
    }
}
