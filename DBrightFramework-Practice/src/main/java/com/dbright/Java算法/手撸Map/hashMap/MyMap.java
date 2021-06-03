package com.dbright.Java算法.手撸Map.hashMap;

//自定义Map接口,对外暴露快速存取的方法
public interface MyMap<K,V> {
     V put(K k,V v);
     V get(K k);

    interface Entry<K,V> {
         K getKey();
         V getValue();
    }
}
