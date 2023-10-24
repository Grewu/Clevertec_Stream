package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Examination {

    private int id;
    private int studentId;
    private int exam1;
    private int exam2;
    private int exam3;

    public int getId() {
        return this.id;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public int getExam1() {
        return this.exam1;
    }

    public int getExam2() {
        return this.exam2;
    }

    public int getExam3() {
        return this.exam3;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setExam1(int exam1) {
        this.exam1 = exam1;
    }

    public void setExam2(int exam2) {
        this.exam2 = exam2;
    }

    public void setExam3(int exam3) {
        this.exam3 = exam3;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Examination)) return false;
        final Examination other = (Examination) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getStudentId() != other.getStudentId()) return false;
        if (this.getExam1() != other.getExam1()) return false;
        if (this.getExam2() != other.getExam2()) return false;
        if (this.getExam3() != other.getExam3()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Examination;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        result = result * PRIME + this.getStudentId();
        result = result * PRIME + this.getExam1();
        result = result * PRIME + this.getExam2();
        result = result * PRIME + this.getExam3();
        return result;
    }

    public String toString() {
        return "Examination(id=" + this.getId() + ", studentId=" + this.getStudentId() + ", exam1=" + this.getExam1() + ", exam2=" + this.getExam2() + ", exam3=" + this.getExam3() + ")";
    }
}
