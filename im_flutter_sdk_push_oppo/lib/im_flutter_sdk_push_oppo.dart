
import 'im_flutter_sdk_push_oppo_platform_interface.dart';

class ImFlutterSdkPushOppo {
  Future<String?> getPlatformVersion() {
    return ImFlutterSdkPushOppoPlatform.instance.getPlatformVersion();
  }
}
