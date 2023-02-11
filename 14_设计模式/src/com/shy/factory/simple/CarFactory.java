package com.shy.factory.simple;

import sun.security.mscapi.CPublicKey;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/22:03
 * @Description:
 */
// 增加一个新产品，如果不修改代码，做不到
// 违反了开闭原则
public class CarFactory {
    // 方法一
    public static Car getCar(String car){
        if (car.equals("五菱")){
            return new Wuling();
        }else if (car.equals("特斯拉")){
            return new Tesla();
        }else {
            return null;
        }
    }
    // 方法二
//    public static Car getWuling(){
//        return new Wuling();
//    }
//    public static Car getTesla(){
//        return new Tesla();
//    }
}
