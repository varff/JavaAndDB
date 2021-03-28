import junit.framework.TestCase;

import java.util.ArrayList;

public class sqlRequestTest extends TestCase {
    private static sqlRequest Queries = new sqlRequest();

    public void testCount2017() {
        flywayWork.initialize();
        Integer count = Queries.Count2017();
        assertEquals(count, (Integer) 2);
        flywayWork.clean();
    }

    public void testSumAfter2015() {
        flywayWork.initialize();
        String sum = Queries.SumAfter2015();
        assertEquals(sum, "$29,000.00");
        flywayWork.clean();
    }

    public void testMinAndMaxCost() {
        flywayWork.initialize();
        String answer = Queries.MinAndMaxCost();
        assertEquals(answer, "Минимальная стоимость автомобиля: $10,000.00, " +
                "максимальная стоимость автомобиля: $15,000.00");
        flywayWork.clean();
    }

    public void testAudiAvto() {
        flywayWork.initialize();
        ArrayList<String> getted = Queries.AudiAvto();
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Фамилия: Чехов, имя: Антон, отчество: Павлович, номер телефона: +375293333333," +
                " адрес: Каштанкина 4, номер автомобиля: 1860AB-7, номер тех. паспорта: AICI27437823423877563," +
                " стоимость: $15,000.00, год выпуска:2017");
        assertEquals(getted, actual);
        flywayWork.clean();
    }

    public void testFirstTwoVendor() {
        flywayWork.initialize();
        ArrayList<String> getted = Queries.FirstTwoVendor();
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Фамилия: Ясинецкий, имя: Алексей, отчество: Вячеславович, номер телефона: +375298888888, " +
                "адрес: Зеленая 3, номер автомобиля: 1235AB-7, номер тех. паспорта: AICI0000000000001, " +
                "стоимость: $10,000.00, год выпуска:1980");
        actual.add("Фамилия: Варфоломеев, имя: Алексей, отчество: Сергеевич, номер телефона: +375296666666, " +
                "адрес: Октябрьская 10, номер автомобиля: 1234AB-7, номер тех. паспорта: AICI1234567891234, " +
                "стоимость: $10,000.00, год выпуска:1985");
        assertEquals(getted, actual);
        flywayWork.clean();
    }

    public void testFromTwoTablesInfo() {
        flywayWork.initialize();
        ArrayList<String> getted = Queries.FromTwoTablesInfo();
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Производитель: ГАЗ, фамилия: Чехов, имя: Антон, номер телефона: +375293333333, " +
                "марка: Audi, номер автомобиля: 1860AB-7");
        actual.add("Производитель: ГАЗ, фамилия: Берия, имя: Лаврентий, номер телефона: +375292222222, " +
                "марка: Черный воронок, номер автомобиля: 1953AB-7");
        actual.add("Производитель: МАЗ, фамилия: Ясинецкий, имя: Алексей, номер телефона: +375298888888, " +
                "марка: Москвич, номер автомобиля: 1235AB-7");
        actual.add("Производитель: ТАЗ, фамилия: Варфоломеев, имя: Алексей, номер телефона: +375296666666, " +
                "марка: Жигули, номер автомобиля: 1234AB-7");
        actual.add("Производитель: Wolkswagen, фамилия: Наумов, имя: Даниил, номер телефона: +375291111111, " +
                "марка: Волга, номер автомобиля: 1845AB-7");
        assertEquals(getted, actual);
        flywayWork.clean();
    }
}