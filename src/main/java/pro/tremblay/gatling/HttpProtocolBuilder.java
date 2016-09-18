package pro.tremblay.gatling;

/**
 * @author Henri Tremblay
 */
public class HttpProtocolBuilder {
    public HttpProtocolBuilder baseURL(String s) {
        return this;
    }

    public HttpProtocolBuilder acceptHeader(String s) {
        return this;
    }


    public HttpProtocolBuilder doNotTrackHeader(String s) {
        return this;
    }

    public HttpProtocolBuilder acceptLanguageHeader(String s) {
        return this;
    }

    public HttpProtocolBuilder acceptEncodingHeader(String s) {
        return this;
    }

    public HttpProtocolBuilder userAgentHeader(String s) {
        return this;
    }

    public HttpConf build() {
        return null;
    }
}
