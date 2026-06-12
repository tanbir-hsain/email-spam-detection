import pandas as pd
import pickle
import re

from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score

#clean and preprocess email text
def clean_text(text):
    text = text.lower()
    text = re.sub(r'[^a-z0-9 ]', '', text)
    return text

#load spam dataset
df = pd.read_csv("spam.csv")

#convert spam/ham labels into numerical values
df['Category'] = df['Category'].map({'ham': 0, 'spam': 1})

#clean all email messages
df['Messages'] = df['Messages'].apply(clean_text)

#create feature and target variables
X = df['Messages']
y = df['Category']

#convert text into numerical features
vectorizer = TfidfVectorizer(stop_words='english')
X_vectorized = vectorizer.fit_transform(X)

#split data
X_train, X_test, y_train, y_test = train_test_split(
    X_vectorized, y, test_size=0.2, random_state=42
)

#train model
model = MultinomialNB(alpha=0.1)
model.fit(X_train, y_train)

#accuracy
y_pred = model.predict(X_test)
print("Accuracy:", accuracy_score(y_test, y_pred))

#save model
pickle.dump(model, open("spam_model.pkl", "wb"))
pickle.dump(vectorizer, open("vectorizer.pkl", "wb"))

print("Model saved successfully!")