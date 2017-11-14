package com.guods.springboot.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guods.springboot.service.RedisService;

@Component
public class SecondKill {

	@Autowired
	private RedisService redisService;
	
	public void add2Redis(String k, String v){
		//获取k
		String a = redisService.getString(k);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//如果没有k，设置k
		if (a == null) {
			Object r = redisService.compareAndSet(k, v);
			if (r != null) {
				System.out.println(Thread.currentThread().getName() + "set :" + new String((byte[])r));
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//设置完后取出k
		a = redisService.getString(k);
		System.out.println(Thread.currentThread().getName() + "get :" + a);
	}
	
	public void decrNumber(String key, Long num){
		Long remainCount = Long.valueOf(redisService.getString(key));
		if (remainCount <= 0) {
			System.out.println(Thread.currentThread().getName() + " has no count failed:" + remainCount);
			return;
		}
		Long prodNum = redisService.incr(key, num);
		if (prodNum < 0) {
			System.out.println(Thread.currentThread().getName() + "second kill failed：" + prodNum);
		}else {
			System.out.println(Thread.currentThread().getName() + "second kill success：" + prodNum);
		}
	}
	
	public void multiThreadAdd2Redis(final String key, final String value){
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		//删除key
		System.out.println(redisService.remove(key));
		for (int i = 0; i < 10; i++) {
			
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					add2Redis(key, value);
				}
			});
		}
		countDownLatch.countDown();
	}
	
	public void multiThreadSecKill(final String key, final Long num){
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		//删除key
		for (int i = 0; i < 100; i++) {
			
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					decrNumber(key, num);
				}
			});
		}
		countDownLatch.countDown();
	}
}
