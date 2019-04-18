package cn.yxj.eurekaconsumer.config;

@FunctionalInterface
public interface MyFunction<T, R,S> {
   public R getResult(T t1,S t2);
}
