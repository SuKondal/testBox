$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("productSearch.feature");
formatter.feature({
  "id": "",
  "description": "As a Resmed site PO I want to make sure that product list displayed on the site is as expected \r\nand verify that it is not affected by other changes of application",
  "name": "",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": ";",
  "description": "Ensure that nasal masks list and link is as expected",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 8,
  "type": "scenario_outline"
});
formatter.step({
  "name": "I select \"\u003cproduct\u003e\" for search",
  "keyword": "When ",
  "line": 11
});
formatter.step({
  "name": "I get the list of products containing \"\u003cProductList\u003e\"",
  "keyword": "Then ",
  "line": 12
});
formatter.step({
  "name": "Search results take you to the Page \"\u003cResultPageHeading\u003e\"",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "should have a video link \"\u003cvideo\u003e\"",
  "keyword": "And ",
  "line": 14
});
formatter.examples({
  "id": ";;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 16,
  "rows": [
    {
      "id": ";;;1",
      "cells": [
        "product",
        "ProductList",
        "ResultPageHeading",
        "video"
      ],
      "line": 17
    },
    {
      "id": ";;;2",
      "cells": [
        "Nasal Mask",
        "AirFit P10",
        "AirFit P10 | ResMed",
        "AirFit P10 - How to fit"
      ],
      "line": 18
    },
    {
      "id": ";;;3",
      "cells": [
        "Nasal Pillow",
        "Swift FX Bella",
        "Swift FX Bella | ResMed",
        "Swift FX Bella - How to fit"
      ],
      "line": 19
    }
  ]
});
formatter.before({
  "duration": 6827927413,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 5,
  "type": "background"
});
formatter.step({
  "name": "I am on the home page of the site",
  "keyword": "Given ",
  "line": 6
});
formatter.match({
  "location": "ProductSearchSteps.iAmOnTheHomePageOfTheSite()"
});
formatter.result({
  "duration": 7550404071,
  "status": "passed"
});
formatter.scenario({
  "id": ";;;2",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 18,
  "type": "scenario"
});
formatter.step({
  "name": "I select \"Nasal Mask\" for search",
  "keyword": "When ",
  "line": 11,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I get the list of products containing \"AirFit P10\"",
  "keyword": "Then ",
  "line": 12,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "Search results take you to the Page \"AirFit P10 | ResMed\"",
  "keyword": "And ",
  "line": 13,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "should have a video link \"AirFit P10 - How to fit\"",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    3
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "Nasal Mask",
      "offset": 10
    }
  ],
  "location": "ProductSearchSteps.iSelectForSearch(String)"
});
formatter.result({
  "duration": 7309590592,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AirFit P10",
      "offset": 39
    }
  ],
  "location": "ProductSearchSteps.iGetTheListOfProductsContaining(String)"
});
formatter.result({
  "duration": 11537773621,
  "status": "failed",
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"link text\",\"selector\":\"AirFit P10\"}\nCommand duration or timeout: 11.51 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.52.0\u0027, revision: \u00274c2593cfc3689a7fcd7be52549167e5ccc93ad28\u0027, time: \u00272016-02-11 11:22:43\u0027\nSystem info: host: \u0027DeltaOne\u0027, ip: \u0027192.168.8.100\u0027, os.name: \u0027Windows 8\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.2\u0027, java.version: \u00271.7.0_79\u0027\n*** Element info: {Using\u003dlink text, value\u003dAirFit P10}\nSession ID: 2ef11e2b-dcd2-4b19-846b-e116f8b3d9de\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{platform\u003dWINDOWS, acceptSslCerts\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, databaseEnabled\u003dtrue, browserName\u003dfirefox, handlesAlerts\u003dtrue, nativeEvents\u003dfalse, webStorageEnabled\u003dtrue, rotatable\u003dfalse, locationContextEnabled\u003dtrue, applicationCacheEnabled\u003dtrue, takesScreenshot\u003dtrue, version\u003d38.0.6}]\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:526)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:246)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat pages.ProductsPage.verifySearchResults(ProductsPage.java:56)\r\n\tat stepsDef.ProductSearchSteps.iGetTheListOfProductsContaining(ProductSearchSteps.java:62)\r\n\tat ✽.Then I get the list of products containing \"AirFit P10\"(productSearch.feature:12)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"link text\",\"selector\":\"AirFit P10\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.52.0\u0027, revision: \u00274c2593cfc3689a7fcd7be52549167e5ccc93ad28\u0027, time: \u00272016-02-11 11:22:43\u0027\nSystem info: host: \u0027DeltaOne\u0027, ip: \u0027192.168.8.100\u0027, os.name: \u0027Windows 8\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.2\u0027, java.version: \u00271.7.0_79\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Temp/anonymous2625901535039516591webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10723)\r\n\tat \u003canonymous class\u003e.fxdriver.Timer.prototype.setTimeout/\u003c.notify(file:///C:/Temp/anonymous2625901535039516591webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:623)\r\n"
});
formatter.match({
  "arguments": [
    {
      "val": "AirFit P10 | ResMed",
      "offset": 37
    }
  ],
  "location": "ProductSearchSteps.searchResultsTakeYouToThePage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "AirFit P10 - How to fit",
      "offset": 26
    }
  ],
  "location": "ProductSearchSteps.shouldHaveAVideoLink(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/jpeg", "embedded0.jpg");
formatter.after({
  "duration": 1336851619,
  "status": "passed"
});
formatter.before({
  "duration": 5560996357,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 5,
  "type": "background"
});
formatter.step({
  "name": "I am on the home page of the site",
  "keyword": "Given ",
  "line": 6
});
formatter.match({
  "location": "ProductSearchSteps.iAmOnTheHomePageOfTheSite()"
});
formatter.result({
  "duration": 7156822592,
  "status": "passed"
});
formatter.scenario({
  "id": ";;;3",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "I select \"Nasal Pillow\" for search",
  "keyword": "When ",
  "line": 11,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I get the list of products containing \"Swift FX Bella\"",
  "keyword": "Then ",
  "line": 12,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "Search results take you to the Page \"Swift FX Bella | ResMed\"",
  "keyword": "And ",
  "line": 13,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "should have a video link \"Swift FX Bella - How to fit\"",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    3
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "Nasal Pillow",
      "offset": 10
    }
  ],
  "location": "ProductSearchSteps.iSelectForSearch(String)"
});
formatter.result({
  "duration": 7415807471,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Swift FX Bella",
      "offset": 39
    }
  ],
  "location": "ProductSearchSteps.iGetTheListOfProductsContaining(String)"
});
formatter.result({
  "duration": 1241760716,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Swift FX Bella | ResMed",
      "offset": 37
    }
  ],
  "location": "ProductSearchSteps.searchResultsTakeYouToThePage(String)"
});
formatter.result({
  "duration": 36977618851,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Swift FX Bella - How to fit",
      "offset": 26
    }
  ],
  "location": "ProductSearchSteps.shouldHaveAVideoLink(String)"
});
formatter.result({
  "duration": 287975,
  "status": "passed"
});
formatter.after({
  "duration": 798809945,
  "status": "passed"
});
});