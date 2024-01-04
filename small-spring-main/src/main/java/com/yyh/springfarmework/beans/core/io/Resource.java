package com.yyh.springfarmework.beans.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sora
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
