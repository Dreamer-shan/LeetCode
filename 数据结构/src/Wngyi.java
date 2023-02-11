/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/07/21:03
 * @Description:
 */


import java.util.*;

public class Wngyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int c = 0; c < T; c++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nodes = new int[n];
            Map<Integer, List<Integer>> hashmap = new HashMap<>();

            for(int i = 0; i < m; i++){
                int CC = sc.nextInt();
                int pre = sc.nextInt() - 1;
                for(int j = 1; j < CC; j++){
                    int number = sc.nextInt() - 1;
                    if(!hashmap.containsKey(pre)){
                        hashmap.put(pre, new ArrayList<>());
                    }
                    hashmap.get(pre).add(number);
                    pre = number;
                    nodes[number] ++;
                }
            }
            boolean flat = false;
            int index = -1;
            for(int i = 0; i < n; i++){
                if(nodes[i] == 0){
                    if(flat){
                        index = -1;
                    }else{
                        flat = true;
                        index = i;
                    }
                }
            }
            if(index == -1) {
                System.out.println("No");
                continue;
            }
            List<Integer> lists = new ArrayList<>();
            while(lists.size() < n - 1){
                flat = false;

                List<Integer> list_item = hashmap.get(index);
                lists.add(index + 1);
                for(int number : list_item){
                    nodes[number] --;
                    if(nodes[number] == 0){
                        if(flat){
                            index = -1;
                            break;
                        }else{
                            flat = true;
                            index = number;
                        }
                    }
                }
                if(index == -1) break;
            }
            if(index == -1) {
                System.out.println("No");
                continue;
            }
            lists.add(index + 1);
            for(int number : lists){
                System.out.print(number);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
