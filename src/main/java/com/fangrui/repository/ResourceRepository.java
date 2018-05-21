package com.fangrui.repository;

import com.fangrui.domain.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/21
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    /**
     * 分页查询
     *
     * @param pageable
     * @return Page
     */
    public Page<Resource> findAll(Pageable pageable);

    public Page findByName(@Param(value = "name") String name, Pageable pageable);
}
