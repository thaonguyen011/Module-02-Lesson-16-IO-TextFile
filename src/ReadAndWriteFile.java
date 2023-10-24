import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();

        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File not exist or error content");
            System.out.println(e.getMessage());
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer= new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("\nMax value is " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax (List<Integer> numbers) {
        int max = numbers.get(0);

        for (Integer i : numbers) {
            if (i > max) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        String filePath = "/Users/apple/Desktop/Codegym /Module-02-Java/16-IO-TextFile/Practice-Execise/src/numbers.txt";
        ReadAndWriteFile readFileExample = new ReadAndWriteFile();
        List<Integer> numbers = readFileExample.readFile(filePath);
        int max = ReadAndWriteFile.findMax(numbers);
        readFileExample.writeFile(filePath, max);
    }

}
