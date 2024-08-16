import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'im_flutter_sdk_push_oppo_platform_interface.dart';

/// An implementation of [ImFlutterSdkPushOppoPlatform] that uses method channels.
class MethodChannelImFlutterSdkPushOppo extends ImFlutterSdkPushOppoPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('im_flutter_sdk_push_oppo');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
