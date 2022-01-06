package Login;
import java.sql.*;

public class Login {
    private String Login;
    private String Password;

    private Boolean LogIn(String Login, String Password){
        boolean returnValue=false;
        try{
            Connection conn= DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/cars", "root", "12345");
            Statement st=conn.createStatement();
            String querend="select Login, Password from users";
            ResultSet rs=st.executeQuery(querend);
            
            while(rs.next()){
                String log=rs.getString("Login");
                String pass=rs.getString("Password");
                if(Login.equals(log) && Password.equals(pass)){
                System.out.println("Welcome " + log + ", you are logged now"); returnValue=true;}
                else{System.out.println("Wrong Login or Password! Try again");returnValue=false;}
                
            }

        }catch (SQLException se){se.printStackTrace();
        }catch (Exception e){e.printStackTrace();}
        return returnValue;
    }

    public void setLogin(String Log){
        this.Login=Log;
    }
    public void setPass(String Pass){
        this.Password=Pass;
    }

    public Boolean decision(){
        boolean decisionValue=LogIn(Login,Password);
        return decisionValue;
    }

    
}
