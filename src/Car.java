import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Andrey on 13.08.2014.
 */
@GetCarState (info = "Let's get object", state = 1)
public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private int yearOfProduction;
    private Colour colour;
    private State state;
    private String owner;
    private int isExclusive;

    Car() {}

    public Car(String brand, String model, int yearOfProduction, Colour colour, State state, String owner, int isExclusive) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.colour = colour;
        this.state = state;
        this.owner = owner;
        this.isExclusive = isExclusive;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public Colour getColour() {
        return colour;
    }

    public State getState() {
        return state;
    }

    public String getOwner() {
        return owner;
    }

    public int getIsExclusive() {
        return isExclusive;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setIsExclusive(int isExclusive) {
        this.isExclusive = isExclusive;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", colour=" + colour +
                ", state=" + state +
                ", owner='" + owner + '\'' +
                ", isExclusive=" + isExclusive +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        return (this.yearOfProduction - car.getYearOfProduction());
    }

    public static Comparator<Car> BrandComparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getBrand().compareTo(o2.getBrand());
        }
    };

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (isExclusive != car.isExclusive) return false;
        if (yearOfProduction != car.yearOfProduction) return false;
        if (!brand.equals(car.brand)) return false;
        if (colour != car.colour) return false;
        if (!model.equals(car.model)) return false;
        if (!owner.equals(car.owner)) return false;
        if (state != car.state) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + yearOfProduction;
        result = 31 * result + colour.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + isExclusive;
        return result;
    }
    */
}
