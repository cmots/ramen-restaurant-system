/**
 * @author: CST
 * @date: 2020/3/25 12:44
 * @description: services of ramen
 */
public interface RamenService {
    /**
     * Get add-ons information
     * use the second constructor in Addon
     * use DataService.getAddonInfo
     * !! If any item is not available, its cost is -1
     * @param
     * @return add-ons cost information
     */
    public Addon getAddonInfo();

}
