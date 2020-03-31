/**
 * @author:
 * @date:
 * @description:
 */

public class UserClass implements UserService{
    /**
     * check is all information we need has been filled and register.
     * automatically generate a new userID
     * use DataService.getLastUserID to get newest userID and generate a new ID
     * use DataService.addUser to insert new user
     *
     * @param user include information of customer
     * @return don't forget userID
     * @author: cmots
     */
    @Override
    public User register(User user) {
        return null;
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
        return null;
    }

    /**
     * if customer has 10 stamps, set it 0
     * use DataService.getUserByID & DataService.updateUser
     *
     * @param userID the 8-digits userID
     * @return true: succeed;   false: stamps number < 10
     * @author: cmots
     */
    @Override
    public boolean useStamps(int userID) {
        return false;
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

    }
}
