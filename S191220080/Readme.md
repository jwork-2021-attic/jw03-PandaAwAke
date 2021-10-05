## Java 高级程序设计 第三次作业

#### 191220080 马英硕



## 1. 工作原理理解

SteganographyClassLoader 是一个自定义的 ClassLoader。它重写 ClassLoader 类的 findClass 方法，能够加载我们需要的 Class 数据，实现了一个自定义的 ClassLoader。

有一些数据被存在泡泡图中，应该是采用了基于图片结构的隐写术，然后形成了一个 png 图片。实际上，如果我们需要去查看这张图片，即使两个 png 文件不一样，也有可能显示出来是几乎完全一致的，因为我们可以采取一些技术手段让 png 文件附加或隐含一些可提取数据。在这里，我们就隐写了一些 ClassLoader 装载 Class 所需的数据。



## 2. 编码成图

完了。。在w02里我改了 sorter 接口和分析方式。。属于是没留后路了

还好改回去也很容易。。但因为我写的三个排序有两个不是 Swap-based 所以我可能得再写一个简单的，就写个垃圾排序吧，好像是叫简单选择排序

本来还自己写了生成图片的代码，结果后来才发现有个 Factory 类，结果是一样的

一开始确实是意识到 example 貌似不能运行，所以等了等哈哈哈

```java
public static void main(String[] args) throws IOException {
    SteganographyFactory.getSteganography("S191220080/QuickSorter.java", 
                                          "S191220080/resources/Picture.jpg");
    SteganographyFactory.getSteganography("S191220080/SimpleSelectionSorter.java", 
                                          "S191220080/resources/Picture.jpg");

}
```

以上代码可以生成所需的图片。



## 3. 还原并使用

我们现在先移除 QuickSorter.java 与 SimpleSelectionSorter.java，然后用我的图片试试

![image-20211001235824914](E:\jw03-PandaAwAke\S191220080\Readme.assets\image-20211001235824914.png)

#### 使用 QuickSorter

```java
SteganographyClassLoader loader = new SteganographyClassLoader(new URL(
	"https://box.nju.edu.cn/seafhttp/files/926807ea-031d-4871-a0e5-893902f6a45d/S191220080.QuickSorter.png"));
Class c = loader.loadClass("S191220080.QuickSorter");
```

#### 使用 SimpleSelectionSorter

```java
SteganographyClassLoader loader = new SteganographyClassLoader(new URL(
	"https://box.nju.edu.cn/seafhttp/files/75233d3b-3762-4ed8-b790-1466e77e4e43/S191220080.SimpleSelectionSorter.png"));
Class c = loader.loadClass("S191220080.SimpleSelectionSorter");
```



结果可以运行！

快速排序图片：https://box.nju.edu.cn/seafhttp/files/926807ea-031d-4871-a0e5-893902f6a45d/S191220080.QuickSorter.png

简单选择排序图片：https://box.nju.edu.cn/seafhttp/files/75233d3b-3762-4ed8-b790-1466e77e4e43/S191220080.SimpleSelectionSorter.png



#### 视频结果

快速排序视频：https://asciinema.org/a/5h3nR7p6zu0shmG8aiESGAagK

简单选择排序视频：https://asciinema.org/a/UyeZi3f9XixyvBbYr77fFqmjf



## 4. 使用别人的

这里从 Github 仓库偷了 haibara4869 同学的 example.SelectSorter.png。

图片地址被我重新生成：https://box.nju.edu.cn/seafhttp/files/a9399862-fcaa-42ae-81a6-e9a7966aaf22/example.SelectSorter.png

大家好像使用的都是 example 包名。。我在 S191220080 目录下跑不通，这也正常，所以我就在 example 里跑了。结果正常。