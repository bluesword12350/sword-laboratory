const fs = require('fs');
const minify = require('html-minifier').minify;
const UglifyJS = require("uglify-js");

if(!fs.existsSync("./build")){
    fs.mkdirSync("./build");
}

fs.readFile('./环形进度条.html', 'utf8', function (err, data) {
    if (err) {
        throw err;
    }
    let index =
        minify(data,{removeComments: true,collapseWhitespace: true,minifyJS:true, minifyCSS:true})
            .replace("node_modules/lunar-javascript/lunar.js","lunar.min.js")
    fs.writeFile('./build/环形进度条.html',
        index,
        ()=>console.log('success build index.html')
    );
});

fs.readFile('./node_modules/lunar-javascript/lunar.js', 'utf8', function (err, data) {
    if (err) {
        console.log(err.name)
    }
    fs.writeFile('./build/lunar.min.js',
        UglifyJS.minify(data).code,
        ()=>console.log('success build lunar')
    );
});