package cn.yxj.eurekaconsumer.config;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestDemo3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5).stream().sorted((x,y)->-(x-y)).collect(Collectors.toList());
        System.out.println(list);
        happ(20,money-> System.out.println("消费了"+money+"元！"));
        System.out.println(getStr("你 好 嘛",s -> Arrays.asList(s.split(" "))));
    }
   static void happ(int money, Consumer<Integer> consumer){
        consumer.accept(money);
   }
   static Object getStr(String s, Function<String,Object> function){
      return   function.apply(s);
   }
}
