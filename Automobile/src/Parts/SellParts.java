package Parts;
import java.util.Scanner;
import java.sql.*;
public class SellParts {
    Scanner scan=new Scanner(System.in);
    public void sellPart(){
        
        System.out.println("You are selling parts now");
        System.out.println("Put Serial number of the part");    String Serial=scan.nextLine();

        Connection(Serial);
    }

    private void Connection(String Serial){
        try{
            Connection conn=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars",
             "root",    "12345");
            String querend= "Select * from cars.cars_parts ";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(querend);
            while(rs.next()){
                st.executeUpdate("DELETE from cars.cars_parts WHERE SerialNumber='" + Serial+"'");
            }

        }catch(SQLException se){se.printStackTrace();
        }catch(Exception e){e.printStackTrace();
}
    }
}
