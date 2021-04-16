package com.ruoyi.bysj.controller;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.bysj.domain.Collect;
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
import com.ruoyi.bysj.vo.CollectVo;
import com.ruoyi.bysj.bo.CollectQueryBo;
import com.ruoyi.bysj.bo.CollectAddBo;
import com.ruoyi.bysj.bo.CollectEditBo;
import com.ruoyi.bysj.service.ICollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 收藏管理Controller
 *
 * @author 牟连波
 * @date 2021-04-11
 */
@Api(value = "收藏管理控制器", tags = {"收藏管理管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/bysj/collect")
public class CollectController extends BaseController {

    private final ICollectService iCollectService;

    /**
     * 查询收藏管理列表
     */
    @ApiOperation("查询收藏管理列表")
    @PreAuthorize("@ss.hasPermi('bysj:collect:list')")
    @GetMapping("/list")
    public TableDataInfo<Collect> list(Collect bo) {
        startPage();
        List<Collect> list = iCollectService.selectCollectList(bo);
        return getDataTable(list);
    }

    /**
     * 导出收藏管理列表
     */
    @ApiOperation("导出收藏管理列表")
    @PreAuthorize("@ss.hasPermi('bysj:collect:export')")
    @Log(title = "收藏管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<Collect> export(Collect bo) {
        List<Collect> list = iCollectService.selectCollectList(bo);
        ExcelUtil<Collect> util = new ExcelUtil<Collect>(Collect.class);
        return util.exportExcel(list, "collect" );
    }

    /**
     * 获取收藏管理详细信息
     */
    @ApiOperation("获取收藏管理详细信息")
    @PreAuthorize("@ss.hasPermi('bysj:collect:query')")
    @GetMapping("/{patientId}")
    public AjaxResult<CollectVo> getInfo(@PathVariable("patientId" ) Long patientId) {
        return AjaxResult.success(iCollectService.queryById(patientId));
    }

    /**
     * 新增收藏管理
     */
    @ApiOperation("新增收藏管理")
    @PreAuthorize("@ss.hasPermi('bysj:collect:add')")
    @Log(title = "收藏管理", businessType = BusinessType.INSERT)
    @PostMapping()
    public AjaxResult<Void> add(@RequestBody CollectAddBo bo) {
        return toAjax(iCollectService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改收藏管理
     */
    @ApiOperation("修改收藏管理")
    @PreAuthorize("@ss.hasPermi('bysj:collect:edit')")
    @Log(title = "收藏管理", businessType = BusinessType.UPDATE)
    @PutMapping()
    public AjaxResult<Void> edit(@RequestBody CollectEditBo bo) {
        return toAjax(iCollectService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除收藏管理
     */
    @ApiOperation("删除收藏管理")
    @PreAuthorize("@ss.hasPermi('bysj:collect:remove')")
    @Log(title = "收藏管理" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{patientIds}")
    public AjaxResult<Void> remove(@PathVariable Long[] patientIds) {
        return toAjax(iCollectService.deleteWithValidByIds(Arrays.asList(patientIds), true) ? 1 : 0);
    }
}
