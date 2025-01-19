package model;

import net.datafaker.Faker;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
    private String numberGroup;
    private String score;
    private String studentsRecordBook;

    private Student(BuilderStudent builderStudent) {
        this.numberGroup = builderStudent.numberGroup;
        this.score = Double.toString(builderStudent.score);
        this.studentsRecordBook = builderStudent.studentsRecordBook;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public String getScore() {
        return score;
    }

    public String getStudentsRecordBook() {
        return studentsRecordBook;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "numberGroup='" + numberGroup + '\'' +
                ", score=" + score +
                ", studentsRecordBook='" + studentsRecordBook + '\'' +
                '}'+"\n";
    }
    public static Student[] randomStudents(int count) {
        Student[] students = new Student[count];
        Faker faker = new Faker();
        for (int i = 0; i < count; i++) {
            students[i] = new Student.BuilderStudent()
                    .setNumberGroup(faker.code().ean8())
                    .setScore(faker.number().randomDouble(1,4,10))
                    .setStudentsRecordBook(faker.passport().valid())
                    .build();
        }
    return students;
    }

    @Override
    public int compareTo(Student other) {
        int groupNumberComparison = this.numberGroup.compareTo(other.numberGroup);
        int averageGradeComparison = this.score.compareTo(other.score);

        if (groupNumberComparison != 0) {
            return groupNumberComparison;
        } else if (averageGradeComparison != 0) {
            return averageGradeComparison;
        } else
            return this.studentsRecordBook.compareTo(other.studentsRecordBook);
    }

    public static class BuilderStudent {
        private String numberGroup;
        private double score;
        private String studentsRecordBook;

        public BuilderStudent setNumberGroup(String numberGroup) {
            this.numberGroup = numberGroup;
            return this;
        }

        public BuilderStudent setScore(double score) {
            this.score = score;
            return this;
        }

        public BuilderStudent setStudentsRecordBook(String studentsRecordBook) {
            this.studentsRecordBook = studentsRecordBook;
            return this;
        }

        private boolean equalsBuilder() {
            return (!this.numberGroup.isBlank() && !this.studentsRecordBook.isBlank());
        }

        public Student build() {
            if (equalsBuilder()) {
                return new Student(this);
            } else {
                System.out.println("Invalid object student");
                return null;
            }
        }
    }


}
