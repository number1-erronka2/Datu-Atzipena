package dambi.restapi.domainobject;


import javax.persistence.*;

@Entity(name = "res_users")
@Table(name = "res_users")
public class Langilea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "active")
    private boolean active;

    @Column (name = "login")
    private String login;

    @Column (name = "company_id")
    private Integer company_id;

    @Column (name = "partner_id")
    private Integer partner_id;

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getLogin() {
        return login;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public Integer getPartner_id() {
        return partner_id;
    }

}