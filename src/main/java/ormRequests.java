import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ormRequests {

    private List select(String input) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery(input);
        List result = query.getResultList();
        tr.commit();
        return result;
    }

    public int countByYear(int year) {
        return (int) select((String) "select count(*) from avtoowners where avto_year=" + year).get(0);
    }

    public String sumAfterYear(int year) {
        String result;
        result = (String) select("select sum(avto_cost) from avtoowners where avto_year>" + year).get(0);
        return result;
    }

    public String[] minMaxByCost() {
        Object[] result;
        result = (Object[]) select("select min(avto_cost),max(avto_cost) from avtoowners").get(0);
        return (String[]) result;
    }

    public List<Object[]> carAvtoowners(String mark) {
        List<Object[]> result;
        result = select("select *from avtoowners a where a.mark ilike \'" + mark + "\'");
        return result;
    }

    public List<Object[]> ormFirstTwoVendor() {
        List<Object[]> result;
        result = select("select *from avtoowners a inner join vendor v on a.vendor_id=v.id" +
                "where v.id=1 or v.id=2");
        return result;
    }

    public List<Object[]> infoFromTwoTables() {
        List<Object[]> result;
        result = select("select a.id, v.venname, a.surname, a.owner_name, a.tel_number, a.mark, a.avto_number" +
                "from avtoowners a left join vendor v on a.vendor_id=v.id");
        return result;
    }

}
