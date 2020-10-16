package ua.politeh;

import lombok.SneakyThrows;
import java.io.IOException;
import java.util.Scanner;

public class FuncUtils {

    /**
     * Gets number from line
     *
     * @return double number
     */
    static double checkNum() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again!");
            }
        }
    }


    /**
     * Add new Triangle to list
     *
     * @param db base of data
     */
    static void addTriangle(Database db) {

        System.out.println("Enter 1ft side of triangle");
        double side1 = FuncUtils.checkNum();
        System.out.println("Enter 2nd side of triangle");
        double side2 = FuncUtils.checkNum();
        System.out.println("Enter 3d side of triangle");
        double side3 = FuncUtils.checkNum();
        System.out.println("____________________________\n");
        db.addTriangle(side1, side2, side3);
    }

    /**
     * Return name of file to method for open this file
     *
     * @param temp Array of names files in folder "files"
     * @return name of file
     */
    static String openBackUpFile(String[] temp) {

        for (int i = 0; i < temp.length; i++) {
            System.out.println(++i + " - > " + temp[--i]);
        }
        System.out.println("Enter number from the list");
        int _i = ((int) checkNum() - 1);
        if (_i >= 0 && _i < temp.length )
            return temp[_i];
        else
            return null;
    }

    /**
     * Method for add 5 triangles to base of data
     *
     * @param db base of data
     */
    static void makeDb(Database db) {
        db.addTriangle(2, 3, 4.5);
        db.addTriangle(3, 4, 5.5);
        db.addTriangle(4, 5, 6.5);
        db.addTriangle(5, 6, 7.5);
        db.addTriangle(6, 7, 15);
    }

   static void menu2S(Database db)  {
        while (true) {
            String s1 = "Hello, " +
                    "enter number from the list\n" +
                    "\n1 Open the file\n" +
                    "2 Open backup files\n" +
                    "3 Use prepared data\n" +
                    "4 Input data\n" +
                    "0 Exit";
            System.out.println(s1);

            switch ((int) checkNum()) {
                case 1:
                    db.deserialize("db.txt");
                    System.out.println(db.toString());
                    return;
                case 2:
                    db.deserialize(openBackUpFile(db.listFilesUsingJavaIO(db.PATHS)));
                    System.out.println(db.toString());
                    return;
                case 3:
                    FuncUtils.makeDb(db);
                    System.out.println(db.toString());
                    return;
                case 4:
                    FuncUtils.addTriangle(db);
                    System.out.println(db.toString());
                    return;
                case 0:
                    return;
            }
        }
    }


    static void menuS(Database db) {
        menu2S(db);
        while (true) {
            String s1 = "Hello, " +
                    "enter number from the list\n" +
                    "\n1 Open the file\n" +
                    "2 Open backup files\n" +
                    "3 Use prepared data\n" +
                    "4 Input data\n" +
                    "5 Save data in the file\n" +
                    "0 Exit";
            System.out.println(s1);

            switch ((int) checkNum()) {
                case 1:
                    db.deserialize("db.txt");
                    System.out.println(db.toString());
                    break;
                case 2:
                    db.deserialize(openBackUpFile(db.listFilesUsingJavaIO(db.PATHS)));
                    System.out.println(db.toString());
                    break;
                case 3:
                    FuncUtils.makeDb(db);
                    System.out.println(db.toString());
                    break;
                case 4:
                    FuncUtils.addTriangle(db);
                    System.out.println(db.toString());
                    break;
                case 5:
                    db.serialize("db.txt");
                    break;
                case 0:
                    return;
            }
        }
    }

    @SneakyThrows
    public static void menu2J(Database db) throws IOException {
        while (true) {
            String s1 = "Hello, " +
                    "enter number from the list\n" +
                    "\n1 Open the file\n" +
                    "2 Open backup files\n" +
                    "3 Use prepared data\n" +
                    "4 Input data\n" +
                    "0 Exit";
            System.out.println(s1);

            switch ((int) checkNum()) {
                case 1:
                    db.jacksonDeserialize("db.json");
                    System.out.println(db.toString());
                    return;
                case 2:
                    db.jacksonDeserialize(openBackUpFile(db.listFilesUsingJavaIO(db.PATHJ)));
                    System.out.println(db.toString());
                    return;
                case 3:
                    FuncUtils.makeDb(db);
                    System.out.println(db.toString());
                    return;
                case 4:
                    FuncUtils.addTriangle(db);
                    System.out.println(db.toString());
                    return;
                case 0:
                    return;
            }
        }

    }

    @SneakyThrows
    public static void menuJ(Database db) throws IOException {
        menu2J(db);
        while (true) {
            String s1 = "Hello, " +
                    "enter number from the list\n" +
                    "\n1 Open the file\n" +
                    "2 Open backup files\n" +
                    "3 Use prepared data\n" +
                    "4 Input data\n" +
                    "5 Save data in the file\n" +
                    "0 Exit";
            System.out.println(s1);

            switch ((int) checkNum()) {
                case 1:
                   db.jacksonDeserialize("db.json");
                    System.out.println(db.toString());
                    break;
                case 2:
                    db.jacksonDeserialize(openBackUpFile(db.listFilesUsingJavaIO(db.PATHJ)));
                    System.out.println(db.toString());
                    break;
                case 3:
                    FuncUtils.makeDb(db);
                    System.out.println(db.toString());
                    break;
                case 4:
                    FuncUtils.addTriangle(db);
                    System.out.println(db.toString());
                    break;
                case 5:
                    db.jacksonSerialize("db.json");
                    break;
                case 0:
                    return;
            }
        }

    }
}





