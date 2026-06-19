# Email Threat Detection System

## Project Description
Email Threat Detection System built using Spring Boot, Flask, REST APIs, and Machine Learning to classify emails as Spam or Ham (Not Spam). The project demonstrates backend development, API integration, and machine learning model deployment.

## Tech Stack
- Java
- Spring Boot
- Python
- Flask
- Machine Learning
- REST API
- Git & GitHub

## Architecture

User
↓
Spring Boot Backend
↓
REST API Call
↓
Flask ML Service
↓
Spam Detection Model
↓
Prediction (SPAM / HAM)
↓
Response to User

## Features
- Real-time email spam detection
- REST API integration between Spring Boot and Flask
- Machine Learning-based email classification
- Backend development using Spring Boot
- Clean separation of backend and ML services

## How It Works
1. User submits email content
2. Spring Boot receives the request
3. Backend sends email content to Flask API
4. Machine Learning model analyzes the text
5. Flask returns prediction (SPAM/HAM)
6. Spring Boot returns the result to the user

## Setup Instructions

### Backend (Spring Boot)
1. Open the Spring Boot project
2. Configure application properties if required
3. Run the application

### ML Service (Flask)
1. Install dependencies

```bash
pip install -r requirements.txt
```

2. Run the Flask application

```bash
python app.py
```

### API Endpoint

```http
POST /email/analyze
```

Example Request:

```json
{
  "emailText": "Congratulations! You won a lottery."
}
```

Example Response:

```json
{
  "result": "SPAM",
  "confidence": 1.0
}
```

## Skills Demonstrated
- Java Programming
- Spring Boot
- REST API Development
- Python
- Flask
- Machine Learning Integration
- Backend Development
- Git & GitHub

## Future Improvements
- Deploy Spring Boot and Flask services on AWS EC2
- Improve model accuracy using larger datasets
- Add frontend user interface
- Implement confidence score from ML model

## Author

**Tanbir Hussain**

LinkedIn: linkedin.com/in/tanbir-hussain-76320b414

GitHub: github.com/tanbir-hsain
