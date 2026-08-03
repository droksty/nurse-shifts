package droksty.nurseshifts.repository;

import droksty.nurseshifts.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Long> {

    List<Nurse> findByLastNameContainingIgnoreCase(String lastName);
}
