import java.util.ArrayList;

/**
 * @version 2.0
 * @author: Qi Lin
 * @date: 2020/04/20
 * @description: Service of manager
 */

public class StoreClass implements StoreService {
    /**
     * change information of add-ons
     * use DataService.updateAddon
     *
     * @param addon if any item in add-on isn't available, set its cost -1
     * @return true: succeed    false: failed
     */
    @Override
    public boolean updateAddon(Addon addon) {
        boolean result = new DataClass().updateAddon(addon);

        return result;
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
        int[] sales = new int[12];
        ArrayList<Bill> myBill = new DataClass().getBillInfo();
        Ramen[] ramen = new Ramen[myBill.size()];

        for (int i = 0; i < myBill.size(); i++) {
            ramen[i] = myBill.get(i).getRamen();

            switch (ramen[i].getSoup()) {
                case "Tonkotsu":
                    sales[0]++;
                    break;
                case "Shoyu":
                    sales[1]++;
                    break;
                case "Shio":
                    sales[2]++;
                    break;
                default:
                    System.out.println("ERROR: no such soup ");
            }

            switch (ramen[i].getNoodles()) {
                case "Soft":
                    sales[3]++;
                    break;
                case "Medium":
                    sales[4]++;
                    break;
                case "Firm":
                    sales[5]++;
                    break;
                default:
                    System.out.println("ERROR: no such noodle ");
            }

            switch (ramen[i].getOnion()) {
                case "No please":
                    sales[6]++;
                    break;
                case "Just a little":
                    sales[7]++;
                    break;
                case "A lot!":
                    sales[8]++;
                    break;
                default:
                    System.out.println("ERROR: no such onion ");
            }

            if (ramen[i].isNori()) {
                sales[9]++;
            }

            if (ramen[i].isChashu()) {
                sales[10]++;
            }

            if (ramen[i].isEgg()) {
                sales[11]++;
            }

        }

        return sales;
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
        int[] sales = new int[4];
        ArrayList<Bill> myBill = new DataClass().getBillInfo();
        Addon[] addons = new Addon[myBill.size()];

        for (int i = 0; i < myBill.size(); i++) {
            addons[i] = myBill.get(i).getAddon();

            if (addons[i].getExtraNori() != 0) {
                sales[0] += addons[i].getExtraNori();
            }

            if (addons[i].getExtraEgg() != 0) {
                sales[1] += addons[i].getExtraEgg();
            }

            if (addons[i].getBamboo() != 0) {
                sales[2] += addons[i].getBamboo();
            }

            if (addons[i].getExtraChashu() != 0) {
                sales[3] += addons[i].getExtraChashu();
            }

        }

        return sales;
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
        int[] sales = new int[6];
        ArrayList<Bill> myBill = new DataClass().getBillInfo();
        Ramen[] ramen = new Ramen[myBill.size()];

        for (int i = 0; i < myBill.size(); i++) {
            ramen[i] = myBill.get(i).getRamen();

            switch (ramen[i].getSpiciness()) {
                case 0:
                    sales[0]++;
                    break;
                case 1:
                    sales[1]++;
                    break;
                case 2:
                    sales[2]++;
                    break;
                case 3:
                    sales[3]++;
                    break;
                case 4:
                    sales[4]++;
                    break;
                case 5:
                    sales[5]++;
                    break;
                default:
                    System.out.println("ERROR: no such spiciness option ");
            }

        }

        return sales;
    }

    /**
     * generate a report every week and send email automatically
     *
     * @return
     */
    @Override
    public void generateReport() {
        String[] soup = {"Tonkotsu", "Shoyu", "Shio"};
        String bestSoup = soup[0];
        String[] noodle = {"Soft", "Medium", "Firm"};
        String bestNoodle = noodle[0];
        String[] onion = {"No please", "Just a little", "A lot!"};
        String bestOnion = onion[0];

        int[] item = itemView();

        int numOfSoup = item[0];
        for (int i = 1; i <= 2; i++) {
            if (item[i] > item[i - 1]) {
                bestSoup = soup[i];
                numOfSoup = item[i];
            }
        }
        int numOfNoodle = item[3];
        for (int i = 4; i <= 5; i++) {
            if (item[i] > item[i - 1]) {
                bestNoodle = noodle[i - 3];
                numOfNoodle = item[i];
            }
        }
        int numOfOnion = item[6];
        for (int i = 7; i <= 8; i++) {
            if (item[i] > item[i - 1]) {
                bestNoodle = noodle[i - 6];
                numOfNoodle = item[i];
            }
        }

        int numOfNori = item[9];
        int numOfChashu = item[10];
        int numOfEgg = item[11];

        String[] spicyOptions = {"0", "1", "2", "3", "4", "5"};
        String bestSpiciness = spicyOptions[0];

        int[] spicy = spicinessView();
        int numOfSpicy = spicy[0];
        for (int i = 1; i <= 5; i++) {
            if (item[i] > item[i - 1]) {
                bestSpiciness = spicyOptions[i];
                numOfSpicy = spicy[i];
            }
        }

        String[] addonOptions = {"Extra Nori", "Extra boiled egg", "Bamboo shoots", "Extra Chashu"};
        String bestAddon = addonOptions[0];

        int[] addon = addonView();
        int numOfAddon = addon[0];
        for (int i = 1; i <= 3; i++) {
            if (item[i] > item[i - 1]) {
                bestAddon = addonOptions[i];
                numOfAddon = addon[i];
            }
        }


        System.out.println("The following weekly report will be sent to your email every Monday. ");

        System.out.println("The most popular soup chosen by the customers in the past week is: " + bestSoup + "\nIt has been chosen: " + numOfSoup + " times. ");
        System.out.println("The most popular noodle chosen by the customers in the past week is: " + bestNoodle + "\nIt has been chosen: " + numOfNoodle + " times. ");
        System.out.println("The most popular onion chosen by the customers in the past week is: " + bestOnion + "\nIt has been chosen: " + numOfOnion + " times. ");

        System.out.println("Free Nori has been chosen: " + numOfNori + " times. ");
        System.out.println("Free Chashu has been chosen: " + numOfChashu + " times. ");
        System.out.println("Free boiled egg has been chosen: " + numOfEgg + " times. ");

        System.out.println("The most popular level of spiciness chosen by the customers in the past week is: " + bestSpiciness + "\nIt has been chosen: " + numOfSpicy + " times. ");

        System.out.println("The most popular additional option added by the customers in the past week is: " + bestAddon + "\nIt has been sold: " + numOfAddon + " times. ");
    }
    /*
    public static void main(String[] args){
        System.out.println(new StoreClass().itemView()[0]);
    }

     */
}
