package networking;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        URLDemo demo = new URLDemo();
        demo.entrypoint();
    }
    private void entrypoint() throws UnsupportedEncodingException {
//        String param = "bAZ1+wYEmfmK87sBD4KLrXdNjcps5AzFbUgV98uR+aYMJWyY9r5sCGkhoG9A26EZQXIQC0DlwhezbfwS5NTYZ4a+2lIfzS8n7Z28bUsuH1+M7XMQPci48o60iwHwHm5qxdeK1EPUMm36C6DKjUzqmhQY+F8=";
        String link = "bAZ1%2BzPcdK5cr%2F1xw2EEvP4XKL0FRzVhpvsbBVkVKXtBB3jyFkOa%2BfMTLyfQCPpx8cf%2Bd97xPc4OX4rZbuWSywKe5ReLmfeT5yrMFsq7Mb14urSt5hJSETgAT4pRdOw1%2FEtbhSux5X88FBTYH%2Bj9e7dbASE%3D";
        String encoded = URLDecoder.decode(link, "UTF-8");
        System.out.println(encoded);
    }
}
