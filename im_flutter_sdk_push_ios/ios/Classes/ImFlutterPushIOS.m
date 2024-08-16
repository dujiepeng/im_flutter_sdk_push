//
//  EventManager.m
//  im_flutter_sdk_push_ios
//
//  Created by 杜洁鹏 on 2024/8/2.
//

#import "ImFlutterPushIOS.h"
#import <UserNotifications/UserNotifications.h>
@interface ImFlutterPushIOS() <FlutterPlugin>

@end

static ImFlutterPushIOS *_manager;

@implementation ImFlutterPushIOS

+ (ImFlutterPushIOS *)shared {
    if(_manager == nil) {
        _manager = [[ImFlutterPushIOS alloc] init];
    }
    return _manager;
}

- (void)registrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    self.tokenHandler = [[TokenEventHandler alloc] initWithRegistrar:registrar];
    self.notificationHandler = [[NotificationEventHandler alloc] initWithRegistrar:registrar];
    self.methodChannel = [FlutterMethodChannel methodChannelWithName:@"IOS/method" binaryMessenger:registrar.messenger];
    [registrar addMethodCallDelegate:self channel:self.methodChannel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
   
}

+ (void)registerWithRegistrar:(nonnull NSObject<FlutterPluginRegistrar> *)registrar { 
   
}

@end
