package Cars;

public class CarsCreator {
    
    String brand;
    String model;
    double engine;
    String fuel;
    int horsepower;
    String color;
    boolean navigation;
    int price;

    public CarsCreator
        (String brand, String model,double engine, String fuel, 
        int horsepower, String color, boolean navigation, int price){

            this.brand=brand;
            this.model=model;
            this.engine=engine;
            this.fuel=fuel;
            this.horsepower=horsepower;
            this.color=color;
            this.navigation=navigation;
            this.price=price;
    }
}
