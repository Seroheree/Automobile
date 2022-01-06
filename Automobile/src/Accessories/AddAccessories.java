package Accessories;
import java.util.Scanner;

import org.w3c.dom.Attr;

import java.sql.*;

public class AddAccessories {
    Scanner scan=new Scanner(System.in);

    public void AddAccessory(){
       System.out.println("Put the name");                  String name=scan.nextLine();
       System.out.println("Put Attribute 1");               String Attr1=scan.nextLine();
       System.out.println("Put Attribute 2");               String Attr2=scan.nextLine();
       System.out.println("Put Attribute 3");               String Attr3=scan.nextLine();

       Connection(name,Attr1,Attr2,Attr3);
    }
    
    private void Connection(String name,String Attr1, String Attr2,String Attr3){

        try{
            Connection conn=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars",
             "root",    "12345");
            String querend= "Select * from cars.cars_accessories";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(querend);
            int id=0;
            while(rs.next()){id=rs.getInt("ID");}
            id++;
            st.executeUpdate("INSERT INTO cars.cars_accessories(ID, Name, Attribute_1, Attribute_2, Attribute_3) "
            + "VALUES (" + id +","
            + "'" + name + "'" +
            "," + "'"+Attr1+"'"+
            ","+"'"+Attr2+"'"
            +","+"'"+ Attr3 +"'"+")");
            System.out.println("Accessory was purchased successfully");
            st.close();
        }
        catch(SQLException se){se.printStackTrace();}
        catch(Exception e){e.printStackTrace();}}
    

}
