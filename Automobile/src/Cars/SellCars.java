package Cars;
import java.util.Scanner;
import java.sql.*;
public class SellCars {
    Scanner scan=new Scanner(System.in);
    public void sellCar(){
        
        System.out.println("You are selling car now");
        System.out.println("Put Brand");    String Brand=scan.nextLine();
        System.out.println("Put Model");    String Model=scan.nextLine();

        Connection(Brand, Model);
    }

    private void Connection(String Brand, String Model){
        try{
            Connection conn=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars",
             "root",    "12345");
            String querend= "Select ID,Brand,Model,Price from cars.cars_base WHERE (" +
            "Brand=" +"'" + Brand +"'" + " AND Model=" +"'" +Model+"')"; 
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(querend);
            boolean ask=false;
            while(rs.next()){
                ask=true;
                int id=rs.getInt("ID");
                String brand= rs.getString("Brand");
                String model= rs.getString("Model");
                int price= rs.getInt("price");
                System.out.println(id+ " " +brand+ " " + model + " " + price);
            }
         
            if(ask==true){
                System.out.println("What car do you want to sell?(press id number)");
                String deleteId=scan.nextLine();
                st.executeUpdate("DELETE FROM cars.cars_base WHERE ID=" + deleteId);
                System.out.println("You sold car");
            }
        }catch(SQLException se){se.printStackTrace();
        }catch(Exception e){e.printStackTrace();
}
    }
}
