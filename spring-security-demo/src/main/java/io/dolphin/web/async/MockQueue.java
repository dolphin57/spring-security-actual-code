package io.dolphin.web.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @create 2019 07 21 17:14
 */
@Data
@Slf4j
@Component
public class MockQueue {
    private String placeOrder;

    private String completeOrder;

    public void setPlaceOrder(String placeOrder) {
        new Thread(() -> {
            log.info("接到下单请求," + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            log.info("下单请求处理完毕," + placeOrder);
        }).start();
    }
}
