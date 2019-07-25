import Controllers.ReadWriteFile;
import Controllers.ReportOutput;
import Controllers.TypeData;

public class Main {
    public static void main(String[] args) {
        ReadWriteFile.readFile();
        ReportOutput reportOutput = new ReportOutput();
        System.out.println(reportOutput.getReport());
        /*
        TypeData typeData = TypeData.getInstance();

        System.out.println("SALES BY SALESMAN LIST");
        System.out.println(typeData.getSalesList());
        System.out.println();

        System.out.println("ITEMS SOLD LIST");
        System.out.println(typeData.getItemsSoldList());
        System.out.println();

        System.out.println("CUSTOMERS LIST");
        System.out.println(typeData.getCustomersList());
        System.out.println();

        System.out.println("SALESMAN LIST");
        System.out.println(typeData.getSalesmanList());*/
    }
}
