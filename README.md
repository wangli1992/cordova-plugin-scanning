cordova-plugin-qrcode-scanner
===================

Cordova Plugin For scanning QR code - implemented for iOS 8.0 and Android


## Using the plugin

The plugin creates the object `window.scanning` with the method `startScanning(success, fail, options)`

Example - (not have options):
```javascript
window.scanning.startScanning(
	function(result) {
		console.log('reslut:'+result);
	}, function (error) {
		console.log('Error: ' + error);
	},options
);
```


```
## Options (暂时未处理)
options = {
	isLight: Bool,//是否开启手电筒
    speed:number //线条运行速度
};

```
