//
//  NotificationEventHandler.m
//  im_flutter_sdk_push_ios
//
//  Created by 杜洁鹏 on 2024/8/2.
//

#import "NotificationEventHandler.h"

@implementation NotificationEventHandler {
    NSDictionary *_pushUserInfo;
}

- (instancetype)initWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    if(self = [super init]) {
        FlutterEventChannel *channel = [FlutterEventChannel eventChannelWithName:@"ios/notificationEvent"
                                                                                  binaryMessenger:registrar.messenger];
        [channel setStreamHandler:self];
        
        [[NSNotificationCenter defaultCenter]
            addObserver:self
               selector:@selector(application_onDidFinishLaunchingNotification:)
            name:UIApplicationDidFinishLaunchingNotification
         object:nil];
    }
    return self;
}

- (FlutterError * _Nullable)onCancelWithArguments:(id _Nullable)arguments {
    _events = nil;
    return nil;
}

- (FlutterError * _Nullable)onListenWithArguments:(id _Nullable)arguments eventSink:(nonnull FlutterEventSink)events {
    _events = events;
    if(_pushUserInfo != nil) {
        _events(_pushUserInfo);
        _pushUserInfo = nil;
    }
    return nil;
}

- (void)application_onDidFinishLaunchingNotification:(nonnull NSNotification *)notification{
    if(notification.userInfo != nil) {
        if(_events == nil) {
            _pushUserInfo = notification.userInfo;
        }else {
            _events(notification.userInfo);
        }
    }
}

@end
