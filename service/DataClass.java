//package service;

//import entity.*;
//import interfaces.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author: Jiaxuan Peng
 * @date: 2020/03/29 18:47
 * @description: Read and write the .txt files.
 */

public class DataClass implements DataService {
    /**
     * search the customer with userID
     *
     * @param userID 8-digit userID want to search
     * @return the User entity according to the UserID
     * if this user isn't existed, return null
     */
    @Override
    public User getUserByID(int userID) {
        int i;
        ArrayList<User> user = readUserInfo();
        for (i = 0; i < user.size(); i++) {
            if (user.get(i).getUserID() == (userID)) {
                break;
            }
        }
        if (i < user.size()) {
            return user.get(i);
        } else {
            return null;
        }
    }

    /**
     * insert a new user
     *
     * @param user a new user
     */
    @Override
    public void addUser(User user) {
        writeUserInfo(user, true);
    }

    /**
     * get the newest userID
     *
     * @return newest userID
     * @advice you can record the newest userID at the first line of txt file
     */
    @Override
    public int getLastUserID() {
        int userID;
        ArrayList<User> user = readUserInfo();
        if (user.size() == 0) {
            return 10000000;
        } else {
            userID = user.get(user.size() - 1).getUserID();
            return userID;
        }
    }

    /**
     * update a user's information
     *
     * @param user
     * @return if update successfully, return true
     * if not or can't find the relevant user, return false
     */
    @Override
    public boolean updateUser(User user) {
        int userID;
        if (getUserByID(user.getUserID()) != null) {
            ArrayList<User> users = readUserInfo();
            for (int i = 0; i < users.size(); i++) {
                String infoString = users.get(i).toString();
                userID = Integer.parseInt(users.get(i).toString().substring(infoString.indexOf("=") + 1, infoString.indexOf(",")));
                if (userID == user.getUserID()) {
                    users.set(i, user);
                    break;
                }
            }
            for (int i = 0; i < users.size(); i++) {
                if (i == 0) {
                    writeUserInfo(users.get(i), false);
                } else {
                    writeUserInfo(users.get(i), true);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * get add-ons cost information
     *
     * @return the Addon entity
     */
    @Override
    public Addon getAddonInfo() {
        return readAddonInfo();
    }

    /**
     * update add-ons cost information
     *
     * @param addon only need to store items' cost!!
     * @return if update successfully, return true, if not, return false
     */
    @Override
    public boolean updateAddon(Addon addon) {
        return writeAddonInfo(addon);
    }

    /**
     * get all bills this week
     *
     * @return bills this week
     */
    @Override
    public ArrayList<Bill> getBillInfo() {
        Date date = new Date();
        int pastDay = 7;
        Date pDate = new Date();
        Long pTime = date.getTime() - pastDay * 24 * 3600000;
        pDate.setTime(pTime);
        ArrayList<Bill> bill = new ArrayList<Bill>();
        ArrayList<Bill> bills = readBillInfo();
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getTime().after(pDate)) {
                bill.add(bills.get(i));
            }
        }
        return bill;
    }

    /**
     * insert a new bill
     *
     * @param bill a new bill
     * @return if update successfully, return true, if not, return false
     */
    @Override
    public boolean addBill(Bill bill) {
        return writeBillInfo(bill);
    }

    /**
     * read the all user information stored in the .txt file
     *
     * @return the arraylist that stores all the User entities
     */
    public ArrayList<User> readUserInfo() {
        String path = "information/UserInfo.txt";
        ArrayList<User> user = new ArrayList<User>();
        int userID;
        String firstName;
        String lastName;
        String email;
        String telephone;
        int stamp;
        String[] str = new String[6];
        try {
            File filename = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            line = br.readLine();
            while (line != null) {
                int index = 0;
                for (int i = 0; i < 6; i++) {
                    if (i < 5) {
                        str[i] = line.substring(line.indexOf("=", index + 1) + 1, line.indexOf(",", index + 1));
                        index = line.indexOf(",", index + 1);
                    } else {
                        str[i] = line.substring(line.indexOf("=", index + 1) + 1, line.indexOf("}"));
                    }
                }
                userID = Integer.parseInt(str[0]);
                firstName = str[1].substring(1, str[1].length() - 1);
                lastName = str[2].substring(1, str[2].length() - 1);
                email = str[3].substring(1, str[3].length() - 1);
                telephone = str[4].substring(1, str[4].length() - 1);
                stamp = Integer.parseInt(str[5]);
                user.add(new User(userID, firstName, lastName, email, telephone, stamp));
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return user;
    }

    /**
     * read the all addon information stored in the .txt file
     *
     * @return the addon information
     */
    public Addon readAddonInfo() {
        String path = "information/AddonInfo.txt";
        try {
            File filename = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            line = br.readLine();
            line = br.readLine();
            String[] str = line.split("\\s+");
            br.close();
            Addon addon = new Addon(Float.parseFloat(str[1]), Float.parseFloat(str[2]),
                    Float.parseFloat(str[3]), Float.parseFloat(str[4]));
            return addon;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    /**
     * read the all bill information stored in the .txt file
     *
     * @return the arraylist that stores all the Bill entities
     */
    public ArrayList<Bill> readBillInfo() {
        String path = "information/BillInfo.txt";
        String[] str = new String[5];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        ArrayList<Bill> bills = new ArrayList<Bill>();
        ArrayList<String> strings = new ArrayList<String>();
        int num = 0;
        int linenum = -1;
        try {
            File filename = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            line = br.readLine();
            while (line != null) {
                if (line.contains("****")) {
                    if (num == 0) {
                        num++;
                    } else {
                        Ramen ramen = new Ramen(
                                strings.get(3), strings.get(4), strings.get(5),
                                Boolean.parseBoolean(strings.get(6)), Boolean.parseBoolean(strings.get(7)),
                                Boolean.parseBoolean(strings.get(8)), Integer.parseInt(strings.get(9)));
                        Addon addon = new Addon(
                                Integer.parseInt(strings.get(10)), Integer.parseInt(strings.get(11)),
                                Integer.parseInt(strings.get(12)), Integer.parseInt(strings.get(13)));
                        Bill bill = new Bill(
                                ramen, addon, Boolean.parseBoolean(strings.get(1)), Boolean.parseBoolean(strings.get(0)),
                                Boolean.parseBoolean(strings.get(14)), Float.parseFloat(strings.get(15)),
                                sdf.parse(strings.get(2)));
                        bills.add(bill);
                        num = 0;
                        linenum = -1;
                        strings.clear();
                    }
                }
                if (num > 0) {
                    linenum++;
                    if (linenum == 2 || linenum >= 8 && linenum <= 9 || linenum == 15 ||
                            linenum >= 17 && linenum <= 20 || linenum == 23 || linenum == 25) {
                        str = line.split("\\s+");
                        strings.add(str[2]);
                    } else if (linenum == 3 || linenum >= 12 && linenum <= 14) {
                        str = line.split("\\s+");
                        if (str[2].equals("Eat-in") || str[2].equals("0")) {
                            str[2] = "false";
                        } else if (str[2].equals("Take-away") || str[2].equals("1")) {
                            str[2] = "true";
                        }
                        strings.add(str[2]);
                    } else if (linenum == 4) {
                        str[0] = line.substring(line.indexOf(":") + 2);
                        strings.add(str[0]);
                    } else if (linenum == 10) {
                        str[0] = line.substring(line.indexOf("Onion") + 8);
                        strings.add(str[0]);
                    }
                }
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bills;
    }

    /**
     * write the new User information into the .txt file
     *
     * @param user the User entity that have the basic info about the user
     * @param bo   if true, write the info from the end of the file
     *             if false, write the info from the beginning of the file
     */
    public void writeUserInfo(User user, boolean bo) {
        String path = "information/UserInfo.txt";
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file, bo);
            fw.write(user.toString() + "\r\n");
            fw.flush();
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * write the new Addon information into the .txt file
     *
     * @param addon the new Addon entity
     * @return if succeed, return true
     * if failed, return false
     */
    public boolean writeAddonInfo(Addon addon) {
        String path = "information/AddonInfo.txt";
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file, false);
            fw.write(printAddon(addon) + "\r\n");
            fw.flush();
            fw.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    /**
     * write the new Bill information into the .txt file
     *
     * @param bill the new Bill entity
     * @return if succeed, return true
     * if failed, return false
     */
    public boolean writeBillInfo(Bill bill) {
        String path = "information/BillInfo.txt";
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file, true);
            fw.write(printBill(bill) + "\r\n");
            fw.flush();
            fw.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    /**
     * write the addon info in this format
     *
     * @param addon the Addon entity that has basic information
     * @return the presentation style of addon info
     */
    public String printAddon(Addon addon) {
        return "\tNori\tEgg\tBamboo\tChashu" +
                "\ncost\t" + addon.getNoriCost() + "\t" + addon.getEggCost() +
                "\t" + addon.getBambooCost() + "\t" + addon.getChashuCost();
    }

    /**
     * write the bill info in this format
     *
     * @param bill the Bill entity that has basic information
     * @return the presentation style of bill
     */
    public String printBill(Bill bill) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String[] str = new String[4];
        if (!bill.isTakeAway()) {
            str[0] = "Eat-in";
        } else {
            str[0] = "Take-away";
        }
        if (bill.getRamen().isNori()) {
            str[1] = "1";
        } else {
            str[1] = "0";
        }
        if (bill.getRamen().isChashu()) {
            str[2] = "1";
        } else {
            str[2] = "0";
        }
        if (bill.getRamen().isEgg()) {
            str[3] = "1";
        } else {
            str[3] = "0";
        }
        double price = bill.getAddon().getNoriCost() * bill.getAddon().getExtraNori() +
                bill.getAddon().getExtraEgg() * bill.getAddon().getEggCost() +
                bill.getAddon().getBambooCost() * bill.getAddon().getBamboo() +
                bill.getAddon().getChashuCost() * bill.getAddon().getExtraChashu() + 9.99;
        return "***************************************************\n" +
                "\t\t Ramen Restaurant" +
                "\nLogin  : " + bill.isLogin() +
                "\nDining : " + str[0] +
                "\nDate   : " + sdf.format(bill.getTime()) +
                "\n---------------------------------------------------" +
                "\n    Item\t\t      Quantity     Amount" +
                "\n---Ramen-------------------------------------------" +
                "\n    Soup\t\t\t" + bill.getRamen().getSoup() +
                "\n    Noodles\t\t\t" + bill.getRamen().getNoodles() +
                "\n    Onion\t\t\t" + bill.getRamen().getOnion() +
                "\n---Jardiniere--------------------------------------" +
                "\n    Nori\t\t\t " + str[1] + "\t    0.0" +
                "\n    Chashu\t\t\t " + str[2] + "\t    0.0" +
                "\n    Egg\t\t\t\t " + str[3] + "\t    0.0" +
                "\n    Spiciness\t\t\t " + bill.getRamen().getSpiciness() +
                "\n---Add-ons-----------------------------------------" +
                "\n    ExtraNori\t\t\t " + bill.getAddon().getExtraNori() + "\t    " +
                bill.getAddon().getNoriCost() * bill.getAddon().getExtraNori() +
                "\n    ExtraEgg\t\t\t " + bill.getAddon().getExtraEgg() + "\t    " +
                bill.getAddon().getExtraEgg() * bill.getAddon().getEggCost() +
                "\n    Bamboo\t\t\t " + bill.getAddon().getBamboo() + "\t    " +
                bill.getAddon().getBambooCost() * bill.getAddon().getBamboo() +
                "\n    ExtraChashu\t\t\t " + bill.getAddon().getExtraChashu() + "\t    " +
                bill.getAddon().getChashuCost() * bill.getAddon().getExtraChashu() +
                "\n---------------------------------------------------" +
                "\nTotal\t :\t\t\t\t   " + String.format("%.2f", price) +
                "\nUseStamp :\t\t\t\t   " + bill.isUseStamp() +
                "\n---------------------------------------------------" +
                "\nTotal Price:\t\t\t\t   " + bill.getPrice() +
                "\n***************************************************\n";
    }

}
