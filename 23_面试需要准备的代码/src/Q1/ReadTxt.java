package Q1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadTxt {

    public static void main(String args[]) {
        readFile();
//        writeFile();
    }

    /**
     * 读入TXT文件
     */
    public static void readFile() {
//        String pathname = "access.log"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
//        String pathname = "E:\\basic-code\\Leetcode\\23_面试需要准备的代码\\src\\Q1\\access.log"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        String pathname = "C:\\Users\\Shan\\Desktop\\attachments\\Question 1\\access.log"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
//        String pathname = "access.log"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            int count = 0;
            int getCount = 0;
            int postCount = 0;
            Map<String,Integer> countMap = new TreeMap<>((o1,o2)->o1.compareTo(o2));
            Map<String, ArrayList<String>> classMap = new HashMap<>();
            ArrayList<String> temp = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                count += 1;
                if ("GET ".equals(line.substring(0,4))){
                    getCount += 1;
                }else if ("POST ".equals(line.substring(0,5))){
                    postCount += 1;
                }
                StringBuilder sb = new StringBuilder();
                String[] line1 = line.split("\\?");
                List<String> message = Arrays.asList(line1);
                if (!countMap.containsKey(message.get(0))){
                    countMap.put(message.get(0), 1);
                }else {
                    countMap.put(message.get(0),countMap.get(message.get(0)) + 1 );
                }
                String lineCopy = line;
                String[] line2 = lineCopy.split("/");

                if (classMap.containsKey(line2[1])){
                    classMap.get(line2[1]).add(lineCopy);
                }else {
                    classMap.put(line2[1], new ArrayList<String>(Collections.singleton(lineCopy)));
                }
//                classMap.put(line2[1], temp);

            }
            System.out.println("getCount = " + getCount);
            System.out.println("postCount = " + postCount);
            // 有两个请求是HEAD
            System.out.println("count = " + count);
            System.out.println("*************************");
//            for (String key : countMap.keySet()) {
//                System.out.println("接口: " + key + " 数量为: " + countMap.get(key));
//            }
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(countMap.entrySet());
            Collections.sort(entries, (o1, o2) -> (o2.getValue() - o1.getValue()));
            Iterator<Map.Entry<String, Integer>> it = entries.iterator();
            for (int i = 0; i < 10 && it.hasNext(); i++) {
                System.out.println(it.next().getKey()+ " --- " + it.next().getValue());
            }
            System.out.println("*************************");
            // 每个种类的数量
            int classCount = 0;
            for (String key : classMap.keySet()) {
                classCount += classMap.get(key).size();
                System.out.println("URI种类: " + key + " 包含的URI: " + classMap.get(key).size());
            }
            System.out.println(classCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入TXT文件
     */
//    public static void writeFile() {
//        try {
//            File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
//            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
//            try (FileWriter writer = new FileWriter(writeName);
//                 BufferedWriter out = new BufferedWriter(writer)
//            ) {
//                out.write("我会写入文件啦1\r\n"); // \r\n即为换行
//                out.write("我会写入文件啦2\r\n"); // \r\n即为换行
//                out.flush(); // 把缓存区内容压入文件
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}


