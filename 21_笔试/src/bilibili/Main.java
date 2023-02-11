package bilibili;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/13/19:15
 * @Description:
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public int[] GetLeastNumbers(int[] input, int k) {
        Arrays.sort(input);
        int[] arr = Arrays.copyOfRange(input, 0, k);
        return arr;

    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        int[] _input = new int[_input_size];
        int _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            _input_item = Integer.parseInt(in.nextLine().trim());
            _input[_input_i] = _input_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = new Solution().GetLeastNumbers(_input, _k);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

