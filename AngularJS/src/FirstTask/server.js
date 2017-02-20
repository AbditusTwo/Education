var express = require('express');
var path = require('path');

var app = express();

app.use(express.static(path.join(__dirname, 'public')));

app.get('/greeting', function (req, res) {
    res.send("Hello " + req.query.name + "! I'm Server!");
});

app.listen(3000); //We start server on port 3000

// http://localhost:3000/greeting?name=Coders
// http://localhost:3000