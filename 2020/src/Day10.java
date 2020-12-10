import java.util.*;
import java.util.stream.Collectors;

public class Day10 {
    private final static List<Integer> intList = Arrays.asList(118, 14, 98, 154, 71, 127, 38, 50, 36, 132, 66, 121, 65, 26, 119, 46, 2, 140, 95, 133, 15, 40, 32, 137, 45, 155, 156, 97, 145, 44, 153, 96, 104, 58, 149, 75, 72, 57, 76, 56, 143, 11, 138, 37, 9, 82, 62, 17, 88, 33, 5, 10, 134, 114, 23, 111, 81, 21, 103, 126, 18, 8, 43, 108, 120, 16, 146, 110, 144, 124, 67, 79, 59, 89, 87, 131, 80, 139, 31, 115, 107, 53, 68, 130, 101, 22, 125, 83, 92, 30, 39, 102, 47, 109, 152, 1, 29, 86);
    private final static Set<Integer> inputs = new HashSet<>(intList);

    public static void main(String[] args) {
        int currJolt = 0;
        int plusOne = 0;
        int plusThree = 0;

        while(!inputs.isEmpty()){
            if(inputs.contains(currJolt + 1)){
                inputs.remove(currJolt + 1);
                plusOne++;
                currJolt += 1;
            }else if (inputs.contains(currJolt + 2)){
                inputs.remove(currJolt + 2);
                currJolt += 2;
            }else if (inputs.contains(currJolt + 3)){
                inputs.remove(currJolt + 3);
                plusThree++;
                currJolt += 3;
            } else {
                System.out.println("COULD NOT FIND ADAPTER FOR: " + currJolt);
            }
        }
        // because our max jolts are 3 + the highest adapter we have, to get
        // the correct number of jolts we need to add one more 3-jolt jump
        plusThree++;

        System.out.println("Pt1: " + (plusOne * plusThree));
    }
}
