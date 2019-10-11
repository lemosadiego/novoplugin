var exec = require('cordova/exec');

var PluginAutoid9U = function (require, exports, module) {

    function EchoService() {

        this.initialise = function (callback) {
            cordova.exec(callback, function(err) {
                callback('Algo deu errado!' + err);
            }, "PluginAutoid9U", "coolMethod", []);
        }

        // this.singleTag = function (callback) {
        //     cordova.exec(callback, function(err) {
        //         callback('Algo deu errado! ' + err);
        //     }, "PluginAutoid9U", "singleTag", []);
        // }

        // this.disconnect = function (callback) {
        //     cordova.exec(callback, function(err) {
        //         callback('Algo deu errado! ' + err);
        //     }, "PluginAutoid9U", "disconnect", []);
        // }

    }

    module.exports = new EchoService();
}

PluginAutoid9U(require, exports, module);

cordova.define("cordova/plugin/EchoService", PluginAutoid9U);
