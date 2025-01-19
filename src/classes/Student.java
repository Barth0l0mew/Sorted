package classes;

public class Student implements Comparable<Student> {

    @Override
    public int compareTo(Student other) {
        int groupNumberComparison = this.groupNumber.compareTo(other.groupNumber);
        int averageGradeComparison = this.averageGrade.compareTo(other.averageGrade);

        if (groupNumberComparison != 0) {
            return groupNumberComparison;
        } else if (averageGradeComparison != 0) {
            return averageGradeComparison;
        } else
            return this.gradeBookNumber.compareTo(other.gradeBookNumber);
    }
}
