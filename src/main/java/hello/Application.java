package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ErrorHandler;

@SpringBootApplication
@EnableScheduling
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	private static StringRedisTemplate template;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		template = ctx.getBean(StringRedisTemplate.class);
	}

	@Scheduled(initialDelay = 5000L, fixedRate = 5000L)
	private void sendMessage(){
		LOGGER.info("Sending message...");
		template.convertAndSend("chat", "Hello from Redis!");
	}
}