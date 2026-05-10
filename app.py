from flask import Flask, request, jsonify
import pickle
import re

app = Flask(__name__)

model = pickle.load(open("spam_model.pkl", "rb"))
vectorizer = pickle.load(open("vectorizer.pkl", "rb"))


def clean_text(text):
    text = text.lower()
    text = re.sub(r'[^a-z0-9 ]', '', text)
    return text

@app.route("/")
def home():
    return "Spam Model Running"

@app.route("/predict", methods=["POST"])
def predict():
    try:
        data = request.get_json(force=True)
        email_text = data.get("emailText")

        if not email_text:
            return jsonify({"prediction": "ERROR"})

 
        email_text = clean_text(email_text)

        vector = vectorizer.transform([email_text])
        prediction = model.predict(vector)[0]

        result = "SPAM" if prediction == 1 else "HAM"
        return jsonify({"prediction": result})

    except Exception as e:
        print("ERROR:", e)
        return jsonify({"prediction": "ERROR"})

if __name__ == "__main__":
    app.run(port=5000)