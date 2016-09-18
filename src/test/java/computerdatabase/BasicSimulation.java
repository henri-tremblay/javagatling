package computerdatabase;

import pro.tremblay.gatling.HttpConf;
import pro.tremblay.gatling.Scenario;
import pro.tremblay.gatling.Simulation;

import java.util.Map;

import static java.time.Duration.*;
import static pro.tremblay.gatling.HttpDsl.*;

public class BasicSimulation extends Simulation {
  
  HttpConf httpConf = http
    .baseURL("http://computer-database.gatling.io") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .build();

  // Note the headers specific to a given request
  Map<String, String> headers_10 = headers(
      header("Content-Type", "application/x-www-form-urlencoded")
  );

  Scenario scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
      .exec(http("request_1")
          .get("/"))
      .pause(7) // Note that Gatling has recorded real time pauses
      .exec(http("request_2")
          .get("/computers?f=macbook"))
      .pause(2)
      .exec(http("request_3")
          .get("/computers/6"))
      .pause(3)
      .exec(http("request_4")
          .get("/"))
      .pause(2)
      .exec(http("request_5")
          .get("/computers?p=1"))
      .pause(ofMillis(670))
      .exec(http("request_6")
          .get("/computers?p=2"))
      .pause(ofMillis(629))
      .exec(http("request_7")
          .get("/computers?p=3"))
      .pause(ofMillis(734))
      .exec(http("request_8")
          .get("/computers?p=4"))
      .pause(5)
      .exec(http("request_9")
          .get("/computers/new"))
      .pause(1)
      .exec(http("request_10") // Here's an example of a POST request
          .post("/computers")
          .headers(headers_10)
          .formParam("name", "Beautiful Computer") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
          .formParam("introduced", "2012-05-30")
          .formParam("discontinued", "")
          .formParam("company", "37"))
      .build();

  @Override
  public void run() {
    setUp(scn.inject(atOnceUsers(1)).protocols(httpConf));
  }

}
