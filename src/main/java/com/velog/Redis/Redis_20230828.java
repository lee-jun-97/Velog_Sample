package com.velog.Redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Redis_20230828 {
	
	private RedisTemplate<String, String> redisTemplate;
		
	public Redis_20230828(RedisTemplate<String, String> redis) {
		this.redisTemplate = redis;
	}
	
	@GetMapping("/redis")
	@ResponseBody
	public String redisTest() {
		StringBuilder sb = new StringBuilder();
		
		redisTemplate.opsForValue().set("test", "test");
		redisTemplate.opsForValue().set("test2", "test2");

		sb.append(redisTemplate.opsForValue().get("test").equals("test")).append("\n");
		sb.append(redisTemplate.opsForValue().get("test2").equals("test2"));
		
		return sb.toString();
	}

}
