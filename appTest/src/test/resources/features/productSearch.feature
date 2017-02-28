Feature:
As a Resmed site PO I want to make sure that product list displayed on the site is as expected 
and verify that it is not affected by other changes of application

Background: 
Given I am on the home page of the site

Scenario Outline: 
Ensure that nasal masks list and link is as expected 

When I select "<product>" for search 
Then I get the list of products containing "<ProductList>" 
And Search results take you to the Page "<ResultPageHeading>" 
And should have a video link "<video>" 

Examples: 
|product |  ProductList |  ResultPageHeading| video |
|Nasal Mask |AirFit P10 |AirFit P10 \| ResMed|AirFit P10 - How to fit|
|Nasal Pillow |Swift FX Bella |Swift FX Bella \| ResMed|Swift FX Bella - How to fit|