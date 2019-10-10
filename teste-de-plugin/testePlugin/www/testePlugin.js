var exec = require('cordova/exec');

var PluginRFIDP6300 = function (require, exports, module) {

    function EchoService() {

        this.initialise = function (callback) {
            cordova.exec(callback, function(err) {
                callback('Algo deu errado!' + err);
            }, "TestePlugin", "initialise", []);
        }

        this.singleTag = function (callback) {
            cordova.exec(callback, function(err) {
                callback('Algo deu errado! ' + err);
            }, "TestePlugin", "singleTag", []);
        }

        this.disconnect = function (callback) {
            cordova.exec(callback, function(err) {
                callback('Algo deu errado! ' + err);
            }, "TestePlugin", "disconnect", []);
        }

    }

    module.exports = new EchoService();
}

PluginRFIDP6300(require, exports, module);

cordova.define("cordova/plugin/EchoService", PluginRFIDP6300);
