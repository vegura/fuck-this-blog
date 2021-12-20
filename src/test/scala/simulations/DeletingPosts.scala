package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class DeletingPosts extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
//    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")
  
  private val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")
  
  private val headers_2 = Map(
  		"Origin" -> "http://51.116.187.213",
  		"Upgrade-Insecure-Requests" -> "1"
  )
  
  private val headers_4 = Map(
  		"Accept" -> "application/json, text/plain, */*",
  		"x-blog-instance" -> "96d5b379-7e1d-4dac-a6ba-1e50db561b04"
  )
  
  private val headers_5 = Map(
  		"Accept" -> "application/json, text/plain, */*",
  		"Content-Type" -> "application/json;charset=utf-8",
  		"Origin" -> "http://51.116.187.213",
  		"x-blog-instance" -> "96d5b379-7e1d-4dac-a6ba-1e50db561b04"
  )


  private val scn = scenario("DeletingPosts")
    .exec(
      http("request_0")
        .get("/blog/")
        .headers(headers_0)
    )
    .pause(2)
    .exec(
      http("Login to blog")
        .get("/blog/Account/login.aspx")
        .headers(headers_0)
    )
    .pause(1)
    .exec(
      http("Fill with login data")
        .post("/blog/Account/login.aspx")
        .headers(headers_2)
        .formParam("__VIEWSTATE", "opUyO5+N9JEfWvBUgKQeK74FrBfBhZ05BmDsKZPCsBj5NV00rdeVo8ifUcWQhCI1s9QAlNIp8kDyG4EXBpqvVedCB5x8MOQBBd627skX/Y6OfFNU+N+IX2Dovrp3ITyK3SF6HgmKNidr8OK+9jAHqwfIo2iq1/omV+nnv9tD4u4Kj12T")
        .formParam("__VIEWSTATEGENERATOR", "B42CDBE2")
        .formParam("__EVENTVALIDATION", "IDBvIiWDrGWeMkvYHs5QpDVawBmpUQ/2W0Yhzrd31PVdw0hFNuuB9n2ju44FyVq1IN6ea2xixTM5MwSmu5gmNUQSd6MO31rckixT1YgLox/rIChUhvGntLaTtNTJTFpIooAgOMHAzAuvAQ4vI7tR6umxpr+aqOv3iPVZx1/bizAoJrA4")
        .formParam("ctl00$MainContent$LoginUser$UserName", "Mary Gniedykh")
        .formParam("ctl00$MainContent$LoginUser$Password", "1488")
        .formParam("ctl00$MainContent$LoginUser$LoginButton", "Log in")
    )
    .pause(3)
    .exec(
      http("GET admin page")
        .get("/blog/admin/")
        .headers(headers_0)
        .resources(
          http("request_4")
            .get("/blog/api/posts?skip=0&take=0")
            .headers(headers_4)
        )
    )
    .pause(3)
    .exec(
      http("Deleting post")
        .put("/blog/api/posts/processchecked/delete")
        .headers(headers_5)
        .body(RawFileBody("simulation/deletingpageofposts/0005_request.bin"))
        .resources(
          http("request_6")
            .get("/blog/api/posts?skip=0&take=15")
            .headers(headers_4)
        )
    )
    .pause(4)
    .exec(
      http("Logout")
        .get("/blog/Account/login.aspx?logoff")
        .headers(headers_0)
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
