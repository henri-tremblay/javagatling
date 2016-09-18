package pro.tremblay.gatling;

import java.util.Map;

/**
 * @author Henri Tremblay
 */
public class HttpDsl implements ActionBuilder {

    public static HttpDsl http(String requestName) {
        return new HttpDsl(requestName);
    }

    public HttpDsl(String requestName) {

    }

    public HttpDsl get(String url) {
        return this;
    }

    public HttpDsl post(String url) {
        return this;
    }

    public HttpDsl headers(Map<String, String> headers) {
        return this;
    }

    public HttpDsl formParam(String name, String value) {
        return this;
    }
}
