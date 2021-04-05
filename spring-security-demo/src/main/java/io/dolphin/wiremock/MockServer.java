package io.dolphin.wiremock;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author Eric
 * @create 2019 07 21 21:48
 */
public class MockServer {
    public static void main(String[] args) throws IOException {
        configureFor(8080);
        removeAllMappings();

        mock("/order/1", "01");
    }

    private static void mock(String url,String filename) throws IOException {
        ClassPathResource pathResource = new ClassPathResource("mock/response/"+filename+".txt");
        String content = StringUtils.join(FileUtils.readLines(pathResource.getFile(), "UTF-8").toArray(), "\n");
        // 伪造测试桩
        stubFor(get(urlPathEqualTo(url))
            .willReturn(aResponse().withBody(content).withStatus(200)));
    }
}
