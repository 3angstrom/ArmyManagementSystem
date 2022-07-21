package ArmyManagementSystem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class Main extends Thread{
    static final String commName = "Ahmad Ashraf";
    final int commCode = 4321;

    public static void main(String[] args){
        Main commander = new Main();
	    System.out.print("Enter Identification Code: ");
        Scanner scan = new Scanner(System.in);
        int IdCode = scan.nextInt();
        if (IdCode == commander.commCode){
            System.out.println("WELCOME COMMANDER: "+commName+"\n\n");
            boolean continueMenu = true;
            while(continueMenu) {
                System.out.println("**************************************\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1. Create Regiment");
                System.out.println("2. Display a Regiment");
                System.out.println("3. Inventory Detail Of Regiment");
                System.out.println("4. Exit");


                int choice = scan.nextInt();
                switch (choice) {
                    case 1: {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter Regiment Name: ");
                        String RegimentName = scan.next();
                        System.out.print("\nEnter Regiment Base Camp: ");
                        String RegimentBase = scan.next();
                        System.out.println();
                        Regiment regiment1 = new Regiment(RegimentName, RegimentBase);

                        break;
                    }
                    case 2: {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("Enter Name of Regiment: ");
                        String RegimentName = scan.next();
                        DisplayRegiment displayRegiment = new DisplayRegiment(RegimentName);
                        try {
                            displayRegiment.detailRegiment();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 3: {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Inventory inventory = new Inventory();
                        System.out.print("Enter Regiment Name: ");
                        String name = scan.next();
                        inventory.main(name);
                    }
                    case 4: {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continueMenu = false;
                        break;
                    }

                    default:
                        break;
                }
                }
            }
        }
}

