package com.yizhen.demo.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import com.yizhen.demo.base.CommonDao;
import com.yizhen.demo.entities.City;

@Repository(value="cityDao")
@Cacheable(value="redisCache")
public class CityDaoImpl extends CommonDao implements CityDao {
    Logger logger = LoggerFactory.getLogger(CityDaoImpl.class);
    
//    protected RedisTemplate<String,City> redisTemplate;
//    
//	 public RedisTemplate<String, City> getRedisTemplate() {
//		 return redisTemplate;
//	 }
//
//
//	 public void setRedisTemplate(RedisTemplate<String, City> redisTemplate) {
//		 this.redisTemplate = redisTemplate;
//	 }
	 
	@Override
	public City selectCity(String id) {
//        BoundValueOperations<String, City> boundValueOps = redisTemplate.boundValueOps("city_"+id);  
//        City serializable = (City) boundValueOps.get();  
//        if(serializable == null ){
        	City city = (City) sqlSessionTempalte.selectOne("selectCity", id);    
//    	    ValueOperations<String, City> valueOps = redisTemplate.opsForValue();  
//    	    valueOps.set("city_"+city.getId(), city);  
//    	   	logger.info("插入缓存");
    	   	return city;
//        }else{
//        	logger.info("从缓存读");
//        	return serializable; 
//        }
 }
}
