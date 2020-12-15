import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Day12 {
    private final static List<SimpleImmutableEntry<Character, Integer>> inputs = new ArrayList<>();
    private final static String filename = "inputs\\day12.txt";
    private final static List<SimpleImmutableEntry<Character, Integer>> miniIn = Arrays.asList(new SimpleImmutableEntry<>('F', 10), new SimpleImmutableEntry<>('N', 3), new SimpleImmutableEntry<>('F', 7), new SimpleImmutableEntry<>('R', 90), new SimpleImmutableEntry<>('F', 11));

    static {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.map(s -> new SimpleImmutableEntry<>(
                    s.charAt(0),
                    Integer.parseInt(s.substring(1)))
            ).forEach(inputs::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int adaptRot(char c, int deg) {
        if (c == 'R') {
            return 360 - deg;
        }
        return deg;
    }

    private static int solvePt1(V position, V dir){
        for (SimpleImmutableEntry<Character, Integer> currUpdate : inputs) {
            int val = currUpdate.getValue();
            switch (currUpdate.getKey()) {
                case 'R':
                case 'L':
                    dir.rot(adaptRot(currUpdate.getKey(), val));
                    break;
                case 'F':
                    V temp = new V(dir.x, dir.y);
                    temp.mult(val);
                    position.sum(temp);
                    break;
                default:
                    V tmp = new V(currUpdate.getKey());
                    tmp.mult(val);
                    position.sum(tmp);
            }
        }
        return position.taxicab();
    }

    private static int solvePt2(V position, V waypoint){
        // todo: implement this method
        for (SimpleImmutableEntry<Character, Integer> currUpdate : inputs) {
            int val = currUpdate.getValue();
            char key = currUpdate.getKey();
            switch (key) {
                case 'R':
                case 'L':
                case 'F':
                default:
            }
        }
        return position.taxicab();
    }


    public static void main(String[] args) {
        V position = new V(0, 0);
        V waypoint = new V(10, 1);
        V dir = new V('E');

        System.out.println("Pt1: " + solvePt1(position, dir));
        System.out.println("Pt1: " + solvePt2(position, waypoint));
    }

    private static class V {
        public int x;
        public int y;

        public V(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public V(char c) {
            switch (c) {
                case 'N': this.x = 0; this.y = 1; break;
                case 'E': this.x = 1; this.y = 0; break;
                case 'S': this.x = 0; this.y = -1; break;
                case 'W': this.x = -1; this.y = 0; break;
                default: throw new IllegalStateException("Unexpected value: " + c);
            }
        }

        public void mult(int z) {
            this.x = this.x * z;
            this.y = this.y * z;
        }

        public void mult(V z) {
            this.x = this.x * z.x;
            this.y = this.y * z.y;
        }

        public void sum(V other) {
            this.x += other.x;
            this.y += other.y;
        }

        public void rot(int deg) {
            for (int i = 0; i < deg / 90; i++) {
                int temp = this.x;
                this.x = -this.y;
                this.y = temp;
            }
        }

        public int taxicab() {
            return Math.abs(x) + Math.abs(y);
        }
    }

}
