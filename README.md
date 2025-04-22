Band 6 Developer - Assignment

Product Price Tracker with Custom Alerts

Develop an API that allows users to enter a product URL and set a price drop alert. The API will simulate tracking product prices by fetching a static JSON and notify users when a price condition is met.

Guidelines
Consider software development best practices
Follow a Test Driven Development (TDD) approach
Implement a notification system that informs users when their set price condition is met

Tech Stack
Choose the language appropriate to the job role:
Java, Spring Boot for Java Developer
JavaScript or TypeScript for Node.js Developer
Python for Backend Developer

Requirements

API Development
Implement a REST API that accepts user inputs:
Product URL (e.g., a link to an e-commerce product)
Desired Price (the price at which the user wants to be alerted)
The API should simulate tracking the product price by fetching a static JSON file containing price data.
The API should notify the user when the product's price meets or drops below the specified price.
Allow users to set time-based price checks. For example, let users specify the frequency of price checks (e.g., check every 24 hours, only morning, mid night alerts).

Functionality
The API should return a structured response:
A message confirming the alert has been set.
Notify users when the price condition is met or exceeded.

Example Flow:
1. User enters a product URL and desired price.
2. API fetches a static JSON with product prices.
3. If the product price matches or falls below the user-set price, the system sends a notification.
   
Submission
Submit your solution as a GitHub repository public URL, including example API requests and responses
Do not spend more than 4 hours on this assignment.
Use your own judgement to decide what is important when writing the code.
The aim of this exercise is to understand your approach to software development and what you see as important.
