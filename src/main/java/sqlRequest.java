import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class sqlRequest {
    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String login = "postgres";
    public String password = "password";

    public int Count2017() {
        int count = 0;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(url, login, password)) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) from avtoowners where avto_year=2017");
                if (rs.next())
                    count = rs.getInt(1);
                rs.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public String SumAfter2015() {
        String sum = "0";
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(url, login, password)) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sum(avto_cost) from avtoowners where avto_year>2015");
                if (rs.next())
                    sum = rs.getString(1);
                rs.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public String MinAndMaxCost() {
        String output = "";
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(url, login, password)) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select min(avto_cost),max(avto_cost) from avtoowners");
                if (rs.next())
                    output = "Минимальная стоимость автомобиля: " + rs.getString(1) + ", максимальная стоимость автомобиля: " + rs.getString(2);
                rs.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public ArrayList<String> AudiAvto() {
        ArrayList<String> output = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(url, login, password)) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select *from avtoowners where mark ilike 'Audi'");
                while (rs.next())
                    output.add("Фамилия: " + rs.getString(2) + ", имя: " + rs.getString(3) + ", отчество: " +
                            rs.getString(4) + ", номер телефона: " + rs.getString(5) + ", адрес: " +
                            rs.getString(6) + ", номер автомобиля: " + rs.getString(8) +
                            ", номер тех. паспорта: " + rs.getString(9) + ", стоимость: " + rs.getString(10) +
                            ", год выпуска:" + rs.getString(11));
                rs.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public ArrayList<String> FirstTwoVendor() {
        ArrayList<String> output = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(url, login, password)) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select *from avtoowners inner join vendor on avtoowners.vendor_id=vendor.id where vendor.id=1 or vendor.id=2");
                while (rs.next())
                    output.add("Фамилия: " + rs.getString(2) + ", имя: " + rs.getString(3) + ", отчество: " +
                            rs.getString(4) + ", номер телефона: " + rs.getString(5) + ", адрес: " +
                            rs.getString(6) + ", номер автомобиля: " + rs.getString(8) +
                            ", номер тех. паспорта: " + rs.getString(9) + ", стоимость: " + rs.getString(10) +
                            ", год выпуска:" + rs.getString(11));
                rs.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public ArrayList<String> FromTwoTablesInfo() {
        ArrayList<String> output = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(url, login, password)) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select avtoowners.id, vendor.venname,surname,owner_name,tel_number,mark, avto_number from avtoowners left join vendor on avtoowners.vendor_id=vendor.id");
                while (rs.next())
                    output.add("Производитель: " + rs.getString(2) + ", фамилия: " + rs.getString(3) + ", имя: " +
                            rs.getString(4) + ", номер телефона: " + rs.getString(5) + ", марка: " +
                            rs.getString(6) + ", номер автомобиля: " + rs.getString(7));
                rs.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
