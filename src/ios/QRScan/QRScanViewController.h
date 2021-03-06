//
//  QRScanViewController.h
//  系统二维码扫描
//
//  Created by long on 17/4/29.
//  Copyright © 2017年 long. All rights reserved.
//

#import <UIKit/UIKit.h>

@class QRScanViewController;

@protocol QRScanDelegate <NSObject>

- (void)qrScanResult:(NSString *)result viewController:(QRScanViewController *)qrScanVC;

@end

@interface QRScanViewController : UIViewController

@property (nonatomic, weak) id<QRScanDelegate> delegate;
@property(nonatomic,copy) void (^callBackResultBlock)(NSString *result);

@end

@interface ProgressView : UIView

- (void)show:(UIView *)view;
- (void)hide;

@end
