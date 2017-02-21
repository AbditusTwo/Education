/**
 * Created by BKuczynski on 2017-01-26.
 */
var ObjectID = require('mongodb').ObjectID;

module.exports = function (app, db) {
    var module = {};

    app.get("/notes", function (req, res) {
            db.notes.find(req.query).toArray(function (err, items) {
                res.send(items);
            });
        }
    );


    app.post("/notes", function (req, res) {
            var note = req.body;
            db.notes.insert(note);
            res.send();

        }
    );


    app.delete("/notes", function (req, res) {
            var id = new ObjectID(req.query.id);
            db.notes.remove({_id: id}, function (err) {
                if(err){
                    console.log("err")
                    res.send("Failed");
                } else {
                    res.send("Success");
                }
            })
        }
    );


    app.put("/notes", function (req, res) {

        }
    );

    return module;
};