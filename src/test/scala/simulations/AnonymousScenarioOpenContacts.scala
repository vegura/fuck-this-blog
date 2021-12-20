package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AnonymousScenarioOpenContacts extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
//    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")

  private val headers_2 = Map(
    "Content-Type" -> "multipart/form-data; boundary=---------------------------7862269131504578011791792878",
    "Origin" -> "http://51.116.187.213"
  )

  private val headers_3 = Map(
    "Content-Type" -> "multipart/form-data; boundary=---------------------------24461960623322713611657342039",
    "Origin" -> "http://51.116.187.213"
  )

  private val scn = scenario("AnonymousScenarioOpenContacts")
    .exec(
      http("request_0")
        .get("/blog/")
    )
    .pause(1)
    .exec(
      http("request_1")
        .get("/blog/contact")
    )
    .pause(45)
    .exec(
      http("request_2")
        .post("/blog/contact")
        .headers(headers_2)
        .body(RawFileBody("simulations/anonymousscenarioopencontacts/0002_request.html"))
    )
    .pause(5)
    .exec(
      http("request_3")
        .post("/blog/contact")
        .headers(headers_3)
        .body(RawFileBody("simulations/anonymousscenarioopencontacts/0003_request.html"))
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
