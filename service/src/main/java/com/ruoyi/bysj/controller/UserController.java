package com.ruoyi.bysj.controller;
import com.ruoyi.bysj.domain.Dept;
import com.ruoyi.bysj.domain.Relation;
import com.ruoyi.bysj.domain.User;
import com.ruoyi.bysj.service.IDeptService;
import com.ruoyi.bysj.service.IRelationService;
import com.ruoyi.bysj.vo.UserVo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.bysj.service.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
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

    @Autowired
    private IDeptService DeptService;

    @Autowired
    private  IRelationService iRelationService;

    /**
     * 患者用户登录
     */
    @RequestMapping("/login")
    public AjaxResult<User> login(@RequestParam(value = "mobile") String mobile,
                       @RequestParam(value = "password") String password) {
        User user=new User();
        String msg = new String();
        if(password.equals(null)|| password.equals("")||mobile.equals(null)||mobile.equals("")){
            return AjaxResult.error("账号密码不能为空",new User());
        };
        try {
            user=iUserService.selectUser(mobile);
            if(!passwordEncoder.matches(password,user.getPassword())){
                return AjaxResult.error("密码不正确，请重新输入密码！",new User());
            };
            msg="200";
        }catch (NullPointerException e){
            System.out.println(e);
            return AjaxResult.error("账号不存在，请先注册",new User());
        };
        return AjaxResult.success(msg,user);
    }

    /**
     * 获取医院推荐信息列表
     * @return
     */
    @GetMapping("/hospitalList")
    public List<Dept> hospitalList() {
        return DeptService.getHList();
    }

    /**
     * 获取医生推荐信息列表
     * @return
     */
    @GetMapping("/doctorList")
    public List<User> doctorList() {
        List<User> userList = iUserService.getDoList();
        return userList;
    }

    /**
     * 获取部门下医生信息列表
     * @return
     */
    @GetMapping("/docListInA")
    public List<User> docListInA(@RequestParam(value = "deptId") Long deptId) {
        return iUserService.docListInA(deptId);
    }

    /**
     * 获取一个医生的详细信息
     * @return
     */
    @GetMapping("/docDetail")
    public UserVo docDetail(@RequestParam(value = "id") Long id) {
        return iUserService.queryById(id);
    }

    /**
     * 获取一个医生的家人信息列表
     * @return
     */
    @GetMapping("/familyList")
    public List<Relation> familyList(@RequestParam(value = "id") Long id) {
        Relation relation=new Relation();
        relation.setUserId(id);
        return iRelationService.queryList(relation);
    }
}
