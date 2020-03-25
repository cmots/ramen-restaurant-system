/**
 * @author: CST
 * @date: 2020/3/25 20:15
 * @description: the entity class of add-ons
 */

public class Addon {
    private int extraNori = 0;
    private float noriCost = 1;
    private int extraEgg = 0;
    private float eggCost = 1;
    private int bamboo = 0;
    private float bambooCost = 1;
    private int extraChashu = 0;
    private float chashuCost = 2;

    /**
     * this constructor is used by GUI.
     * Because when Addon transport to Service, Addon don't need to carry money information
     * Actually, Service must get costs information from txt for safety.
     */
    public Addon(int extraNori, int extraEgg, int bamboo, int extraChashu) {
        this.extraNori = extraNori;
        this.extraEgg = extraEgg;
        this.bamboo = bamboo;
        this.extraChashu = extraChashu;
    }

    /**
     * this constructor is used by Service.
     * These costs will be searched in txt and transported to other Service and GUI
     */
    public Addon(float noriCost, float eggCost, float bambooCost, float chashuCost) {
        this.noriCost = noriCost;
        this.eggCost = eggCost;
        this.bambooCost = bambooCost;
        this.chashuCost = chashuCost;
    }





/**                     don't need to see after here
****************************************************************************************************************
*/
    public float getNoriCost() {
        return noriCost;
    }

    public void setNoriCost(float noriCost) {
        this.noriCost = noriCost;
    }

    public float getEggCost() {
        return eggCost;
    }

    public void setEggCost(float eggCost) {
        this.eggCost = eggCost;
    }

    public float getBambooCost() {
        return bambooCost;
    }

    public void setBambooCost(float bambooCost) {
        this.bambooCost = bambooCost;
    }

    public float getChashuCost() {
        return chashuCost;
    }

    public void setChashuCost(float chashuCost) {
        this.chashuCost = chashuCost;
    }

    public int getExtraNori() {
        return extraNori;
    }

    public void setExtraNori(int extraNori) {
        this.extraNori = extraNori;
    }

    public int getExtraEgg() {
        return extraEgg;
    }

    public void setExtraEgg(int extraEgg) {
        this.extraEgg = extraEgg;
    }

    public int getBamboo() {
        return bamboo;
    }

    public void setBamboo(int bamboo) {
        this.bamboo = bamboo;
    }

    public int getExtraChashu() {
        return extraChashu;
    }

    public void setExtraChashu(int extraChashu) {
        this.extraChashu = extraChashu;
    }
}
