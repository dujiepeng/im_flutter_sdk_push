//
//  TokenEventHandler.m
//  im_flutter_sdk_push_ios
//
//  Created by 杜洁鹏 on 2024/7/29.
//

#import "UIKit/UIKit.h"
#import "ImFlutterSdkPushIosPlugin.h"
#import "TokenEventHandler.h"


@interface TokenEventHandler() <UIApplicationDelegate>
@property (nonatomic, strong) FlutterEventSink events;
@end

@implementation TokenEventHandler

- (instancetype)initWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    if(self = [super init]) {
        FlutterEventChannel *channel = [FlutterEventChannel eventChannelWithName:@"ios/tokenEvent"
                                                                      binaryMessenger:registrar.messenger];
        [channel setStreamHandler:self];
    }
    return self;
}

- (FlutterError * _Nullable)onCancelWithArguments:(id _Nullable)arguments {
    _events = nil;
    return nil;
}

- (FlutterError * _Nullable)onListenWithArguments:(id _Nullable)arguments eventSink:(nonnull FlutterEventSink)events {
    _events = events;
    [self registerDeviceToken];
    return nil;
}

- (void)registerDeviceToken  {
    [UIApplication.sharedApplication registerForRemoteNotifications];
}

- (void)updateDeviceToken:(NSData *)deviceToken {
    self.events([self _extractTokenFromRawData:deviceToken]);
}

- (void)onDeviceTokenError:(NSError *)error {
    FlutterError *flutterError = [FlutterError errorWithCode:[NSString stringWithFormat:@"%ld", (long)error.code] message:error.description details:nil];
    self.events(flutterError);
}



- (NSString *)_extractTokenFromRawData:(NSData *)deviceToken
{
    NSString *token = @"";
    do {
        if (@available(iOS 13.0, *)) {
            if ([deviceToken isKindOfClass:[NSData class]]) {
                const unsigned *tokenBytes = (const unsigned *)[deviceToken bytes];
                token = [NSString stringWithFormat:@"%08x%08x%08x%08x%08x%08x%08x%08x",
                                      ntohl(tokenBytes[0]), ntohl(tokenBytes[1]), ntohl(tokenBytes[2]),
                                      ntohl(tokenBytes[3]), ntohl(tokenBytes[4]), ntohl(tokenBytes[5]),
                                      ntohl(tokenBytes[6]), ntohl(tokenBytes[7])];
                break;
            }else if ([deviceToken isKindOfClass:[NSString class]]) {
                token = [NSString stringWithFormat:@"%@",deviceToken];
                token = [token stringByReplacingOccurrencesOfString:@"<" withString:@""];
                token = [token stringByReplacingOccurrencesOfString:@">" withString:@""];
                token = [token stringByReplacingOccurrencesOfString:@" " withString:@""];
                break;
            }
        }else {
            token = [NSString stringWithFormat:@"%@",deviceToken];
            token = [token stringByReplacingOccurrencesOfString:@"<" withString:@""];
            token = [token stringByReplacingOccurrencesOfString:@">" withString:@""];
            token = [token stringByReplacingOccurrencesOfString:@" " withString:@""];
            break;
        }
    } while (0);
    
    return token;
}


@end

