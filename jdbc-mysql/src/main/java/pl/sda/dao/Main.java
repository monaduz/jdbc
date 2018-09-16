//W klasie pl.sda.dao.AccountJdbcDAO zaimplementować metody:
//        openConncection
//        closeConncection
//        createStatement
//        createPrepareStatement
//        findAll
//        findById
//        findByNumber
//        findByCreationDate
//        findAllAfterCreationDate
//        findAccountsCount
//        W klasie Main przetestować każdą z metod.

package pl.sda.dao;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccountJdbcDAO accountJdbcDAO = new AccountJdbcDAO();
        System.out.println( "findAll" );
        accountJdbcDAO.findAll();
        System.out.println( "findDyId" );
        accountJdbcDAO.findById( 1 );
        System.out.println( "findByNumber" );
        accountJdbcDAO.findByNumber( "PL96934" );
        System.out.println( "findByCreationDate" );
        accountJdbcDAO.findByCreationDate( Date.valueOf( "2011-03-11" ) );
        System.out.println("findAllAfterCreationDate");
        accountJdbcDAO.finAllAfterCreationDate( Date.valueOf( "2012-03-10" ) );
        System.out.println("findAccountsCount");
     //   accountJdbcDAO.findAccountsCount();

        System.out.println("AddAcount");
        accountJdbcDAO.addAccount( 6,1563,"PL152569",Date.valueOf( "2011-03-11" ),Date.valueOf( "2019-03-11" ));


    }
}
