package ArmyManagementSystem;
import java.io.*;
import java.util.*;


public class Inventory extends Thread{
    final int totalGuns = 20;
    static int avaliableGuns=20;
    HashMap <String, String> inventory = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    void main(String Name){
        boolean continueMenu = true;
        while (continueMenu){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("INVENTORY OF "+Name+" REGIMENT\n");
            System.out.println("*********************************");
            System.out.println("1. Allocate Guns");
            System.out.println("2. Allocate Health Facilities");
            System.out.println("3. Allocate Food");
            System.out.println("4. Change Health Facilities");
            System.out.println("5. Allocate more Food");
            System.out.println("6. Allocate more Guns");
            System.out.println("7. Display Inventory");
            System.out.println("8. Update File");
            System.out.println("9. EXIT");


            int userChoice = scan.nextInt();
            switch (userChoice){
                case 1: {
                    System.out.print("Enter Number Of Guns: ");
                    int Guns = scan.nextInt();
                    allocateGuns(Guns);
                    break;
                }
                case 2: {
                    System.out.print("Enter Name Of Health Provider: ");
                    String healthName = scan.next();
                    allocateHeath(healthName);
                    break;
                }
                case 3: {
                    System.out.println("Enter Food Allocate(Days): ");
                    String foodDays = scan.next();
                    allocateFood(foodDays);
                    break;
                }
                case 4: {
                    System.out.print("Enter Name Of New Health Provider: ");
                    String healthName = scan.next();
                    ChangeHeath(healthName);
                    break;
                }
                case 5: {
                    System.out.print("Allocate More Food: ");
                    String moreFood = scan.next();
                    allocateMoreFood(moreFood);
                    break;
                }
                case 6: {
                    System.out.print("Allocate More Guns: ");
                    int Guns = scan.nextInt();
                    allocateMoreGuns(Guns);
                    break;
                }
                case 7: {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter Name of Regiment: ");
                    String RegimentName = scan.next();
                    DisplayInventory displayInventory = new DisplayInventory(RegimentName);
                    try {
                        displayInventory.detailInventory();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 8: {
                    System.out.print("Enter File Name: ");
                    String FileName = scan.next();
                    updateFile(FileName);
                    break;
                }
                case 9: {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continueMenu = false;
                    break;
                }
            }
        }
    }
    void allocateGuns(int guns){
        if (avaliableGuns>guns){
            avaliableGuns-=guns;
            String Guns=String.valueOf(guns);
            this.inventory.put("Guns", Guns);
        }
        else{
            System.out.println("Guns Resource Insufficient");
        }
    }
    void allocateMoreGuns(int guns){
        if (avaliableGuns>guns){
            avaliableGuns-=guns;
            String Guns=String.valueOf(guns);
            this.inventory.replace("Guns", Guns);
        }
        else{
            System.out.println("Guns Resource Insufficient");
        }
    }
    void allocateHeath(String healthName){
        this.inventory.put("HealthProvider", healthName);
    }
    void ChangeHeath(String healthName){
        this.inventory.replace("HealthProvider", healthName);
    }
    void allocateFood(String foodDays){
        this.inventory.put("Food", foodDays);
    }
    void allocateMoreFood(String foodDays){
        this.inventory.replace("Food", foodDays);
    }

    void updateFile(String Name){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("/Users/ahmadashraf/Desktop/java/CaseStudy/"+Name+"Inventory.txt"));
            for (Map.Entry<String, String> entry : inventory.entrySet()) {

                bf.write(entry.getKey() + ":" + entry.getValue());

                bf.newLine();
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
