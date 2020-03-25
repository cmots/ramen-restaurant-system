import java.sql.Time;

/**
 * @author: CST
 * @date: 2020/3/24 23:22
 * @description: the entity class of bill that inherit Ramen
 * @description: it is also used as an order for kitchen
 */

public class Bill {
    /**
     * user personalizes ramen, and bill get its information.
     */
    private Ramen ramen;

    private Addon addon;

    /**
     * takeAway = false means 'Eat in'
     */
    private boolean takeAway = false;

    /**
     * if customer choose not to login, we don't need to check user's information
     */
    private boolean login = false;

    /**
     * customer can choose not using stamps although stamps number is 10
     * if user's stamps number < 10, program must set useTamp = false
     * if login = false, useStamp must be false
     */
    private boolean useStamp = false;

    /**
     * if user pay for ramen, calculate the total price and set it
     */
    private float price;

    private Time time;

    public Bill(Ramen ramen, Addon addon, boolean takeAway, boolean login, boolean useStamp, float price, Time time) {
        this.ramen = ramen;
        this.addon = addon;
        this.takeAway = takeAway;
        this.login = login;
        this.useStamp = useStamp;
        this.price = price;
        this.time = time;
    }


    /**
     * don't need to see after here
     * ***************************************************************************************************************
     */
    public Addon getAddon() {
        return addon;
    }

    public void setAddon(Addon addon) {
        this.addon = addon;
    }

    public Ramen getRamen() {
        return ramen;
    }

    public void setRamen(Ramen ramen) {
        this.ramen = ramen;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isUseStamp() {
        return useStamp;
    }

    public void setUseStamp(boolean useStamp) {
        this.useStamp = useStamp;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
