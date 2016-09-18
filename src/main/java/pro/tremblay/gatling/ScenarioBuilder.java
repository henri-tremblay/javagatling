package pro.tremblay.gatling;

import java.time.Duration;

/**
 * @author Henri Tremblay
 */
public class ScenarioBuilder {

    public ScenarioBuilder(String name) {

    }

    public ScenarioBuilder exec(ActionBuilder actionBuilder) {
        return this;
    }

    public ScenarioBuilder pause(Duration duration) {
        return this;
    }

    public ScenarioBuilder pause(long millis) {
        return this;
    }

    public Scenario build() {
        return new Scenario();
    }
}
