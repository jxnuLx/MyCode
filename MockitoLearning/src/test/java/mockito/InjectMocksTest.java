package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import service.UserServiceImpl;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class InjectMocksTest {

    /**
     * 1.被InjectMocks标注的属性必须是实现类，因为InjectMocks会创建对应的实例对象，默认创建的对象就是未经过mockito处理的普通对象，因此常常配合@spy注解使其
     * 变为默认调用真实方法的mock对象
     * 2.mockito会使用spy对象或者mock对象注入到InjectMocks对应的实例对象
     */
    @InjectMocks
    @Spy
    UserServiceImpl userService;
    //如果userService有需要用到list成员变量，会自动注入到userService
    @Mock
    List<String> list;

    @Test
    public void test1(){
        System.out.println(1);
    }

}
