import java.util.Date;

/**
 * @author: Qichen Sun
 * @date: 2020/04/18
 * @description:
 *
 * @update: 2020-05-01 Qi Lin
 *          modified the condition of updating the stamp (line 39-46)
 *          to fix the bug that always update the stamp amount even if failed to pay by stamps.
 */

public class BillClass implements BillService {
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
        RamenClass ramenService = new RamenClass();
        UserClass userService = new UserClass();

        DataClass dataService = new DataClass();
        Addon addon = ramenService.getAddonInfo();
        bill.setPrice((float) 9.99 + addon.getNoriCost() * bill.getAddon().getExtraNori() + addon.getEggCost() * bill.getAddon().getExtraEgg()
                + addon.getBambooCost() * bill.getAddon().getBamboo() + addon.getChashuCost() * bill.getAddon().getExtraChashu());

        if (bill.isLogin() == true) {
            User user = userService.login(userID);
            if (bill.isUseStamp() == true) {
                boolean isUseStamps = userService.useStamps(userID);
            } else if (bill.isUseStamp() == false) {
                userService.updateStamps(userID);
            }
        }

        bill.setTime(new Date());

        dataService.addBill(bill);
        return bill;
    }
}
