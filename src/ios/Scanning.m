/********* Scanning.m Cordova Plugin Implementation *******/

#import "Scanning.h"


@implementation Scanning

- (void)startScanning:(CDVInvokedUrlCommand*)command
{
   
    NSDictionary *options = [command.arguments objectAtIndex:0];
    

    QRScanViewController *vc = [[QRScanViewController alloc] init];
    vc.hidesBottomBarWhenPushed = YES;

    vc.callBackResultBlock = ^(NSString *result){

     CDVPluginResult* pluginResult = nil;
     NSError* err = nil;

    if(result){
        pluginResult =  [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:result];
    }else{
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_IO_EXCEPTION messageAsString:[err localizedDescription]];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

        UIViewController *nav = [self.viewController.navigationController popViewControllerAnimated:YES];
        if (!nav) {
            [self.viewController dismissViewControllerAnimated:YES completion:nil];
        }
    };


    [self.viewController showViewController:vc sender:nil];
}



@end
