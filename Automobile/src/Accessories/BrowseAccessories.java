package Accessories;

import java.sql.*;

public class BrowseAccessories {
    public void BrowseAccessoriesMethod(){
        System.out.println("You are browsing accessories now");
        Connection();
    }

    private void Connection(){
        try{
            Connection conn=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars",
             "root",    "12345");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("Select * from cars.cars_accessories");

            while(rs.next()){
                int ID=rs.getInt("ID");
                String name=rs.getString("Name");
                String Attr1=rs.getString("Attribute_1");
                String Attr2=rs.getString("Attribute_2");
                String Attr3=rs.getString("Attribute_3");
                System.out.println(ID+ "    " + name + "    " + Attr1+ "    " +Attr2 + "    " + Attr3);
            }
        }
        catch(SQLException se){se.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }
    
}







