import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class Main {
  private static ArrayList<String> cities = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    fillCities();
    gameLoop();
  }

  private static void gameLoop() {
    String lastComputerCity = ""; 
    
    while (true) {
        String input = scanner.nextLine();

        if (input.equals("exit")) {
            System.out.println("It was fun! Thanks");
          System.out.println("Now you know more cities.");
            System.exit(0);
        }
      
         // Checking if the city was added is in the list
      boolean isCorrectCity = false;
for(String city: cities)  {
  if (city.equalsIgnoreCase(input)) {
    isCorrectCity = true;
    break;
  }
}
      if (!isCorrectCity) {
        System.out.println("This city doesn´t exist in the database. Try another city");
        continue;
      }
      
        // Checking if we add a word with the correct first letter
        if (!lastComputerCity.isEmpty()) {
            char lastComputerCityChar = lastComputerCity.charAt(lastComputerCity.length() - 1);
            char firstInputChar = input.charAt(0);

            if (Character.toLowerCase(lastComputerCityChar) != Character.toLowerCase(firstInputChar)) {
                System.out.println("You added a word with the wrong first letter");
                continue;
            }
        }

        char lastChar = input.charAt(input.length() - 1);
      lastComputerCity = getRandomCity(lastChar);
      System.out.println("My city: " + lastComputerCity);

        }
    }


  private static String getRandomCity(char firstChar) {
    List<String> properCities = new ArrayList<>();
    for(String city: cities) {
      if (Character.toLowerCase(city.charAt(0)) == Character.toLowerCase(firstChar)) {
        properCities.add(city);
      }
    }
    Random random = new Random();
    int index = random.nextInt(properCities.size());
    return properCities.get(index);
  }

  private static void fillCities() {
   List<String> allCities = Arrays.asList("Paris",
"Tokyo",
"London",
"Sydney",
"New York",
"Rio de Janeiro",
"Cairo",
"Mumbai",
"Los Angeles",
"Toronto",
"Beijing",
"Amsterdam",
"Istanbul",
"Buenos Aires",
"Dubai",
"Berlin",
"Seoul",
"New Delhi",
"Rome",
"Jakarta",
"San Francisco",
"Bangkok",
"Prague",
"Athens",
"Nairobi",
"Mexico City",
"Auckland",
"Vancouver",
"Chicago",
"Kuala Lumpur",
 "Stockholm",
"Lisbon",
"Helsinki",
"Oslo",
"Budapest",
"Warsaw",
"Vienna",
"Madrid",
"Brussels",
"Copenhagen",
"Dublin",
"Zurich",
"Edinburgh",
"Geneva",
"Osaka",
"Montreal",
"Munich",
"Barcelona",
"Hamburg",
"Milan"
);
    cities.addAll(allCities);
  
  }
}