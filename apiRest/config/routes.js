// import route
const User = require('../src/Users');



const router = (app) => {
   app.use('/register',User);
};

module.exports = router;