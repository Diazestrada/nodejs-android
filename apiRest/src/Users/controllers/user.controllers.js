const service = require('../service/user.service');
const controllers = {};

controllers.addUser = (req, res) => {
    const data = req.body;
    return service.sendUser(data)
    .then(response => res.json(response))
    .catch(err => res.status(400).json(err));
}

module.exports = controllers;