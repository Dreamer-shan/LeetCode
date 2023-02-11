package Q5;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI_1 {

    public static void main(String[] args) throws Exception {
        // WeatherAPI.json("北京");
//        System.out.println(getHttpRequestData("http://www.weather.com.cn/data/sk/101190408.html"));
//        System.out.println(getHttpRequestData("https://www.baidu.com/"));
//        System.out.println(getHttpRequestData("https://baijiahao.baidu.com/s?id=1737603763533381343"));
        getHttpRequestData("https://baijiahao.baidu.com/s?id=1737603763533381343");
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
}