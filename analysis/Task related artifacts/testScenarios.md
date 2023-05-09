| Name | Register a flight |
| --- | --- |
| Actor | Sales officer |
| Description | Sales officer registers a new flight. |
| Pre-condition | A route and an airplane have been registered. |
| Scenario | 1. System asks for flight information. <br> 2. Sales officer chooses between the route and airplane options, ticket price, date and time of take-off and arrival: <br> Route: SOF-EIND <br> Airplane: AB1234<br> Ticket price: 15 euros <br> Date of takeoff: 2022-06-06 and time of takeoff: 12:30<br> Date of arrival: 2022-06-06 and time of arrival: 14:20 <br> 3. System creates a new flight from Sofia to Eindhoven, on 2022-06-06 at 12:30 for 15 euros per ticket. |
| Result | A new Flight is created. |
| Exception | 3. System shows an error message: “The chosen flight already exists in the database.” <br> 3.1 return to Step 1. |

| Name | Flight with missing fields |
| --- | --- |
| Actor | Sales officer |
| Description | Sales officer registers a new flight with missing fields. |
| Pre-condition| A route and an airplane have been registered. |
| Scenario | 1. System asks for flight information. <br> 2. Sales officer chooses between the route and airplane options, ticket price, date and time of take-off and arrival but forgets to input a route for the flight: <br> Route: <br> Airplane: AB1234<br> Ticket price: 15 euros <br> Date of takeoff: 2022-06-06 and time of takeoff: 12:30<br> Date of arrival: 2022-06-06 and time of arrival: 14:20 <br> 3. System throws an exception: "All fields must be filled in." <br> 4. Return to Step 2. |
| Result | A flight exception is thrown. |

| Name | Flight with equal Arrival-Takeoff time and dates |
| --- | --- |
| Actor | Sales officer |
| Description | Sales officer registers a new flight with equal times and dates of arrival and takeoff. |
| Pre-condition | A route and an airplane have been registered. |
| Scenario | 1. System asks for flight information. <br> 2. Sales officer chooses between the route and airplane options, ticket price, date and time of take-off and arrival but inputs the same date and time for the flight: <br> Route: SOF-EIND <br> Airplane: AB1234<br> Ticket price: 15 euros <br> Date of takeoff: 2022-06-06 and time of takeoff: 12:00<br> Date of arrival: 2022-06-06 and time of arrival: 12:00 <br> 3. System throws an exception: "Takeoff and arrival dates and time should not be the same." <br> 4. Return to Step 2. |
| Result | A flight exception is thrown. |

| Name | Create a booking |
| --- | --- |
| Actor | Sales employee |
| Pre-condition| A flight has been registered|
| Scenario | 1. Actor indicates that he/she want’s to create a booking. <br> 2. System shows a list of available flights (Düsseldorf airport to Berlin airport 500€). <br> 3. Actor selects a flight. <br>  4. System asks if extra options for the booking are needed. <br> 5. Actor selects options for booking. <br> 6. System shows an overview of the currently selected flight and booking options (Feet extension, price: 100€, Premium seat, price: 1500€, total price: 1600€). <br> 7. System asks the actor wether another ticket should be added to the booking. <br> 8. Actor indicates if the booking is correct. <br> 9. System creates a booking with 1 ticket from Düsseldorf to Berlin, price 2100€(Ticket 500, premium setat 1500, feet extension 100)  |
| Result | A booking is created. |
| Extension | 5a. Actor selected extra options for booking. <br> 1. System shows list of available booking options (Luggage extension 100€, Feet extension 100€, Premium seat 1500€, Food 20€) <br> 2. Actor selects Feet extension and Premium seat. Return to step 6. <br> 8a. Actor indicates the he wants to add another ticket to the booking. Return to step 2|
| Exception |  |

| Name | Calculate ticket price |
| --- | --- |
| Actor | Sales officer |
| Scenario | 1. System shows a price list of each ticket and booking options (DDA to BA 500€, Feet extension 100€, Premium seat 1500€). <br> 2. Actor selects DDA to BA 500€ with Feet extension and Premium seat. <br> 3. System asks if the Actor if the selected prices are correct, if not go back to step 2. <br> 4. Actor indicates that he/she want’s to set the price of 2100€. <br> 5. System asks if discounts for the price are available. <br> 6. Actor selects discounts for the price, if nothing selected skip to step 7. <br> 7. System shows an overview of the currently selected prices and discounts (Price: 2100€, coupon discount 20%, total price: 1680€). <br> 8. Actor indicates the price 1680€ is final. <br> 9. System acknowledges the choice of actor, if passed the price is calculated. If not passed return to step 3. |
| Result | A ticket price is set. |
| Exception | 5a. Actor selects discounts for the price (coupon codes, first buy discount). <br> 1. System shows list of discount options (20% discount coupons, 25% discount first buy) Actor selects one or more options. Return to step 6. |

|Name | Reduce prices |
| --- | --- |
| Actor | Sales officer |
| Description | Sales Employee reduces the price for a certain flight |
| Scenario | 1. Sales officer chooses ‘reduce price’ for a particular flight  <br> 2. System gives the option for a temporary static price reduction or dynamic price reductions depending on remaining sun hours at the destination  <br> 3. Sales officer chooses option and inputs price reduction and reduction time depending on the chosen option |
| Exception | 3. System message: "Flight price allready reduced". <br> i. Use case ends here. |

|Name | Look up a flight|
| --- | --- |
| Actor | Sales empoloyee |
| Description | Sales Employee looks up a flight |
| Scenario | 1. Actor indicated that he wants to look up a flight <br> 2. System asks for departure and arrival location <br> 3. Actor enters information: Eidhoven, Paris <br> 4. System displays available flights(Eidhoven to Paris 22-03-2022, 11:43) 
| Exception | 4. System message: "No flights have been found". <br> 4.1 return to Step 2|

|Name | Using management dashboard|
| --- | --- |
| Actor | Sales Manager |
| Description | Sales Manager looks at the Dashboard |
| Scenario | 1. Sale Manager chooses ‘See Dashboard’ <br> 2. System displays Dashboard |
| Exception | 3. None |


