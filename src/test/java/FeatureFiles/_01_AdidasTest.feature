Feature: Beymen Test project

  Scenario:
    Given Nagivgate to blaze.com
    When Navigate to "Laptop"
    Then "Sony vaio i5" and click on Add to cart
    And Accept pop up confirmation
    When Navigate to "Laptop"
    Then "Dell i7 8gb" and click on Add to cart
    And Accept pop up confirmation
    When Navigate to "Cart"
    Then Delete "Dell i7 8gb" from cart
    And Click on "Place order"
    Then Fill in all web form fields
    And Click on "Purchase"
    Then Capture and log purchase Id and Amount
    And Assert purchase amount equals expected
    And Click on "Ok"


