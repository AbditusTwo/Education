/**
 * Created by koziolek on 22.01.17.
 */

var express = require('express');

var path = require('path');
var session = require('express-session');
var bodyParser = require('body-parser');
var fs = require('fs');
var Db = require('mongodb').Db;
var Server = require('mongodb').Server;

var db = new Db('tutor',
    new Server("localhost", 27017, {safe: true}, {auto_reconnect: true}, {})
);

db.open(function () {
    console.log("mongo db is open");
    db.collection("notes", function (err, notes) {
        db.notes = notes;
    });
    db.collection("sections", function (err, sections) {
        db.sections = sections;
    });
});

var app = express();

app.use(express.static(path.join(__dirname, 'public')));

app.use(bodyParser.urlencoded(
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

require('./notes')(app, db);
require('./section')(app, db);


app.listen(3000);