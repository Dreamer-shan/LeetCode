package Q2;

import java.io.*;

public class CodeCounter {

    public static long totalCodeCount;
    public static long totalBlackCount;
    public static long totalRemarkCount;

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Shan\\Desktop\\attachments\\Question 2";//统计代码文件目录
        File projectFile = new File(path);
        countDir(projectFile);
        System.out.println("--------------总行数：" + (totalCodeCount + totalBlackCount + totalRemarkCount));
        System.out.println("--------------空行：" + totalBlackCount);
        System.out.println("--------------注释行：" + totalRemarkCount);
        System.out.println("--------------有效代码行：" + totalCodeCount);
        writeFile("E:\\basic-code\\Leetcode\\23_面试需要准备的代码\\src\\Q2\\validLineCount1.txt");

    }

    /**
     *
     * @param file  要统计的文件夹路径
     * @throws IOException
     */
    private static void countDir(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                countDir(files[i]);
            }
        } else {
            parse(file);
        }
    }

    /**
     * 更准确点
     *
     * @param file
     */
    public static void parse(File file) {
        BufferedReader br = null;
        // 判断此行是否为注释行
        boolean comment = false;
        int temp_whiteLines = 0;//空白行数
        int temp_commentLines = 0;//注释行数
        int temp_normalLines = 0; //有效程序行数

        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.matches("^[\\s&&[^\\n]]*$")) {
                    // 空行
                    temp_whiteLines++;
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    // 判断此行为"/*xxx*/"的注释行
                    temp_commentLines++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                    // 判断此行为"/*"开头的注释行
                    temp_commentLines++;
                    comment = true;
                } else if (comment == true && !line.endsWith("*/")) {
                    // 为多行注释中的一行（不是开头和结尾）
                    temp_commentLines++;
                } else if (comment == true && line.endsWith("*/")) {
                    // 为多行注释的结束行
                    temp_commentLines++;
                    comment = false;
                } else if (line.startsWith("//")) {
                    // 单行注释行
                    temp_commentLines++;
                } else {
                    // 正常代码行
                    temp_normalLines++;
                }
            }

            totalBlackCount += temp_whiteLines;
            totalRemarkCount += temp_commentLines;
            totalCodeCount += temp_normalLines;

            System.out.println("当前扫描文件：" + file.getAbsoluteFile() + " 有效代码行" + temp_normalLines + " 注释行" + temp_commentLines + " 空行" + temp_whiteLines);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeFile(String filePath) {
        try {
            File writeName = new File(filePath); // 相对路径，如果没有则要建立一个新的文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write("总行数: " + (totalCodeCount + totalBlackCount + totalRemarkCount) + "\r\n"); // \r\n即为换行
                out.write("空行数: " + totalBlackCount + "\r\n"); // \r\n即为换行
                out.write("注释行数: " + totalRemarkCount + "\r\n"); // \r\n即为换行
                out.write("有效代码行数: " + totalCodeCount + "\r\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


