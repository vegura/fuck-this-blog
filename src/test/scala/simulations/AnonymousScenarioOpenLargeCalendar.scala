package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AnonymousScenarioOpenLargeCalendar extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
//    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")
  
  private val headers_0_large_calendar = Map("Upgrade-Insecure-Requests" -> "1")
  
  private val headers_4 = Map(
  		"Accept" -> "*/*",
  		"Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
  		"Origin" -> "http://51.116.187.213"
  )


  private val scn = scenario("AnonymousScenarioOpenLargeCalendar")
    .exec(
      http("request_0")
        .get("/blog/")
        .headers(headers_0_large_calendar)
    )
    .pause(4)
    .exec(
      http("request_1")
        .get("/blog/calendar/default.aspx")
        .headers(headers_0_large_calendar)
    )
    .pause(9)
    .exec(
      http("request_2")
        .get("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_0_large_calendar)
    )
    .pause(2)
    .exec(
      http("request_3")
        .get("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_0_large_calendar)
    )
    .pause(21)
    .exec(
      http("request_4")
        .post("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_4)
        .formParam("__EVENTTARGET", "")
        .formParam("__EVENTARGUMENT", "")
        .formParam("__VIEWSTATE", "rAAOexzm7ID3BHyUXa2pf6VBrEjjg9vak8qV5NsvLi0C7IoT+0Q1d/Yf8UWrQmqedDdZO9dI2GS5yTl0eCISV2fca2X76pL2m9IIBRr+ceEUX2JQ09UpBrvTx9m7FJZrHCh3TcC6qBT78GdO6bZ7peonuGJwNS6A+qnn69fsqw807ph9WRCf/6YeTMrqQZQHiopG5A==")
        .formParam("txtName", "")
        .formParam("", "")
        .formParam("txtContent", "")
        .formParam("ctl00$cphBody$ucCommentList$hiddenReplyTo", "")
        .formParam("simpleCaptchaValue", "")
        .formParam("ctl00$cphBody$ucCommentList$hfCaptcha", "6f7bc259-6b22-458c-89c7-118e311ffaba")
        .formParam("", "Enter search term or APML url")
        .formParam("__VIEWSTATEGENERATOR", "0DB23B8C")
        .formParam("__CALLBACKID", "ctl00$cphBody$ucCommentList")
        .formParam("__CALLBACKPARAM", "hey-|-hey@hey.com-|--|--|-this is fine-|-false-|-false-|-6f7bc259-6b22-458c-89c7-118e311ffaba-|--|--|--|--|-10")
        .formParam("__EVENTVALIDATION", "rcMDU/IGRAQmIxtXEsFJTyRtQYNgnTHFK5SAPoHheH8ODlq7yY4GUnHFmHeM16SZwVyjeXVvvzp8hNW2wXqunHB8hfMe4jZ6YV3UNFCo2Mbra13m8C9iDmjUnFCnxd0q/6KzLgokPxaVDc5KUyuWlPAsq6ayMCoZ7+M71j0l8Ka6OEWYQmnRSvdQhuy4Gmeceb33z+3pfsgQEui3RI8t/KcAd5Sion0ETlGaxDG2Vvt3dy7KgZ5fl/euXq/GzSlqtCndoIOyQyORf+Up0f8b1IhapQmziVliJNdu9gN9saXBGUv9ZrDNXo6ikcvYbT/aOBJuxhw6iVV0SZQCTMoRYlPVJIqW8RSoGAAsAMU+4tgawpSI1dWlrkhADcNFDc7PBcMIJcy83jMr7ZzhPQYe5icaYo4olSqVkY4SZZpGpN0i0J+45sJc3PozX62soQK1sj9P2LrRmH5ZTOGEWY3r1g0KfKCZa46U2DBnUomXRDVgHA30KZgda226FAv1JADPYKviHXF/Q3j/GBuT6dctKf4RazYqyXSQa+0zIdvwq5aU1zPI3uY53FtgWLEK24a72QdoFfhJuo8n6QGMoaiarg5o5PFqCpksBM2TRmcX7S3SnSfpS8NrYjoNDuMb0yQX3lrE2NRwaKf6GPu6CHY9CPyBpuVclYkeFTWdnX96JElvXwHLwYeBxPwVDobnvaHCVXhvaWrJeoX0QuYCwyjjso8OGTgxOQ69KZ8Xmgvi/qBClB+z8TUBdqDDYinvKZ0DYCEMxht16hRwDhiOQ+3SXiDpU+3uWWqJBCxWqBvTK0hMKfF1EERhBiW4bXBcTBmvPu4Qxp/Vu+Ob0m9fBmLLtBOLvHqIYK48sIxsitWo/IS1f4BYuZubNdQ+SMCWXPpOA5mslvgyLNgy0JhqavWYAsTZpP8GuM2C4B5dYmfJ8TutViZOdBQVApmVMoCLYbB5mLWZFCeZrJhB/KlZkZtw4tBJqhyLxqsdsOqvREFLhzmIkYIakJbDweHy7ZU/ZFEmnVZHQg==")
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
