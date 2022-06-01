<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FreeMarker Web</title>
</head>
<body>
<h1>Hello ${name} !</h1>
<a href="${url}">${url}</a>
<div>${number?string("#")}</div>
<div>${null!}</div>
</body>
</html>
