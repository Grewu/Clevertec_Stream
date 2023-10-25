package by.clevertec.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examination {

    private int id;
    private int studentId;
    private int exam1;
    private int exam2;
    private int exam3;

    protected boolean canEqual(final Object other) {
        return other instanceof Examination;
    }

}
