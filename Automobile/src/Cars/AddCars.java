package Cars;
import java.util.Scanner;
import java.sql.*;

public class AddCars {
    Scanner scan=new Scanner(System.in);
    private String querend="";

    boolean navCheck(){
        String navigation=scan.nextLine();  
        boolean booleanNavigation=false;
        if      (navigation.equals("yes")){booleanNavigation=true;} 
        else if (navigation.equals("no")){booleanNavigation=false;}
        else    {System.out.println("Bad value, try again!");System.exit(0);}
        return booleanNavigation;
    }

    
    public void AddCar(){
        System.out.println("You are adding car now");
        System.out.println("Put brand");                String brand=scan.nextLine();   
        System.out.println("Put model");                String model=scan.nextLine();
        System.out.println("Put engine(for example 1.6)");String engine=scan.nextLine();                  double doubleEngine=Double.parseDouble(engine);
        System.out.println("Put fuel");                 String fuel=scan.nextLine();
        System.out.println("Put horsepower");           String horsePower=scan.nextLine();              int intHorsePower=Integer.parseInt(horsePower);
        System.out.println("Put color");                String color=scan.nextLine();       
        System.out.println("Put navigation (yes/no)");  boolean navValue=navCheck();
        System.out.println("Put price");                String price=scan.nextLine();                   int intPrice=Integer.parseInt(price);

        CarsCreator car= new CarsCreator(brand,model,doubleEngine,fuel,intHorsePower,color,navValue,intPrice);
        Connection(brand,model,doubleEngine,fuel,intHorsePower,color,navValue,intPrice);
    }
    
    private void Connection(String Brand, String Model, double Engine,
    String Fuel, int HorsePower, String Color, boolean Nav, int Price){

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
            st.executeUpdate("INSERT INTO cars.cars_base(ID,Brand,Model,"+
            "Engine,Fuel,Horsepower,Color,Navigation,Price) VALUES ("
            + id + "," + "'" + Brand + "'" + "," + "'" + Model + "'" + ","
            + Engine  + ","+ "'" + Fuel + "'" + "," + HorsePower  + "," +
            "'" + Color + "'" + "," + Nav + "," + Price + ")");
            
            System.out.println("The car was purchased successfully");
            st.close();
        }
        catch(SQLException se){se.printStackTrace();}
        catch(Exception e){e.printStackTrace();}}
    

}