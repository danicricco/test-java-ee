

(function (window) {
    'use strict';

    /**
     * Creates a new client side storage object and will create an empty
     * collection if no collection already exists.
     *
     * @param {string} name The name of our DB we want to use
     * @param {function} callback Our fake DB uses callbacks because in
     * real life you probably would be making AJAX calls
     */
    function Rest(url) {
        this.urlBase_ = url;
    };

    Rest.prototype.todos = function (callback) {
        this.invokeFind_({}, callback);
    };
    Rest.prototype.todos = function (filter, callback) {
        this.invokeFind_(filter, callback);
    };
    Rest.prototype.crear = function (object, callback) {
        this.invoke_("POST", "", object, callback);
    };

    Rest.prototype.obtener = function (id, callback) {
        this.invoke_("GET", id, {}, callback);
    };
    Rest.prototype.actualizar = function (id, objeto, callback) {
        this.invoke_("PUT", id, objeto, callback);
    };
    Rest.prototype.eliminar = function (id, callback) {
        this.invoke_("DELETE", id, {}, callback);
    };

    Rest.prototype.invoke_ = function (metodo, addUrl, parametros, callback) {

        var xhr = new XMLHttpRequest();
        xhr.open(metodo, this.urlBase_ + addUrl, true);
        xhr.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        xhr.onreadystatechange = function () {
            if (xhr.status === 200 && callback) {
                var db = JSON.parse(xhr.responseText);
                callback.call(this, db);
            } else {
                callback.call(this, {});
            }
        };
        xhr.send(JSON.stringify(parametros));
    };

    Rest.prototype.invokeFind_ = function (parametros, callback) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', this.urlBase_, true);
        xhr.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        xhr.onreadystatechange = function () {
            if (xhr.status === 200 && callback) {

                var db=[];
                if(xhr.responseText!=''){
                    db= JSON.parse(xhr.responseText).content;
                }
                callback.call(this, db);
            } else {
                callback.call(this, []);
            }
        };
        xhr.send(JSON.stringify(parametros));
    };

    // Export to window
    window.app = window.app || {};
    window.app.Rest = Rest;
})(window);
