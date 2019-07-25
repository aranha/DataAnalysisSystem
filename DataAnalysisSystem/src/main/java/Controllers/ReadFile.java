package Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class ReadFile {
    private static String ARCHIVE_NAME = "file.txt";
    private static String SEPARATOR = "ç";

    public static void readFile(){
        try (FileReader reader = new FileReader(ARCHIVE_NAME)){
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            while (line != null){
                List<String> regex = Arrays.asList(line.trim().split(SEPARATOR));
                System.out.println(Integer.parseInt(regex.get(0)));
                line = buffer.readLine();
            }
        } catch (IOException e) {
            System.out.println("File not found " + e.getMessage());
        }
    }
}
