<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<h1>Latest code snippets:</h1>
<#list codeSnippets as codeSnippet>
    Created on: <span id="load_date">${codeSnippet.date.format("yyyy-MM-dd HH:mm:ss")}</span>
    <pre id="code_snippet"><code> ${codeSnippet.code}</code> </pre>
</#list>
</body>
</html>
