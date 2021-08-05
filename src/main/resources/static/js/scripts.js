function send() {
    let object = {
        "code": document.getElementById("code_snippet").value,
        "time": document.getElementById("time_restriction").value,
        "views": document.getElementById("views_restriction").value
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    let response = JSON.parse(xhr.responseText);
    let url = document.URL.slice(0, -3);
    url += response["id"];

    if (xhr.status === 200) {
        alert("Success!");
        addCodeSnippetLink(url);
    }
}

function showRestrictions() {
    let x = document.getElementById("restrictions");
    if (x.style.display === "none") {
        x.style.display = "block";
    }
}

function addCodeSnippetLink(url) {
    const anchorElement = document.createElement("a");
    const message = document.createTextNode(url);
    anchorElement.appendChild(message);
    anchorElement.setAttribute("href", url);
    document.body.appendChild(anchorElement);
}
