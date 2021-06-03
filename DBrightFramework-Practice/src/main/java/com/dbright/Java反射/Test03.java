package com.dbright.Java反射;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test03 {
    //通过反射获取泛型
        public void test01(Map<String, Person> map, List<Person> list){
            System.out.println("test01");
        }

        public Map<String, Person> test02(){
            System.out.println("test02");
            return null;
        }

        public static void main(String[] args) throws NoSuchMethodException {
            Method method = Test03.class.getMethod("test01", Map.class, List.class);

            Type[] geners = method.getGenericParameterTypes();

            for (Type gener : geners) {
                System.out.println("*" + gener);
                if (gener instanceof ParameterizedType){
                    Type[] actuals = ((ParameterizedType)gener).getActualTypeArguments();
                    for (Type actual : actuals) {
                        System.out.println(actual);
                    }
                }
            }

            method = Test03.class.getMethod("test02", null);
            Type geners1 = method.getGenericReturnType();

            if (geners1 instanceof ParameterizedType){
                Type[] actuals = ((ParameterizedType)geners1).getActualTypeArguments();
                for (Type actual : actuals) {
                    System.out.println(actual);
                }
            }
        }
}
