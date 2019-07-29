package controllers;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Optional;


public final class MonitoringDirectory {
	public static void monitoringDirectory(String delimiter) {
		ReadWriteFile.readFile(delimiter);
		try (WatchService watchService = FileSystems.getDefault().newWatchService()){
			Path path = Paths.get(System.getProperty("user.home") + "/data/in/");
			System.out.println(path);
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, 
					StandardWatchEventKinds.ENTRY_DELETE, 
					StandardWatchEventKinds.ENTRY_MODIFY);
			while(true) {
				WatchKey watchKey = watchService.take();
				Optional<WatchEvent<?>> watchEvent = watchKey.pollEvents().stream().findFirst();
				Path directory = (Path) watchEvent.get().context();
				if(directory.toString().endsWith(".dat")) {
					ReadWriteFile.readFile(delimiter);
				}
				boolean valid = watchKey.reset();
				if(!valid) {
					System.exit(0);
				}
				TypeData.getInstance().clearAllLists();
			}
		} catch (IOException | InterruptedException e) {
			System.err.println("an error occurred while attempting directory monitoring " + e.getMessage());
		}
		
	}
}
