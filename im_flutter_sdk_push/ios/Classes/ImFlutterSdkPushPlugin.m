#import "ImFlutterSdkPushPlugin.h"

@implementation ImFlutterSdkPushPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"im_flutter_sdk_push"
            binaryMessenger:[registrar messenger]];

  ImFlutterSdkPushPlugin* instance = [[ImFlutterSdkPushPlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"getPlatform" isEqualToString:call.method]) {
    result(@"ios");
  } else {
    result(FlutterMethodNotImplemented);
  }
}

@end
