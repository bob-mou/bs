package com.ruoyi.bysj.controller;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.bysj.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.bysj.vo.TicketVo;
import com.ruoyi.bysj.bo.TicketQueryBo;
import com.ruoyi.bysj.bo.TicketAddBo;
import com.ruoyi.bysj.bo.TicketEditBo;
import com.ruoyi.bysj.service.ITicketService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 放号管理Controller
 *
 * @author 牟连波
 * @date 2021-04-18
 */
@Api(value = "放号管理控制器", tags = {"放号管理管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/bysj/ticket")
public class TicketController extends BaseController {

    private final ITicketService iTicketService;

    /**
     * 查询放号管理列表
     */
    @ApiOperation("查询放号管理列表")
    @PreAuthorize("@ss.hasPermi('bysj:ticket:list')")
    @GetMapping("/list")
    public TableDataInfo<Ticket> list(Ticket bo) {
        startPage();
        List<Ticket> list = iTicketService.selectTicketList(bo);
        return getDataTable(list);
    }

    /**
     * 导出放号管理列表
     */
    @ApiOperation("导出放号管理列表")
    @PreAuthorize("@ss.hasPermi('bysj:ticket:export')")
    @Log(title = "放号管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TicketVo> export(TicketQueryBo bo) {
        List<TicketVo> list = iTicketService.queryList(bo);
        ExcelUtil<TicketVo> util = new ExcelUtil<TicketVo>(TicketVo.class);
        return util.exportExcel(list, "ticket" );
    }

    /**
     * 获取放号管理详细信息
     */
    @ApiOperation("获取放号管理详细信息")
    @PreAuthorize("@ss.hasPermi('bysj:ticket:query')")
    @GetMapping("/{doctorId}")
    public AjaxResult<TicketVo> getInfo(@PathVariable("doctorId" ) Long doctorId) {
        return AjaxResult.success(iTicketService.queryById(doctorId));
    }

    /**
     * 新增放号管理
     */
    @ApiOperation("新增放号管理")
    @PreAuthorize("@ss.hasPermi('bysj:ticket:add')")
    @Log(title = "放号管理", businessType = BusinessType.INSERT)
    @PostMapping()
    public AjaxResult<Void> add(@RequestBody TicketAddBo bo) {
        return toAjax(iTicketService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改放号管理
     */
    @ApiOperation("修改放号管理")
    @PreAuthorize("@ss.hasPermi('bysj:ticket:edit')")
    @Log(title = "放号管理", businessType = BusinessType.UPDATE)
    @PutMapping()
    public AjaxResult<Void> edit(@RequestBody TicketEditBo bo) {
        return toAjax(iTicketService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除放号管理
     */
    @ApiOperation("删除放号管理")
    @PreAuthorize("@ss.hasPermi('bysj:ticket:remove')")
    @Log(title = "放号管理" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{doctorIds}")
    public AjaxResult<Void> remove(@PathVariable Long[] doctorIds) {
        return toAjax(iTicketService.deleteWithValidByIds(Arrays.asList(doctorIds), true) ? 1 : 0);
    }
}
