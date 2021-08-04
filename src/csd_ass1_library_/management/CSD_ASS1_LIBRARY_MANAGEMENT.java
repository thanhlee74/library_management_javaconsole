package csd_ass1_library_.management;


import java.util.Scanner;
import java.util.regex.Pattern;

public class CSD_ASS1_LIBRARY_MANAGEMENT {
 
    private final static Scanner in = new Scanner(System.in);
//==============================================================================

    public static int checkInputIntLimit(int min, int max) {

        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print(
                        "Enter again: ");
            }
        }

    }
//=======================================================================================

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
//==========================================================================================

    public static String checkInputBCODE() {
        while (true) {
            String result;
            String regex = "B{1}[0-9]{1,}";
            Pattern pattern = Pattern.compile(regex);

            while (true) {
                result = in.nextLine().trim();
                if (result.matches(regex)) {
                    return result;
                }
                System.err.println("Bcode's format is B+[0-9]");
                System.out.print("enter again:");
            }

        }
    }
//==================================================================================

    public static String checkInputRCODE() {
        while (true) {
            String result;
            String regex = "R{1}[0-9]{1,}";
            Pattern pattern = Pattern.compile(regex);

            while (true) {
                result = in.nextLine().trim();
                if (result.matches(regex)) {
                    return result;
                }
                System.err.println("Rcode's format is R+[0-9]");
                System.out.print("enter again:");
            }

        }
    }
//==================================================================================

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (Exception e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }
//================================================================================

    public static int checkInputBYEAR() {
        while (true) {
            int result = Integer.parseInt(in.nextLine());
            if (result < 1900 || result > 2010) {
                System.out.println("Please input number");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
//================================================================================

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (Exception e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }
//=================================================================================

    static int menu() {
        System.out.println("||=========MENU=========||");
        System.out.println("1. Books list");
        System.out.println("2. Reader list");
        System.out.println("3. Lending list");
        System.out.println("4. Exists");
        System.out.println("ENTER YOUR CHOICE:");
        int choice = checkInputIntLimit(1, 4);
        return choice;
    }

    static int menuBooks() {
        System.out.println("||=========BOOKS LIST===========||");
        System.out.println("10. Load data from file ");
        System.out.println("11. Input & add to the end");
        System.out.println("12. Display data");
        System.out.println("13. Save books list to file");
        System.out.println("14. Search by bcode");
        System.out.println("15. Delete by bcode");
        System.out.println("16. Sort by bcode");
        System.out.println("17. Input & add to begin");
        System.out.println("18. Add after position k");
        System.out.println("19. Delete position k");
        System.out.println("20. Exists");
        System.out.println("ENTER YOUR CHOICE:");
        int choice = checkInputIntLimit(10, 20);
        return choice;
    }

    static int menuReader() {
        System.out.println("||===========READER LIST============||");
        System.out.println("21. Load data from file ");
        System.out.println("22. Input & add to the end");
        System.out.println("23. Display data");
        System.out.println("24. Save books list to file");
        System.out.println("25. Search by bcode");
        System.out.println("26. Delete by bcode");
        System.out.println("27. Exists");
        System.out.println("ENTER YOUR CHOICE:");
        int choice = checkInputIntLimit(21, 27);
        return choice;
    }

    static int menuLending() {
        System.out.println("||===========LENDING LIST============||");
        System.out.println("31. Input data");
        System.out.println("32. Display data");
        System.out.println("33. Sort by bcode+rcode");
        System.out.println("34. Exists");
        System.out.println("ENTER YOUR CHOICE:");
        int choice = checkInputIntLimit(31, 34);
        return choice;
    }

    static void processbook() throws Exception {
        MyListBooks mlb = new MyListBooks();
        while (true) {
            int choice1 = CSD_ASS1_LIBRARY_MANAGEMENT.menuBooks();
            switch (choice1) {
                case 10:
                    System.out.println("enter file name:");
                    String fname = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputString();
                    mlb.loadFromFile(fname);
                    mlb.traverse();
                    break;
                case 11:
                    mlb.addLast(mlb.enterData());

                    break;
                case 12:
                    mlb.display();
                    break;
                case 13:
                    System.out.println("enter file name:");
                    String fname1 = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputString();
                    mlb.saveToFile(fname1);
                    break;
                case 14:
                    System.out.println("enter bcode:");
                    String bcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputBCODE();
                    System.out.println(mlb.search(bcode).getInfo());
                    break;
                case 15:
                    System.out.println("enter bcode:");
                    String bcode1 = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputBCODE();
                    mlb.delete(bcode1);
                    break;
                case 16:
                    mlb.sortByCode();
                    mlb.display();
                    break;
                case 17:
                    mlb.addFirst(mlb.enterData());
                    break;
                case 18:
                    System.out.println("enter position k:");
                    int k = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputInt();
                    mlb.addAtPossition(k);
                    break;
                case 19:
                    System.out.println("enter position i:");
                    int i = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputInt();
                    mlb.deleIth(i);
                    System.out.println("delete successful");
                    mlb.traverse();
                    break;
                case 20:
                    return ;
            }
        }
    }

    static void processreader() throws Exception {
        MyListReader mlr = new MyListReader();
        while (true) {
            int choice2 = CSD_ASS1_LIBRARY_MANAGEMENT.menuReader();
            switch (choice2) {
                case 21:
                    System.out.println("enter file name:");
                    String fname2 = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputString();
                    mlr.loadFromFile1(fname2);
                    mlr.traverse1();
                    break;
                case 22:
                    mlr.addLast1(mlr.enterData1());
                    break;
                case 23:
                    mlr.display1();
                     break;
                case 24:
                    System.out.println("enter file name:");
                    String fname3 = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputString();
                    mlr.saveToFile1(fname3);
                    break;
                case 25:
                    System.out.println("enter rcode:");
                    String rcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputRCODE();
                    System.out.println(mlr.search1(rcode).getInfo());
                    break;
                case 26:
                    System.out.println("enter rocde:");
                    String rcode1 = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputRCODE();
                    mlr.delete1(rcode1);
                    mlr.traverse1();
                    break;
                case 27:
                    return ;
            }
        }
    }
static void processlending() throws Exception{
    MyListLending mll=new MyListLending();
     MyListBooks mlb = new MyListBooks();
      MyListReader mlr = new MyListReader();
    while(true){
        int choice3=CSD_ASS1_LIBRARY_MANAGEMENT.menuLending();
        switch(choice3){
            
            case 31: 
               mll.addLast2(mll.enterdata2());                            
             
            break;
            case 32:// System.out.println("enter file name:");
//              String fname3=CSD_ASS1_LIBRARY_MANAGEMENT.checkInputString();
//              mll.loadFromFile2(fname3);
                mll.display2();
           
            break;
            case 33: mll.sortByCode3();
            mll.display2();
            break;
            case 34:return;
        }
    }
}
    public static void main(String[] args) throws Exception {
        
        while (true) {
            int choice = CSD_ASS1_LIBRARY_MANAGEMENT.menu();
            switch (choice) {
                case 1:
                    CSD_ASS1_LIBRARY_MANAGEMENT.processbook();
                   break;
                case 2:
                    CSD_ASS1_LIBRARY_MANAGEMENT.processreader();
                    break;
                case 3:
                    CSD_ASS1_LIBRARY_MANAGEMENT.processlending();
                    break;
                case 4:
                    return;
            }

        }

    }

}
