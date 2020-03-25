/**
 * @author: CST
 * @date: 2020/3/24 22:41
 * @description: the entity class of ramen
 */

public class Ramen {
    private String soup;
    private String noodles;
    private String onion;
    private boolean nori;
    private boolean chashu;
    private boolean egg;
    private int spiciness;

    /**
     * constructor of Ramen with all params
     * @param soup Tonkotsu; Shoyu; Shio
     * @param noodles Soft; Medium; Firm
     * @param onion No please; Just a little; A lot!
     * @param spiciness 0~5
     */
    public Ramen(String soup, String noodles, String onion, boolean nori, boolean chashu, boolean egg, int spiciness) {
        this.soup = soup;
        this.noodles = noodles;
        this.onion = onion;
        this.nori = nori;
        this.chashu = chashu;
        this.egg = egg;
        this.spiciness = spiciness;
    }




/**                     don't need to see after here
****************************************************************************************************************
*/
    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public String getNoodles() {
        return noodles;
    }

    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    public String getOnion() {
        return onion;
    }

    public void setOnion(String onion) {
        this.onion = onion;
    }

    public boolean isNori() {
        return nori;
    }

    public void setNori(boolean nori) {
        this.nori = nori;
    }

    public boolean isChashu() {
        return chashu;
    }

    public void setChashu(boolean chashu) {
        this.chashu = chashu;
    }

    public boolean isEgg() {
        return egg;
    }

    public void setEgg(boolean egg) {
        this.egg = egg;
    }

    public int getSpiciness() {
        return spiciness;
    }

    public void setSpiciness(int spiciness) {
        this.spiciness = spiciness;
    }
}
