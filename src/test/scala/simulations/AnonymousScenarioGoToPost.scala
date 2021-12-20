package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AnonymousScenarioGoToPost extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
//    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")
  
  private val headers_0_go_to_post = Map("Upgrade-Insecure-Requests" -> "1")
  private val headers_2_go_to_post = Map(
  		"Accept" -> "*/*",
  		"Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
  		"Origin" -> "http://51.116.187.213"
  )

  private val scn = scenario("AnonymousScenarioGoToPost")
    .exec(
      http("request_0")
        .get("/blog/")
        .headers(headers_0_go_to_post)
    )
    .pause(2)
    .exec(
      http("request_1")
        .get("/blog/post/where-does-it-come-from")
        .headers(headers_0_go_to_post)
    )
    .pause(20)
    .exec(
      http("request_2")
        .post("/blog/post/where-does-it-come-from")
        .headers(headers_2_go_to_post)
        .formParam("__EVENTTARGET", "")
        .formParam("__EVENTARGUMENT", "")
        .formParam("__VIEWSTATE", "XeuvrE/GF7OIgsdbuZtJTI1ZXMPusX0SA5s03/ZtrcCv/QB51jM++d1H+wQmu2LMLUTaE68nWSUp7VliwW9cALSp6OUUN+ycfm0swwIsDyhaVYz8EcS8+j/bhzFaN0xQun5f8cJJz21uJky+URHPmuKN6zB+jugqK4Qtpccw9Fm2YrqJVKowuvfk1hePiW08V7jHqA==")
        .formParam("txtName", "")
        .formParam("", "")
        .formParam("txtContent", "")
        .formParam("ctl00$cphBody$ucCommentList$hiddenReplyTo", "")
        .formParam("simpleCaptchaValue", "")
        .formParam("ctl00$cphBody$ucCommentList$hfCaptcha", "e553e882-963c-431f-809d-84c1baea2d32")
        .formParam("", "Enter search term or APML url")
        .formParam("__VIEWSTATEGENERATOR", "0DB23B8C")
        .formParam("__CALLBACKID", "ctl00$cphBody$ucCommentList")
        .formParam("__CALLBACKPARAM", "Ilya-|-ilya@mail.com-|--|--|-Thats awesome!-|-false-|-false-|-e553e882-963c-431f-809d-84c1baea2d32-|--|--|--|--|-10")
        .formParam("__EVENTVALIDATION", "zfB/StUsGJoLU5JFxsv8TzGSV5goyd8ucgXgqxOTTIxx93DGWu4mSB+8KsF+tiEep5jyzUCp8Hw/5VHSAeFdMI+NQfNgVU5kQBqX0WdY71cxlvLn8aEWjfxLUJJRkWGu9UYk23VlxU5tAnAkGCaqyj74z+eupHSI64v9mQef54vErcVrW7i5tJWBItllviwwiHuKRj4JM5K4DtPEfiRI65VUGvr7PTSGz54Kif3HW4vJ1jGgZ4hlROXl8r037OqzJZRDLcI57naVmU9bz6r/t8E3zmxBMvf5dI5rEdBa7631N6uBOkQXtJyfdD0qE4nrMCxjG5uHyj5Wis/NsFJBg2kkAISGnPWhtzNJPw8XxR+/Ca4SPB2Ok9Wur9ypkUmeAd5XegKghN+YhJfiZngP/lvisszJU6mx9hHpFa8ENgvtyyXr9gVimcw2NXf1Bga5eIaqN+Yt4nviKVI72ww4ur8pzQ9YVa7j2NkyvszES/UEXLQWFOEVB3XpIXqUxhcsP5At1I/zBEyNL1rA1oGGDoTqBmsFfndbfQjmDIvQH/kLvMHVzHsyIKn8P6bn9qWeqYnBm9RO+nqqdnHnklwv6FofJNMVLxQL2NfJVoo+gojP2J6z+K3ai4tP1FZw1CTKWWZ0keqk+PsBFgS7rDgwGjf2wVmyfNkQZo1gI6Ir1VdHeNnFiI2fDgLmhSkd31i5HFy956JcjiavRy7JGqy8jnOTHj92SRsqaO5Tz1Ml3CSfV4HvEjyRXccL7D74D7n5NMSt+Mg5DGpcSKJYlvpAKNlXH3dfxnTtJywRXjdbsA053NvPKp/l/zJM3mzVL0TflayHvzJWh/+D9I2DioNbdwdZ2ViTyMvpRhgacwANsFmdqhrLLKuQqWGumzwm0sR4UblO/byuHSb5nf8Kae1xZ9Npj5yPgc+WRYVgjSG5EI3UW760zg6/22KwEHR5Cf/xRrqEeTsvRAbmGslw6PqdkxkGVJCutU/pnAuPtD5pC50leWx0o6pKr4Rsxvucx2TIioePEQ==")
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
