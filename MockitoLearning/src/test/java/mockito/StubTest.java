package mockito;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import service.UserServiceImpl;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StubTest {

    @Mock
    List<String> mockList;

    @Mock
    UserServiceImpl mockUserService;

    @Spy
    UserServiceImpl spyUserService;

    /**
     * 返回指定的值
     */
    @Test
    public void test1(){
        //方法1
        Mockito.doReturn("zero").when(mockList).get(0);
        Assertions.assertEquals("zero",mockList.get(0));

        //方法2
        Mockito.when(mockList.get(1)).thenReturn("one");
        Assertions.assertEquals("one",mockList.get(1));

    }

    /**
     * 验证void方法
     */
    @Test
    public void test2(){
        Mockito.doNothing().when(mockList).clear();
        mockList.clear();
        //验证clear方法是否被调用
        Mockito.verify(mockList,Mockito.times(1)).clear();

    }

    @Test
    public void test3(){
        Mockito.when(mockUserService.getNumber()).thenReturn(99);
        System.out.println("mockito:" + mockUserService.getNumber());


        //当对象是spy时,在没有插桩时是调用真实方法的，写在when中会导致先执行一次原始方法，达不到mock目的，Mockito.when()会先调用一次原方法，推荐使用Mockito.doReturn().when().someMethon
        Mockito.when(spyUserService.getNumber()).thenReturn(99);
        System.out.println("mockito:" + spyUserService.getNumber());

    }

    /**
     * 抛出异常
     */
    @Test
    public void test4(){
//        //方法1
//        Mockito.doThrow(RuntimeException.class).when(mockList).get(Mockito.anyInt());
//
//        try{
//            mockList.get(3);
//            //走到下面说明插桩失败
//            Assertions.fail();
//        }catch (Exception e){
//            Assertions.assertTrue(e instanceof RuntimeException);
//        }


        //when在前面需要有返回值
        Mockito.when(mockList.get(Mockito.anyInt())).thenThrow(RuntimeException.class);
        try{
            mockList.get(4);
            //走到下面说明插桩失败
            Assertions.fail();
        }catch (Exception e){
            Assertions.assertTrue(e instanceof RuntimeException);
        }

    }


    /**
     * 多次插桩
     */
    @Test
    public void test5(){
        //第一次调用返回1，第二次返回2，第三次及以后返回3，
        Mockito.when(mockList.size()).thenReturn(1).thenReturn(2).thenReturn(3);
        Assertions.assertEquals(1,mockList.size());
        Assertions.assertEquals(2,mockList.size());
        Assertions.assertEquals(3,mockList.size());
        Assertions.assertEquals(3,mockList.size());

    }


    /**
     * thenAnswer 实现指定逻辑的插桩
     */
    @Test
    public void test6(){
        Mockito.when(mockList.get(Mockito.anyInt())).thenAnswer(new Answer<String>() {
            /**
             * 泛型表示要插桩方法的返回类型
             * @param invocationOnMock
             * @return
             * @throws Throwable
             */
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                //getArgument表示获取插桩方法（此处就是list.get）的第几个参数值，list.get就只传一个值
                Integer argument=invocationOnMock.getArgument(0,Integer.class);
                return String.valueOf(argument * 100);
            }
        });
        String result=mockList.get(3);
        Assertions.assertEquals("300",result);

    }

    /**
     * 执行真正的原始方法
     */
    @Test
    public void test7(){
//        //对mock对象插桩让它执行原始方法
//        Mockito.when(mockUserService.getNumber()).thenCallRealMethod();
//        int nu=mockUserService.getNumber();
//        Assertions.assertEquals(0,nu);
//
//        //spy对象默认就会调用真实的方法，如果不想让它调用，需要单独为它进行插桩
//        int result=spyUserService.getNumber();
//        Assertions.assertEquals(0,result);


        //不让spy对象调用真实方法
        Mockito.doReturn(1000).when(spyUserService).getNumber();
        int resSpy = spyUserService.getNumber();
        Assertions.assertEquals(1000,resSpy);

    }
}
