# AndroidStudio OpenCV环境搭建
Version: 3.2.0

1.下载openCV android sdk [https://opencv.org/releases/]()

2.解压

3.将OpenCV-android-sdk\sdk\java目录下的代码，用AndroidStudio导入Module，File → New → Import Module...

4.将OpenCV-android-sdk\sdk\native\libs\armeabi-v7a目录下的库导入到项目jniLibs目录下

5.引入OpenCV Module

# 案例
1.使用OpenCV将图片进行灰度化处理(MainActivity)

2.使用ColorMatrix进行灰度化处理（GrayActivity）