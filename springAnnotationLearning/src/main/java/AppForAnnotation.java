import com.xl.config.SpringConfig;
import com.xl.dao.BookDao;
import com.xl.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao =  applicationContext.getBean(BookDao.class);

//        System.out.println(bookDao);

    }
}
