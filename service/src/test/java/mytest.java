import com.ruoyi.RuoYiApplication;
import com.ruoyi.bysj.service.IUserService;
import com.ruoyi.bysj.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RuoYiApplication.class)
public class mytest {
    @Autowired
    private IUserService iUserService;

    @Test
    void atest() {
        UserVo userVo = iUserService.queryById((long) 104);
        String str= userVo.toString();
        System.out.println(str);
    }
}
