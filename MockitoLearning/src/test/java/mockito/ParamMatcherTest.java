package mockito;


import dao.UserUpdateReq;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 参数匹配，通过方法签名（参数）来指定哪些方法调用需要被处理（插桩，verify验证）
 */

@ExtendWith(MockitoExtension.class)
public class ParamMatcherTest {

    @Mock
    UserService mockUserService;


    /**
     * 对于mock对象，不会调用真实的方法，直接返回mock对象的默认值
     * 默认值（int），null（对象），空集合（list）
     */
    @Test
    public void test1(){

    }

    @Test
    public void test2(){
        UserUpdateReq userUpdateReq=new UserUpdateReq();
        userUpdateReq.setId(1l);
        userUpdateReq.setPhone("11");
        Mockito.doReturn(99).when(mockUserService).modifyById(userUpdateReq);
        int res= mockUserService.modifyById(userUpdateReq);
        System.out.println(res);  //99
        System.out.println(mockUserService.modifyById(new UserUpdateReq()));  //0

    }


    /**
     * 拦截UserUpdateReq的任意对象
     */
    @Test
    public void test3(){
        Mockito.doReturn(99).when(mockUserService).modifyById(ArgumentMatchers.any(UserUpdateReq.class));
        System.out.println(mockUserService.modifyById(new UserUpdateReq()));
    }


    @Test
    public void test4(){
        List<String> feetures=new ArrayList<>();
        mockUserService.add("11","22",feetures);
        // 校验参数为"11","22", feetures的add方法背调用了1次
        Mockito.verify(mockUserService,Mockito.times(1)).add("11","22",feetures);


        //注意用了any作为参数，所有的参数都得用any
        Mockito.verify(mockUserService,Mockito.times(1)).add(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyList());
    }
}
