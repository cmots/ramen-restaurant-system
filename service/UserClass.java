import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserClass implements UserService {

    public static boolean isEmail(String email) {
        Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        if (str.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    /**
     * check is all information we need has been filled and register.
     * automatically generate a new userID
     * use DataService.getLastUserID to get newest userID and generate a new ID
     * use DataService.addUser to insert new user
     *
     * @param user include information of customer
     * @return don't forget userID.
     * @author: cmots
     */
    @Override
    public User register(User user) {
        if (user.getFirstName() == null || user.getFirstName().length() == 0)  //first name cannot be empty
        {
            return null;
        }
        if (user.getLastName() == null || user.getLastName().length() == 0)   //last name cannot be empty
        {
            return null;
        }
        if (user.getEmail().equals("") && user.getTelephone().equals("")) {
            return null;
        }
        if ((isEmail(user.getEmail()) == false && !user.getEmail().equals(""))
                || (isNumeric(user.getTelephone()) == false && !user.getTelephone().equals("")))//email and telephone need at least one
        {
            return null;
        }

        User newuser = new User((new DataClass().getLastUserID() + 1), user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getTelephone(), 0);
        new DataClass().addUser(newuser);
        return newuser;
    }


    /**
     * login and can be used as getUserByID
     * use DataService.getUserByID and make some operation on User
     *
     * @param userID the 8-digits userID
     * @return this user's information. If userID isn't existed, return null.
     */
    @Override
    public User login(int userID) {
        return new DataClass().getUserByID(userID);
    }

    /**
     * if customer has 10 stamps, set it 0
     * use DataService.getUserByID & DataService.updateUser
     *
     * @param userID the 8-digits userID
     * @return true: succeed;   false: stamps number < 10
     */
    @Override
    public boolean useStamps(int userID) {
        User user = new DataClass().getUserByID(userID);
        int stamps = user.getStamp();
        if (stamps >= 10) {
            user.setStamp(stamps - 10);
            new DataClass().updateUser(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * let user's stamps number add 1.
     * use DataService.getUserByID & DataService.updateUser
     *
     * @param userID the 8-digits userID
     * @return
     */
    @Override
    public void updateStamps(int userID) {
        User user = new DataClass().getUserByID(userID);
        user.setStamp(user.getStamp() + 1);
        new DataClass().updateUser(user);
    }
}
