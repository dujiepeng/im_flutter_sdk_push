import 'package:flutter/services.dart';
import 'package:im_flutter_sdk_push/im_flutter_sdk_push.dart';
import 'package:im_flutter_sdk_push/src/keys.dart';

class ImFlutterSdkPush {
  // static MethodChannel? _platformChannel;
  static EventChannel? _tokenEventChannel;
  static EventChannel? _notificationChannel;
  static MethodChannel? _methodChannel;

  static ImPushPlatform _platform = ImPushPlatform.unknown;
  static get pushPlatform => _platform;

  // 用于获取当前属于什么推送平台
  static const MethodChannel _channel = MethodChannel('im_flutter_sdk_push');

  static Future<void> enablePush() async {
    String? platformKey = await _getPlatform();
    if (!supportPlatforms.contains(platformKey)) {
      throw Exception('Unsupported push platform');
    }

    _methodChannel = MethodChannel(
      '$platformKey/$method',
    );

    _tokenEventChannel = EventChannel(
      '$platformKey/$token',
    );

    _notificationChannel = EventChannel(
      '$platformKey/$notification',
    );
  }

  static Future<String?> _getPlatform() async {
    String? ret;
    final platform = await _channel.invokeMethod('getPlatform');
    if (platform is String) {
      ret = platform;
    }
    return ret;
  }

  static void getToken() {
    _methodChannel!.invokeMethod('getToken');
  }

  static Stream<String> get getTokenStream {
    return _tokenEventChannel!.receiveBroadcastStream().cast<String>();
  }

  static Stream<String> get onNotificationOpenedApp {
    return _notificationChannel!.receiveBroadcastStream().cast<String>();
  }

  static Future<void> sendLocalNotification(
    LocalNotification localNotification,
  ) async {
    await _methodChannel!
        .invokeMethod('sendLocalNotification', localNotification.toMap());
  }
}
