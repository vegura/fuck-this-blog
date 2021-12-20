package simulations

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import scala.util.Random
import scala.util.Random.nextInt
import simulations.AnonymousScenarioPredefinedDate

import java.io.FileWriter
import scala.language.postfixOps;

class AnonymousScenario extends Simulation {

  private val isComments = false
  private val repeatTimes = 30

  private val httpProtocol = http
    .baseUrl("http://51.116.187.213")
//    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,uk-UA;q=0.8,uk;q=0.5,en-US;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:96.0) Gecko/20100101 Firefox/96.0")

  // Go to post case

  private val headers_0_go_to_post = Map("Upgrade-Insecure-Requests" -> "1")
  private val headers_2_go_to_post = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
    "Origin" -> "http://51.116.187.213"
  )

  def goToPost(): ChainBuilder = {
    exec(
      http("Go to post page")
        .get("/blog/")
        .headers(headers_0_go_to_post)
    )
      .exec(
        http("Go to exact post")
          .get("/blog/post/where-does-it-come-from")
          .headers(headers_0_go_to_post)
      )
      .exec(
        http("create comment")
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
  }

  // Predefined dates case

  private val headers_0_predefined_dates = Map("Upgrade-Insecure-Requests" -> "1")
  private val headers_3_predefined_dates = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
    "Origin" -> "http://51.116.187.213"
  )

  def findByPredefinedDate(): ChainBuilder = {
    exec(
        http("Go to main page - predefined dates")
          .get("/blog/")
          .headers(headers_0_predefined_dates)
      )
    .exec(
      http("Go to exact date - predefined dates")
        .get("/blog/2020/12/default")
        .headers(headers_0_predefined_dates)
    )
    .exec(
      http("Go to exact post - predefined dates")
        .get("/blog/post/where-does-it-come-from")
        .headers(headers_0_predefined_dates)
    )
    .exec(
      http("Create comment - predefined dates")
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
  }

  // search by name

  private val headers_0_search_by_name = Map("Upgrade-Insecure-Requests" -> "1")
  private val headers_3_search_by_name = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
    "Origin" -> "http://51.116.187.213"
  )

  def searchByName(): ChainBuilder = {
    exec(
      http("Go to main page - search by name")
        .get("/blog/")
        .headers(headers_0_search_by_name)
    )
    .exec(
      http("Perform search - search by name")
        .get("/blog/search?q=Lorem%20ipsum")
        .headers(headers_0_search_by_name)
    )
    .exec(
      http("Go to exact post - search by name")
        .get("/blog/post/where-does-it-come-from")
        .headers(headers_0_search_by_name)
    )
    .exec(
      http("Leave comment - search by name")
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
  }

  // Archive case

  private val headers_0_archive = Map("Upgrade-Insecure-Requests" -> "1")
  private val headers_4_archive = Map("Accept" -> "image/avif,image/webp,*/*")
  private val headers_6_archive = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
    "Origin" -> "http://51.116.187.213"
  )

  def goToArchive(): ChainBuilder = {
    exec(
    http("archive page - go to archive")
      .get("/blog/archive")
      .headers(headers_0_archive)
    )
    .exec(
      http("go to main page - go to archive")
        .get("/blog/")
        .headers(headers_0_archive)
    )
    .exec(
      http("Go to main page 2 - go to archive")
        .get("/blog/")
        .headers(headers_0_archive)
    )
    .exec(
      http("Go to exact post - go to archive")
        .get("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_0_archive)
        .resources(
          http("request_4")
            .get("/blog/Content/images/blog/star_small.gif")
            .headers(headers_4_archive)
        )
    )
    .exec(
      http("Go to exact post 2 - go to archive")
        .get("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_0_archive)
    )
    .exec(
      http("Leave comment - go to archive")
        .post("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_6_archive)
        .formParam("__EVENTTARGET", "")
        .formParam("__EVENTARGUMENT", "")
        .formParam("__VIEWSTATE", "IIvPWb4/hHZtFBkAp+MiTtLk74do/s1KlDp+/03AxhKDKNuFt1glw1FgkgAjOxngcsMcG3NemPeefMTlgNhGRwZrK0C5d2LrjETVTHCo5/c8Ncd/woN4wm+1vJyUCgztuOdqN6n9RvaOyMEwam7D5+9QAB8Fq4Gm41YXH40qeu6HU8pkuhdYUeFcLyJRA+2pfWom5g==")
        .formParam("txtName", "")
        .formParam("", "")
        .formParam("txtContent", "")
        .formParam("ctl00$cphBody$ucCommentList$hiddenReplyTo", "")
        .formParam("simpleCaptchaValue", "")
        .formParam("ctl00$cphBody$ucCommentList$hfCaptcha", "02253d2d-5241-40c1-9fa1-b114d408ca2f")
        .formParam("", "Enter search term or APML url")
        .formParam("__VIEWSTATEGENERATOR", "0DB23B8C")
        .formParam("__CALLBACKID", "ctl00$cphBody$ucCommentList")
        .formParam("__CALLBACKPARAM", "Ilya-|-ilya@mail.com-|--|--|-This is good!-|-false-|-false-|-02253d2d-5241-40c1-9fa1-b114d408ca2f-|--|--|--|--|-")
        .formParam("__EVENTVALIDATION", "H+n7j/RC3OkaqP16qlv95+zktQ3Fla9aqSTzJ1Iwk2hG+7fRcVsEmJJL6SiUKvl6U4HHCNIySD/nkuL2r2ZxC8WFryfXfmD0luQJhsmbu0ITCtzi5O2r6TmdAFksGLfvocsPYbbKX+1sGsPCyYg0/mcCyJcB9bQwpyk3ZREvv+rnWdKUtSIvUp3OdkcPohz6kU+zGYPDRmaRCSHfnUfVqirLAF+OmkdGkak9nY0j2kLc1J6rYcOdWa6bSz4cUBTrXd+UTYFCw85AfCWFULTujHUVLa5ElhszQUT3fy1rzBkabv4hrivQDVqJcfk4CnW44XY7+XLe94ZORTzjo3Mh4SIYLd/dTgligDziL8NhGSNGqcBh/P8lT+Daz4bqZewISjhljatcQPVUve3WOIwwZPBu9J5gMG5nquQNhoIEyUeEUx+T/RQy4trCpdu9pj+v1A9jJyARx1WqRwVJm1SS2AOGnzepaSwjq+FiVMYXLp4vfvuP7mRXNrpxDW8YVzkhLWm6PRdInpRRpD4I6sDhX+v71PwN/c6lIVGLv4iTVl/xMBLGdIzPj5emrbvFQtOmi2YGxHyoDgjvYE6VHMOgcXhAufQtdMNHaLCF1dl59kqf3kSmFBMLSROoOWohP79Pci42th777t8EyZhjiiV8xfjOVPmcU+2IpHV++palWGaoaA5hhNTec4PB6dRWqJyzQ44fG/TYVlQVaYvRmlq874ePSAi62x/2gaHZbS777c+JldwP53TbWgnJ5RH3i+dUIQVrDa84CNUmhde+63DeV8268BQUzF7BT6NiRgjs6bHrimf7xxZy/pecfRjGQyR8ZrOUulTAVSt+YGLi1TOwEp0yFhJ832mIjg3QnVPY4v2RzPKmTkeFL3eMqMU+BymmKwo/ZNBrXFVGF6HT3wIfawl3A9ILVUzfRuntSMlruBmvb1oAS+AIVAma9iLP5a3EGqx6S9pXSt7N7OVoovRd0t0oSG7Li9xVLRVxv/L2i6mBFtEa6T0v9vVHOcc2YBmz8VbszA==")
    )
    .exec(
      http("Leave comment 2 - go to archive")
        .post("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_6_archive)
        .formParam("__EVENTTARGET", "")
        .formParam("__EVENTARGUMENT", "")
        .formParam("__VIEWSTATE", "IIvPWb4/hHZtFBkAp+MiTtLk74do/s1KlDp+/03AxhKDKNuFt1glw1FgkgAjOxngcsMcG3NemPeefMTlgNhGRwZrK0C5d2LrjETVTHCo5/c8Ncd/woN4wm+1vJyUCgztuOdqN6n9RvaOyMEwam7D5+9QAB8Fq4Gm41YXH40qeu6HU8pkuhdYUeFcLyJRA+2pfWom5g==")
        .formParam("txtName", "")
        .formParam("", "")
        .formParam("txtContent", "")
        .formParam("ctl00$cphBody$ucCommentList$hiddenReplyTo", "")
        .formParam("simpleCaptchaValue", "")
        .formParam("ctl00$cphBody$ucCommentList$hfCaptcha", "02253d2d-5241-40c1-9fa1-b114d408ca2f")
        .formParam("", "Enter search term or APML url")
        .formParam("__VIEWSTATEGENERATOR", "0DB23B8C")
        .formParam("__CALLBACKID", "ctl00$cphBody$ucCommentList")
        .formParam("__CALLBACKPARAM", "Ilya-|-ilya@mail.com-|--|--|-This is good!-|-false-|-false-|-02253d2d-5241-40c1-9fa1-b114d408ca2f-|--|--|--|--|-10")
        .formParam("__EVENTVALIDATION", "39ogW1dEag1aMWcMvAXHdZgfKbP3Pqj2demdGfxsv+OJuuiei7W8ZjzmnZgW4BjX/mKajYvA6BeS6C4vyEy0v6IYdL9EwMWO6JKNg2cNsdbwPr7MhA0IKuMCz/SibB5Suk7T4jpmdggGYL6WgHLdEJ/6sKIsaqHooTjRPdCv2ogtmshVdXPjaO/Qyq21qc650WDy3v+FA9GcF/7QJt/FuIZnpUgIBP1SV5vGsDEFN5izsXcemBoev1PFgPK2+z6tA1UTL/E2toO8gPiJXSAiN0IFunArZb+D1OkBuDkzIzsKEIfRAN82vAteee+Z7JlqMQzpWOfgISJPigfwMz/YQzwDdFYsG6YGs5cAn3ueWxC8bKiWcd0Fv3gnUApBt7qJhTCLbnwZEcIhzvx9W+mn/YyzpnmazV+IIeQITVm0Oq7aP+yFjg9sYlC9IKHWt6FUIIjxVAbLEYgMik7Cg96RL+6NHcLCEVfPTZ66214k+NkSxm5zE5C0vVbdKceER+0MVhjX8ntj3rYw4ajwMgFIpI9olyjEGklzn0+oWgt4JRZeO4k7AEgCRPrzQHtUrL2ZIWJ9cfL5382okh6u+CI5ij/K+mp+LufEWQ4AVRdUMRp9Sc303pLHPvcLEWLjQ89RfIsAAdipoTYGLsCzfpBe5EQMBpNMGChWWKsXuzWhShB1S7tz8d8wBw1vkjUU7c/B1PWyvgkhdP5vhZ00cCgVCvzGVFG9X33XHQYoIYNlv07KLP2eLjReD54X3/iZH0Orrj4D3ou5o3vqUTGUUXzkR8d0W5IiCkVsDsV5YC4hYAqWYF5xfpazYd44R+g7O+CwVE8JBlsK8fipciLW0EDJ+yr/VMKz8F65yBil4z4aIg2B58Ai3lW9kWTFknaSSTkmSH88W95o+JAgavwxO2LmeQGiQ2Z5vLdI3EQsX4mAGzklj5rc1liMVrpsNlQIb1PH8xo/Bj+6AvK/o/yeYjOQPchY4UguhIGPwizOlJ4UluAMgiUzWqFf4ZFMCRfejFzNsECDnQ==")
        .resources(
          http("request_8")
            .get("/blog/Custom/Themes/Standard/images/carrow.png")
            .headers(headers_4_archive)
        )
    )
  }

  // Contacts case

  private val headers_2_contact = Map(
    "Content-Type" -> "multipart/form-data; boundary=---------------------------7862269131504578011791792878",
    "Origin" -> "http://51.116.187.213"
  )
  private val headers_3_contact = Map(
    "Content-Type" -> "multipart/form-data; boundary=---------------------------24461960623322713611657342039",
    "Origin" -> "http://51.116.187.213"
  )

  def goToContacts(): ChainBuilder = {
    exec(
      http("Get main page - contacts case")
        .get("/blog/")
    )
    .exec(
      http("Get contact page - contact case")
        .get("/blog/contact")
    )
    .exec(
      http("contact case 3")
        .post("/blog/contact")
        .headers(headers_2_contact)
        .body(RawFileBody("simulation/anonymousscenarioopencontacts/0002_request.html"))
    )
    .exec(
      http("contact case 4")
        .post("/blog/contact")
        .headers(headers_3_contact)
        .body(RawFileBody("simulation/anonymousscenarioopencontacts/0003_request.html"))
    )
  }

  // Large calendar case

  private val headers_0_large_calendar = Map("Upgrade-Insecure-Requests" -> "1")
  private val headers_4_large_calendar = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=utf-8",
    "Origin" -> "http://51.116.187.213"
  )

  def openLargeCalendar(): ChainBuilder = {
    exec(
      http("Get main page - large calendar case")
        .get("/blog/")
        .headers(headers_0_large_calendar)
    )
    .exec(
      http("Open calendar - - large calendar case")
        .get("/blog/calendar/default.aspx")
        .headers(headers_0_large_calendar)
    )
    .exec(
      http("Go to exact post - - large calendar case")
        .get("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_0_large_calendar)
    )
    .exec(
      http("large calendar case 2")
        .get("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_0_large_calendar)
    )
    .exec(
      http(" leave comment - large calendar case")
        .post("/blog/post/meaningful-lorem-ipsum")
        .headers(headers_4_large_calendar)
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
  }

  def randomScenarioAction(): ChainBuilder = {
    val randomNum = nextInt(6)
    println("====================================== Option is " + randomNum)
    if (randomNum == 0) {
      goToArchive()
    } else if (randomNum == 1) {
      openLargeCalendar()
    } else if (randomNum == 2) {
      goToContacts()
    } else if (randomNum == 3) {
      searchByName()
    } else if (randomNum == 4) {
      findByPredefinedDate()
    } else if (randomNum == 5) {
      goToPost()
    } else goToPost()
  }

  def randomProbabilityScenario(): ChainBuilder = {
    val prob = nextInt(100)
    if (prob <= 30) {
      findByPredefinedDate()
    } else if (prob > 30 && prob <= 40) {
      openLargeCalendar()
    } else if (prob > 40 && prob <= 45) {
      goToContacts()
    } else if (prob > 45 && prob <= 60) {
      goToContacts()
    } else if (prob > 60 && prob <= 85) {
      goToPost()
    } else {
      goToArchive()
    }
  }

  def mapScenarioCases(a: Int): ChainBuilder = {
    randomProbabilityScenario()
  }

  def generateFullRandomScenarioCases(): ChainBuilder = {
    val collection = (0 to repeatTimes).toList
    collection.map(mapScenarioCases)
      .reduce((a, b) => a.exec(b))
  }


  private val scn = scenario("AnonymousScenario")
      .exec(generateFullRandomScenarioCases())

  setUp(scn.inject(
//    atOnceUsers(10)
    rampUsersPerSec(10) to (20) during(1 minutes)
  )).protocols(httpProtocol)
}
