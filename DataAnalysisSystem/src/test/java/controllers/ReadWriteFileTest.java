package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadWriteFileTest {
    String fileLocal = "/home/ilegra/data/in/file.dat";

    @Test
    public void processFileId001Test() {
        assertEquals("001", ReadWriteFile.processFile(fileLocal, "ç").get(0).get(0));
        assertEquals("1234567891234", ReadWriteFile.processFile(fileLocal, "ç").get(0).get(1));
        assertEquals("Diego", ReadWriteFile.processFile(fileLocal, "ç").get(0).get(2));
        assertEquals("50000", ReadWriteFile.processFile(fileLocal, "ç").get(0).get(3));
    }

    @Test
    public void processFileId002Test(){
        assertEquals("002", ReadWriteFile.processFile(fileLocal, "ç").get(2).get(0));
        assertEquals("2345675434544345", ReadWriteFile.processFile(fileLocal, "ç").get(2).get(1));
        assertEquals("Jose da Silva", ReadWriteFile.processFile(fileLocal, "ç").get(2).get(2));
        assertEquals("Rural", ReadWriteFile.processFile(fileLocal, "ç").get(2).get(3));
    }

    @Test
    public void processFileId003Test(){
        assertEquals("003", ReadWriteFile.processFile(fileLocal, "ç").get(4).get(0));
        assertEquals("10", ReadWriteFile.processFile(fileLocal, "ç").get(4).get(1));
        assertEquals("[1-10-100,2-30-2.50,3-40-3.10]", ReadWriteFile.processFile(fileLocal, "ç").get(4).get(2));
        assertEquals("Diego", ReadWriteFile.processFile(fileLocal, "ç").get(4).get(3));
    }
}
