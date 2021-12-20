package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AnonymousScenarioSearchByName extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
//    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")
  
  private val headers_0_search_by_name = Map("Upgrade-Insecure-Requests" -> "1")
  
  private val headers_3_search_by_name = Map(
  		"Accept" -> "*/*",
  		"Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
  		"Origin" -> "http://51.116.187.213"
  )


  private val scn = scenario("AnonymousScenarioSearchByName")
    .exec(
      http("request_0")
        .get("/blog/")
        .headers(headers_0_search_by_name)
    )
    .pause(13)
    .exec(
      http("request_1")
        .get("/blog/search?q=Lorem%20ipsum")
        .headers(headers_0_search_by_name)
    )
    .pause(17)
    .exec(
      http("request_2")
        .get("/blog/post/where-does-it-come-from")
        .headers(headers_0_search_by_name)
    )
    .pause(54)
    .exec(
      http("request_3")
        .post("/blog/post/where-does-it-come-from")
        .headers(headers_3_search_by_name)
        .formParam("__EVENTTARGET", "")
        .formParam("__EVENTARGUMENT", "")
        .formParam("__VIEWSTATE", "gfeNZ7PoYFdF00crzbIXeUeQsAZ4Q7+PyeKUC9Su6DS0VSFA856mljo5m6uIv7E0T2gI+yUI6I8LwncgmTH2pkpIUHX0oMP2Vsg3I8/qms34yCwuFjuPDgnmOG/B6SABqgylXTxZHg2sXuDYBVeboZCH8A1TzXNO4clbSK6VVEXKBmh5P2hDJKtpvSBfz5qV/hqRjQ==")
        .formParam("txtName", "")
        .formParam("", "")
        .formParam("txtContent", "")
        .formParam("ctl00$cphBody$ucCommentList$hiddenReplyTo", "")
        .formParam("simpleCaptchaValue", "")
        .formParam("ctl00$cphBody$ucCommentList$hfCaptcha", "45115ad4-ed80-42de-b88a-cdfebd034bc3")
        .formParam("", "Enter search term or APML url")
        .formParam("__VIEWSTATEGENERATOR", "0DB23B8C")
        .formParam("__CALLBACKID", "ctl00$cphBody$ucCommentList")
        .formParam("__CALLBACKPARAM", "Commentor-|-ilya@mail.com-|--|--|-Thats fine-|-false-|-false-|-45115ad4-ed80-42de-b88a-cdfebd034bc3-|--|--|--|--|-10")
        .formParam("__EVENTVALIDATION", "hpnuua/hk+C2R7yDPqh2yQVD+UojQ2b9HHcbI+tjGELr1FfedNzsiyX5wlQbRtKI9rK7hkMEhvW0Nfi5IOSp5mDMNYIRLOFG6ZDClgQztphgGZWpUVA0WqEdYbKWg+l8M4SXMZIYvVJpKNq1tCZS3owSiGs6cva2RdU8igVkY6cv+7TZj/x2JgnmHxuw2LsbhteTC5svVBEsE+X8YH3osZ2edzqqoaK9YB7fxfFPcjTsmTKAB+gLrNQaYbxFaqwd7IX4d22VnUdKwpv9ZihXlDqQWV57B0xZ9A8i/od9cjPKF41Bvgq9HTepij7xbBH3vbFJyXzaI1byIGS3hDF74vO17XmyF5UbBeGVYicFIYY9w/QHmByPG8ghMmlFpoVs5isKuH5dGAH2UDMP8YOpJkiwisVoyh7SyfrFwuGtoLflXUOBlN22HsUTAnvAA4a0yOm+TZ2whADkdUZSTAiC86KXIkKXXee0TWlH98Q0Koz5NcfF0W49cIK8DxFSQ9nvpY5hGA2e072Dviz5Vf9fyHzcr394ev4L04fwKW+WsrnWIJqss3CJMqt6WISeNSLNSNjnNseaOREQ+uZt9L9jtXe+61J4hmHGYscNuvGXUEfgXszrZNAenZufSkZZisAPuF0yGgTpkKOdFB8/lb7hP8sD1LyzsQEidY4fSye/TabdF7OLmZv0Sfn/z9E+tSXuHArmc7gPur7JryhMrqdRHwK1TFVBgUibDpdNQK20+uaGds1XZDwq/i+tWT1AtvY9uw71VxfDbgJJvxdAu4E3JcUpqKfQGpxxix8AilKkf+OrOUWNxtpnMI+lWipT857zkS/irQRtsoYm4fBAY4XLmDslSMP1PDYjJchQ1s9cFKqus4hpFYXCC7NP+5ZUC5qwlSDgglfjMmKnBYZ129OJjGlkvSRhz3M35KpVonm297eiE/r64vCJVILc1wckxLXq/Ui2ZjHhXDyQ5eLv55hCXllHBn/gvcmwF2qfcPDLcj/Uq2heyZBKe0ske7eU4OwQMsK6+g==")
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
