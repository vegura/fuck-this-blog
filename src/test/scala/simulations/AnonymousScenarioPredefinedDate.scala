package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AnonymousScenarioPredefinedDate extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
//    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")
  
  private val headers_0_predefined_dates = Map("Upgrade-Insecure-Requests" -> "1")
  
  private val headers_3_predefined_dates = Map(
  		"Accept" -> "*/*",
  		"Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
  		"Origin" -> "http://51.116.187.213"
  )

  private val scn = scenario("AnonymousScenarioPredefinedDate")
    .exec(
      http("request_0")
        .get("/blog/")
        .headers(headers_0_predefined_dates)
    )
    .pause(95)
    .exec(
      http("request_1")
        .get("/blog/2020/12/default")
        .headers(headers_0_predefined_dates)
    )
    .pause(30)
    .exec(
      http("request_2")
        .get("/blog/post/where-does-it-come-from")
        .headers(headers_0_predefined_dates)
    )
    .pause(41)
    .exec(
      http("request_3")
        .post("/blog/post/where-does-it-come-from")
        .headers(headers_3_predefined_dates)
        .formParam("__EVENTTARGET", "")
        .formParam("__EVENTARGUMENT", "")
        .formParam("__VIEWSTATE", "X3NhyX6PARO4DY5cLKOpJUe/rqmUGMNgT7fbEBmjLGcVyY2rP2GNJeV1hgbz7X6KzfvR3RAwYw7jwO0TbkRKP/WGn0VqRkUc176gL68NtokrOXTrsoM0LNHLp8S+kbCnqZs/g3FZ9FM04RxWCEGrqby83VonWPtmN1SRY5i18iJ2MYMZf6mmLXKNAsqz5G67QNHTIA==")
        .formParam("txtName", "")
        .formParam("", "")
        .formParam("txtContent", "")
        .formParam("ctl00$cphBody$ucCommentList$hiddenReplyTo", "")
        .formParam("simpleCaptchaValue", "")
        .formParam("ctl00$cphBody$ucCommentList$hfCaptcha", "6d33e745-4571-4d9a-ba54-390ccf5b1d5b")
        .formParam("", "Enter search term or APML url")
        .formParam("__VIEWSTATEGENERATOR", "0DB23B8C")
        .formParam("__CALLBACKID", "ctl00$cphBody$ucCommentList")
        .formParam("__CALLBACKPARAM", "ILya-|-ilya@mail.com-|--|--|-Wow!-|-false-|-false-|-6d33e745-4571-4d9a-ba54-390ccf5b1d5b-|--|--|--|--|-10")
        .formParam("__EVENTVALIDATION", "z2P0p8Sov3olZPM+cgbd1U2DfnArDcB5WQKyRVowHg3VRtVDw4gM6302YMyqLqO84+FhLPp7dGaPLE7105VNOKMXVx1kFJK5zvECTFHIggHRoS+jqe7nu8dfnmoQGzfER9csBGBPkdwEupqeQVp1ZkpdLZAZvTaBRM6D5Z341hxyeMAUDV2W1J3jzKL5GaukdmB0smlhSv0O4oL4h93pPUdHHbWpXpyomI0uV1Hnn0M3A+v6tG5hhFH8njUc2DthY0BpuQyvXvjYcSoWu+Fn/LM2gPES8cOD1GwZDiio4JwglX1aZbnfXcB6ennCL6MvFgxsGyS9m7IKD/gcNXbujHlQEDkTvbe3daub7CbGg/1Y0A6aXCBMPY8tU7UGM4dgrFTVkp4JnxFHG5aOpa9uLXecQYynbkCW2J1B5dEinCFHooaIIsQq2y8gf7Y4lEvBnMeIA9eFO3XWmbcCn0UZHKYZG6I1LxBBT6nmxdQXVt0v3624m3bJyd6Qeyh4693ezFUuFXfxg8CNe1t85Stxs2amjUoBbiWNXRP5CUpk7ZFXCDyceYcbHtDkjUCnY0csrSOqkhjD1grTj2cGJUjPcCNmFA2Pm10EjcJpl83B1D14dEabbehBWQKQf/8OpjFYa07JMTDzeT9WmZin7BakZzVxoiZuVuwWC/S3HR7C46oJBCYC8GjM83AZoOx5F+UyT3OcNztWWzNdaKmp+07LpLLSzsc/ECrGQpz0p50motCXQuBOvMYaENQpOU0vyO+eKtJL51xZA4Gp4IIOfttNXs1VBSOjRBMBBs8fSnetSFO+JgKKF3hngt+Tuyg5DN86HJpWjmtsCTRf7W0zJbRJtfm5otj7zvh1um5LtKbQ+WfHPm8tQuhYrUtRQ7uTNuP8QrJ6XLSXnwfzODLsO/1DitOMkO0bxS/2axEd6R4rEyeVr+VIfTSO7VCffSeImb1C5/1RyJDT7kvMrrp80V7htvSkOWiog6GTDvPmxOOvDa3YQ3TANUNXQRP3c9rrAs5Tz28Fuw==")
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
