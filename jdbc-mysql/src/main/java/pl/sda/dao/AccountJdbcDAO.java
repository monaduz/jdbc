//W klasie pl.sda.dao.AccountJdbcDAO zaimplementować metody:
//    v    openConncection
//    v    closeConncection
//    nie trzeba    createStatement
//    nie trzeba    createPrepareStatement

//     v   findAll
//     v   findById
//     v   findByNumber
//     v   findByCreationDate
//     v   findAllAfterCreationDate
//     v   findAccountsCount
//        W klasie Main przetestować każdą z metod.

package pl.sda.dao;

import java.sql.*;

public class AccountJdbcDAO {
    public static final String BD_URL = "jdbc:mysql://localhost:3306/zad1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=true";
    public static final String BD_USER = "scott";
    public static final String BD_PASS = "Scott12!@";

    Connection openConnection() throws SQLException {
        return DriverManager.getConnection( BD_URL, BD_USER, BD_PASS );
    }

    void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    void applyExecuteQuery(String query) throws SQLException {
        Connection connection = openConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( query );

        ResultSetMetaData rsmd = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (i > 1) System.out.print( ",  " );
                System.out.print( rsmd.getColumnName( i ) + ": "
                        + resultSet.getString( i ) );
            }
            System.out.println( "" );
        }
        closeConnection( connection );
    }

    void applyExecuteUpdate(String query) throws SQLException {
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate( query );
        closeConnection( connection );
    }

    void findAll() throws SQLException {
        final String query = "select * from account";
        applyExecuteQuery( query );
    }

    void findById(int id) throws SQLException {
        final String query = "select * from account where account_id=" + id;
        applyExecuteQuery( query );
    }

    void findByNumber(String number) throws SQLException {
        final String query = "select * from account where number='"
                + number + "'";
        applyExecuteQuery( query );
    }


    void findByCreationDate(Date creationDate) throws SQLException {
        final String query = "select * from account where creation_date='"
                + creationDate + "'";
        applyExecuteQuery( query );
    }


    void finAllAfterCreationDate(Date creationDate) throws SQLException {
        final String query = "select * from account where creation_date>'"
                + creationDate + "'";
        applyExecuteQuery( query );
    }


    void findAccountsCount() throws SQLException {
        final String query = "select * from account ";

        Connection connection = openConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( query );
        ResultSetMetaData rsmd = resultSet.getMetaData();
        System.out.println( rsmd.getColumnCount() );

        closeConnection( connection );
    }

    void addAccount(int id, int balance, String number,
                    Date creationDate, Date closeDate) throws SQLException {
        final String query =
                "insert into account values('"
                        + id + "','" + balance + "','" + number + "','"
                        + creationDate + "','" + closeDate + "')";
        applyExecuteUpdate( query );
    }

    void deleteAccount(int id) throws SQLException {
        final String query = "delete from account where account_id='" + id + "'";
        applyExecuteUpdate( query );
    }

    void updateBalance(int id, int balance) throws SQLException {
        final String query = "update account set balance=" + balance
                + " where account_id=" + id;

        applyExecuteUpdate( query );
    }


    void updateCreationDate(int id, Date date) throws SQLException {
        final String query = "update account set creation_date='" + date
                + "' where account_id=" + id;

        applyExecuteUpdate( query );
    }

    public void updateCloseDate(int id, Date date) throws SQLException {
        final String query = "update account set close_date='" + date
                + "' where account_id=" + id;

        applyExecuteUpdate( query );

    }
}
