//
//  EventManager.h
//  im_flutter_sdk_push_ios
//
//  Created by 杜洁鹏 on 2024/8/2.
//
#import <Flutter/Flutter.h>
#import <Foundation/Foundation.h>
#import "TokenEventHandler.h"
#import "NotificationEventHandler.h"


NS_ASSUME_NONNULL_BEGIN

@interface ImFlutterPushIOS : NSObject

@property (nonatomic, strong) TokenEventHandler *tokenHandler;
@property (nonatomic, strong) NotificationEventHandler *notificationHandler;
@property (nonatomic, strong) FlutterMethodChannel *methodChannel;

+ (ImFlutterPushIOS *)shared;

- (void)registrar:(NSObject<FlutterPluginRegistrar>*)registrar;
- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result;
@end

NS_ASSUME_NONNULL_END
