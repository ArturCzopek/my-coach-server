package pl.arturczopek.mycoach.model.database;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @Author Artur Czopek
 * @Date 09-10-2016
 */

@Data
@Entity
@Table(name = "TRAININGS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Training implements Serializable {

    private static final long serialVersionUID = 3305548865433699112L;

    @Id
    @Column(name = "TRN_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TRAININGS_TRN_ID_SEQ")
    @SequenceGenerator(name = "TRAININGS_TRN_ID_SEQ", sequenceName = "TRAININGS_TRN_ID_SEQ", allocationSize = 1)
    private long trainingId;

    @Column(name = "TRN_SET_ID")
    private long setId;

    @Column(name = "TRN_DT", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date trainingDate;
}