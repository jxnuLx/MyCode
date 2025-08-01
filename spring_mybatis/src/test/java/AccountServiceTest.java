import com.xl.config.SpringConfig;
import com.xl.domain.Account;
import com.xl.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境对应的配置类
@ContextConfiguration(classes = {SpringConfig.class})//加载配置类
public class AccountServiceTest {
    //支持自动装配注入bean
    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void selectAll(){
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    public void testTransfer() {
        accountService.transfer("Tom", "Jerry", 100D);
    }
}
