package com.ruoyi.bysj.controller;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.bysj.domain.Relation;
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
import com.ruoyi.bysj.vo.RelationVo;
import com.ruoyi.bysj.bo.RelationQueryBo;
import com.ruoyi.bysj.bo.RelationAddBo;
import com.ruoyi.bysj.bo.RelationEditBo;
import com.ruoyi.bysj.service.IRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 家庭成员管理Controller
 *
 * @author 牟连波
 * @date 2021-04-17
 */
@Api(value = "家庭成员管理控制器", tags = {"家庭成员管理管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/bysj/relation")
public class RelationController extends BaseController {

    private final IRelationService iRelationService;

    /**
     * 查询家庭成员管理列表
     */
    @ApiOperation("查询家庭成员管理列表")
    @PreAuthorize("@ss.hasPermi('bysj:relation:list')")
    @GetMapping("/list")
    public TableDataInfo<Relation> list(Relation bo) {
        startPage();
        List<Relation> list = iRelationService.queryList(bo);
        return getDataTable(list);
    }

    /**
     * 导出家庭成员管理列表
     */
    @ApiOperation("导出家庭成员管理列表")
    @PreAuthorize("@ss.hasPermi('bysj:relation:export')")
    @Log(title = "家庭成员管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<Relation> export(Relation bo) {
        List<Relation> list = iRelationService.queryList(bo);
        ExcelUtil<Relation> util = new ExcelUtil<Relation>(Relation.class);
        return util.exportExcel(list, "relation" );
    }

    /**
     * 获取家庭成员管理详细信息
     */
    @ApiOperation("获取家庭成员管理详细信息")
    @PreAuthorize("@ss.hasPermi('bysj:relation:query')")
    @PostMapping("/selectOne")
    public AjaxResult<Relation> getInfo(@RequestBody Relation relation) {
        return AjaxResult.success(iRelationService.selectRelation(relation));
    }

    /**
     * 新增家庭成员管理
     */
    @ApiOperation("新增家庭成员管理")
    @PreAuthorize("@ss.hasPermi('bysj:relation:add')")
    @Log(title = "家庭成员管理", businessType = BusinessType.INSERT)
    @PostMapping()
    public AjaxResult<Void> add(@RequestBody RelationAddBo bo) {
        return toAjax(iRelationService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改家庭成员管理
     */
    @ApiOperation("修改家庭成员管理")
    @PreAuthorize("@ss.hasPermi('bysj:relation:edit')")
    @Log(title = "家庭成员管理", businessType = BusinessType.UPDATE)
    @PutMapping()
    public AjaxResult<Void> edit(@RequestBody RelationEditBo bo) {
        return toAjax(iRelationService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除家庭成员管理
     */
    @ApiOperation("删除家庭成员管理")
    @PreAuthorize("@ss.hasPermi('bysj:relation:remove')")
    @Log(title = "家庭成员管理" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult<Void> remove(@PathVariable Long[] userIds) {
        return toAjax(iRelationService.deleteWithValidByIds(Arrays.asList(userIds), true) ? 1 : 0);
    }
}
