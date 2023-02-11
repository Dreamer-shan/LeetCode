/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/09/22:13
 * @Description:
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        for (Integer value : list) {
            System.out.println(value);
        }
        int i = list.indexOf(3);
        System.out.println(i);
        list.insert(1,1111111);
        System.out.println("****************************");
        int j = list.indexOf(3);
        System.out.println(j);
        for (Integer value : list) {
            System.out.println(value);
        }
        Integer getResult = list.get(1);
        System.out.println("索引1处的结果为: " + getResult);
        Integer getRemove = list.remove(1);
        System.out.println("删除的元素为: " + getRemove);
        list.clear();
        System.out.println("清空后的长度为: " + list.length());
    }
}
