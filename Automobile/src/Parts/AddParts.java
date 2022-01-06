package Parts;
import java.util.Scanner;
import java.sql.*;

public class AddParts {
    Scanner scan=new Scanner(System.in);

    
    public void AddPart(){
       System.out.println("Put the name");                  String name=scan.nextLine();
       System.out.println("Put the Serial Number");         String Serial=scan.nextLine();
       System.out.println("Put the Brand");                 String Brand=scan.nextLine();
       System.out.println("Put the Model");                 String Model=scan.nextLine();
       System.out.println("Put the Year of Production");    String Year=scan.nextLine();        int YearInt=Integer.parseInt(Year);

      Connection(name, Serial, Brand, Model, YearInt);
    }
    
    private void Connection(String name, String Serial, String Brand, String Model, int Year){

        try{
            Connection conn=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars",
             "root",    "12345");
            String querend= "Select * from cars.cars_base";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(querend);
            int id=0;
            while(rs.next()){id=rs.getInt("ID");}
            id++;
            st.executeUpdate("INSERT INTO cars.cars_parts(ID, Name, SerialNumber, Brand, Model, YearOfProduction) "
            + "VALUES (" + id +","+ "'" + name + "'" +"," +"'"+ Serial + "'"+"," + "'" + Brand + "'" + "," + "'" + Model + "'" + "," + Year + ")");
            System.out.println("Part was purchased successfully");
            st.close();
        }
        catch(SQLException se){se.printStackTrace();}
        catch(Exception e){e.printStackTrace();}}
    

}
