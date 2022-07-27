package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    private static final String DATABASE_ROOT_URL = "jdbc:mysql://localhost:3306";
    private static final String STUDENT_GRADER_DB = "studentgrader";
    private static final String STUDENT_TABLE = "student";
    private static final String USER = "root";
    private static final String PASSWORD = "General_0017";

    public static boolean createDatabase(String databaseName) {
        try {
            Connection conn = DriverManager.getConnection(DATABASE_ROOT_URL, USER, PASSWORD);
            Statement st = conn.createStatement();
            st.execute("CREATE database " + databaseName.trim());
            return true;
        } catch (SQLException e) {
            // Can't create database 'studentgrader'; database exists
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean createTable(String databaseName, String tableName) {
        try {
            Connection conn = DriverManager.getConnection(DATABASE_ROOT_URL + "/" + databaseName, USER, PASSWORD);
            Statement st = conn.createStatement();
            String query = "CREATE TABLE " + tableName.trim() + " id INT PRIMARY KEY AUTO_INCREMENTING NOT NULL";
            st.execute(query);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean insertColumn(String databaseName, String tableName, String columnName, String constraints) {
        try {
            Connection conn = DriverManager.getConnection(DATABASE_ROOT_URL + "/" + databaseName, USER, PASSWORD);
            Statement st = conn.createStatement();
            String query = "ALTER TABLE " + tableName.trim() + " ADD " + columnName + " " + constraints;
            st.execute(query);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
//     + "(" + "name VARCHAR(25) NOT NULL,"
//             + "studentId INT NOT NULL,"
//             + "physicsMarks INT NOT NULL,"
//             + "chemistryMarks INT NOT NULL,"
//             + "biologyMarks INT NOT NULL,"
//             + "mathMarks INT NOT NULL"
//             + ")";

    public static boolean dropTable(String database, String name) {
        try {
            Connection conn = DriverManager.getConnection(DATABASE_ROOT_URL + "/" + database, USER, PASSWORD);
            Statement st = conn.createStatement();
            String query = "DROP TABLE IF EXISTS " + name.trim();
            st.execute(query);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        boolean createdDatabase = createDatabase(STUDENT_GRADER_DB);
        System.out.println("Created: " + createdDatabase);

        boolean createdTable = createTable(STUDENT_GRADER_DB, STUDENT_TABLE);
        System.out.println("Created: " + createdTable);

//        boolean droppedTable = dropTable(STUDENT_GRADER_DB, STUDENT_TABLE);
//        System.out.println("Dropped: " + droppedTable);


    }
}
