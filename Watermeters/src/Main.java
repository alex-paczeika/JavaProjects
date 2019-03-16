import DataAccesPackage.FakeDAO;
import DataAccesPackage.WaterMeterDAO;
import Model.WaterMeterModel;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        FakeDAO fakeDAO = new FakeDAO();


        Scanner scanner = new Scanner(System.in);
        int number = 0;

        while (number != 4) {
            System.out.println("\n\n1.\tAdaugare citire pe o anumita luna\n" +
                    "2.\tStergere citire pe o anumita luna\n" +
                    "3.\tAfisare consum pe o anumita luna\n" +
                    "4.\tIesire\n ");


            number = scanner.nextInt();

            switch (number) {
                case 1:
                    fakeDAO.addNewWaterMeter();
                    break;

                case 2:
                    System.out.println("Introduceti va rog citirea care vreti sa o stergeti in formatul IAN-2018:");
                    scanner.nextLine();
                    String monthDeleted = scanner.nextLine();
                    fakeDAO.deleteWaterMeter(monthDeleted);
                    break;
                case 3:
                    fakeDAO.selectAllWater();
                    break;
            }
        }

    }


}
