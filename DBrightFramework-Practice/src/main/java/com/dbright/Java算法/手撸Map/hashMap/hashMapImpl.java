package com.dbright.Java算法.手撸Map.hashMap;

import java.util.ArrayList;
import java.util.List;

public class hashMapImpl<K,V> implements MyMap<K,V> {
    // 数组的默认初始化长度
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    // 设置默认加载因子
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;
    private float deaultLoadFactor;

    // Map当中entry的数量
    private int entryUseSize;

    // 数组
    private Entry<K, V>[] table = null;

    // 构造方法,这里使用到了"门面模式".
    // 这里的2个构造方法其实指向的是同一个,但是对外却暴露了两个"门面".
    public hashMapImpl() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public hashMapImpl(int defaultInitialCapacity, float deaultLoadFactor) {
        if (defaultInitialCapacity < 0) {
            throw new IllegalArgumentException("参数有误" + defaultInitialCapacity);
        }

        if (deaultLoadFactor <= 0 || Float.isNaN(deaultLoadFactor)) {
            throw new IllegalArgumentException("参数有误" + deaultLoadFactor);
        }

        this.defaultInitSize = defaultInitialCapacity;
        this.deaultLoadFactor = deaultLoadFactor;

        table = new Entry[this.defaultInitSize];
    }

    /**
     *
     * @ClassName: Entry
     * @Description: HashMap的内部类,HashMap的要素之一,单链表的体现就在这里!
     * @author Kingram
     * @date 2018年8月3日
     *
     * @param <K>
     * @param <V>
     */
    class Entry<K, V> implements MyMap.Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    /**
     * 第一，要考虑是否扩容？
     *
     * HashMap中的Entry的数量（数组以及单链表中的所有Entry）是否达到加载因子限制的最大值？
     *
     * 第二，如果扩容，意味着新生成一个Entry[]，不仅如此还得重新散列。
     *
     * 第三，要根据Key计算出在Entry[]中的位置，定位后，如果Entry[]中的元素为null，那么可以放入其中，如果不为空，那么得遍历单链表，
     * 要么更新value，要么形成一个新的Entry“挤压”单链表！
     */
    @Override
    public V put(K k, V v) {
        V oldValue = null;
        // 判断是否需要扩容?
        // 扩容完毕 re肯定需要重新散列
        if (entryUseSize >= defaultInitSize * deaultLoadFactor) {
            resize(2 * defaultInitSize);
        }
        // 得到HASH值,计算出数组的索引
        int index = hash(k) & (defaultInitSize - 1);
        if (table[index] == null) {// 判断当前索引位置有没有元素,如果没有直接插入
            table[index] = new Entry<K, V>(k, v, null);
            ++entryUseSize;
        } else {// 如果有元素就需要遍历链表
            // 遍历链表
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (k == e.getKey() || k.equals(e.getKey())) {
                    oldValue = e.value;
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new Entry<K, V>(k, v, entry);
            ++entryUseSize;
        }
        return oldValue;
    }

    /**
     *
     * @Title: hash
     * @Description: hash函数,跟据Key计算出索引
     * @param @param k
     * @param @return 参数
     * @return int 返回类型
     * @throws
     */
    private int hash(K k) {
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>>4);
    }

    private void resize(int i) {
        Entry[] newTable = new Entry[i];
        // 改变了数组的大小
        defaultInitSize = i;
        entryUseSize = 0;
        rehash(newTable);
    }

    private void rehash(Entry<K,V>[] newTable) {
        // 得到原来老的Entry集合 注意遍历单链表
        List<Entry<K,V>> entryList = new ArrayList<Entry<K,V>>();
        for(Entry<K,V> entry : table) {
            if(entry != null) {
                do{
                    entryList.add(entry);
                    entry = entry.next;
                }while(entry != null);
            }
        }

        // 覆盖旧的引用
        if(newTable.length > 0) {
            table = newTable;
        }

        // 所谓的重新HASH就是重新PUT ENTRY到HASHMAP
        for(Entry<K,V> entry : entryList) {
            put(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitSize -1);
        if(table[index] == null) {
            return null;
        } else {
            Entry<K,V> entry = table[index];
            do{
                if(k == entry.getKey() || k.equals(entry.getKey())) {
                    return entry.value;
                }
                entry = entry.next;
            }while(entry != null);
        }
        return null;
    }

}
