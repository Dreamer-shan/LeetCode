package Q2;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {
    //统计行数
    static int count;

    private static void start() {
        //指定读取文件的路径
        File file = new File("C:\\Users\\Shan\\Desktop\\attachments\\Question 2");
        /**
         * 读取总行数：对指定文件进行读取,匹配的方式是换行
         */
        getPath(file, "\\n");
        int totalLine = count;
        count = 0;
        /**
         * 读取空白行数：对指定文件进行读取,匹配的方式是
         * 在上一个换行之后和下一个换行之间都是空白的。
         */
        getPath(file, "\\n\\s*\\n");
        int spaceLine = count;
        count = 0;
        /**
         * 读取注释行数：对指定文件进行读取,
         * 匹配的方式是在两个换行之间都是注释
         */
        getPath(file, "\\n\\s*(/\\*|//|\\*|\\*/).*\\n");
        int annotationLine = count;
        System.out.println("总行数:" + totalLine);
        System.out.println("空行数:" + spaceLine);
        System.out.println("注释行数:" + annotationLine);
        System.out.println("代码行数:"
                + (totalLine - spaceLine - annotationLine));
    }

    public static void getPath(File file, String regex) {
        File[] files = file.listFiles();
        if (Objects.nonNull(files)) {
            for (File f : files) {
                if (f.isDirectory()) {
                    getPath(f, regex);
                }
                if (f.isFile() && f.getAbsolutePath().endsWith(".java")) {
                    deal(readFile(f.getAbsolutePath()), regex);
                }
            }
        }
    }

    public static String readFile(String path) {
//StringBuffer用于字符串拼接
        StringBuffer content = new StringBuffer();
//读取文件的地址（源头）
        File file = new File(path);
/**
 * try with语句(JDK7新增)：可以自动关闭资源（要实现Closeable接口）
 * 因为读取的是纯文本，选择文件字符流是FileReader
 * BufferedReader是字符缓冲流，提高读取的性能
 */
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //定义一个字符串临时存储读取的数据
            String line = "";
            //读取一行数据存储到line
            while ((line = br.readLine()) != null) {
                //保存一行数据
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//StringBuffer转换成String
        return content.toString();
    }

    public static void deal(String s, String regex) {
        //将给定的正则表达式编译为模式。
        Pattern p = Pattern.compile(regex);
        //创建一个匹配器，匹配给定的输入与此模式。
        Matcher m = p.matcher(s);
        //尝试找到匹配模式的输入序列的下一个子序列。
        while (m.find()) {
            count++;
        }
    }
    public static void writeFile(String filename) {
        try {
            File writeName = new File(filename); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {

                out.write("我会写入文件啦1\r\n"); // \r\n即为换行
                out.write("我会写入文件啦2\r\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start();
        writeFile("validLineCount.txt");
    }
}