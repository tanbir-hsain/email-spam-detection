import pandas as pd
import pickle

df = pd.read_csv("spam.csv")

print("Columns found:", df.columns)

# Rename incorrect column name
df.rename(columns={"Masseges": "Messages"}, inplace=True)

# Im keeping only required columns
df = df[['Category', 'Messages']]

# Convert labels
df['Category'] = df['Category'].map({'ham': 0, 'spam': 1})

from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score

X = df['Messages']
y = df['Category']

vectorizer = CountVectorizer()
X_vectorized = vectorizer.fit_transform(X)

X_train, X_test, y_train, y_test = train_test_split(
    X_vectorized, y, test_size=0.2, random_state=42
)

model = MultinomialNB()
model.fit(X_train, y_train)

y_pred = model.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)
print("Model Accuracy:", accuracy)

pickle.dump(model, open("spam_model.pkl", "wb"))
pickle.dump(vectorizer, open("vectorizer.pkl", "wb"))
