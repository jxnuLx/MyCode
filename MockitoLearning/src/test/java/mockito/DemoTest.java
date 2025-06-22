package mockito;

import dao.Demo;
import dao.StaticUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class DemoTest {
    @Spy
    private Demo demo;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void add1(){
        when(demo.add(1,1)).thenReturn(3);
        int res=demo.add(1,1);
        Assertions.assertEquals(3,res);
    }


    @Test
    void add2(){
        when(demo.add(1,1)).thenThrow(new RuntimeException());
        demo.add(1,1);
    }


    /**
     * 对静态方法进行插桩
     */
    @Test
    void add3(){

        //使用try-with -resource来进行资源的关闭,不关闭的同时执行两个静态打桩方法会报错
        try(MockedStatic<StaticUtils> demo = Mockito.mockStatic(StaticUtils.class)){
            demo.when(() -> StaticUtils.range(2,6)).thenReturn(Arrays.asList(10,11,12));
        }
        Assertions.assertTrue(StaticUtils.range(2,6).contains(10));
    }

}
