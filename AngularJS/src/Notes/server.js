var path = require('path');

var app = express();

app.use(express.static(path.join(__dirname, 'public')));
    var notes = [
        {text: "first note"},
        {text: "second node"},
        {text: "third note"}
    ];

    res.send(notes);
});


app.listen(3000);

