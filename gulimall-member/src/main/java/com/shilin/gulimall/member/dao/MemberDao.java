package com.shilin.gulimall.member.dao;

import com.shilin.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 19:43:40
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
