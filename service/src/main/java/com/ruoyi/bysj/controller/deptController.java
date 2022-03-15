package com.ruoyi.bysj.controller;


import com.ruoyi.bysj.domain.Dept;
import com.ruoyi.bysj.domain.Ticket;
import com.ruoyi.bysj.service.IDeptService;
import com.ruoyi.bysj.service.ITicketService;
import com.ruoyi.bysj.vo.TicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class deptController {

    @Autowired
    private IDeptService DeptService;

    @Autowired
    private   ITicketService iTicketService;

    /**
     * 获取一个医院下部门列表列表
     * @return
     */
    @GetMapping("/hospitalDetail")
    public List<Dept> depList(@RequestParam(value = "id") Long id) {
        return DeptService.deptDetail(id);
    }


    /**
     * 获取一个医院下部门列表列表
     * @return
     */
    @GetMapping("/haoDetail")
    public List<Ticket> haoDetail(@RequestParam(value = "id") Long id) {
        return  iTicketService.queryDocId(id);
    }

}
