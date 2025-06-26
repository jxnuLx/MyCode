package staticProxy;

/**
 * 金士顿厂家实现代理接口,不接受用户的
 */
public class USbKingFactory implements UsbSell{
    @Override
    public float sell(int amount) {
        return 85.0f;
    }
}
