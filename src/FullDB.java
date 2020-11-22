import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FullDB {
    public static void main(String[] args) {
        FullDB connection = new FullDB();
        connection.createConnection();
    }

    //Create a method to connect to database
    void createConnection(){
        try{
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/Test","root","root");

            //Create a sql statement
            Statement query = connect.createStatement();

            //Insert/Uodate data to Database
            query.executeUpdate("INSERT INTO Test1" + "(nom)" + "VALUES('orange'), ('melons')," +
                    "('hotdogs'), ('buns')");

            //Execute a select all statement
            ResultSet rs = query.executeQuery("SELECT * FROM Test1");
            System.out.println("Test");
            while (rs.next()){
                String table = rs.getString("nom");
                System.out.println(table);
            }

//            System.out.println("Connected to Database");
        }

        catch (ClassNotFoundException ex){
            Logger.getLogger(FullDB.class.getName()).log(Level.SEVERE,null,ex);
        }

        catch(SQLException ex){
            Logger.getLogger(FullDB.class.getName()).log(Level.SEVERE,null,ex);
            ex.printStackTrace();
        }
    }

}
