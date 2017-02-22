// use tutor;

db.notes.find();

db.notes.insert({text: "My note"});

db.notes.find({text: "My note"});

db.notes.update({text: "My note"}, {$set: {text: "His note"}});

db.notes.update({text: "My note"}, {$set: {text: "Her note"}}); // do nothing
db.notes.update({text: "My note"}, {$set: {text: "Her note"}}, {upsert: true});

db.notes.update({}, {$set: {lastUpdate: new Date().getTime()}}); // only one updated
db.notes.update({}, {$set: {lastUpdate: new Date().getTime()}}, {multi: true}); // all updated

db.notes.find().sort({text: 1}); // ASC
db.notes.find().sort({text: -1}); // DSC
db.notes.find().sort({lastUpdate: 1, text: -1}); // ASC then DSC

db.notes.remove({text: "My note"});
db.notes.drop();

db.notes.update({}, {$unset: {lastUpdate: ""}}, {multi: true});

db.sections.insert({title: "Work"});
db.sections.insert({title: "Vacations"});
db.sections.insert({title: "Children"});

db.notes.update({}, {$set: {section: "Old notes"}}, {multi: true});
db.sections.insert({title: "Old notes"});

db.sections.update({}, {$set: {userName: "demo"}}, {multi: true});
db.notes.update({}, {$set: {userName: "demo"}}, {multi: true});
db.users.insert({userName: "demo", password: "demo"});


// show collections;

db.sections.find();
db.users.find();
db.notes.find();
