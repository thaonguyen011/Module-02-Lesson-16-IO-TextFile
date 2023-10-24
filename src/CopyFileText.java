import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {

    public List<String> readFileText(String sourceFilePath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(sourceFilePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));


            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File not exist or error content");
        }
        return list;
    }

    public void writeFileText (String targetFilePath, List<String> list) {
        try {
            FileWriter writer = new FileWriter(targetFilePath);

            for (String s : list) {
                writer.write(s + "\n");
            }

            writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    public void copyFileText (String sourceFilePath, String targetFilePath) {
        List<String> list = readFileText(sourceFilePath);
        writeFileText(targetFilePath, list);
    }

    public void copyFile(String sourceFilePath, String targetFilePath) {
        try {
            File fileSource = new File(sourceFilePath);
            File fileTarget = new File(targetFilePath);
            if (!fileSource.exists() || !fileTarget.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(fileSource));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTarget));

            String line;

            while ((line = br.readLine()) != null) {
               bw.write(line + "\n");
            }

            br.close();
            bw.close();
        } catch (Exception e) {
            System.err.println("File not exist or error content");
        }
    }

    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        String sourceFilePath = "/Users/apple/Desktop/Codegym /Module-02-Java/16-IO-TextFile/Practice-Execise/src/numbers.txt";
        String targetFilePath = "/Users/apple/Desktop/Codegym /Module-02-Java/16-IO-TextFile/Practice-Execise/src/numbers copy.txt";
        copyFileText.copyFile(sourceFilePath, targetFilePath);
        copyFileText.copyFileText(sourceFilePath, targetFilePath);
    }
}
