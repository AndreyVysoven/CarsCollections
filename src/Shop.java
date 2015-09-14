import javax.rmi.CORBA.Util;
import java.util.*;

/**
 * Created by Andrey on 13.08.2014.
 */
public class Shop {

    public void viewListOfCars (List<Car> cars)
    {
        if (cars.size() > 0)
            for (int i = 0; i < cars.size(); i++)
                System.out.println(i + ": " + cars.get(i));
        else System.out.println("There are no cars in the list.");
    }

    public void viewSetOfExclusiveCars (Set<Car> exclusiveCars)
    {
        if (exclusiveCars.size() > 0)
            for (Car aCar : exclusiveCars)
                System.out.println(aCar);
        else System.out.println("There are no exclusive cars in the list.");
    }

    public void viewQueueOfCarsWithoutOwners (Queue<Car> carsWithoutOwners)
    {
        if (carsWithoutOwners.size() > 0)
            for (Car aCar : carsWithoutOwners)
                System.out.println(aCar);
        else System.out.println("There are no cars without owners in the list.");
    }

    public void viewMapOfRarities(Map<String,Car> rarities)
    {
        if (rarities.size() > 0)
            for (Map.Entry<String,Car> entry: rarities.entrySet())
                System.out.println("ID = " + entry.getKey() + "; " + entry.getValue());
    }

    public  void addNewCar(List<Car> cars, Set<Car> exclusiveCars, Queue<Car> carsWithoutOwners, Map<String,Car> rarities)
    {
        Scanner in = new Scanner(System.in);
        Car car = new Car();

        System.out.println("Please enter the brand:");
        car.setBrand(in.next());

        System.out.println("Please enter the model:");
        car.setModel(in.next());

        // Entering the year of production:
        boolean bError = true;
        do
        {
            System.out.println("Please enter the year of production:");
            Scanner ss = new Scanner(System.in);
            try {
                car.setYearOfProduction(ss.nextInt());
                bError = false;
            } catch (InputMismatchException e) {
                System.out.println("You did not enter an integer, please enter an integer value.");
            }
        } while (bError);

        // Entering the colour:
        int colourChoice = 1;
        bError = true;
        do {
            do {
                System.out.println("Please choose the colour. Enter 1 for RED, 2 for GREEN, 3 for BLUE, 4 for YELLOW, 5 for GREY, 6 for BLACK, 7 for BROWN, 8 for WHITE:");
                Scanner ss = new Scanner(System.in);
                try {
                    colourChoice = ss.nextInt();
                    bError = false;
                } catch (InputMismatchException e) {
                    System.out.println("You did not enter an integer, please enter an integer value.");
                }
            } while (bError);
        } while ((colourChoice != 1)
                && (colourChoice != 2)
                && (colourChoice != 3)
                && (colourChoice != 4)
                && (colourChoice != 5)
                && (colourChoice != 6)
                && (colourChoice != 7)
                && (colourChoice != 8));

        switch (colourChoice)
        {
            case 1:
                car.setColour(Colour.RED);
                break;
            case 2:
                car.setColour(Colour.GREEN);
                break;
            case 3:
                car.setColour(Colour.BLUE);
                break;
            case 4:
                car.setColour(Colour.YELLOW);
                break;
            case 5:
                car.setColour(Colour.GREY);
                break;
            case 6:
                car.setColour(Colour.BLACK);
                break;
            case 7:
                car.setColour(Colour.BROWN);
                break;
            case 8:
                car.setColour(Colour.WHITE);
                break;
            default:
                car.setColour(Colour.RED);
        }

        // Entering the state:
        int stateChoice = 1;
        bError = true;
        do {
            do {
                System.out.println("Please choose the state. Enter 1 for NEW, 2 for USED:");
                Scanner ss = new Scanner(System.in);
                try {
                    stateChoice = ss.nextInt();
                    bError = false;
                } catch (InputMismatchException e) {
                    System.out.println("You did not enter an integer, please enter an integer value.");
                }
            } while (bError);
        } while ((stateChoice != 1) && (stateChoice != 2));

        switch (stateChoice) {
            case 1:
                car.setState(State.NEW);
                break;
            case 2:
                car.setState(State.USED);
                break;
            default:
                car.setState(State.NEW);
        }

        System.out.println("Please enter the owner name. If there is no owner, enter n:");
        car.setOwner(in.next());

        // Entering the exclusivity:
        bError = true;
        int exclusivityChoice = 0;
        do {
            do {
                System.out.println("Please enter whether the car is exclusive. 1 - YES, 2 - NO");
                Scanner ss = new Scanner(System.in);
                try {
                    exclusivityChoice = ss.nextInt();
                    bError = false;
                } catch (InputMismatchException e) {
                    System.out.println("You did not enter an integer, please enter an integer value.");
                }
            } while (bError);
        } while ((exclusivityChoice != 1) && (exclusivityChoice != 2));
        car.setIsExclusive(exclusivityChoice);

        Date date = new Date();

        // Adding a car to the collections:
        cars.add(car);
        if (car.getIsExclusive() == 1)
            exclusiveCars.add(car);
        if (car.getOwner().equals("n"))
            carsWithoutOwners.add(car);
        if (car.getYearOfProduction() < 1950)
            rarities.put(date.toString(), car);

        System.out.println("The car has been added successfully.");
    }
    public void deleteCar (List<Car> cars, Set<Car> exclusiveCars, Queue<Car> carsWithoutOwners, Map<String,Car> rarities)
    {
        int choice = 0;
        boolean bError = true;

        if (cars.size() > 0)
        {
            this.viewListOfCars(cars);
            do {
                do {
                    System.out.println("Which car do you want to delete? Please enter its index:");
                    Scanner ss = new Scanner(System.in);
                    try {
                        choice = ss.nextInt();
                        bError = false;
                    } catch (InputMismatchException e) {
                        System.out.println("You did not enter an integer, please enter an integer value.");
                    }
                } while (bError);
            } while ((choice < 0) || (choice >= cars.size()));

            // Deleting the car from the collections
            UtilHelper util = new UtilHelper();

            if (exclusiveCars.contains(cars.get(choice)))
                exclusiveCars.remove(cars.get(choice));
            if (carsWithoutOwners.contains(cars.get(choice)))
                carsWithoutOwners.remove(cars.get(choice));
            if (rarities.containsValue(cars.get(choice)))
              rarities.remove(util.getKeyByValue(rarities, cars.get(choice)));
            cars.remove(choice);

            System.out.println("The car with index " + choice + " was removed successfully.");
        }
        else System.out.println("There are no cars to remove.");
    }
}
