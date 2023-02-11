package Q4;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShellExample {

    public static void main(String[] args) throws IOException {
        //cat命令，相当于是读取文件中的所有行，并输出
        File file = new File("E:\\basic-code\\Leetcode\\23_面试需要准备的代码\\src\\Q4\\a.txt");
//        File file = new File("a.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            lines.add(str);
        }
        System.out.println(lines);
        //grep a，相当于filter
        lines = lines.stream().filter(s -> s.contains("a")).collect(Collectors.toList());

        //sort 按照字典序从小到大排序
        lines = lines.stream().sorted().collect(Collectors.toList());

        //uniq -c，统计相同的元素的个数
        Map<String, Long> integerMap =
                lines.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //sort -rn，排序后逆序输出
        List<Long> res = integerMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        res.forEach(System.out::println);
    }

}