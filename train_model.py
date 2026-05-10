import pandas as pd
import pickle
import re

from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score

# 🔹 Clean text
def clean_text(text):
    text = text.lower()
    text = re.sub(r'[^a-z0-9 ]', '', text)
    return text

# 🔹 Load data
df = pd.read_csv("spam.csv")
df.rename(columns={"Masseges": "Messages"}, inplace=True)
df = df[['Category', 'Messages']]

# 🔹 Label encode
df['Category'] = df['Category'].map({'ham': 0, 'spam': 1})

# 🔹 Apply cleaning
df['Messages'] = df['Messages'].apply(clean_text)

X = df['Messages']
y = df['Category']

# 🔥 TF-IDF (better than CountVectorizer)
vectorizer = TfidfVectorizer(stop_words='english')
X_vectorized = vectorizer.fit_transform(X)

# 🔹 Train-test split
X_train, X_test, y_train, y_test = train_test_split(
    X_vectorized, y, test_size=0.2, random_state=42
)

# 🔥 Better model tuning
model = MultinomialNB(alpha=0.1)
model.fit(X_train, y_train)

# 🔹 Accuracy
y_pred = model.predict(X_test)
print("Accuracy:", accuracy_score(y_test, y_pred))

# 🔹 Save
pickle.dump(model, open("spam_model.pkl", "wb"))
pickle.dump(vectorizer, open("vectorizer.pkl", "wb"))