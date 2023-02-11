package com.shy.factory.simple1;

import com.shy.factory.simple.Tesla;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/17:28
 * @Description:
 */
public class CarFactory {
    public static Car getCar(String car){
        if ("五菱".equals(car)){
            return new Wuling();
        }else if ("奔驰".equals(car)){
            return new Benchi();
        }else {
            return null;
        }
    }

}
