package Library.Management.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="master_book")
// @Cacheable
// @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Books
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "subject_name" , nullable = false)
    private String sname;

    @Column(name = "author_name" , nullable = false)
    private String aname;

    @Column(name = "book_name" , nullable = false)
    private String bname;

    @Column(name = "inventory")
    private int inv;

//     @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY , mappedBy = "book")
//    private List<mapping> has;

    /*

    @ManyToMany
    private List<User> user;


     */

    @CreationTimestamp
    @Column(name="creation_date" , updatable = false  , columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) " , scale = 3)
    // @Temporal(TemporalType.TIMESTAMP)
    private Timestamp currdate;


    @UpdateTimestamp
    @Column(name="updation_date" ,  columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3)" , scale = 3)
    //  @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedate;


    public Books()
    {
        super();
    }

    public Books(int id, String sname, String aname, String bname, int inv) {
        this.id = id;
        this.sname = sname;
        this.aname = aname;
        this.bname = bname;
        this.inv = inv;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }



    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", aname='" + aname + '\'' +
                ", bname='" + bname + '\'' +
                ", inv=" + inv +
                ", currdate=" + currdate +
                ", updatedate=" + updatedate +
                '}';
    }
}



