
package db;
import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
    static public Connection c;
    static public Statement st;
    static public PreparedStatement insertClient,getClients,updateClient;
    static{
        try{
    Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection(
           "jdbc:mysql://localhost:3306/clientdb3pm","root","incapp");
    st=c.createStatement(); 
    insertClient=c.prepareStatement("insert into client_info (name,gender,dob,"
            +   "country,address,language) values(?,?,?,?,?,?)");
    getClients=c.prepareStatement("select * from client_info where name like ?");
    updateClient=c.prepareStatement("update client_info set name=?,gender=?,dob=?,"
            +   "country=?,address=?,language=? where cid=?");
        }catch(Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, ex);        
        }
    }
}
