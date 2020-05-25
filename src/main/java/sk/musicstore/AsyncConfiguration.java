package sk.musicstore;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * The configuration class will be used to enable and configure the asynchronous method execution.
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.scheduling.annotation.EnableAsync
 * @author Holubenko Vladyslav
 * 
 *
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {
	/**
	 * @value LOGGER logs when some thread starts
	 */
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfiguration.class);
	/**
	 * The bean taskExecutor helps to customize the thread executor such as configuring the number of threads for an application,
	 *  queue limit size, and so on. Spring will specifically look for this bean when the server is started.
	 * @return returns executor
	 */
	 @Bean (name = "taskExecutor")
	    public Executor taskExecutor() {
		 LOGGER.debug("Creating Async Task Executor");
	        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(6);
	        executor.setMaxPoolSize(6);
	        executor.setQueueCapacity(100);
	        executor.setThreadNamePrefix("ProductThread-");
	        executor.initialize();
	        return executor;
	    }
}
