import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        flywayWork.initialize();
        sqlRequest m = new sqlRequest();
        System.out.println("Число машин 2017 года производства: " + m.Count2017());
        System.out.println("Сумма стоимостей автомобилей, выпущенных позже 2015: " + m.SumAfter2015());
        System.out.println(m.MinAndMaxCost());
        ArrayList<String> audiInfo = m.AudiAvto();
        int n = audiInfo.size();
        System.out.println("Информация о владельцах Audi:");
        for (int i = 0; i < n; i++)
            System.out.println("Автомобиль номер " + (i + 1) + ": " + audiInfo.get(i));
        ArrayList<String> vendorInfo = m.FirstTwoVendor();
        n = vendorInfo.size();
        System.out.println("Информация о владельцах первых двух производителей:");
        for (int i = 0; i < n; i++)
            System.out.println("Автомобиль номер " + (i + 1) + ": " + vendorInfo.get(i));
        ArrayList<String> TwoTablesInfo = m.FromTwoTablesInfo();
        n = TwoTablesInfo.size();
        System.out.println("Информация о владельцах и производителях:");
        for (int i = 0; i < n; i++)
            System.out.println("Автомобиль номер " + (i + 1) + ": " + TwoTablesInfo.get(i));
        flywayWork.clean();
    }
}
