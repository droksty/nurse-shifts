package droksty.nurseshifts.model;

import lombok.Getter;

import java.time.LocalTime;

@Getter
@SuppressWarnings("OctalInteger")
public enum ShiftType {
    FIRST   (LocalTime.of(07, 00), LocalTime.of(14, 30)),
    SECOND  (LocalTime.of(14, 30), LocalTime.of(22, 30)),
    THIRD   (LocalTime.of(22, 30), LocalTime.of(07, 00));

    private final LocalTime startTime;
    private final LocalTime endTime;

    ShiftType(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
