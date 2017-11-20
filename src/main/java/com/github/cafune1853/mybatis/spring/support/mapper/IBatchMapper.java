package com.github.cafune1853.mybatis.spring.support.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.github.cafune1853.mybatis.spring.support.annotation.AutoResultMap;
import com.github.cafune1853.mybatis.spring.support.provider.BatchProvider;

/**
 */
public interface IBatchMapper<T> {
    @InsertProvider(type = BatchProvider.class, method = "batchInsert")
    int batchInsert(@Param(BatchProvider.KEY) List<T> list);

    @UpdateProvider(type = BatchProvider.class, method = "batchUpdate")
    int batchUpdate(@Param(BatchProvider.KEY) List<T> list);

    @AutoResultMap
    @SelectProvider(type = BatchProvider.class, method = "findBatchIds")
    List<T> findBatchIds(@Param(BatchProvider.KEY) List<? extends Serializable> list, @Param(BatchProvider.COLUMN) String column);
}
