/**
 * @author: CST
 * @date: 2020/3/24 23:25
 * @description: services of customer
 */
public interface UserService {

    /**
     * check is all information we need has been filled and register.
     * automatically generate a new userID
     * use DataService.getLastUserID to get newest userID and generate a new ID
     * use DataService.addUser to insert new user
     * @author: cmots
     * @param user include information of customer
     * @return don't forget userID
     */
    public User register(User user);

    /**
     * login and can be used as getUserByID
     * use DataService.getUserByID and make some operation on User
     * @param userID the 8-digits userID
     * @return this user's information. If userID isn't existed, return null.
     */
    public User login(int userID);

    /**
     * if customer has 10 stamps, set it 0
     * @author: cmots
     * @param userID the 8-digits userID
     * @return true: succeed;   false: stamps number < 10
     */
    public boolean useStamps(int userID);

    /**
     * let user's stamps number add 1.
     * use DataService.getUserByID & DataService.updateUser here
     * @param userID the 8-digits userID
     * @return
     */
    public void updateStamps(int userID);
}
