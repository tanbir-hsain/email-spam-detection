from flask import Flask, request, jsonify
import pickle
import re


# create flask application
app = Flask(__name__)


# load trained spam model
model = pickle.load(open("spam_model.pkl", "rb"))

# load saved TF-IDF vectorizer
vectorizer = pickle.load(open("vectorizer.pkl", "rb"))


# clean and preprocess email text
def clean_text(text):
    text = text.lower()
    text = re.sub(r'[^a-z0-9 ]', '', text)
    return text


# home endpoint
@app.route("/")
def home():
    return "Spam Detection API Running"


# prediction endpoint
@app.route("/predict", methods=["POST"])
def predict():

    # get JSON data from request
    data = request.get_json(force=True)

    # extract email text
    email_text = data.get("emailText")

    # validate input
    if not email_text:
        return jsonify({"prediction": "ERROR"})

    # clean email text
    email_text = clean_text(email_text)

    # convert text into numerical features
    vector = vectorizer.transform([email_text])

    # predict spam or ham
    prediction = model.predict(vector)[0]

    # convert numeric prediction to text
    result = "SPAM" if prediction == 1 else "HAM"

    # return result as JSON
    return jsonify({"prediction": result})


# run flask server
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)