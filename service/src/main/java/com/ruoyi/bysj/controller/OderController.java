package com.ruoyi.bysj.controller;

import java.util.List;
import java.util.Arrays;

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
import com.ruoyi.bysj.vo.OderVo;
import com.ruoyi.bysj.bo.OderQueryBo;
import com.ruoyi.bysj.bo.OderAddBo;
import com.ruoyi.bysj.bo.OderEditBo;
import com.ruoyi.bysj.service.IOderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单信息Controller
 * 
 * @author 牟连波
 * @date 2021-04-16
 */
@Api(value = "订单信息控制器", tags = {"订单信息管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/bysj/oder")
public class OderController extends BaseController {

    private final IOderService iOderService;

    /**
     * 查询订单信息列表
     */
    @ApiOperation("查询订单信息列表")
    @PreAuthorize("@ss.hasPermi('bysj:oder:list')")
    @GetMapping("/list")
    public TableDataInfo<OderVo> list(OderQueryBo bo) {
        startPage();
        List<OderVo> list = iOderService.queryList(bo);
        return getDataTable(list);
    }

    /**
     * 导出订单信息列表
     */
    @ApiOperation("导出订单信息列表")
    @PreAuthorize("@ss.hasPermi('bysj:oder:export')")
    @Log(title = "订单信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<OderVo> export(OderQueryBo bo) {
        List<OderVo> list = iOderService.queryList(bo);
        ExcelUtil<OderVo> util = new ExcelUtil<OderVo>(OderVo.class);
        return util.exportExcel(list, "oder" );
    }

    /**
     * 获取订单信息详细信息
     */
    @ApiOperation("获取订单信息详细信息")
    @PreAuthorize("@ss.hasPermi('bysj:oder:query')")
    @GetMapping("/{userId}")
    public AjaxResult<OderVo> getInfo(@PathVariable("userId" ) Long userId) {
        return AjaxResult.success(iOderService.queryById(userId));
    }

    /**
     * 新增订单信息
     */
    @ApiOperation("新增订单信息")
    @PreAuthorize("@ss.hasPermi('bysj:oder:add')")
    @Log(title = "订单信息", businessType = BusinessType.INSERT)
    @PostMapping()
    public AjaxResult<Void> add(@RequestBody OderAddBo bo) {
        return toAjax(iOderService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改订单信息
     */
    @ApiOperation("修改订单信息")
    @PreAuthorize("@ss.hasPermi('bysj:oder:edit')")
    @Log(title = "订单信息", businessType = BusinessType.UPDATE)
    @PutMapping()
    public AjaxResult<Void> edit(@RequestBody OderEditBo bo) {
        return toAjax(iOderService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除订单信息
     */
    @ApiOperation("删除订单信息")
    @PreAuthorize("@ss.hasPermi('bysj:oder:remove')")
    @Log(title = "订单信息" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult<Void> remove(@PathVariable Long[] userIds) {
        return toAjax(iOderService.deleteWithValidByIds(Arrays.asList(userIds), true) ? 1 : 0);
    }
}
