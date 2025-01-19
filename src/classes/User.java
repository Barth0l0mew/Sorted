package classes;

public class User implements Comparable<User> {


    @Override
    public int compareTo(User other) {
        int nameComparison = this.name.compareTo(other.name);
        int passwordComparison = this.password.compareTo(other.password);

        if (nameComparison != 0) {
            return nameComparison;
        } else if (passwordComparison != 0) {
            return passwordComparison;
        } else
            return this.email.compareTo(other.email);


    }
}
