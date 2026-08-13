import java.util.*;

class HashIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tableSize = sc.nextInt();
        int key = sc.nextInt();

        int index = key % tableSize;

        System.out.println(index);
    }
}