package com.ruoyi.bysj.controller;
import com.ruoyi.bysj.bo.UserQueryBo;
import com.ruoyi.bysj.domain.User;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.bysj.service.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * 患者管理Controller
 *
 * @author 牟连波
 * @date 2021-04-20
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  IUserService iUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询患者管理列表
     */
    @RequestMapping("/login")
    public String login(@RequestParam(value = "mobile") String mobile,
                       @RequestParam(value = "password") String password) {
        System.out.println(mobile);
        System.out.println(password);
        User user=new User();
        user.setPhonenumber(mobile);
        if(password.equals(null)|| password.equals("")){
            return "500";
        };
        User u =new User();
        try {
            u  =iUserService.selectUser(mobile);
        }catch (NullPointerException e){
            System.out.println(e);
            return "500";
        };
        if(!passwordEncoder.matches(password,u.getPassword())){
            return "500";
        };
        return "200";
    }

    /**
     * 查询患者管理列表
     * @return
     */

    @GetMapping("/test")
    public AjaxResult<Void> test() {
        return AjaxResult.success("fbusbudevufu");
    }
}
