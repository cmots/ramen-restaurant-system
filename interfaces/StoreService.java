import java.util.ArrayList;

/**
 * @author: CST
 * @date: 2020/3/25 23:14
 * @description: services of manager
 */
public interface StoreService {

    /**
     * change information of add-ons
     * use DataService.updateAddon
     * @param addon if any item in add-on isn't available, set its cost -1
     * @return true: succeed    false: failed
     */
    public boolean updateAddon(Addon addon);

    /**
     * get each item on the basic menu how many times it has been sold in the past week
     * use DataService.getBillInfo
     * @param
     * @return array that contains how many times each item has been sold in the past week
     *         array size should be 12: soup:0~2; noodles: 3~5; onion: 6~8;
     *         nori: 9; chashu: 10; egg: 11
     */
    public int[] itemView();

    /**
     * get each item on the add-ons menu how many times it has been sold in the past week
     * use DataService.getBillInfo
     * @param
     * @return array that contains how many times each item has been sold in the past week
     *         array size should be 4
     */
    public int[] addonView();

    /**
     * get each level of spiciness how many times it has been choice in the past week
     * use DataService.getBillInfo
     * @param
     * @return array that contains times of spiciness level
     *         array size should be 6
     */
    public int[] spicinessView();

    /**
     * generate a report every week and send email automatically
     * @param
     * @return
     */
    public void generateReport();
}
