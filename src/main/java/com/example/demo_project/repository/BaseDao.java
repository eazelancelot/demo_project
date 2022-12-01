package com.example.demo_project.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class BaseDao {
	
	@PersistenceContext //JPA 專有的注釋
    private EntityManager entityManager;
	
	/*
	 * createQuery
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, 
			Class<EntityType> clazz) { // 無每次結果要返回筆數
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			// 原本使用 entrySet 遍歷取值
//			for(Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
                query.setParameter(p, params.get(p.getName()));
            }
		}
		return query.getResultList();
    }
	
	/*
	 * createQuery
	 */
//	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, 
//			Class<EntityType> clazz) {
//		return doQuery(sql, params, clazz, -1);
//    }
	
	/**
	 * @param pageSize: 每次結果要返回的筆數，同 limit
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, 
			Class<EntityType> clazz, int pageSize) { 
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			// 原本使用 entrySet 遍歷取值
//			for(Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
                query.setParameter(p, params.get(p.getName()));
            }
		}
		if (pageSize > 0) {
            query.setMaxResults(pageSize);
        }
		return query.getResultList();
    }
	
	/**
	 * @param pageSize: 每次結果要返回的筆數，同 limit
	 * @param startPosition: 返回結果的起始筆數位置
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, 
			Class<EntityType> clazz, int pageSize, int startPosition) {
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			// 原本使用 entrySet 遍歷取值
//			for(Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
                query.setParameter(p, params.get(p.getName()));
            }
		}
		if (pageSize > 0) {
            query.setMaxResults(pageSize);
        }
		if (startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
		return query.getResultList();
    }
	
	/*
	 * createNativeQuery
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    protected <EntityType> List<EntityType> doNativeQuery(String nativeSql, Map<String, Object> params, 
    		Class<EntityType> clazz, int pageSize, int startPosition) {
        Query query = null;
        if (clazz == null) {
            query = entityManager.createNativeQuery(nativeSql);
        } else {
            query = entityManager.createNativeQuery(nativeSql, clazz);
        }
        if (!CollectionUtils.isEmpty(params)) {
            for(Parameter p : query.getParameters()) {
                query.setParameter(p, params.get(p.getName()));
            }
        }
        if (pageSize > 0) {
            query.setMaxResults(pageSize);
        }
		if (startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
        return query.getResultList();
    }
	
	/*
	 * execute update
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    protected int doUpdate(String sql, Map<String, Object> params) {
        Query query = entityManager.createQuery(sql);
        if (!CollectionUtils.isEmpty(params)) {
            for(Parameter p : query.getParameters()) {
                query.setParameter(p, params.get(p.getName()));
            }
        }
        return query.executeUpdate();
    }
	
	/*
	 * execute native update
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    protected int doNativeUpdate(String nativeSql, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(nativeSql);
        if (!CollectionUtils.isEmpty(params)) {
            for(Parameter p : query.getParameters()) {
                query.setParameter(p, params.get(p.getName()));
            }
        }
        return query.executeUpdate();
    }
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//    protected final <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz, Integer pageSize) {
//        return doQuery(sql, clazz, pageSize, (query) -> {
//            for(Parameter p : query.getParameters()) {
//                query.setParameter(p, params.get(p.getName()));
//            }
//            return query.getResultList();
//        });
//    }

//    @SuppressWarnings("unchecked")
//    private <EntityType> List<EntityType> doQuery(String sql, Class<EntityType> clazz, Integer pageSize, Function<Query, List<EntityType>> function) {
//        Query query;
//
//        try {
//            query = entityManager.createQuery(sql, clazz);
//
//            if (pageSize != null && pageSize > 1) {
//                query.setMaxResults(pageSize);
//            }
//
//            return function.apply(query);
//        } catch (Exception e) {
//            this.logger.debug("doQuery error: " + e);
//            return Collections.EMPTY_LIST;
//        }
//    }

}
