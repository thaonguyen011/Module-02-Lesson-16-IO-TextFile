import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static void main(String[] args) {
        CSVReader example = new CSVReader();
        String filePath = "/Users/apple/Desktop/Codegym /Module-02-Java/16-IO-TextFile/Practice-Execise/src/countries.txt";

        example.csvReader(filePath);
    }

    public void csvReader(String filePath) {

        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                System.out.println("Country [id= " + temp[0] + ",code= " + temp[1] + ", name= " + temp[2]+"]");
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File not exist or error content");
        }
    }
}