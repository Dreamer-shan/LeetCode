package Q5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public  class Server_Test1 extends Thread{
    ServerSocket server = null;
    Socket socket = null;
    public Server_Test1(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        super.run();
        try{
            System.out.println("wait client connect...");
            socket = server.accept();
            new sendMessThread().start();//连接并返回socket后，再启用发送消息线程
            System.out.println(socket.getInetAddress().getHostAddress()+"SUCCESS TO CONNECT...");
            InputStream in = socket.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len=in.read(buf))!=-1){
                System.out.println("client saying: "+new String(buf,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    class sendMessThread extends Thread{
        @Override
        public void run(){
            super.run();
            Scanner scanner=null;
            OutputStream urlPath = null;
            OutputStream out = null;
            try{
                if(socket != null){
                    out = socket.getOutputStream();
                    String in = "";
                    urlPath = socket.getOutputStream();
                    do {
                        // 1  创建URL对象,接收用户传递访问地址对象链接
                        System.out.println(String.valueOf(urlPath));
                        URL url = new URL(urlPath.toString());

                        // 2 打开用户传递URL参数地址
                        HttpURLConnection connect = (HttpURLConnection) url.openConnection();

                        // 3 设置HTTP请求的一些参数信息
                        connect.setRequestMethod("GET"); // 参数必须大写
                        connect.connect();

                        // 4 获取URL请求到的数据，并创建数据流接收
                        InputStream isString = connect.getInputStream();

                        // 5 构建一个字符流缓冲对象,承载URL读取到的数据
                        BufferedReader isRead = new BufferedReader(new InputStreamReader(isString));
                        String str = "";
                        StringBuilder sb = new StringBuilder();
                        // 6 输出打印获取到的文件流
                        while ((str = isRead.readLine()) != null) {
                            str = new String(str.getBytes(),"UTF-8"); //解决中文乱码问题
//				System.out.println("文件解析打印：");
//				System.out.println(str);
                            sb.append(str);
//                            returnString = str;
                        }

                        String E1 = "[\u4e00-\u9fa5]";// 中文
                        String E2 = "[a-zA-Z]";// 英文
                        String E3 = "[0-9]";// 数字
                        int chineseCount = 0;
                        int englishCount = 0;
                        int numberCount = 0;
                        String temp;
                        String str1 = sb.toString();
                        for (int i = 0; i < str1.length(); i++) {
                            temp = String.valueOf(str1.charAt(i));
                            if (temp.matches(E1)) {
                                chineseCount++;
                            }
                            if (temp.matches(E2)) {
                                englishCount++;
                            }
                            if (temp.matches(E3)) {
                                numberCount++;
                            }
                        }
                        System.out.println("汉字数:" + chineseCount);
                        System.out.println("英文数:" + englishCount);
                        System.out.println("数字数:" + numberCount);
                        System.out.println("特殊字符:" + (str1.length() - (chineseCount + englishCount + numberCount)));

                        // 7 关闭流
                        isString.close();
                        connect.disconnect();
                        in = scanner.next();
                        out.write(("汉字数:" + chineseCount).getBytes());
                        out.write(("英文数:" + englishCount).getBytes());
                        out.write(("数字数:" + numberCount).getBytes());
                        out.write(("特殊字符:" + (str1.length() - (chineseCount + englishCount + numberCount))).getBytes());
                        out.flush();//清空缓存区的内容
                    }while (!in.equals("q"));
                    scanner.close();
                    try{
                        out.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getHttpRequestData(String urlPath) {

        // 首先抓取异常并处理
        String returnString = "1";
        try{
            // 代码实现以GET请求方式为主,POST跳过
            /** 1 GET方式请求数据 start*/

            // 1  创建URL对象,接收用户传递访问地址对象链接
            URL url = new URL(urlPath);

            // 2 打开用户传递URL参数地址
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();

            // 3 设置HTTP请求的一些参数信息
            connect.setRequestMethod("GET"); // 参数必须大写
            connect.connect();

            // 4 获取URL请求到的数据，并创建数据流接收
            InputStream isString = connect.getInputStream();

            // 5 构建一个字符流缓冲对象,承载URL读取到的数据
            BufferedReader isRead = new BufferedReader(new InputStreamReader(isString));
            String str = "";
            StringBuilder sb = new StringBuilder();
            // 6 输出打印获取到的文件流
            while ((str = isRead.readLine()) != null) {
                str = new String(str.getBytes(),"UTF-8"); //解决中文乱码问题
//				System.out.println("文件解析打印：");
//				System.out.println(str);
                sb.append(str);
                returnString = str;
            }

            String E1 = "[\u4e00-\u9fa5]";// 中文
            String E2 = "[a-zA-Z]";// 英文
            String E3 = "[0-9]";// 数字
            int chineseCount = 0;
            int englishCount = 0;
            int numberCount = 0;
            String temp;
            String str1 = sb.toString();
            for (int i = 0; i < str1.length(); i++) {
                temp = String.valueOf(str1.charAt(i));
                if (temp.matches(E1)) {
                    chineseCount++;
                }
                if (temp.matches(E2)) {
                    englishCount++;
                }
                if (temp.matches(E3)) {
                    numberCount++;
                }
            }
            System.out.println("汉字数:" + chineseCount);
            System.out.println("英文数:" + englishCount);
            System.out.println("数字数:" + numberCount);
            System.out.println("特殊字符:" + (str1.length() - (chineseCount + englishCount + numberCount)));

            // 7 关闭流
            isString.close();
            connect.disconnect();
            // 8 JSON转List对象
            // do something

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(returnString);
        return returnString;
    }

    //函数入口
    public static void main(String[] args) {
        Server_Test1 server = new Server_Test1(1234);
        server.start();
    }
}

