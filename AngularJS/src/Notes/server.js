var express = require('express');
var path = require('path');

var session = require('express-session');
var bodyParser = require('body-parser');

var app = express();


app.use(express.static(path.join(__dirname, 'public')));

app.use(bodyParser.urlencoded (
    {
        extended: true
    })
);
    app.use(bodyParser.json());

app.use(
    session(
        {
            secret: "angular_tutorial",
            resave: true,
            saveUninitialized: true
        }
    )
);

app.get('/notes', function (req, res) {
    var notes = [
        {text: "first note"},
        {text: "second node"},
        {text: "third note"}
    ];

    res.send(notes);
});

app.listen(3000);