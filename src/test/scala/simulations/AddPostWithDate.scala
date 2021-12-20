package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddPostWithDate extends Simulation {

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
  
  private val headers_2 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
  		"Origin" -> "http://51.116.187.213",
  		"Upgrade-Insecure-Requests" -> "1"
  )
  
  private val headers_4 = Map("x-blog-instance" -> "96d5b379-7e1d-4dac-a6ba-1e50db561b04")
  
  private val headers_8 = Map(
  		"Content-Type" -> "application/json;charset=utf-8",
  		"Origin" -> "http://51.116.187.213",
  		"x-blog-instance" -> "96d5b379-7e1d-4dac-a6ba-1e50db561b04"
  )


  private val scn = scenario("AddPostWithDate")
    .exec(
      http("Get blog page")
        .get("/blog/")
        .headers(headers_0)
    )
    .pause(6)
    .exec(
      http("GET login page")
        .get("/blog/Account/login.aspx")
        .headers(headers_0)
    )
    .pause(7)
    .exec(
      http("Fill login form with login data")
        .post("/blog/Account/login.aspx")
        .headers(headers_2)
        .formParam("__VIEWSTATE", "C8BhE9RM+7IwzgXaskCBwbx34xS6wLJl+cmqNsd5mZsmWnwLqI/YCWjfKMP7OAFx8PfaYjsYq8hmkVxOHTdrE9ib9XDkTNr/sA0xarsMCibN91Hjgw/x+TFbI3rV/wGYMyzdhc3l/F+XxOZOXWJOgSvedR3zFuo+LfVTaC6bNAMe3NzO")
        .formParam("__VIEWSTATEGENERATOR", "B42CDBE2")
        .formParam("__EVENTVALIDATION", "C+8h/Jhu80vknZTKp4zLoiMrKURrOXE3MUozzlDeBCsH2wOVYiCOGX/CZSvUIyZNH/Ksp1lDjiR/VmAzgpeoYnZJdQx4VL+TQWb5q5sUaaBvlAc0hM5ThQZBJNOLq7JUQgC2A0BzDP/zM6q1GH4uMJw1El2bp3IyxFcWpJnKJGvmyr52")
        .formParam("ctl00$MainContent$LoginUser$UserName", "Mary Gniedykh")
        .formParam("ctl00$MainContent$LoginUser$Password", "1488")
        .formParam("ctl00$MainContent$LoginUser$LoginButton", "Log in")
    )
    .pause(6)
    .exec(
      http("Go to admin panel")
        .get("/blog/admin/")
        .headers(headers_0)
        .resources(
          http("request_4")
            .get("/blog/api/posts?skip=0&take=0")
            .headers(headers_4)
        )
    )
    .pause(10)
    .exec(
      http("GET create post form")
        .get("/blog/admin/app/editor/editpost.cshtml")
        .headers(headers_0)
        .resources(
          http("request_6")
            .get("/blog/api/lookups")
            .headers(headers_4),
          http("request_7")
            .get("/blog/api/tags?skip=0&take=0")
            .headers(headers_4)
        )
    )
    .pause(10)
    .repeat(100) {
      exec(
        http("request_8")
          .post("/blog/api/posts")
          .headers(headers_8)
          .body(RawFileBody("simulation/addpostwithdate/0008_request.json"))
          .resources(
            http("create post additional request 1")
              .put("/blog/api/customfields")
              .headers(headers_8)
              .body(RawFileBody("simulation/addpostwithdate/0009_request.bin")),
            http("create post additional request 2")
              .put("/blog/api/posts/update/foo")
              .headers(headers_8)
              .body(RawFileBody("simulation/addpostwithdate/0010_request.bin")),
            http("create post additional request 3")
              .get("/blog/api/posts/c84c0be1-9b73-4572-a01b-9ce2ccfcc23e")
              .headers(headers_4),
            http("create post additional request 4")
              .put("/blog/api/customfields")
              .headers(headers_8)
              .body(RawFileBody("simulation/addpostwithdate/0012_request.bin"))
          )
      )
    }
    .pause(2)
    .exec(
      http("Checking for creating post")
        .get("/blog/admin/")
        .headers(headers_0)
        .resources(
          http("request_14")
            .get("/blog/api/posts?skip=0&take=0")
            .headers(headers_4)
        )
    )
    .pause(10)
    .exec(
      http("Logout")
        .get("/blog/Account/login.aspx?logoff")
        .headers(headers_0)
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
