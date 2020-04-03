#import <Cordova/CDV.h>
#import "QRScanViewController.h"

@interface Scanning : CDVPlugin 
  // Member variables go here.

- (void)startScanning:(CDVInvokedUrlCommand*)command;

@end