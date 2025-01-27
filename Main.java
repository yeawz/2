public class Main {

    public static void main(String[] args) {
       Car[] cars = {
           new Car(1, "Toyota", "Camry", 2022, "Red", .4560000, "ET123C"),
           new Car(2, "Honda", "Civic", 2021, "Blue", 220000.0, "EH456E"),
           new Car(3, "Toyota", "Corolla", 2023, "Silver", .654000, "EC789K"),
           new Car(4, "Nissan", "Altima", 2022, "Black", .380000, "MB012OP")
      };

       String searchBrand = "Toyota";
      Car[] toyotaCars = getCarByBrend(cars, searchBrand);

       if(toyotaCars.length == 0){
        System.out.println("No cars of brand '" + searchBrand + "' found.");
      } else {
        System.out.println("Cars of brand '" + searchBrand + "':");
       for (Car car : toyotaCars) {
          System.out.println(car);
       }
     }

      String searchBrand2 = "BMW";
    Car[] bmwCars = getCarByBrend(cars, searchBrand2);

    if(bmwCars.length == 0){
      System.out.println("No cars of brand '" + searchBrand2 + "' found.");
    } else {
      System.out.println("Cars of brand '" + searchBrand2 + "':");
      for (Car car : bmwCars) {
        System.out.println(car);
    }
  }
}


 public static Car[] getCarByBrend(Car[] cars, String brand) {
   if (cars == null || cars.length == 0 || brand == null || brand.isEmpty()) {
       return new Car[0]; // Возвращаем пустой массив, если входные данные некорректны
     }

    int count = 0;
    for (Car car : cars) {
      if (car != null && brand.equals(car.getBrand())) {
        count++;
     }
   }

    Car[] result = new Car[count];
    int index = 0;
    for (Car car : cars) {
       if (car != null && brand.equals(car.getBrand())) {
        result[index++] = car;
        }
   }
   return result;
  }
}