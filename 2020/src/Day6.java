import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day6 {
    private final static String input = "res\\day6.txt";
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> currSet = new HashMap<>();
        int count = 0;
        int countPeoplePerGroup = 0;

        for(String s : Files.readAllLines(Paths.get(input))){
            if(s.isBlank()){
                Map<Character, Integer> finalCurrSet = currSet;
                int finalCountPeoplePerGroup = countPeoplePerGroup;
                count += currSet.keySet().stream().filter(c -> finalCurrSet.get(c) == finalCountPeoplePerGroup-1).count();
                currSet = new HashMap<>();
                countPeoplePerGroup = 0;
            } else {
                countPeoplePerGroup++;
                for(Character c : s.toCharArray()) currSet.merge(c, 0, (x, y) -> x + 1);
            }
        }

        System.out.println(count);
    }
}
