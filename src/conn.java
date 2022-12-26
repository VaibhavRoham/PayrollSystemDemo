import java.sql.*;

public class conn {

    public Connection c;
    public Statement s;

    public conn()
    {
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3308/vaibhav", "root", "root");
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaJdbcDemo {
    public static void main(String a[])
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/java-jdbc", "root", "root");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from people");

            while (rs.next()) {
                System.out.println(rs.getString("firstname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
*/
