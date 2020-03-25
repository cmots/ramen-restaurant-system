/**
 * @author: CST
 * @date: 2020/3/25 12:41
 * @description: This is the controller of data. It make options on txt files.
 * @advice: Make four txt files: 1. bill_data.txt 2. user_data.txt 3. add_on.txt
 *
 * DataService don't need to care about what others are doing, just need to know entity classes
 * and insert, update, search information in txt file.
 * just like operate database(but we can just use txt/json/xml..)
 */
import java.util.ArrayList;

public interface DataService {

    /**
     * search the customer with userID
     * @param userID 8-digit userID want to search
     * @return if this user isn't existed, return null
     */       
    public User getUserByID(int userID);

    /**
     * insert a new user
     * @param user a new user
     * @return
     */
    public void addUser(User user);

    /**
     * get the newest userID
     * @param
     * @return newest userID
     * @advice you can record the newest userID at the first line of txt file
     */
    public int getLastUserID();

    /**
     * update a user's information
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * get add-ons cost information
     * @param
     * @return
     */
    public Addon getAddonInfo();

    /**
     * update add-ons cost information
     * @param addon only need to store items' cost!!
     * @return
     */
    public boolean updateAddon(Addon addon);

    /**
     * get all bills this week
     * @param
     * @return bills this week
     */
    public ArrayList<Bill> getBillInfo();

    /**
     * insert a new bill
     * @param bill a new bill
     * @return
     */
    public boolean addBill(Bill bill);
}
