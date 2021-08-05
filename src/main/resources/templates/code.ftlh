<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>

    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    Created on: <span id="load_date">${codeSnippet.date.format("yyyy-MM-dd HH:mm:ss")}</span>
    <pre id="code_snippet"><code>${codeSnippet.code}</code></pre>
    <#if codeSnippet.time gt 0>
        Time left: <span id="time_restriction">${codeSnippet.time}</span>
    </#if>
    <br>
    <#if codeSnippet.views gt 0>
        Views left: <span id="views_restriction">${codeSnippet.views}</span>
    </#if>

    <!-- Special case when there are 0 views left. -->
    <#if codeSnippet.views == -1>
        Views left: <span id="views_restriction">0</span>
    </#if>

</body>
</html>
