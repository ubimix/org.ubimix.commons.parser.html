package org.ubimix.commons.parser.html;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class TestUtil {

    public static String readResource(Class<?> cls, String resource)
        throws IOException {
        String path = "/"
            + cls.getPackage().getName().replace('.', '/')
            + "/"
            + resource;
        InputStream input = cls.getResourceAsStream(path);
        String str;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024 * 10];
            int len;
            while ((len = input.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            str = new String(out.toByteArray(), "UTF-8");
        } finally {
            input.close();
        }
        return str;
    }

}
