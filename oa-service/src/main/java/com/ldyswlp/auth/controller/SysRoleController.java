package com.ldyswlp.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldyswlp.auth.service.SysRoleService;
import com.ldyswlp.common.result.Result;
import com.ldyswlp.model.system.SysRole;
import com.ldyswlp.util.FormatQueryPage;
import com.ldyswlp.vo.PageVo;
import com.ldyswlp.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Api(tags = "角色管理相关")
@RestController
@RequestMapping("/system")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 查询角色
     * @param sysRoleQueryVo 模糊查询条件
     * @param pageVo         分页查询条件
     */
    @ApiOperation("查询角色")
    @GetMapping("/roles")
    public Result<HashMap<String, Object>> findRoles(PageVo pageVo, SysRoleQueryVo sysRoleQueryVo) {

        String roleName = sysRoleQueryVo.getRoleName();
        Long page = pageVo.getPage();
        Long pageSize = pageVo.getPageSize();

        Page<SysRole> pageParam = new Page<>(page, pageSize);
        // 封装条件
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();

        // 如果查询条件不为空设置模糊查询条件
        if (roleName != null) {
            wrapper.like(SysRole::getRoleName, roleName);
        }

        // 进行查询
        Page<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);

        // 优化返回结果
        HashMap<String, Object> data = FormatQueryPage.format(pageModel);

        return Result.success(data);
    }

    /**
     * 根据 id 进行查询
     * @param id 查询的 id
     */
    @ApiOperation("根据id查询")
    @GetMapping("/roles/{id}")
    public Result<SysRole> queryById(@PathVariable Long id) {

        SysRole role = sysRoleService.getById(id);

        if (role == null) return Result.noFoundFail();

        return Result.success(role);
    }

    /**
     * 添加角色
     * @param role 添加的角色
     */
    @ApiOperation("添加角色")
    @PostMapping("/roles")
    public Result<Object> addRoles(@RequestBody SysRole role) {
        boolean is_success = sysRoleService.save(role);

        if (!is_success) return Result.createFail();

        return Result.createSuccess();
    }

    /**
     * 根据 id 进行查询
     * @param role 要修改的角色
     */
    @ApiOperation("修改角色")
    @PutMapping("/roles")
    public Result<SysRole> updateById(@RequestBody SysRole role) {
        boolean is_success = sysRoleService.updateById(role);

        if (!is_success) return Result.updateFail();

        return Result.createSuccess();
    }

    /**
     * 根据 id 删除
     * @param id 角色 id
     */
    @ApiOperation("删除角色")
    @DeleteMapping("/roles/{id}")
    public Result<Object> removeById(@PathVariable Long id) {
        boolean is_success = sysRoleService.removeById(id);

        if (!is_success) return Result.noFoundFail();

        return Result.deleteSuccess();
    }

    /**
     * 批量删除角色
     *
     */
    @ApiOperation("批量删除角色")
    @DeleteMapping("/roles")
    public Result<Object> batchRemove(@RequestBody List<Long> idList) {
        boolean is_success = sysRoleService.removeByIds(idList);

        if (!is_success) return Result.noFoundFail();

        return Result.deleteSuccess();
    }
}
