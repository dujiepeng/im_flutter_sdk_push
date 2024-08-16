#import "ImFlutterSdkPushIosPlugin.h"
#import "ImFlutterPushIOS.h"

@interface ImFlutterSdkPushIosPlugin()

@end

@implementation ImFlutterSdkPushIosPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    [ImFlutterPushIOS.shared registrar:registrar];
}

@end

@implementation FlutterAppDelegate(Push)
- (void)application:(UIApplication *)application didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken {
    [ImFlutterPushIOS.shared.tokenHandler updateDeviceToken:deviceToken];
}

- (void)application:(UIApplication *)application didFailToRegisterForRemoteNotificationsWithError:(NSError *)error {
    [ImFlutterPushIOS.shared.tokenHandler getDeviceTokenError:error];
}

@end
