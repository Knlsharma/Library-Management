package Library.Management.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="master_mapping")
public class mapping

{

    @Id
    @Column(name="isbn_no" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int is_no;


    /*
    @Column(name="book_id")
    private  int b_id;
     */

    @CreationTimestamp
    @Column(name="creation_date" , updatable = false  , columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) " , scale = 3)
    // @Temporal(TemporalType.TIMESTAMP)
    private Timestamp currdate;


    @UpdateTimestamp
    @Column(name="updation_date" ,  columnDefinition="TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3)" , scale = 3)
  //  @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedate;

   // @JsonIgnore
    @JoinColumn(name = "book_id")
    @ManyToOne(cascade=CascadeType.ALL)
    private Books book;

    // @JsonIgnore
//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL , mappedBy = "map")
//    private List<Issue>  is_;


    public mapping()
    {
        super();
    }

    public mapping(int is_no, Books book)
    {
        this.is_no = is_no;
        this.book = book;
    }




    public int getIs_no() {
        return is_no;
    }

    public void setIs_no(int is_no) {
        this.is_no = is_no;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book)
    {
        this.book = book;
    }



    @Override
    public String toString() {
        return "mapping{" +
                "is_no=" + is_no +
                ", currdate=" + currdate +
                ", updatedate=" + updatedate +
                ", book=" + book +

                '}';
    }


}
