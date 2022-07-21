package ArmyManagementSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayRegiment {
    String RegimentName;
    DisplayRegiment(String RegimentName){
        this.RegimentName="/Users/ahmadashraf/Desktop/java/CaseStudy/"+RegimentName+"SoldierDetail.txt";
    }
    void detailRegiment() throws FileNotFoundException {
        File detail = new File(RegimentName);
        Scanner scan = new Scanner(detail);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
        }
        scan.close();
    }

}
