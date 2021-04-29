Feature: LandingPage Amazon Webpage

  Scenario: Validate current url
    Given :Landing page of Amazon website in chrome
    When :get the current url
    Then :validate the current "https://www.amazon.com/" and actual url
    And :close the browser
  Scenario: MouseOver in landing page
    Given :Landing page of Amazon website in chrome
    When :Mouseover in landing page
    Then :validate the text when mouseover "Hello, Sign inAccount & Lists"
    And :close the browser
  Scenario: Validate title
    Given :Landing page of Amazon website in chrome
    When :get the title of the url
    Then :validate the current "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more" and actual title
    And :close the browser
  Scenario Outline: Search box
    Given :Landing page of Amazon website in chrome
    When :Enter serach data"<searchData>"
    Then :take screenshot
    And :close the browser
    Examples:
    |searchData|
  |COACH Rowan Satchel In Signature Canvas|
  |Michael Kors                           |
  |chanel                                 |
  |adidas                                 |
