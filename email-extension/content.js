console.log("Extension running");

function getEmailText() {
    let emailBody =
        document.querySelector(".a3s.aiL") ||
        document.querySelector(".a3s");

    return emailBody ? emailBody.innerText : "";
}

setInterval(() => {

    let text = getEmailText();

    if (!text) return;

    fetch("http://127.0.0.1:8080/email/analyze", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            emailText: text
        })

    })
    .then(res => res.text())
    .then(data => {

        let box = document.getElementById("spam-box");

        if (!box) {

            box = document.createElement("div");

            box.id = "spam-box";

            box.style.position = "fixed";
            box.style.top = "10px";
            box.style.right = "10px";
            box.style.background = "black";
            box.style.color = "white";
            box.style.padding = "12px";
            box.style.borderRadius = "8px";
            box.style.zIndex = "9999";

            document.body.appendChild(box);
        }

        box.innerText = "Spam Detection Result: " + data;

    })
    .catch(err => console.log("Backend error:", err));

}, 4000);
