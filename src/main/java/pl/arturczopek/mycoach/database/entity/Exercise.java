package pl.arturczopek.mycoach.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author arturczopek
 * @Date 10/9/16
 */

@Data
@Entity
@Table(name = "Exercises")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Exercise implements Serializable {

    private static final long serialVersionUID = -8266637636238912062L;

    @Id
    @Column(name = "ExerciseId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "exercises_exerciseid_seq")
    @SequenceGenerator(name = "exercises_exerciseid_seq", sequenceName = "exercises_exerciseid_seq", allocationSize = 1)
    private long exerciseId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "SetId")
    private Set set;

    @Column(name = "ExerciseName", nullable = false, length = 100)
    private String exerciseName;

    @OneToMany(mappedBy = "exercise")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Series> series;
}
