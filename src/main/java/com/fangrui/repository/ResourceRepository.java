package com.fangrui.repository;

import com.fangrui.domain.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/21
 */
@RepositoryRestResource(path = "resource")
public interface ResourceRepository extends JpaRepository<Resource, Long>, JpaSpecificationExecutor<Resource> {
    /**
     * 分页查询
     *
     * @param pageable
     * @return Page
     */
    @Override
    @RestResource(path = "resourcePage", rel = "resourcePage")
    public Page<Resource> findAll(Pageable pageable);
}
