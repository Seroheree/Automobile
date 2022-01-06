package Parts;
import java.sql.*;
public class BrowseParts {

    public void BrowsePartsMethod(){
        System.out.println("You are browsing cars now");
        Connection();
    }

    private void Connection(){
        try{    
            Connection conn=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars",
            "root",    "12345");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("Select * from cars.cars_parts");
            while(rs.next()){
                int ID=rs.getInt("ID");
                String Name=rs.getString("Name");
                String Serial=rs.getString("SerialNumber");
                String Brand=rs.getString("Brand");
                String Model=rs.getString("Model");
                String Year=rs.getString("YearOfProduction");
                System.out.println(ID + "   " + Name + "    " + Serial + "   " + Brand + "   " + Model + "   " + Year);
            }}
            catch(SQLException se){se.printStackTrace();}
            catch(Exception e){e.printStackTrace();}
}}
