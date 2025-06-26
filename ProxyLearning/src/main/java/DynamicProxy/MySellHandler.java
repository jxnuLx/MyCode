package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//必须实现InvocationHandler接口，完成代理类要做的功能（1.调用目标方法 2.功能增强）
public class MySellHandler implements InvocationHandler {
    private Object target = null;

    //动态代理：目标对象是活动的，不是固定的，需要传入进来
    //传入是谁，就给谁创建代理
    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;
        //向厂家发送订单，告诉厂家，买了U盘，进行加价，这一步就是代理增强
        res = method.invoke(target, args);

        //商家需要加价，也就是代理加价
        if (res != null) {
            Float price = (Float) res;
            price = price + 25;
            res = price;
        }

        //在目标类的方法调用后，你做的其他功能，都是增强的意思
        System.out.println("淘宝商家，给你一个优惠券，或者红包");
        return res;
    }
}
