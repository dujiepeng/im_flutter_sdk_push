import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'im_flutter_sdk_push_oppo_method_channel.dart';

abstract class ImFlutterSdkPushOppoPlatform extends PlatformInterface {
  /// Constructs a ImFlutterSdkPushOppoPlatform.
  ImFlutterSdkPushOppoPlatform() : super(token: _token);

  static final Object _token = Object();

  static ImFlutterSdkPushOppoPlatform _instance = MethodChannelImFlutterSdkPushOppo();

  /// The default instance of [ImFlutterSdkPushOppoPlatform] to use.
  ///
  /// Defaults to [MethodChannelImFlutterSdkPushOppo].
  static ImFlutterSdkPushOppoPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [ImFlutterSdkPushOppoPlatform] when
  /// they register themselves.
  static set instance(ImFlutterSdkPushOppoPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
