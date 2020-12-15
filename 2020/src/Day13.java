import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day13 {
    private static int targetTime;
    private static final List<String> shuttle = new ArrayList<>();
    private final static String filename = "inputs\\day13.txt";

    static {
        try {
            List<String> a = Files.readAllLines(Path.of(filename));
            targetTime = Integer.parseInt(a.get(0));
            for(String x : a.get(1).split(",")){
                if(x.isEmpty()) continue;
                shuttle.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for(String s : shuttle){
            int i = 0;

            try { i = Integer.parseInt(s); }
            catch (NumberFormatException e){ continue; }

            int reminder = targetTime % i;
            int arrival = -reminder + i;
            map.put(arrival, i);
        }
        int minWaiting = Collections.min(map.keySet());
        int minBus = map.get(minWaiting);

        System.out.println("Pt1: " + (minBus*minWaiting));
    }


}
