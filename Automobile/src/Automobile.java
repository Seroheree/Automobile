import java.util.Scanner;
public class Automobile extends Login.Login{

    public static void main(String[] args) throws Exception {

        Scanner scan= new Scanner(System.in);
        Login.Login login= new Login.Login();


        System.out.println("Welcome in Automobile system.");
        System.out.println("Put login: ");  String logValue=scan.nextLine();
        System.out.println("Put password: "); String passValue=scan.nextLine();

        login.setLogin(logValue);login.setPass(passValue);
        
        if(login.decision()==true){
            System.out.println
            ("Welcome in automobile system, "
            +"choose what you want to work with (press number) : ");
    
            System.out.println("1. cars");
            System.out.println("2. parts");
            System.out.println("3. accessorries");
            
            final String decision=scan.nextLine();
            Options.Options option=new Options.Options();

            switch(decision){
                case "1":
                option.setTaskType("cars");
                option.OptionsPatern();
                    break;
                case "2":
                option.setTaskType("parts");
                option.OptionsPatern();
                    break;
                case "3":
                option.setTaskType("accessories");
                option.OptionsPatern();
                    break;
            } 
        }else{
            System.exit(0);
        }


        


        



    }
}
