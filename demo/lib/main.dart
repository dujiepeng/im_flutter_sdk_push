import 'package:flutter/material.dart';
import 'package:im_flutter_sdk_push/im_flutter_sdk_push.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  void initState() {
    super.initState();

    initPush();
  }

  Future<void> initPush() async {
    // 初始化推送配置

    await ImFlutterSdkPush.enablePush();

    // 获取 deviceToken
    ImFlutterSdkPush.getTokenStream.listen((event) {
      debugPrint('token: $event');
    }, onError: (e) {
      debugPrint('error: ${e.toString()}');
    });

    ImFlutterSdkPush.getToken();

    // 点击推送通知
    ImFlutterSdkPush.onNotificationOpenedApp.listen((event) {
      debugPrint('notification: $event');
    }, onError: (e) {
      debugPrint('error: ${e.toString()}');
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: ListView(
        children: [
          ElevatedButton(
            onPressed: () {
              ImFlutterSdkPush.sendLocalNotification(const LocalNotification(
                title: 'title',
                subtitle: 'subtitle',
                body: 'body',
                userInfo: {'key': 'value'},
                sound: 'sound',
                enableSound: true,
                badge: 1,
              ));
            },
            child: const Text('send local notification'),
          ),
        ],
      ),
    );
  }
}
