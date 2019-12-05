package Library.Management.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@JsonSerialize
@Entity
@Table(name="master_issue")
public class Issue
{

  /*
    @JoinColumn(name="id")
    @ManyToOne(targetEntity = User.class , fetch=FetchType.LAZY)
    private List<User> user_id = new ArrayList<User>();


   */
/*
      @Column(name="isbn_no")
      private int id2;


 */
   // @JsonIgnore
    @JoinColumn(name = "isbn_no")
    @ManyToOne(cascade = CascadeType.ALL)                  // CHANGED
//     @JsonBackReference   // ManyToOne
    private mapping map;

     // @JsonIgnore
//    @JsonBackReference
    @JoinColumn(name = "USER_ID")
    @ManyToOne (cascade=CascadeType.ALL)                   // ManyToOne
    private User user;

     @Column(name = "Issue_Date" )
     @Temporal(TemporalType.DATE)
     private Date iss_date;


     @Column(name = "Return_Date")
     @Temporal(TemporalType.DATE)
     private Date re_date;

     @Column(name =  "active" , nullable = false , columnDefinition = "BOOLEAN")
     private boolean status;

    @CreationTimestamp
    @Column(name="creation_date" , updatable = false , columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) " , scale = 3)
    // @Temporal(TemporalType.TIMESTAMP)
    private Timestamp currdate;


    @UpdateTimestamp
    @Column(name="updation_date" , columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3)" , scale = 3)
    //  @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedate;



    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="unique_id")
    private int id3;

    public Issue() {
        super();
    }


    public Issue(mapping map, User user, Date iss_date, Date re_date, boolean status) {
        this.map = map;
        this.user = user;
        this.iss_date = iss_date;
        this.re_date = re_date;
        this.status = status;
    }

    public mapping getMap() {
        return map;
    }

    public void setMap(mapping map) {
        this.map = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getIss_date() {
        return iss_date;
    }

    public void setIss_date(Date iss_date) {
        this.iss_date = iss_date;
    }

    public Date getRe_date() {
        return re_date;
    }

    public void setRe_date(Date re_date) {
        this.re_date = re_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "map=" + map +
                ", user=" + user +
                ", iss_date=" + iss_date +
                ", re_date=" + re_date +
                ", status=" + status +
                ", currdate=" + currdate +
                ", updatedate=" + updatedate +
                ", id3=" + id3 +
                '}';
    }
}
