<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script src="/js/scripts.js"></script>
</head>
<body>
    <main id="main">
        <h1>Share your code!</h1>

        <label for="code_snippet"></label><textarea id="code_snippet" placeholder="Insert your code here"></textarea>
        <button id="show_restrictions" onclick="showRestrictions()">Add restrictions</button>
        <div id="restrictions" style="display: none">
            <label for="time_restriction">Time restriction in seconds: </label>
            <input id="time_restriction" type="number" min="0" max="1000000" value="0"/>
            <label for="views_restriction">Number of views: </label>
            <input id="views_restriction" type="number" min="0" max = "1000000" value="0"/>
        </div>
        <button id="send_snippet" type="submit" onclick="send()">Submit</button>
    </main>
</body>
</html>