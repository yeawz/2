import java.time.Year;
public class Main {
    
    public static void main(String[] args) {
        Car[] cars = {
                new Car(1, "Toyota", "Camry", 2022, "Red", 6468770.0, "CC123C"),
                new Car(2, "Honda", "Civic", 2018, "Blue", 22688000.0, "EE456E"),
                new Car(3, "Toyota", "Corolla", 2020, "Silver", 16723000.0, "MM789M"),
                new Car(4, "Nissan", "Altima", 2019, "Black", 1987510.0, "PP012P"),
                new Car(5, "Toyota", "RAV4", 2015, "White", 87876700.0, "TT345T")
        };

        String searchBrand = "Toyota";
        int operationalYears = 3;

        Car[] filteredCars = getCarByBrendAndYearOperational(cars, searchBrand, operationalYears);

        if (filteredCars.length == 0) {
            System.out.println("No cars of brand '" + searchBrand + "' operational more than " + operationalYears + " years were found.");
        } else {
            System.out.println("Cars of brand '" + searchBrand + "' operational more than " + operationalYears + " years:");
            for(Car car: filteredCars) {
                System.out.println(car);
            }
        }

        String searchBrand2 = "Honda";
        int operationalYears2 = 5;

        Car[] filteredCars2 = getCarByBrendAndYearOperational(cars, searchBrand2, operationalYears2);

        if (filteredCars2.length == 0) {
            System.out.println("No cars of brand '" + searchBrand2 + "' operational more than " + operationalYears2 + " years were found.");
        } else {
            System.out.println("Cars of brand '" + searchBrand2 + "' operational more than " + operationalYears2 + " years:");
            for(Car car: filteredCars2) {
                System.out.println(car);
            }
        }
    }

    public static Car[] getCarByBrendAndYearOperational(Car[] cars, String brand, int years) {
        if (cars == null || cars.length == 0 || brand == null || brand.isEmpty() || years < 0) {
            return new Car[0];  // Возвращаем пустой массив в случае некорректных входных данных
        }

        int currentYear = Year.now().getValue();
        int count = 0;
        for(Car car : cars) {
            if (car != null && brand.equals(car.getBrand()) && (currentYear - car.getYear()) > years) {
                count++;
            }
        }

        Car[] result = new Car[count];
        int index = 0;
        for (Car car : cars) {
            if (car != null && brand.equals(car.getBrand()) && (currentYear - car.getYear()) > years) {
                result[index++] = car;
            }
        }
        return result;
    }
}