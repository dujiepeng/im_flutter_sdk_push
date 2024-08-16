//
//  NotificationEventHandler.h
//  im_flutter_sdk_push_ios
//
//  Created by 杜洁鹏 on 2024/8/2.
//

#import <Foundation/Foundation.h>
#import <Flutter/Flutter.h>

NS_ASSUME_NONNULL_BEGIN

@interface NotificationEventHandler : NSObject<FlutterStreamHandler>
@property (nonatomic, strong) FlutterEventSink events;
- (instancetype)initWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar;
@end

NS_ASSUME_NONNULL_END
