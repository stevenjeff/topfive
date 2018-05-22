package com.fangrui.repository;

import com.fangrui.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/21
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
