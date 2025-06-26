package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {
    public static void main(String[] args) {
        //创建代理对象
        //1.创建目标对象
        UsbSell factory=new UsbkingFactory();
        //2.创建InvocationHandler对象
        InvocationHandler handler=new MySellHandler(factory);

        //创建代理对象
        //proxy是代理对象，是com.sun.proxy.$Proxy类型的
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);
        //4.通过代理执行方法
        float price=proxy.sell(1);
        System.out.println("通过动态代理对象，调用目标方法："+price);
    }
}
