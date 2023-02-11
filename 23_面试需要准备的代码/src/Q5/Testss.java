package Q5;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Testss {
    public static void main(String[] args) {
        testBeytes();
    }

    public static void testUrl() {
        HttpURLConnection connection = null;
        try {
            URL getUrl = new URL("https://baijiahao.baidu.com/s?id=1737603763533381343");
            connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer();
            while ((lines = reader.readLine()) != null) {
                // System.out.println(lines);
                sb.append(lines + "\n");
            }
            reader.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.disconnect();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void testBeytes() {
        InputStream in = null;
        OutputStream out = null;
        try {
            URL url = new URL("https://baijiahao.baidu.com/s?id=1737603763533381343");
            in = url.openStream();
            out = System.out;

            byte[] buffer = new byte[4096];
            int bytes_read;
            while ((bytes_read = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytes_read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
