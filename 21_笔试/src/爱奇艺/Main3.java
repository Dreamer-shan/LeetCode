//package 爱奇艺;
//
//import java.util.*;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/09/12/16:34
// * @Description:
// */
//public class Main3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int[][] temp = fun2(str);
//        int len = fun1(temp);
//        System.out.println(temp.length - len);
//    }
//
//    private static int fun1(int[][] arr) {
//        if (arr == null || arr.length == 0){
//            return 0;
//        }
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1]  - o2[1];
//            }
//        });
//        int end = arr[0][1];
//        int res = 1;
//        for (int i = 0; i < arr.length; i++) {
//            int start = arr[i][0];
//            if (start >= end){
//                end = arr[i][1];
//                res++;
//            }
//        }
//        return res;
//    }
//
//    private static int[][] fun2(String str) {
//        List<Integer> list = new ArrayList<>();
//        int size = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '[' || str.charAt(i) == ']' || str.charAt(i) == ' ' || str.charAt(i) == ',') {
//                continue;
//            } else {
//                list.add(Integer.valueOf(String.valueOf(str.charAt(i))));
//            }
//        }
//
//        if (list.size() != 0) {
//            size = list.size() / 2;
//        }
//        int[][] temp = new int[size][2];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < 2; j++) {
//                temp[i][j] = list.remove(0);
//            }
//        }
//        return temp;
//    }
//}
//
//    create table VIP_USER(id int primary key not null,  name varchar(30),  deadline DATE,  vip_type int);
//        insert into VIP_USER(id,name,deadline,vip_type) values(1,'Joe', '2021-10-01 00:00:00', 1);
//        insert into VIP_USER(id,name,deadline,vip_type) values(2,'Jim', '2021-12-05 00:00:00', 1);
//        insert into VIP_USER(id,name,deadline,vip_type) values(3,'Tom', '2021-11-02 00:00:00', 2);
//        insert into VIP_USER(id,name,deadline,vip_type) values(4,'Mary', '2021-09-03 00:00:00', 2);
//        insert into VIP_USER(id,name,deadline,vip_type) values(5,'Lucy', '2021-12-05 00:00:00', 1);
//        insert into VIP_USER(id,name,deadline,vip_type) values(6,'Henry', '2021-08-19 00:00:00', 1);
//        insert into VIP_USER(id,name,deadline,vip_type) values(7,'Bill', '2021-08-31 00:00:00', 1);
//
//        create table VIP_TYPE(id int primary key not null,  name varchar(30));
//        insert into VIP_TYPE(id,name) values(1,'黄金会员');
//        insert into VIP_TYPE(id,name) values(2,'钻石会员');
//
//
//
//        黄金会员	Jim	2021-12-05
//        黄金会员	Lucy	2021-12-05
//        黄金会员	Joe	2021-10-01
//        黄金会员	Bill	2021-08-31
//        钻石会员	Tom	2021-11-02
//        钻石会员	Mary	2021-09-03
//
//
//        每种会员类型会员时长排名前三的用户
//
//        输出3列：会员类型名称、会员用户名称，会员卡到期日期。对列名无要求。
//
//        排序：会员类型id升序，剩余时长降序，相同剩余时长时，按会员id升序排列。
//
//        可以复制样例在本地先调试。
//
//
//        请写出合适的SQL语句，查询出每种会员类型会员时长排名前三的用户，每种会员类型按剩余时长从大到小排序输出。（deadline字段说明：类型为datetime）。
//
//        VIP_USER表包含所有的会员用户信息
//
//        id	name	deadline	vip_type
//        1	Joe	2021-10-01 00:00:00	1
//        2	Jim	2021-12-05 00:00:00	1
//        3	Tom	2021-11-02 00:00:00	2
//        4	Mary	2021-09-03 00:00:00	2
//        5	Lucy	2021-12-05 00:00:00	1
//        6	Henry	2021-08-19 00:00:00	1
//        7	Bill	2021-08-31 00:00:00	1
//        VIP_TYPE表是会员类型描述的基本信息
//
//        id	name
//        1	黄金会员
//        2	钻石会员