package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReportOutputTest {

    @Test
    public void getReport() {
        ReadWriteFile.readFile("ç");
        ReportOutput reportOutput = new ReportOutput();
        String reportExpected = " Amount Customer: 2\n" +
                "Amount Salesman: 2\n" +
                "ID most expensive sale: 1\n" +
                "Worst Salesman:   CPF: 3245678865434, name: Renato, salary: R$40,000.99\n" +
                "with a total sales of: R$1,694.00";
        assertEquals(reportExpected, reportOutput.getReport());
    }
}