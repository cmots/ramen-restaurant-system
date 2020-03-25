/**
 * @author: cmots
 * @date: 2020/3/24 21:49
 * @description: the entity class of users who register
 */

public class User {
    /**
     * the membership number of user, must be 8-digit
     */
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    /**
     * the number of virtual stamps user has received
     */
    private int stamp = 0;

    /**
     * constructor of user with all params.
     * @param userID should be generated automatically, 8-digit
     * @param firstName must be entered by user
     * @param lastName must be entered by user
     * @param email program should check at least one of email and telephone has been set
     * @param telephone if one of email and telephone is empty, set it null
     * @param stamp default 0
     */
    public User(int userID, String firstName, String lastName, String email, String telephone, int stamp) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.stamp = stamp;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getStamp() {
        return stamp;
    }

    public void setStamp(int stamp) {
        this.stamp = stamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", stamp=" + stamp +
                '}';
    }
}
