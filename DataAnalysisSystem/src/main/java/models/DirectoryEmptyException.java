package models;

public class DirectoryEmptyException extends RuntimeException {
	public DirectoryEmptyException(String message) {
		super(message);
	}
}
