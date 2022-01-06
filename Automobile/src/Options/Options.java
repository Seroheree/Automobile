package Options;
import java.util.Scanner;
public class Options {
    String taskType;
    public void setTaskType(String settin){
        this.taskType=settin;
    }   

    public void OptionsPatern(){
        System.out.println("Welcome in " + taskType + " interface");
        System.out.println("Choose what do you want to do");
        System.out.println("1. Buy " + taskType);
        System.out.println("2. Sell " + taskType);
        System.out.println("3. Browse " + taskType);
            
        Scanner scan= new Scanner(System.in);
        String decision=scan.nextLine();
        switch(decision){
            case "1":
                if(taskType=="cars"){Cars.AddCars car= new Cars.AddCars(); car.AddCar();}
                else if(taskType=="parts"){Parts.AddParts part= new Parts.AddParts(); part.AddPart();}
                else if(taskType=="accessories"){Accessories.AddAccessories Accessory= new Accessories.AddAccessories();Accessory.AddAccessory(); }
            case "2":
                if(taskType=="cars"){Cars.SellCars car= new Cars.SellCars(); car.sellCar();}
                if(taskType=="parts"){Parts.SellParts part= new Parts.SellParts(); part.sellPart();}
                if(taskType=="accessories"){Accessories.SellAccessories Accessory= new Accessories.SellAccessories();Accessory.SellAccessoriesMethod();}
                break;
            case "3":
                if(taskType=="cars"){Cars.BrowseCars car= new Cars.BrowseCars(); car.BrowseCarsMethod();}
                if(taskType=="parts"){Parts.BrowseParts part= new Parts.BrowseParts(); part.BrowsePartsMethod();}
                if(taskType=="accessories"){Accessories.BrowseAccessories Accessory= new Accessories.BrowseAccessories();Accessory.BrowseAccessoriesMethod();}
                break;
            default: 
                System.out.println("Bad values, try again");
                System.exit(0);
                break;
        }
        
    }
}
