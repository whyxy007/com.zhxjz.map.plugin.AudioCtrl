var cordova = require('cordova');

var audioCtrl = {

	"setSilent" : function(onSuccessFn, onErrorFn){
		cordova.exec(onSuccessFn, onErrorFn, 'AudioCtrlPlugin', 'setSilent', []); 
	},
	
	"setNormal" : function(onSuccessFn, onErrorFn) {
		cordova.exec(onSuccessFn, onErrorFn, 'AudioCtrlPlugin', 'setNormal', []); 
	}

};

module.exports = audioCtrl;

