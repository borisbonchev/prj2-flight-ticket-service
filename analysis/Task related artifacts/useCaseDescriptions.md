## Sales employee
<a name="look-up-a-flight"></a>
| Name | Look up a flight |
| --- | --- |
| Actor | Sales employee |
| Description | Sales employee looks up a flight for a customer. |
| Pre-condition | You need permission to access the relevant parts of the software. |
| Scenario | 1. Actor indicates that they want to see all available flights. <br> 2. System shows a list of all available flights. <br> 3. Actor selects a flight. <br> 4. System displays flight page. |
| Result | System displays the flight selected by the actor. |

| Name | Create a booking |
| --- | --- |
| Actor | Sales employee |
| Description | Sales employee wants to create a new booking for a particular flight. |
| Pre-condition | You need permission to access the relevant parts of the software. |
| Scenario | 1. Actor selects a specific flight for which they want to create a booking. <br> 2. System displays the selected flight page. <br> 3. Actor indicates that they want to create a booking for the selected flight. <br> 4. System requests personal details of the customer, payment information and gives the option to add additional booking services. <br> 5. Actor inputs the required information. <br> 6. System creates a new booking in the database. |
| Result | A booking is created. |
| Extension | 5a. Actor indicates that want to add additional booking options to the booking. <br> 5a.1 System creates a new booking in the database with the booking options included. |

## Sales officer
| Name | Create a route |
| --- | --- |
| Actor | Sales officer |
| Description | Sales officer creates a new airflight route. |
| Scenario | 1. Actor indicates that they want to create a new route. <br> 2. System requires departure and arrival locations from the actor. <br> 3. Actor inputs the required information. <br> 4. System saves the new route information. |
| Result | The sales officer creates a new flight on the airline database. |
| Exception | 4. System shows an error message: "The chosen route already exists in the database". <br> 4.1 Actor is sent back to step 2. <br> 4.2 Use case ends here. |

| Name | Register a flight |
| --- | --- |
| Actor | Sales officer |
| Description | Sales officer registers a flight. |
| Scenario | 1. Actor indicates that they want to register a new flight. <br> 2. System requests for route of flight, aircraft, ticket prices, date and time of the departure from the actor. <br> 3. Actor inputs the required information. <br> 4. System creates a new flight with the selected data. |
| Result | The sales officer creates a new flight on the airline database. |
| Exception | 4. System shows an error message: “This flight already exists in the database.". <br> 4.1 Actor is sent back to step 2. <br> 4.2 Use case ends here. |

| Name | Update flight information |
| --- | --- |
| Actor | Sales officer |
| Description | Sales officer updates specific flight information. |
| Pre-condition | A flight must be created beforehand. |
| Scenario | 1. Actor [looks up](#look-up-a-flight) a flight. <br> 2. System displays flight details. <br> 3. Actor indicates that he wants to update a flight. <br> 4. System displays all flight related information. <br> 5. Actor updates flight information of their choice. <br> 6. System asks for confirmation from the actor. <br> 7. The actor indicates that he wants to apply the changes. <br> 8. System updates the flight information. |
| Result | Flight information is updated. |
| Extension | 5a. Actor indicates that he wants to cancel this flight. <br> 5a.1 System asks for confirmation from the actor. <br> 5a.2 The actor confirms his choice to cancel the flight. <br> 5a.3 System cancels the flight. |

## Sales manager
| Name | Access management dashboard |
| --- | --- |
| Actor | Sales manager |
| Description | Sales manager accesses the management dashboard. |
| Scenario | 1. Actor indicates that they want to access the management dashboard. <br> 2. System displays different statistics relevant to the management of the airline company. |
| Result | The dashboard presents different key performance indicators. |
| Extension | 3a. Actor indicates that they want to overview the total revenue numbers of the company. <br> 3a.1 System displays the total revenue numbers of the company. <br> 3b. Actor indicates that they want to overview the key performance statistics chart of the company. <br> 3b.1 System displays the key performance statistics of the company. |

| Name | Reduce ticket price |
| --- | --- |
| Actor | Sales manager |
| Description | Sales officer reduces the price of a ticket for a particular flight. |
| Pre-condition | A flight must be created beforehand. |
| Scenario | 1. Actor indicates that they want to see the ticket and booking options prices. <br> 2. System shows a price list of each ticket and booking option. <br> 3. Actor indicates that they want to apply a price change for a ticket or a booking option. <br> 4. System displays the chosen ticket or option and lets the actor change the price to the desired amount. <br> 5. Actor inputs the required price change. <br> 6. System acknowledges the choice of actor, the new price of the entity is saved in the database. |
| Result | A ticket/booking option price is changed. |
| Extension | 4a. System asks the actor if they wish to make a change for all tickets or a discount for a selected flight. <br> 4a.1 Actor indicates that they want to make a discount. <br> 4a.2 System requests from the actor to input the desired discount amount and select an available flight from the database. <br> 4a.3 Actor inputs the required information. <br> 4a.4 System saves the discount information. |