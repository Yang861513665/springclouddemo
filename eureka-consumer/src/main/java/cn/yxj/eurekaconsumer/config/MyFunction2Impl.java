package cn.yxj.eurekaconsumer.config;

public class MyFunction2Impl implements MyFunction2 {

    @Override
    public Integer getResult(Object t1, Object t2) {
        return (int)t1+ (int)t2;
    }
}
