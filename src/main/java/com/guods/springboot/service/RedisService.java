package com.guods.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.guods.springboot.common.util.NullUtil;

@Service
public class RedisService {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public Long getLong(final String key){
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				Object result = connection.get(key.getBytes());
				if (result != null) {
					return (Long)result;
				}
				return null;
			}
		});
	}
	/**
	 * 获取key
	 * @param key
	 * @return
	 */
	public String getString(final String key){
		return (String)redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] result = connection.get(key.getBytes());
				if (result != null) {
					return new String(result);
				}
				return null;
			}
		});
	}
	/**
	 * 增加key
	 * @param key
	 * @param i
	 * @return
	 */
	public Long incr(final String key, final long i){
		return (Long)redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.incrBy(key.getBytes(), i);
			}
		});
	}
	
	public Long remove(final String key){
		return redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				Long del = connection.del(key.getBytes());
				return del;
			}
		});
	}
	/**
	 * 设置key
	 * @param key
	 * @param value
	 * @return
	 */
	public Object compareAndSet(final String key, final String value){
		return (Object)redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.watch(key.getBytes());
				connection.multi();
				byte[] bs = connection.get(key.getBytes());
				if (bs != null) {
					connection.discard();
					connection.unwatch();
					return null;
				}
				connection.set(key.getBytes(), value.getBytes());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "---in set---" + value);
				List<Object> result = connection.exec();
				if (NullUtil.isEmpty(result)) {
					return null;
				}
				return result.get(0);
			}
		});
	}
}
