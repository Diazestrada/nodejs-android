const userModel = require('../model/user.model');
const userservice = {};

userservice.sendUser = (data) => new Promise((resolve,reject) => {

    const sendUser = new userModel(data);

    sendUser.save((error, save) => {
        if(!error){
            const ok = {
                ok: true,
                save,
                status: 200
            }
            console.log(ok);

            return resolve(ok);
        }else {
            const error = {
                ok: false,
                error,
                status: 400
            }

            return reject(error);
        }

    });
})

module.exports = userservice;