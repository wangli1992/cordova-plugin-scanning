// var exec = require('cordova/exec');

// exports.startScanning = function (arg0, success, error) {
//     exec(success, error, 'Scanning', 'coolMethod', [arg0]);
// };

var  ScanningShow = function(){

};

ScanningShow.prototype.startScanning = function(success, fail, options){
    if (!options) {
		options = {};
    }

    return cordova.exec(success, fail, "Scanning", "startScanning", [options]);
};

window.scanning = new ScanningShow();
