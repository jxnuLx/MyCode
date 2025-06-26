package staticProxy;


/**
 * 定义一个代理的接口，后续厂家和代理家都实现该接口
 */
public interface UsbSell {
    /**
     * 返回值表示一个U盘价格
     * @param amount 表示购买的数量
     * @return
     */
    float sell(int amount);

}
