document.getElementById("checkBtn").addEventListener("click", function () {

    let text = document.getElementById("emailText").value;

    fetch("http://13.206.142.50:5000/predict", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ emailText: text })
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById("result").innerText =
            "Prediction: " + data.prediction;
    })
    .catch(err => {
        console.error(err);
        document.getElementById("result").innerText = "ERROR";
    });

});