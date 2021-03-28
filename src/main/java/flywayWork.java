import org.flywaydb.core.Flyway;

import java.io.FileReader;
import java.util.Properties;

class flywayWork {
    private static Flyway flyway;

    static void initialize() {
        try {
            Properties properties = new Properties();
            FileReader reader = new FileReader("database.properties");
            properties.load(reader);
            flyway = Flyway.configure().dataSource(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "password").load();
            flyway.migrate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void clean() {
        flyway.clean();
    }
}