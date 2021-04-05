package io.dolphin.web.async;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 * @create 2019 07 21 17:19
 */
@Component
@Data
public class DeferredResultHolder {
    private Map<String, DeferredResult<String>> map = new HashMap<>();
}
