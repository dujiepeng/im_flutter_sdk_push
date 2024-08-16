//
//  TokenEventHandler.h
//  im_flutter_sdk_push_ios
//
//  Created by 杜洁鹏 on 2024/7/29.
//
#import <Flutter/Flutter.h>
#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface TokenEventHandler : NSObject<FlutterStreamHandler>

- (instancetype)initWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar;
- (void)updateDeviceToken:(NSData *)deviceToken;
- (void)onDeviceTokenError:(NSError *)error;
@end

NS_ASSUME_NONNULL_END
