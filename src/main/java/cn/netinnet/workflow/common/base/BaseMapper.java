package cn.netinnet.workflow.common.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author 欧阳宣来
 * @date 2017/12/8
 */
public interface BaseMapper<T, E> {
    /**
     * 通过主键查找对象
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(long id);

    /**
     * 条件查询
     *
     * @param example
     * @return
     */
    List<T> selectByExample(E example);

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(long id);

    /**
     * 条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(E example);

    /**
     * 条件统计
     *
     * @param example
     * @return
     */
    long countByExample(E example);

    /**
     * 通过主键更新
     *
     * @param t
     * @return
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * 条件更新，更新全字段
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") T record, @Param("example") E example);

    /**
     * 条件更新，更新部分字段
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    /**
     * 新增部分字段
     *
     * @param t
     * @return
     */
    int insertSelective(T t);

    /**
     * 条件查询
     *
     * @param t
     * @return
     */
    List<T> getList(@Param("item") T t);

    /**
     * 批量插入，全字段
     *
     * @param list
     * @return
     */
    int batchInsert(List<T> list);

    /**
     * 批量插入，全字段--快速
     *
     * @param list
     * @return
     */
    int batchInsertFast(List<T> list);

    /**
     * 批量插入，部分字段
     *
     * @param list
     * @return
     */
    int batchInsertSelective(List<T> list);

    /**
     * 批量删除，通过列表
     *
     * @param list
     * @return
     */
    int batchDeleteByList(List<Long> list);

    /**
     * 批量删除，通过数组
     *
     * @param ids
     * @return
     */
    int batchDeleteByArray(long[] ids);

    /**
     * 批量更新，通过主键
     *
     * @param list
     * @return
     */
    int batchUpdateByPrimaryKey(List<T> list);

}