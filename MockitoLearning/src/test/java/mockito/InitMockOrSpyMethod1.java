package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import service.UserService;


/**
 * 创建mock的第一种方式
 */
@ExtendWith(MockitoExtension.class)
public class InitMockOrSpyMethod1 {
    @Mock
    UserService mockUserService;

    @Spy
    UserService spyUserService;

    @Test
    public void test1(){
        System.out.println(Mockito.mockingDetails(mockUserService).isMock());
        System.out.println(Mockito.mockingDetails(mockUserService).isSpy());
//spy
        System.out.println(Mockito.mockingDetails(spyUserService).isMock());
        System.out.println(Mockito.mockingDetails(spyUserService).isSpy());
    }
}
