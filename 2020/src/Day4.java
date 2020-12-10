import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {
    private final static String filename = "inputs\\day4.txt";

    public static void main(String[] args) throws IOException {
        int counterP1 = 0;
        int counterP2 = 0;
        List<Map<String, String>> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            StringBuilder linePassport = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    String[] splitted = linePassport.toString().trim().split(" ");
                    Map<String, String> m = new HashMap<>();
                    for (String s : splitted) {
                        String[] keyvalue = s.split(":");
                        m.put(keyvalue[0].trim(), keyvalue[1].trim());
                    }
                    list.add(m);
                    linePassport = new StringBuilder();
                } else {
                    linePassport.append(" ").append(line);
                }
            }
        }

        for (Map<String, String> m : list) {
            if (m.containsKey("byr")
                    && m.containsKey("iyr")
                    && m.containsKey("eyr")
                    && m.containsKey("hgt")
                    && m.containsKey("hcl")
                    && m.containsKey("ecl")
                    && m.containsKey("pid")) {
                counterP1++;
                String byrS = m.get("byr");
                String iyrS = m.get("iyr");
                String eyrS = m.get("eyr");
                String hgtS = m.get("hgt");
                String hclS = m.get("hcl");
                String eclS = m.get("ecl");
                String pidS = m.get("pid");

                boolean isValid = true;
                try {
                    int byr = Integer.parseInt(byrS);
                    int iyr = Integer.parseInt(iyrS);
                    int eyr = Integer.parseInt(eyrS);
                    if (byr < 1920 || byr > 2002) isValid = false;
                    if (iyr < 2010 || iyr > 2020) isValid = false;
                    if (eyr < 2020 || eyr > 2030) isValid = false;
                    if (hgtS.matches("\\d+(cm|in)")) {
                        int hgt = Integer.parseInt(hgtS.substring(0, hgtS.length() - 2));
                        if (hgtS.endsWith("cm") && (hgt < 150 || hgt > 193)) {
                            isValid = false;
                        } else if (hgtS.endsWith("in") && (hgt < 59 || hgt > 76)) {
                            isValid = false;
                        }
                    } else isValid = false;
                    if (!hclS.matches("#[0-9a-f]{6}")) isValid = false;
                    switch (eclS) {
                        case "amb":
                        case "blu":
                        case "brn":
                        case "gry":
                        case "grn":
                        case "hzl":
                        case "oth":
                            break;
                        default:
                            isValid = false;
                    }
                    for (Character c : pidS.toCharArray()) {
                        if (!Character.isDigit(c) || pidS.length() != 9) {
                            isValid = false;
                        }
                    }
                } catch (Exception e) {
                    isValid = false;
                }
                if (isValid) counterP2++;
            }
        }
        System.out.println("P1: " + counterP1);
        System.out.println("P2: " + counterP2);
    }
}
