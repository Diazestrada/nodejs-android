const { Router } = require('express');
const controller = require('./controllers/user.controllers');
const router = Router();

router.post('/addUser',controller.addUser);

module.exports = router;