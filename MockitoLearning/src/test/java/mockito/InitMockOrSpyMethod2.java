package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.UserService;


/**
 * 创建mock的第2种方式
 */

public class InitMockOrSpyMethod2 {
    UserService mockUserService;

    UserService spyUserService;

    @BeforeEach
    public void init(){
        mockUserService=Mockito.mock(UserService.class);
        spyUserService=Mockito.spy(UserService.class);
    }

    @Test
    public void test1(){
        System.out.println(Mockito.mockingDetails(mockUserService).isMock());
        System.out.println(Mockito.mockingDetails(mockUserService).isSpy());
//spy
        System.out.println(Mockito.mockingDetails(spyUserService).isMock());
        System.out.println(Mockito.mockingDetails(spyUserService).isSpy());
    }
}
