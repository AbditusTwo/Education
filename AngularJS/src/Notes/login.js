/**
 * Created by koziolek on 19.02.17.
 */
module.exports = function (app, db) {
    var module = {};

    app.post("/login", function (req, res) {
        db.users.find({
            userName: req.body.login,
            password: req.body.password
        }).toArray(function (err, items) {
            if (items.length > 0) {
                req.session.userName = req.body.login;
            }
            res.send(items.length > 0);
        });
    });

    app.get("/logout", function (req, res) {
        req.session.userName = null;
        res.end();
    });

    return module;
};