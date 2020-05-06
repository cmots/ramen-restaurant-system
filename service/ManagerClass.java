import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerClass implements ManagerService {

    
    @Override
    public Manager login(int managerID) {
    	int i;
        ArrayList<Manager> manager = readManagerInfo();
        for (i = 0; i < manager.size(); i++) {
            if (manager.get(i).getManagerID() == (managerID)) {
                break;
            }
        }
        if (i < manager.size()) {
            return manager.get(i);
        } else {
            return null;
        }
    }
    
    public ArrayList<Manager> readManagerInfo() {
        String path = "information/ManagerInfo.txt";
        ArrayList<Manager> manager = new ArrayList<Manager>();
        int managerID;
        String email;
        String[] str = new String[2];
        try {
            File filename = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            line = br.readLine();
            while (line != null) {
                int index = 0;
                for (int i = 0; i < 2; i++) {
                    if (i < 1) {
                        str[i] = line.substring(line.indexOf("=", index + 1) + 1, line.indexOf(",", index + 1));
                        index = line.indexOf(",", index + 1);
                    } else {
                        str[i] = line.substring(line.indexOf("=", index + 1) + 1, line.indexOf("}"));
                    }
                }
                managerID = Integer.parseInt(str[0]);
                email = str[1].substring(1, str[1].length() - 1);
                manager.add(new Manager(managerID, email));
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return manager;
    }
   
}
