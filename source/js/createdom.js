var message = {
    "name": "hello webpack",
    "content": "this is my first demo",
    "start": "Ready Go!"
};
module.exports = function () {
    var greet = document.createElement('div');
    greet.innerHTML = "<p>" + message.name + "</p>" + "<p>" + message.content + "</p>" + "<p>" + message.start + "</p>";
    return greet;
};
