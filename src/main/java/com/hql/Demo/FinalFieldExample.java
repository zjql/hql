package com.hql.Demo;

import java.util.ArrayList;

/**
 * @author 开发者中文姓名
 * @date 2019/11/4 10:31
 */
public class FinalFieldExample {

    byte[] b = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<FinalFieldExample> heapTests = new ArrayList<FinalFieldExample>();
        while (true){
            heapTests.add(new FinalFieldExample());
            Thread.sleep(10);
    }
    }
}
