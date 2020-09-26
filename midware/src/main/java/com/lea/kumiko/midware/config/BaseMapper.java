package com.lea.kumiko.midware.config;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *      基础 Mapper
 * @param <T>
 */
public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, MySqlMapper<T>, ExampleMapper<T> {
}
