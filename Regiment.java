package ArmyManagementSystem;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;


public class Regiment {
    String RegimentName;
    String RegimentCaptain;
    String Mission;
    String BaseCamp;
    static Scanner scan = new Scanner(System.in);
    FileWriter solFile;

    Regiment (String RegimentName, String BaseCamp){
        this.RegimentName = RegimentName;
        this.BaseCamp = BaseCamp;
        this.RegimentCaptain = allocateCaptain();
        this.Mission = allocateMission();
        {
            try {
                solFile = new FileWriter(RegimentName+"SoldierDetail.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            addRegimentDetail();
            addSoldier();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void addRegimentDetail(){
        try {
            solFile.write("REGIMENT NAME: " + RegimentName +"\n\n");
            solFile.write("REGIMENT BASE: "+ BaseCamp+"\n\n");
            solFile.write("REGIMENT CAPTAIN: "+ RegimentCaptain +"\n\n");
            solFile.write("MISSION: "+ Mission +"\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void addSoldier() throws IOException {
        System.out.print("Enter the no of Soldiers: ");
        int noSol = scan.nextInt();
        ArrayList<String> soldier= new ArrayList<>();
        solFile.write("\nSOLDIER\t    NAMES\t HEIGHT\t BMI\n");
        for (int i=1; i<=noSol; i++){
            System.out.print("Enter Soldier Name: ");
            String name = scan.next();
            System.out.print("\nEnter Soldier Height: ");
            double height = scan.nextDouble();
            System.out.print("\nEnter Solider BMI: ");
            double bmi = scan.nextDouble();
            soldier.add(name);
            solFile.write("SoldierID " +i+ " :" +name+"\t"+height+"\t"+bmi+"\n");
        }
        solFile.close();
    }

    String allocateMission(){
        System.out.print("Enter Name of Mission: ");
        String Mission = scan.next();
        return Mission;
    }
    String allocateCaptain(){
        System.out.print("Enter Captain Name: ");
        String RegimentCaptain = scan.next();
        return RegimentCaptain;
    }

}
