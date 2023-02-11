package Q5;

public class Test_wzs7 {
    public static void main(String[] args) {
        String str = "[email protected]&4语*言3c";
        String E1 = "[\u4e00-\u9fa5]";// 中文
        String E2 = "[a-zA-Z]";// 英文
        String E3 = "[0-9]";// 数字
        int chineseCount = 0;
        int englishCount = 0;
        int numberCount = 0;
        String temp;
        for (int i = 0; i < str.length(); i++) {
            temp = String.valueOf(str.charAt(i));
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
        System.out.println("特殊字符:" + (str.length() - (chineseCount + englishCount + numberCount)));
    }
}