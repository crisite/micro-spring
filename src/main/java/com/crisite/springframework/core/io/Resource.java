package com.crisite.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/10 11:47
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
