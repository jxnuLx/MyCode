import com.xl.dao.BookDao;
import com.xl.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        //3.获取IOC容器
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //4.获取bean
        BookDao bookDao1 = (BookDao) context.getBean("bookDao");
        BookDao bookDao2 = (BookDao) context.getBean("bookDao");
        System.out.println(bookDao1);
        System.out.println(bookDao2);

        //在虚拟机退出前关闭容器,这样才能看到bean销毁方法执行
        context.registerShutdownHook();
        //close关闭比较暴力
//        context.close();
    }
}
