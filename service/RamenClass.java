/**
 * @author: CST
 * @date: 2020/3/27 20:37
 * @description: the controller of ramen
 */

public class RamenClass implements RamenService {
    /**
     * Get add-ons information
     * use the second constructor in Addon
     * use DataService.getAddonInfo
     * !! If any item is not available, its cost is -1
     *
     * @return add-ons cost information
     */
    @Override
    public Addon getAddonInfo() {
        Addon addonInfo = new DataClass().getAddonInfo();
        Addon addon = new Addon(addonInfo.getNoriCost(),addonInfo.getEggCost(),addonInfo.getBambooCost(),
                addonInfo.getChashuCost());
        return addon;
    }
}
