package staticProxy;

/**
 * 代理金士顿厂家
 */
public class Taobao implements UsbSell {

    //声明厂家的订单，此处为目标类
    private USbKingFactory factory=new USbKingFactory();

    @Override
    public float sell(int amount) {

        //向厂家发送订单，告诉厂家，买了U盘，进行加价，这一步就是代理增强
        float price=factory.sell(amount);
        price=price+5;
        //在目标类的方法调用后，你做的其他功能，都是增强的意思
        return 0;
    }
}
