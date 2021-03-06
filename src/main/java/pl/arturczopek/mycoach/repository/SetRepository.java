package pl.arturczopek.mycoach.repository;

import org.springframework.data.repository.CrudRepository;
import pl.arturczopek.mycoach.model.database.Set;
import pl.arturczopek.mycoach.model.database.Training;

import java.util.List;

/**
 * @Author Artur Czopek
 * @Date 09-10-2016
 */

public interface SetRepository extends CrudRepository<Set, Long> {

    Set findOneByTrainingsContains(Training training);

    List<Set> findAllByCycleId(long cycleId);
}
