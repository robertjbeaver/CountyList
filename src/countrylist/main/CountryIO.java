package countrylist.main;

import java.util.ArrayList;
import java.io.*;

public class CountryIO {

    private File countriesFile = null;

    public CountryIO() {
        countriesFile = new File("countries.txt");
        this.checkFile();
    }

    public ArrayList<String> getCountries() {
        try (BufferedReader in = new BufferedReader(
                    new FileReader(countriesFile))) {

            ArrayList<String> countries = new ArrayList<>();

            // read each line in the file
            String country = in.readLine();
            while (country != null) {
                countries.add(country);
                country = in.readLine();
            }
            return countries;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        } 
    }

    public boolean saveCountries(ArrayList<String> countries) {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(countriesFile)))) {
            for (String country : countries) {
                out.println(country);
            }
            return true;
        } catch (IOException e) {
            System.err.println(e);
            return false;
        }
    }

    // a private method that creates a blank file if the file doesn't already exist
    private void checkFile() {
        try {
            if (!countriesFile.exists()) {
                countriesFile.createNewFile();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}