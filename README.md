# Email Spam Detection System

## Project Description

Email Spam Detection System built using a Browser Extension, Spring Boot, Flask, REST APIs, and Machine Learning to classify Gmail emails as Spam or Ham.

The Browser Extension automatically captures email content from Gmail and sends it to the Spring Boot backend. The backend communicates with a Flask-based Machine Learning API through REST APIs. The Machine Learning model analyzes the email and returns the prediction (SPAM or HAM), which is displayed inside the browser.

This project demonstrates Browser Extension Development, Backend Development, REST API Integration, and Machine Learning deployment.

---

## Tech Stack

- Java
- Spring Boot
- Python
- Flask
- Machine Learning
- Scikit-learn
- Pandas
- NumPy
- REST APIs
- Chrome Browser Extension
- Git & GitHub

---

## System Architecture

```text
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
Flask Machine Learning API
   ↓
Spam Detection Model
   ↓
Prediction (SPAM / HAM)
   ↓
Browser Extension displays result
```

---

## Features

- Browser Extension for Gmail
- Automatic email content extraction
- Real-time Spam/Ham prediction
- REST API integration between Spring Boot and Flask
- Machine Learning based email classification
- Clean separation between Browser Extension, Backend, and ML Service

---

## Project Workflow

1. User opens an email in Gmail.
2. Browser Extension extracts the email content.
3. Browser Extension sends the email content to the Spring Boot backend.
4. Spring Boot validates the request.
5. Spring Boot sends the email text to the Flask API using REST APIs.
6. Flask preprocesses the email text.
7. The Machine Learning model predicts whether the email is SPAM or HAM.
8. Flask returns the prediction to Spring Boot.
9. Spring Boot sends the response back to the Browser Extension.
10. Browser Extension displays the prediction inside Gmail.

---

## Machine Learning Model

### Dataset

- spam.csv

### Algorithm

- Multinomial Naive Bayes

### Text Processing

- TF-IDF Vectorizer

### Libraries

- Scikit-learn
- Pandas
- NumPy

---

## Setup Instructions

### Browser Extension

1. Open Chrome.
2. Go to **chrome://extensions/**
3. Enable **Developer Mode**.
4. Click **Load unpacked**.
5. Select the `email-extension` folder.

---

### Backend (Spring Boot)

1. Open the Spring Boot project.
2. Configure `application.properties` if required.
3. Run the Spring Boot application.

---

### ML Service (Flask)

Install dependencies

```bash
pip install -r requirements.txt
```

Run the Flask application

```bash
python app.py
```

---

## API Endpoint

### Request

```http
POST /email/analyze
```

Example Request

```json
{
  "emailText": "Congratulations! You won a lottery."
}
```

Example Response

```json
{
  "result": "SPAM",
  "confidence": 1.0
}
```

---

## Skills Demonstrated

- Java Programming
- Spring Boot
- REST API Development
- Python
- Flask
- Browser Extension Development
- Machine Learning Integration
- Backend Development
- API Integration
- Git & GitHub

---

## Future Improvements

- Deploy Spring Boot and Flask on AWS EC2
- Replace localhost APIs with cloud endpoints
- Improve model accuracy using larger datasets
- Add confidence score from the Machine Learning model
- Support multiple email providers

---

## Demo Video

https://youtu.be/5glKjS0X9h8

---

## Author

**Tanbir Hussain**

GitHub  
https://github.com/tanbir-hsain

LinkedIn  
https://www.linkedin.com/in/tanbir-hussain-76320b414
