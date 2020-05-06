import java.io.File;
import java.io.FileWriter;

/**
 * @author: Sitong Cheng
 * @date: 2020/5/5 16:02
 * @description:
 */

public class EmailClass implements EmailService {
    /**
     * save a text file to represent email of weekly report
     *
     * @return true: success false: failed
     */
    @Override
    public boolean weeklyReport() {
        String[] soup = {"Tonkotsu", "Shoyu", "Shio"};
        String bestSoup = soup[0];
        String[] noodle = {"Soft", "Medium", "Firm"};
        String bestNoodle = noodle[0];
        String[] onion = {"No please", "Just a little", "A lot!"};
        String bestOnion = onion[0];

        int[] item = new StoreClass().itemView();

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

        int[] spicy = new StoreClass().spicinessView();
        int numOfSpicy = spicy[0];
        for (int i = 1; i <= 5; i++) {
            if (item[i] > item[i - 1]) {
                bestSpiciness = spicyOptions[i];
                numOfSpicy = spicy[i];
            }
        }

        String[] addonOptions = {"Extra Nori", "Extra boiled egg", "Bamboo shoots", "Extra Chashu"};
        String bestAddon = addonOptions[0];

        int[] addon = new StoreClass().addonView();
        int numOfAddon = addon[0];
        for (int i = 1; i <= 3; i++) {
            if (item[i] > item[i - 1]) {
                bestAddon = addonOptions[i];
                numOfAddon = addon[i];
            }
        }
        String str = "The following weekly report will be sent to your email every Monday. \n" +
                "The most popular soup chosen by the customers in the past week is: " + bestSoup + "\nIt has been chosen: "
                + numOfSoup + " times. \nThe most popular noodle chosen by the customers in the past week is: "
                + bestNoodle + "\nIt has been chosen: " + numOfNoodle + " times.\nThe most popular onion chosen by " +
                "the customers in the past week is: " + bestOnion + "\nIt has been chosen: " + numOfOnion + " times.\n" +
                "Free Nori has been chosen: " + numOfNori + " times.\nFree Chashu has been chosen: " + numOfChashu +
                " times.\nFree boiled egg has been chosen: " + numOfEgg + " times.\nThe most popular level of spiciness " +
                "chosen by the customers in the past week is: " + bestSpiciness + "\nIt has been chosen: " + numOfSpicy +
                " times.\nThe most popular additional option added by the customers in the past week is: " + bestAddon +
                "\nIt has been sold: " + numOfAddon + " times. ";

        String path = "information/ManagerEmail.txt";
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * SMS or Email to the user when he/she registers
     *
     * @param user the new registered user
     * @return true: success false: failed
     */
    @Override
    public boolean registerReply(User user) {
        String path = "information/" + user.getUserID() + ".txt";
        String str = "Dear customer:" + user.getLastName() + " " + user.getFirstName() + ",\nYou have already registered successfully!" +
                "\nYour userID is: " + user.getUserID() + " . Please remember it carefully and it's your membership voucher!\n" +
                "We hope you can have fun in our restaurant!";
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
