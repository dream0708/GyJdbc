package com.gysoft.jdbc.dao;

import com.gysoft.jdbc.bean.*;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 *@author 周宁
 */
public interface EntityDao<T,Id extends Serializable>{

	/**
	 * 设置一些操作的常量
	 */
	String SQL_INSERT = "insert";
	String SQL_UPDATE = "update";
	String SQL_DELETE = "delete";
	String SPACE = " ";
	String SQL_IN = "IN";
	String SQL_NOT_IN = "NOT IN";
	char IN_START = '(';
	char IN_END = ')';
	String SQL_IS = "IS";
	String SQL_ORDER_BY = "ORDER BY";
	String SQL_GROUP_BY = "GROUP BY";

	/**
	 * 插入指定的持久化对象
	 * @throws Exception sql错误抛出异常
	 * @param t 实体对象
	 */
	void save(T t) throws Exception ;

	/**
	 * 修改指定的持久化对象
	 * @throws Exception sql错误抛出异常
	 * @param t 实体对象
	 */
	void update(T t) throws Exception ;

	/**
	 * 批量保存指定的持久化对象
	 * @throws Exception sql错误抛出异常
	 * @param list 实体对象集合
	 */
	void batchSave(List<T> list) throws Exception ;

	/**
	 * 批量更新指定的持久化对象
	 * @throws Exception sql错误抛出异常
	 * @param list 实体对象集合
	 */
	void batchUpdate(List<T> list) throws Exception ;

	/**
	 * 根据主键删除
	 * @throws Exception sql错误抛出异常
	 * @param id 实体主键
	 */
	void delete(Id id) throws Exception ;

	/**
	 * 根据where条件删除
	 * @param criteria 条件参数
	 * @throws Exception sql错误抛出异常
	 */
	void deleteWithCriteria(Criteria criteria) throws Exception;

	/**
	 * 根据主键批量删除
	 * @throws Exception sql错误抛出异常
	 * @param ids 主键集合
	 */
	void batchDelete(List<Id> ids) throws Exception ;

	/**
	 * 根据ID检索持久化对象
	 * @param id 主键
	 * @return T 实体对象
	 * @throws Exception sql错误抛出异常
	 */
	T queryOne(Id id) throws Exception ;

	/**
	 * 检索所有持久化对象
	 * @return List 实体对象列表
	 * @throws Exception sql错误抛出异常
	 */
	List<T> queryAll() throws Exception ;

	/**
	 * 分页查询
	 * @param page 分页条件
	 * @return PageResult 分页查询结果
	 * @throws Exception sql错误抛出异常
	 */
	PageResult<T> pageQuery(Page page) throws Exception;

	/**
	 * 分页条件查询
	 * @param page 分页条件
	 * @param criteria 查询条件
	 * @return PageResult 分页查询结果
	 * @throws Exception sql错误抛出异常
	 */
	PageResult<T> pageQueryWithCriteria(Page page, Criteria criteria) throws Exception;

	/**
	 * 条件查询
	 * @param criteria 查询条件
	 * @return List 结果集
	 * @throws Exception sql错误抛出异常
	 */
	List<T> queryWithCriteria(Criteria criteria) throws Exception;

	/**
	 * 根据条件查询
	 * @param criteria 查询条件
	 * @return T 实体对象
	 * @throws Exception sql错误抛出异常
	 */
	T queryOne(Criteria criteria)throws Exception;

	/**
	 * 根据条件查询Map集合
	 * @param criteria 查询条件
	 * @return List 结果集
	 * @throws Exception sql错误抛出异常
	 */
	List<Map<String,Object>> queryMapsWithCriteria(Criteria criteria)throws Exception;

	/**
	 * 根据条件查询Map
	 * @param criteria 查询条件
	 * @param resultSetExtractor 结果抽取器
	 * @return Map 结果集
	 * @throws Exception sql错误抛出异常
	 */
	Map<String,Object> queryMapWithCriteria(Criteria criteria, ResultSetExtractor<Map<String, Object>> resultSetExtractor)throws Exception;

	/**
	 * 根据条件查询某个整数列值
	 * @param criteria 查询条件
	 * @return Integer int结果
	 * @throws Exception sql错误抛出异常
	 */
	Integer queryIntegerWithCriteria(Criteria criteria)throws Exception;

	/**
	 * 根据条件查询某个字符列值
	 * @param criteria 查询条件
	 * @return String string类型的结果
	 * @throws Exception sql错误抛出异常
	 */
	String queryStringWithCriteria(Criteria criteria)throws Exception;

	/**
	 * 根据条件更新
	 * @param criteria 查询条件
	 * @return int 更新条目数量
	 * @throws Exception sql错误抛出异常
	 */
	int updateWithCriteria(Criteria criteria)throws Exception;

	/**
	 * 使用自定义sql
	 * @param clss Class类型
	 * @param sql 自定义Sql
	 * @param params 参数数组
	 * @param <E> 结果泛型
	 * @return Result 结果集
	 * @throws Exception 异常
	 */
	<E>Result<E> useSql(Class<E> clss,String sql, Object... params)throws Exception;

	/**
	 * 使用自定义sql
	 * @param sql 自定义sql
	 * @param params 参数数组
	 * @param <E> 结果泛型
	 * @return Result 结果集
	 * @throws Exception 异常
	 */
	<E extends Map<String, Object>> Result<E> useSql(String sql, Object... params)throws Exception;

	/**
	 * 使用自定义sql
	 * @param clss Class类型
	 * @param iSqlParamMapProvider sql和paramMap策略类
	 * @param <E> 结果泛型
	 * @return Result 结果集
	 * @throws Exception 异常
	 */
	<E> Result<E> useSql(Class<E> clss, ISqlParamMapProvider iSqlParamMapProvider)throws Exception;

	/**
	 * 多表连接查询
	 * @param clss clss Class类型
	 * @param criteria 查询条件
	 * @param <E> 结果泛型
	 * @return Result
	 * @throws Exception
	 */
	<E> Result<E> joinQuery(Class<E> clss, Criteria criteria)throws Exception;
}
