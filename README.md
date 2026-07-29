Email Spam Detection System

Project Description

Email Spam Detection System built using a Browser Extension, Spring Boot, Flask, REST APIs, and Machine Learning to classify Gmail emails as Spam or Ham.

The browser extension automatically reads the email content from Gmail and sends it to a Spring Boot backend. The backend communicates with a Flask-based Machine Learning API through REST APIs. The Machine Learning model analyzes the email and returns the prediction (Spam or Ham), which is displayed inside the browser.

This project demonstrates Browser Extension Development, Backend Development, REST API Integration, and Machine Learning deployment.

Tech Stack
Java
Spring Boot
Python
Flask
Machine Learning
Scikit-learn
Pandas
REST APIs
Chrome Browser Extension
Git & GitHub
System Architecture
User
        ↓
Gmail
        ↓
Browser Extension
        ↓
Spring Boot Backend
        ↓
REST API
        ↓
Flask Machine Learning Service
        ↓
Spam Detection Model
        ↓
Prediction (SPAM / HAM)
        ↓
Browser Extension displays result
Features
Browser extension for Gmail
Automatic email content extraction
Real-time Spam/Ham prediction
Spring Boot REST API integration
Flask Machine Learning API
Machine Learning based email classification
Clean separation between frontend, backend, and ML service
Project Workflow
User opens an email in Gmail.
The browser extension extracts the email content.
The extension sends the email text to the Spring Boot backend.
Spring Boot validates the request.
Spring Boot sends the email text to the Flask API using REST APIs.
Flask preprocesses the text using TF-IDF Vectorizer.
The trained Naive Bayes model predicts whether the email is Spam or Ham.
Flask returns the prediction to Spring Boot.
Spring Boot returns the response to the browser extension.
The browser extension displays the prediction inside Gmail.
Machine Learning Model

Dataset:

spam.csv

Algorithm:

Multinomial Naive Bayes

Text Processing:

TF-IDF Vectorizer

Libraries:

Scikit-learn
Pandas
NumPy

Model Output:

SPAM
HAM
Backend Components
Browser Extension
Reads email content from Gmail
Sends email text to Spring Boot
Displays Spam/Ham result inside Gmail
Spring Boot
Receives requests from the browser extension
Validates user input
Calls the Flask Machine Learning API
Returns the prediction
Flask API
Cleans the email text
Converts text into TF-IDF vectors
Predicts Spam or Ham using the trained model
Returns prediction as JSON
API
Analyze Email
POST /email/analyze

Request

{
  "emailText": "Congratulations! You won a lottery."
}

Response

{
  "result": "SPAM",
  "confidence": 1.0
}
Project Structure
email-extension/
    content.js
    manifest.json

Spring Boot/
    Controller
    Service
    DTO
    Exception Handler

Flask/
    app.py
    train_model.py
    spam_model.pkl
    vectorizer.pkl
Skills Demonstrated
Java
Spring Boot
REST APIs
Python
Flask
Machine Learning
Browser Extension Development
API Integration
Backend Development
Git & GitHub
Future Improvements
Deploy Spring Boot on AWS EC2
Deploy Flask API on AWS EC2
Replace localhost with cloud endpoints
Improve prediction confidence score
Support multiple email providers
Use larger datasets for better accuracy
Author

Tanbir Hussain

GitHub:
https://github.com/tanbir-hsain

LinkedIn:
https://www.linkedin.com/in/tanbir-hussain-76320b414
