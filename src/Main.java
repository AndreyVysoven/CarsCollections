import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Andrey on 13.08.2014.
 */
public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        Class clazz = car.getClass();

        if (clazz.isAnnotationPresent(GetCarState.class))
            System.out.println("Annotation is present.");
        for (Method method : clazz.getMethods())
            if (method.isAnnotationPresent(GetCarState.class))
                System.out.println("There is annotation");
            else System.out.println("There are no method annotations");

        // Collections variables declaration
        List<Car> cars = new ArrayList<Car>();
        Set<Car> exclusiveCars = new HashSet<Car>();
        Queue<Car> carsWithoutOwners = new LinkedList<Car>();
        Map<String,Car> rarities = new HashMap<String,Car>();

        Shop shop = new Shop();
        int globalChoice = 0, choice = 0;
        boolean bError = true;

        // Making global choice
        do {
            // Making choice
            do
            {
                System.out.println("Please make your choice:");
                System.out.println("Choose 1 for viewing list of cars:");
                System.out.println("Choose 2 for viewing list of exclusive cars:");
                System.out.println("Choose 3 for viewing list of cars without owners:");
                System.out.println("Choose 4 for adding a new car:");
                System.out.println("Choose 5 for deleting the car:");
                System.out.println("Choose 6 for viewing rarities:");
                System.out.println("Choose 7 for viewing sorted by year of production list of cars:");
                System.out.println("Choose 8 for viewing list of cars sorted by brand:");

                Scanner ss = new Scanner(System.in);
                try {
                    choice = ss.nextInt();
                    bError = false;
                } catch (InputMismatchException e) {
                    System.out.println("You did not enter an integer, please enter an integer value.");
                }
            } while (bError);

            // Choice processing
            switch (choice)
            {
                case 1:
                     System.out.println("This is a list of cars:");
                     shop.viewListOfCars(cars);
                     break;
                case 2:
                     System.out.println("This is a list of exclusive cars:");
                     shop.viewSetOfExclusiveCars(exclusiveCars);
                     break;
                case 3:
                     System.out.println("This is a list of cars without owners:");
                     shop.viewQueueOfCarsWithoutOwners(carsWithoutOwners);
                     break;
                case 4:
                     System.out.println("Please add a new car:");
                     shop.addNewCar(cars, exclusiveCars, carsWithoutOwners,rarities);
                     break;
                case 5:
                     System.out.println("Please delete the car:");
                     shop.deleteCar(cars, exclusiveCars, carsWithoutOwners, rarities);
                     break;
                case 6:
                     System.out.println("This is the list of rarities:");
                     shop.viewMapOfRarities(rarities);
                     break;
                case 7:
                     System.out.println("This is a list of cars sorted by year of production:");
                     Collections.sort(cars); // Comparable has been used
                     shop.viewListOfCars(cars);
                     break;
                case 8:
                     System.out.println("This is a list of cars sorted by brand:");
                     Collections.sort(cars, Car.BrandComparator); // Comparator has been used
                     shop.viewListOfCars(cars);
                     break;
                default:
                     System.out.println("Default action.");
            }

            bError = true;
            do {
                System.out.println("Do you want to continue? To continue press 1, to exit press 0:");
                Scanner ss = new Scanner(System.in);
                try {
                    globalChoice = ss.nextInt();
                    bError = false;
                } catch (InputMismatchException e) {
                    System.out.println("You did not enter an integer, please enter an integer value.");
                }
            } while (bError);
        } while (globalChoice == 1);
    }
}
