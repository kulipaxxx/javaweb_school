package com.cheng.shopping.pojo;

import java.util.HashMap;
import java.util.Map;

public class shoppingCat {
    private int numbers;//存放图书数量
    private Map<String,Integer> map;

    public shoppingCat(){
        map = new HashMap<String, Integer>();
        numbers = 0;
    }

    //加锁影响效率
    public synchronized void add(String itemName){
        //判断是否存在此书
        if (map.containsKey(itemName)){
            Integer count = map.get(itemName);

            //增加数量
            map.put(itemName,count++);
        }else {
            //初始化一本
            map.put(itemName,Integer.valueOf(1));
        }
        numbers++;
    }

    public int getNumbers(){
        return numbers;
    }

    public Map getBooks(){
        return map;
    }
}
