package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import service.UserService;


/**
 * 创建mock的第3种方式
 */

public class InitMockOrSpyMethod3 {
    @Mock
    UserService mockUserService;
    @Spy
    UserService spyUserService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
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
