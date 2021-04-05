package io.dolphin.dto;

import lombok.Data;

/**
 * @author Eric
 * @create 2019 07 20 21:55
 */
@Data
public class FileInfo {
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }
}
