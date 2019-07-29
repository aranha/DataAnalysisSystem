import java.util.Scanner;

import controllers.ReadWriteFile;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
    	System.out.println("Insert a delimiter");
		String delimiter = scanner.next();
        ReadWriteFile.readFile("\\" + delimiter);
    }
}
