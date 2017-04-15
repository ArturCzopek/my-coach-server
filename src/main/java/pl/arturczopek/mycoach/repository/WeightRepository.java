package pl.arturczopek.mycoach.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.arturczopek.mycoach.model.database.Weight;

import java.sql.Date;
import java.util.List;

/**
 * @Author Artur Czopek
 * @Date 09-10-2016
 */

public interface WeightRepository extends PagingAndSortingRepository<Weight, Long> {

    @Override
    List<Weight> findAll();

    List<Weight> findAllByOrderByMeasurementDateDesc();

    List<Weight> findByMeasurementDateBetweenOrderByMeasurementDate(Date after, Date before);
}