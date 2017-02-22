module.exports = function (app, db) {
    var module = {};

    app.get("/checkUser", function (req, res) {
        db.users.find({"userName": req.query.user}).toArray(function (err, usr) {
                if (usr.length > 0) {
                    res.send(false);
                } else {
                    res.send(req.query.user.length > 2);
                }
            }
        );

    });

    app.post("/users", function (req, res) {
        db.users.insert(req.body, function (resp) {
            req.session.userName = req.body.userName;
            res.end();
        });
    });

    return module;
};