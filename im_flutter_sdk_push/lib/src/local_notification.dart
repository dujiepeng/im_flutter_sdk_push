class LocalNotification {
  const LocalNotification({
    this.title,
    this.subtitle,
    this.body,
    this.userInfo,
    this.sound,
    this.enableSound = true,
    this.badge = -1,
  });

  final String? title;
  final String? subtitle;
  final String? body;
  final Map<String, String>? userInfo;
  final String? sound;
  final bool enableSound;
  final int badge;

  Map<String, dynamic> toMap() {
    Map<String, dynamic> map = {};
    if (title != null) {
      map['title'] = title;
    }
    if (subtitle != null) {
      map['subtitle'] = subtitle;
    }
    if (body != null) {
      map['body'] = body;
    }
    if (userInfo != null) {
      map['userInfo'] = userInfo;
    }
    if (sound != null) {
      map['sound'] = sound;
    }
    map['enableSound'] = enableSound;
    map['badge'] = badge;
    return map;
  }
}
