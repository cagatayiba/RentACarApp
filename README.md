#RentACarApp

#Program Description

In this application, there are two different types of car rental: commercial and individual. 
Commercial rental is on a monthly basis and individual rental is on a daily basis. 


Individual customers rent on a daily basis. The customer may have membership or rent without being a member. 
However, the company offers a 10% discount for the members. 
There is no discount for the rentals without a membership. 
The overall price is calculated by multiplying the number of days and daily_price of the rental car and also 10% discount for the members.
-Each customer has an ID. ID format differs for members (12 digit String) and customers without membership (11 digit integer) which is based on Turkish Republic Identity Number


Commercial customers rent on a monthly basis. All commercial customers have a membership. The monthly price for commercial customers is 
calculated by thirty days and daily_price and also special discount for the customer. The discount differs for the customer status as follows:

silver customer : %20
gold : %25
platinium: %30

-Similar to individual customers, all commercial customers have an ID (8 digit string). The ID starts with S, G or P based on the customer type.


The file that consists of different rentals information is given: HW4_Rentals.csv The columns of the file are given in the following for each different rental type:
Individual Rental: type*, customer ID, number of days, car model, car model year, base price
Commercial Rental: type*, customer ID, number of months, car model, car model year, base price
see HW4_Rentals.csv

see sampleOutput for execution result of the program