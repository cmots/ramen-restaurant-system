/**
 * @author:
 * @date:
 * @description:
 */

public class StoreClass implements StoreService{
    /**
     * change information of add-ons
     * use DataService.updateAddon
     *
     * @param addon if any item in add-on isn't available, set its cost -1
     * @return true: succeed    false: failed
     */
    @Override
    public boolean updateAddon(Addon addon) {
        return false;
    }

    /**
     * get each item on the basic menu how many times it has been sold in the past week
     * use DataService.getBillInfo
     *
     * @return array that contains how many times each item has been sold in the past week
     * array size should be 12: soup:0~2; noodles: 3~5; onion: 6~8;
     * nori: 9; chashu: 10; egg: 11
     */
    @Override
    public int[] itemView() {
        return new int[0];
    }

    /**
     * get each item on the add-ons menu how many times it has been sold in the past week
     * use DataService.getBillInfo
     *
     * @return array that contains how many times each item has been sold in the past week
     * array size should be 4
     */
    @Override
    public int[] addonView() {
        return new int[0];
    }

    /**
     * get each level of spiciness how many times it has been choice in the past week
     * use DataService.getBillInfo
     *
     * @return array that contains times of spiciness level
     * array size should be 6
     */
    @Override
    public int[] spicinessView() {
        return new int[0];
    }

    /**
     * generate a report every week and send email automatically
     *
     * @return
     */
    @Override
    public void generateReport() {

    }
}
