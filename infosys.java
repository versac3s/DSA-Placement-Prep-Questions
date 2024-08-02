import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
public class infosys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial experience points (e): ");
        int e = sc.nextInt();

        // Take input from user for power array
        System.out.print("Enter the number of elements for power array: ");
        int powerLength = sc.nextInt();
        int[] power = new int[powerLength];
        System.out.println("Enter the elements for power array:");
        for (int i = 0; i < powerLength; i++) {
            power[i] = sc.nextInt();
        }

        // Take input from user for bonus array
        System.out.print("Enter the number of elements for bonus array: ");
        int bonusLength = sc.nextInt();
        int[] bonus = new int[bonusLength];
        System.out.println("Enter the elements for bonus array:");
        for (int i = 0; i < bonusLength; i++) {
            bonus[i] = sc.nextInt();
        }
        int monster_count=0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        // Populate the TreeMap with power as key and bonus as value
        for (int i = 0; i < power.length; i++) {
            tm.put(power[i], bonus[i]);
        }

        // Iterate through the TreeMap in ascending order of keys (power)
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            int monsterPower = entry.getKey();
            int monsterBonus = entry.getValue();

            // Check if we have enough experience to defeat the monster
            if (e >= monsterPower) {
                monster_count++;
                e += monsterBonus; 
            } else {
                System.out.println("Game Over");
                break;  
            }
        }

        System.out.println("Number of monsters killed = " + monster_count);
    }
}
