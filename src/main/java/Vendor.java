import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "ven_name")
    private String ven_name;
    @Basic
    @Column(name = "ven_descriprion")
    private String ven_descriprion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVen_name() {
        return ven_name;
    }

    public void setVen_name(String ven_name) {
        this.ven_name = ven_name;
    }

    public String getVen_descriprion() {
        return ven_descriprion;
    }

    public void setVen_descriprion(String ven_descriprion) {
        this.ven_descriprion = ven_descriprion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null && this == null)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Vendor myObj = (Vendor) obj;
        return Objects.equals(this.id, myObj.id) && Objects.equals(this.ven_descriprion, myObj.ven_descriprion)
                && Objects.equals(this.ven_name, myObj.ven_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ven_name, ven_descriprion);
    }
}
