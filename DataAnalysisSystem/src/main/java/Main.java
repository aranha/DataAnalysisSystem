import java.util.Scanner;

import controllers.ReadWriteFile;

public class Main {
    private static Scanner scanner;

	public static void main(String[] args) {
    	System.out.println("Insert a delimiter");
    	scanner = new Scanner(System.in);
		String delimiter = scanner.next();
        ReadWriteFile.setAFileWillBeRead("\\" + delimiter);
    }
}
