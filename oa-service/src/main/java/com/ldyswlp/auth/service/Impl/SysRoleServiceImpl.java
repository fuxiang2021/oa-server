package com.ldyswlp.auth.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldyswlp.auth.mapper.SysRoleMapper;
import com.ldyswlp.auth.service.SysRoleService;
import com.ldyswlp.model.system.SysRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
