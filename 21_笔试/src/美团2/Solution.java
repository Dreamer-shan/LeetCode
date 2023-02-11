package 美团2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String edge = sc.nextLine();
            if (n - 1 == m){
                if(n == 1 || n == 2){
                    System.out.println("Yes");
                    continue;
                }
            }
            Set<Integer> hashset = new HashSet<>();
            String[] split = edge.split("]\\[");
            for (int i = 0; i < split.length-1; i++) {
                String[] split_item = split[i].split(", ");
                hashset.add(Integer.valueOf(split_item[0]));
                hashset.add(Integer.valueOf(split_item[1]));
            }

        }

    }
}
