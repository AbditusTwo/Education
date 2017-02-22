module.exports = function (app, db) {
    var module = {};

    app.get("/sections", function (req, res) {
        var username = app.setUserQuery(req);
        db.sections.find({userName: username}).toArray(function (err, items) {
            var user = items[0];
            res.send(user.sections);
        });
    });

    app.post("/sections/replace", function (req, resp) {
        // do not clear the list
        var username = app.setUserQuery(req);
        db.users.update({userName: username}, {$set: {sections: req.body}}, function () {
            resp.end();
        });
    });

    return module;
};