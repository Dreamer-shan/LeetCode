package Q4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Shell_1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入linux命令，输入-1结束");
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("-1")) break;
            int count = 0;
            String[] linuxOrder = str.split(" ");
//            System.out.println(Arrays.toString(linuxOrder));
            File file = new File("E:\\basic-code\\Leetcode\\23_面试需要准备的代码\\src\\Q4\\a.txt");
//        File file = new File("a.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> allLine = new ArrayList<>();
            List<String> grepLine = new ArrayList<>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                count++;
                allLine.add(line);
            }
            if ("cat".equals(linuxOrder[0]) && !Arrays.toString(linuxOrder).contains("grep")) {
                //cat命令，相当于是读取文件中的所有行，并输出
//                System.out.println(allLine);
                allLine.forEach(System.out::println);
            } else if ("wc".equals(linuxOrder[0])) {
                System.out.println(count);
            }
//            System.out.println(Arrays.toString(linuxOrder));
            if (Arrays.toString(linuxOrder).contains("grep")) {
                int grepIndex = 0;
                for (int i = 0; i < linuxOrder.length; i++) {
                    if (linuxOrder[i].equals("grep")) {
                        grepIndex = i + 1;
                    }
                }
                int finalGrepIndex = grepIndex;
//                Object[] grepContent = allLine.stream().filter(x -> x.contains(linuxOrder[finalGrepIndex])).toArray();
                List<String> grepContent = allLine.stream().filter(x -> x.contains(linuxOrder[finalGrepIndex])).collect(Collectors.toList());
                if (Arrays.toString(linuxOrder).contains("wc")) {
                    System.out.println(grepContent.size());
                }else {
                    grepContent.forEach(System.out::println);
                }
            }
        }

    }
}

