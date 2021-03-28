import junit.framework.TestCase;

import java.util.List;

public class ormRequestsTest extends TestCase {
    private static final ormRequests Queries = new ormRequests();

    public void testCountByYear() {
        flywayWork.initialize();
        Integer count = Queries.countByYear(2017);
        assertEquals(count, (Integer) 2);
        flywayWork.clean();
    }

    public void testSumAfterYear() {
        flywayWork.initialize();
        String sum = Queries.sumAfterYear(2015);
        assertEquals(sum, "$29,000.00");
        flywayWork.clean();
    }

    public void testMinMaxByCost() {
        flywayWork.initialize();
        String[] output = Queries.minMaxByCost();
        assertEquals(output.length, 2);
        flywayWork.clean();
    }

    public void testCarAvtoowners() {
        flywayWork.initialize();
        List<Object[]> output = Queries.carAvtoowners("Audi");
        assertEquals(output.size(), 1);
        flywayWork.clean();
    }

    public void testOrmFirstTwoVendor() {
        flywayWork.initialize();
        List<Object[]> output = Queries.ormFirstTwoVendor();
        assertEquals(output.size(), 2);
        flywayWork.clean();
    }

    public void testInfoFromTwoTables() {
        flywayWork.initialize();
        List<Object[]> output = Queries.infoFromTwoTables();
        assertEquals(output.size(), 5);
        flywayWork.clean();
    }
}