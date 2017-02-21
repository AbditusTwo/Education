var express = require('express');
var path = require('path');
var session = require('express-session');
var bodyParser = require('body-parser');

var fs = require('fs');
var Db = require('mongodb');
var Server = require ('mongodb').Server;

var db = ne Db('tutor')


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
            store: new MongoStore(
                {
                    url: "mongodb://localhost:27017/angular_session"
                }
            ),
            secret: "angular_tutorial",
            resave: true,
            saveUninitialized: true
        }
    )
);

app.get('/notes', function (req, res) {

    res.send(req.session.notes || []);
    });

app.post(
    "/notes",
    function(req, res) {
    if(!req.session.notes){
    req.session.notes = [];
    req.session.last_note_id = 0;
    }

    var note = req.body;
    note.id = req.session.last_note_id;
    req.session.last_note_id++;
    req.session.notes.push(note);
    req.end();
    }
);

app.listen(3000);