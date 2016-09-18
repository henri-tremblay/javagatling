package pro.tremblay.gatling;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Henri Tremblay
 */
public abstract class Simulation implements Runnable {

    protected HttpProtocolBuilder http = new HttpProtocolBuilder();

    protected Map<String, String> headers(HeaderEntry... headers) {
        return Arrays.stream(headers).collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue
        ));
    }

    protected HeaderEntry header(String key, String value) {
        return new HeaderEntry(key, value);
    }

    protected ScenarioBuilder scenario(String name) {
        return new ScenarioBuilder(name);
    }

    protected void setUp(Scenario scenario) {

    }

    protected InjectionStep atOnceUsers(int i) {
        return new InjectionStep();
    }
}
