var express = require('express');
var app = express();

app.use(express.static(__dirname + '/'));

// });
// app.get("/students/test", function(req, res) {
//     res.send("from students test");
// });

app.get("/", function(req, res) {
    res.redirect("/view/index.html#!/home");
});

//Launching server
app.listen(8000, function(req, res) { //runing server in the port 8080
    console.log("Opening port 8000");
    console.log('application launched at localhost:8000');
});
