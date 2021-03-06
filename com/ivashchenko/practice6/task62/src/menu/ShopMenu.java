package menu;

import utils.Reader;
import entity.Car;
import entity.Shop;
import menu.enums.MenuItems;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * This class is used to define car shop menu and handle user input.
 * @version 0.01
 * @author Alex Ivashchenko
 */
public class ShopMenu extends AbstractMenu {
    Shop shop;

    public ShopMenu(Shop shop) {
        this.shop = shop;
    }

    private void printCars(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car);
        }
    }

    private void printCars() {
        printCars(shop.queryAllCars());
    }

    private void queryCarsOfModelOlderThan(){
        String modelName = askForStringInput("Enter model name: ");
        int age = askForIntInput("Enter age: ");

        List<Car> query = shop.queryCarsOfModel(modelName);
        query = shop.queryCarsOlderThan(query, age);
        if (query.isEmpty()) {
            System.out.println("No cars with specified parameters.");
        } else {
            printCars(query);
        }
    }

    private void queryCarsOfYearExpensiveThan() {
        int productionYear = askForIntInput("Enter production year: ");
        int price = askForIntInput("Enter price: ");

        List<Car> query = shop.queryCarsOfProductionYear(productionYear);
        query = shop.queryCarsExpensiveThan(query, price);
        if (query.isEmpty()) {
            System.out.println("No cars with specified parameters.");
        } else {
            printCars(query);
        }
    }

    private void queryCarsSortedByName() {
        List<Car> allCars = shop.queryCarsSortedByManufacturerName();
        printCars(allCars);
    }

    private void queryCarsSortedByPrice() {
        List<Car> allCars = shop.queryCarsSortedByPriceAsc();
        printCars(allCars);
    }

    private void queryCarsSortedByProductionYear() {
        List<Car> allCars = shop.queryCarsSortedByProductionYear();
        printCars(allCars);
    }


    private void readCarsFromFile() {
        String fileName = Reader.askForString("Enter filename: ");
        try {
            shop.readCarsFromFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Your filename is not valid.");
        } catch (ClassNotFoundException e) {
            System.out.println("File has incorrect format.");
        }
    }

    private void writeCarsToFile() {
        String fileName = Reader.askForString("Enter filename: ");
        shop.writeCarsToFile(fileName);
    }

    @Override
    public void printMenu() {
        for (MenuItems item: MenuItems.values()) {
            int index = item.ordinal() + 1;
            String description = item.toString();
            System.out.println(index + ": " + description);
        }
    }

    @Override
    public void handleMenu() {
        MenuItems menuItem = MenuItems.EXIT;
        do {
            printMenu();
            int input = scanner.nextInt();
            if ((input < 0) || (input > MenuItems.values().length)) {
                input = MenuItems.EXIT.ordinal() + 1;
            }

            menuItem = MenuItems.values()[input-1];
            switch (menuItem) {
                case PRINT_CARS:
                    printCars();
                    break;
                case MODEL_AND_OLDER_THAN:
                    queryCarsOfModelOlderThan();
                    break;
                case OF_YEAR_EXPENSIVE_THAN:
                    queryCarsOfYearExpensiveThan();
                    break;
                case SORT_BY_MANUFACTURER:
                    queryCarsSortedByName();
                    break;
                case SORT_BY_PRICE:
                    queryCarsSortedByPrice();
                    break;
                case SORT_BY_PRODUCTION_YEAR:
                    queryCarsSortedByProductionYear();
                    break;
                case WRITE_TO_FILE:
                    writeCarsToFile();
                    break;
                case READ_FROM_FILE:
                    readCarsFromFile();
                    break;
                case EXIT:
                    return;
            }
        } while (true);
    }
}
