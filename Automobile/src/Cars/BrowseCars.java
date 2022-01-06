package Cars;
import java.sql.*;
public class BrowseCars {
    public void BrowseCarsMethod(){
        System.out.println("You are browsing parts now");
        Connection();
    }

    private void Connection(){
        try{
            Connection conn=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars",
            "root",    "12345");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("Select * from cars.cars_base");

            while(rs.next()){
                int id=rs.getInt("ID");
                String Brand=rs.getString("Brand");
                String Model=rs.getString("Model");
                double Engine=rs.getDouble("Engine");
                String Fuel=rs.getString("Fuel");
                int HorsePower=rs.getInt("Horsepower");
                String Color=rs.getString("Color");
                Boolean Nav=rs.getBoolean("Navigation");
                int Price=rs.getInt("price");
                System.out.println(id + "   " + Brand+ "    " +Model+ "     " +Engine+ "    " +Fuel+ "      " +HorsePower + "   " +Color + "    " +"Navigation: " + Nav + "     " + Price + "$");
            }
        
        }
            
        catch(SQLException se){se.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }
}
