package droksty.nurseshifts.repository;

import droksty.nurseshifts.model.Nurse;
import droksty.nurseshifts.model.ShiftAssignment;
import droksty.nurseshifts.model.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShiftAssignmentRepository extends JpaRepository<ShiftAssignment, Long> {

    boolean existsByDateAndShiftTypeAndNurse(LocalDate date, ShiftType shift, Nurse nurse);
    List<ShiftAssignment> findByDateBetween(LocalDate from, LocalDate to);
}
