import controllers.ReadWriteFile;
import controllers.ReportOutput;

public class Main {
    public static void main(String[] args) {
        ReadWriteFile.readFile();
        ReportOutput reportOutput = new ReportOutput();
        System.out.println(reportOutput.getReport());
        reportOutput.worstSalesman();
    }
}
