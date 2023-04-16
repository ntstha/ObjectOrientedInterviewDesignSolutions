package dto;

public class User {

    long userId;
    String firstName;
    String lastName;
    boolean isPrime;

    public User(long userId, String firstName, String lastName, boolean isPrime) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isPrime = isPrime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }
}
