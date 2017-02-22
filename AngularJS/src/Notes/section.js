module.exports = function (app, db) {
    var module = {};

    app.get("/sections", function (req, res) {
        db.sections.find(req.query).toArray(function (err, items) {
            res.send(items);
        });
    });

    app.post("/sections/replace", function (req, resp) {
        // do not clear the list
        if (req.body.length == 0) {
            resp.end();
        }
        db.sections.remove({}, function (err, res) {
            if (err) console.log(err);
            db.sections.insert(req.body, function (err, res) {
                if (err) console.log("err after insert", err);
                resp.end();
            });
        });
    });

    return module;
};