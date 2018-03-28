package countrylist.main;

import java.util.ArrayList;

public class CountriesApp {

    public static void main(String args[]) {
        System.out.println("Country List Manager");
        System.out.println();
        System.out.println("COMMAND MENU");
        System.out.println("1 - List countries");
        System.out.println("2 - Add a country");
        System.out.println("3 - Exit\n");

        CountryIO countriesFile = new CountryIO();

        // continue until the user enters 3
        int menuNumber = 0;
        while (menuNumber != 3) {
            // get input from user
            menuNumber = Console.getInt("Enter menu number: ", 0, 4);
            System.out.println();

            switch (menuNumber) {
                // display countries
                case 1: {
                    ArrayList<String> countries = countriesFile.getCountries();
                    for (int i = 0; i < countries.size(); i++) {
                        String country = countries.get(i);
                        System.out.println(country);
                    }
                    System.out.println();
                    break;
                }
                // add country
                case 2: {
                    ArrayList<String> countries
                            = countriesFile.getCountries();

                    String country = Console.getString("Enter country: ");

                    // add the country to the countries array list
                    countries.add(country);

                    // save the array list and display confirmation message
                    countriesFile.saveCountries(countries);
                    System.out.println("This country has been saved.\n");

                    break;
                }
                case 3: {
                    System.out.println("Goodbye.\n");
                    break;
                }
            }
        }
    }
}