package Library.Management.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// import java.sql.Date;


@Entity
@Table(name="master_user")
//@Cacheable
// @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name="u_name" , nullable = false)
    private String name;

    @Column(name="ph_no" )
    private  long ph;

    @Column(name="email_id" , nullable = false)
    private String email;

    @CreationTimestamp
    @Column(name="creation_date" , updatable = false  , columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) " , scale = 3)
    // @Temporal(TemporalType.TIMESTAMP)
    private Timestamp currdate;


    @UpdateTimestamp
    @Column(name="updation_date" ,  columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3)" , scale = 3)
    //  @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedate;


 //   @JoinColumn(name="user")
//    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY , mappedBy = "user")
//    private List<Issue> is;

    /*
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY , mappedBy = "stats")
    private List<Issue> check;


     */


    /*
    @ManyToMany (mappedBy = "user")
    private List<Books> book;

     */


    public User()
    {
        super();
    }


    public User(int id, String name, long ph, String email)
    {
        this.id = id;
        this.name = name;
        this.ph = ph;
        this.email = email;
       // this.is = is;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPh() {
        return ph;
    }

    public void setPh(long ph) {
        this.ph = ph;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=" + ph +
                ", email='" + email + '\'' +
                ", currdate=" + currdate +
                ", updatedate=" + updatedate +
                '}';
    }
}