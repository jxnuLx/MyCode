import com.xl.config.SpringConfig;
import com.xl.domain.Account;
import com.xl.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnno {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean(AccountService.class);
        Account account = accountService.findById(2);
        System.out.println(account);

    }
}
