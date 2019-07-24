package spring.boot.redis.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class MyErrorHandler implements ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Override
    public void handleError(Throwable throwable) {
        LOGGER.error("MyErrorHandler: {}", throwable.getCause());
    }
}