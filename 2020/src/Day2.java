import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    private final static String filename = "inputs\\day2.txt";

    public static void main(String[] args) throws IOException {
        int counterP1 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(": | |-");
                int lowerBound = Integer.parseInt(splitted[0]);
                int upperBound = Integer.parseInt(splitted[1]);
                String chr = splitted[2];
                String pswd = splitted[3];

                int localCounter = 0;
                if ((pswd.charAt(lowerBound - 1) + "").equals(chr)) {
                    localCounter++;
                }
                if ((pswd.charAt(upperBound - 1) + "").equals(chr)) {
                    localCounter++;
                }
                if (localCounter == 1) {
                    counterP1++;
                }
            }
        }
        System.out.println(counterP1);
    }
}
