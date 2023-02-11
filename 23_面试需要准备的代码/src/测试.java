import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/08/11:26
 * @Description:
 */
public class 测试 {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        List<Integer> list = new ArrayList<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(vector.equals(list));
    }
}
