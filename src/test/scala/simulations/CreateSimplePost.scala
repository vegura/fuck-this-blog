package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class CreateSimplePost extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
    //    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")

  private val headers_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
    "Upgrade-Insecure-Requests" -> "1"
  )

  private val headers_1 = Map("Accept" -> "image/avif,image/webp,*/*")

  private val headers_2 = Map(
    "Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
    "Accept-Encoding" -> "identity",
    "Origin" -> "http://51.116.187.213"
  )

  private val headers_3 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
    "Origin" -> "http://51.116.187.213",
    "Upgrade-Insecure-Requests" -> "1"
  )

  private val headers_5 = Map("x-blog-instance" -> "96d5b379-7e1d-4dac-a6ba-1e50db561b04")

  private val headers_9 = Map(
    "Content-Type" -> "application/json;charset=utf-8",
    "Origin" -> "http://51.116.187.213",
    "x-blog-instance" -> "96d5b379-7e1d-4dac-a6ba-1e50db561b04"
  )

  private val uri2 = "http://fonts.gstatic.com/s/roboto/v29/KFOmCnqEu92Fr1Mu5mxKOzY.woff2"

  private val scn = scenario("RecordedSimulation")
    .exec(
      http("login")
        .get("/blog/Account/login.aspx")
        .headers(headers_0)
    )
    .pause(1)
    .exec(
      http("headers 1")
        .get(uri2)
        .headers(headers_2)
    )
    .pause(15)
    .exec(
      http("authentication")
        .post("/blog/Account/login.aspx")
        .headers(headers_3)
        .formParam("__VIEWSTATE", "94ELNsGMHgld552SBVr0Lr1e0ycUgoS+UisiiDErIVeJPfC1dqIo6rOcqHsqoQUf0cUF05pW/5DHAT7Dn4OvUz4hCTdFy5L+N+SfrFTdvx40JWWQaH3WOf9EGaQT/lWDiuEyvkKVH9qeWQ/t+0hXFkthgTuiEBcHfDnS9OHP8im1PFYz")
        .formParam("__VIEWSTATEGENERATOR", "B42CDBE2")
        .formParam("__EVENTVALIDATION", "gnwbqLMxLvcSpYH995LEUPLe800di9madiRmg0t0Vso7DeP+qrf/83kNRQ2BD/fg858KxQH8Sr25UgHNVVOudaqWCASngTuzzVhNmrsrI3GWQnaAsF9p27zzsmLNq1RKyIYfqeJOxXvt/48fkkwnK1F0FjRtoujnipWxMLRw4y7v7CWq")
        .formParam("ctl00$MainContent$LoginUser$UserName", "Mary Gniedykh")
        .formParam("ctl00$MainContent$LoginUser$Password", "1488")
        .formParam("ctl00$MainContent$LoginUser$LoginButton", "Log in")
    )
    .pause(3)
    .exec(
      http("go to admin page")
        .get("/blog/admin/")
        .headers(headers_0)
        .resources(
          http("request_5")
            .get("/blog/api/posts?skip=0&take=0")
            .headers(headers_5)
        )
    )
    .pause(1)
    .exec(
      http("create post page")
        .get("/blog/admin/app/editor/editpost.cshtml")
        .headers(headers_0)
        .resources(
          http("request_7")
            .get("/blog/api/lookups")
            .headers(headers_5),
          http("request_8")
            .get("/blog/api/tags?skip=0&take=0")
            .headers(headers_5)
        )
    )
    .pause(1)
    .repeat(1000) {
      exec(
        http("creating post")
          .post("/blog/api/posts")
          .headers(headers_9)
          .body(RawFileBody("simulation/simplepost/0009_request.json"))
          .resources(
            http("put data")
              .put("/blog/api/customfields")
              .headers(headers_9)
              .body(RawFileBody("simulation/simplepost/0010_request.bin"))
          )
      )
    }
    .pause(1)
    .exec(
      http("publishing")
        .put("/blog/api/posts/update/foo")
        .headers(headers_9)
        .body(RawFileBody("simulation/simplepost/0011_request.bin"))
        .resources(
          http("request_12")
            .put("/blog/api/customfields")
            .headers(headers_9)
            .body(RawFileBody("simulation/simplepost/0012_request.bin")),
          http("request_13")
            .get("/blog/api/posts/48025aa2-ddb4-4bc5-b7d0-96290f090f3a")
            .headers(headers_5)
        )
    )
    .pause(4)
    .exec(
      http("log out")
        .get("/blog/Account/login.aspx?logoff")
        .headers(headers_0)
    )

  setUp(scn.inject(
    atOnceUsers(2))
  ).protocols(httpProtocol)
}
