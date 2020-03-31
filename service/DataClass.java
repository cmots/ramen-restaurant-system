import java.util.ArrayList;

/**
 * @author:
 * @date:
 * @description:
 */

public class DataClass implements DataService{
    /**
     * search the customer with userID
     *
     * @param userID 8-digit userID want to search
     * @return if this user isn't existed, return null
     */
    @Override
    public User getUserByID(int userID) {
        return null;
    }

    /**
     * insert a new user
     *
     * @param user a new user
     * @return
     */
    @Override
    public void addUser(User user) {

    }

    /**
     * get the newest userID
     *
     * @return newest userID
     * @advice you can record the newest userID at the first line of txt file
     */
    @Override
    public int getLastUserID() {
        return 0;
    }

    /**
     * update a user's information
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        return false;
    }

    /**
     * get add-ons cost information
     *
     * @return
     */
    @Override
    public Addon getAddonInfo() {
        return null;
    }

    /**
     * update add-ons cost information
     *
     * @param addon only need to store items' cost!!
     * @return
     */
    @Override
    public boolean updateAddon(Addon addon) {
        return false;
    }

    /**
     * get all bills this week
     *
     * @return bills this week
     */
    @Override
    public ArrayList<Bill> getBillInfo() {
        return null;
    }

    /**
     * insert a new bill
     *
     * @param bill a new bill
     * @return
     */
    @Override
    public boolean addBill(Bill bill) {
        return false;
    }
}
