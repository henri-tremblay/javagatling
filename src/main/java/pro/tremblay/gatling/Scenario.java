package pro.tremblay.gatling;

/**
 * @author Henri Tremblay
 */
public class Scenario {

    public Scenario inject(InjectionStep step) {
        return this;
    }

    public Scenario protocols(HttpConf httpConf) {
        return this;
    }
}
