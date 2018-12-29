const express = require('express');
const app = express();
const mongoose = require('mongoose');
const morgan = require('morgan');
const { url } = require('./database');
const router = require('./routes');
require('./index');



// MIDDLEWARES
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(morgan('dev'));
router(app);


//DATABASE
mongoose.connect(url, {useNewUrlParser: true})
.then(() => {
    console.log('Conected to database');
    return app.listen(process.env.PORT, (error, server) => {
        if(!error){
            console.log(`server init on ${process.env.PORT}`);
        }else{
            console.log("error init server");
        }
    });
})
.catch((error) => {
    if (error) throw error;
});


