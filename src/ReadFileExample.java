import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileExample(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }

            br.close();
            System.out.println("Sum = " + sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println("File not exist or error content");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter file path: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        ReadFileExample readfileEx = new ReadFileExample();
        readfileEx.readFileExample(filePath);
    }
}
