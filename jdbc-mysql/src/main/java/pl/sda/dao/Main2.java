
/*
Zad 2. Na podstawie wcześniejszego zadania napisać program z menu, w którym
będą możliwości:
- dodanie nowego konta,
- edycja istniejsącego konta, np. zmiana salda, daty początku i końca konta,
- wypisanie informacji o koncie za pomocą identyfikatora konta,
- wypisanie wszystkich informacji o kontach,
- usuwanie konta po identyfikatorze lub numerze
 */

package pl.sda.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;


public class Main2 {
    static Scanner scanner = new Scanner( System.in );
    static AccountJdbcDAO accountJdbcDAO = new AccountJdbcDAO();
    public static void main(String[] args) throws SQLException {

        System.out.println( "co chcesz zrobić?\n" +
                "1. dodać nowe konto\n" +
                "2. edytowac konto\n" +
                "3. wypisać informacje o koncie\n" +
                "4. wypisać wszystkie informacje o kontach\n" +
                "5. usunąć konto\n" );

        switch (scanner.nextInt()) {
            case 1:
                newAccount();
                break;
            case 2:
                editAccount();
                break;
            case 3:
                System.out.println("podaj id konta");
                int idd = scanner.nextInt();
                accountJdbcDAO.findById( idd );
                break;
            case 4:
                accountJdbcDAO.findAll();
                break;
            case 5:
                System.out.println("podaj id konta które chcesz usunąć");
                int id5=scanner.nextInt();
                accountJdbcDAO.deleteAccount(id5);
                break;
            default:
                System.out.println( "wpisano nieprawidłowy znak" );
                break;
        }
    }

    private static void editAccount() throws SQLException {
        System.out.println("podaj id konta które chcesz edytować");
        int id = scanner.nextInt();
        System.out.println("który parametr chcesz edytować?\n" +
                "1. balance\n" +
                "2. creation date\n" +
                "3. close date\n");
        switch(scanner.nextInt()){
            case 1:
                System.out.println("podaj nowy balace");
                int balance=scanner.nextInt();
                accountJdbcDAO.updateBalance( id,balance );
                break;
            case 2:
               // System.out.println("test");
                String test=scanner.nextLine();
                System.out.println("podaj creation date (yyyy-mm-dd)");
                String openDate = scanner.nextLine();
                accountJdbcDAO.updateCreationDate(id, Date.valueOf(   openDate));
                break;
            case 3:
                //System.out.println("test");
                String test2=scanner.nextLine();
                System.out.println("podaj close date (yyyy-mm-dd)");
                String closeDate = scanner.nextLine();
                accountJdbcDAO.updateCloseDate(id, Date.valueOf(   closeDate));
                break;
            default:
                System.out.println("wpisano nieprawidłowy znak");
        }
    }

    private static void newAccount() throws SQLException {
        System.out.println("podaj id");
        int id=scanner.nextInt();
        System.out.println("podaj balance");
        int balance=scanner.nextInt();
        //System.out.println("test ");
        String test = scanner.nextLine();
        System.out.println("podaj number");
        String number=scanner.nextLine();
        System.out.println("podaj creation date (yyyy-mm-dd)");
        String creationDate=scanner.nextLine();
        System.out.println("podaj close date (yyyy-mm-dd)");
        String closeDate=scanner.nextLine();
        accountJdbcDAO.addAccount( id,balance,number, Date.valueOf( creationDate),Date.valueOf(closeDate ));

    }

}
