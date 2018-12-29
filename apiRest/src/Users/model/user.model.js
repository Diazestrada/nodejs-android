const mongoose = require('mongoose');
const { Schema } = mongoose;

const Users = new Schema({
    name: { type:String },
    last_name: { type:String },
    age: { type:String }
});

module.exports = mongoose.model('users',Users);