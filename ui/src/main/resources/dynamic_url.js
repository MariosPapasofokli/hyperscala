var currentHash = null;

$(function() {
    jsFireHashChanged();
    $(window).on('hashchange', function() {
        jsFireHashChanged();
    });
});

function jsFireHashChanged() {
    var hash = window.location.hash;
    if (hash != currentHash) {
        var body = $('body');
        jsFire(body, 'hashChanged', {
            hash: hash
        });
        currentHash = hash;
    }
}

function setHash(newValue) {
    currentHash = '#' + newValue;
    window.location.hash = currentHash;
}