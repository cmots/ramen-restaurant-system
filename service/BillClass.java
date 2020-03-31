/**
 * @author:
 * @date:
 * @description:
 */

public class BillClass implements BillService{
    /**
     * 1. calculate price in bill.addon,
     * use RamenService.getAddonInfo to get cost of every items in add-on
     * and set bill.price
     * 2. if bill.login == true, use UserService.login to get customer's information
     * else, you don't need to get customer's information
     * 3. if bill.useStamp == true, use UserService.useStamps and judge the return value
     * 4. if bill.useStamp == false or UserService.useStamps return false
     * use UserService.updateStamps
     * 5. At last, set bill.time and use DataService.addBill to store bill
     *
     * @param userID 8-digits userID, if customer doesn't login, userID can be any 8-digit value
     * @param bill   must check all information in bill because GUI won't check validation
     * @return all information about this bill, GUI can use any useful value to print
     */
    @Override
    public Bill pay(int userID, Bill bill) {
        return null;
    }
}
