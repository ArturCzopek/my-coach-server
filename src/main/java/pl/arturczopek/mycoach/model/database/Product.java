package pl.arturczopek.mycoach.model.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author Artur Czopek
 * @Date 09-10-2016
 */

@Data
@Entity
@Table(name = "PRODUCTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {

    private static final long serialVersionUID = 5913443781036872464L;

    @Id
    @Column(name = "PRD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PRODUCTS_PRD_ID_SEQ")
    @SequenceGenerator(name = "PRODUCTS_PRD_ID_SEQ", sequenceName = "PRODUCTS_PRD_ID_SEQ", allocationSize = 1)
    private long productId;

    @Column(name = "PRD_NAME", nullable = false, length = 60)
    private String productName;

    @Column(name = "PRD_SCRN", length = 100)
    @Lob
    private byte[] screen;

    // not column!!
    private float average = 0;

    @OneToMany(mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Price> prices;

    public void countAveragePrice() {
        this.average = 0;

        if (!prices.isEmpty()) {
            for (Price price : prices) {
                this.average += price.getValue();
            }

            this.average /= this.prices.size();
        }
    }
}