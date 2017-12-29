#gbk字节数组与utf8数组互转
-
####需求
---

有一个这种需求，我自己有一个系统A，编码格式采用的是UTF8。我需要与系统B交互数据，但是系统B采用GBK编码。
那么我需要将GBK转成UTF8

####实验环境
---
为了做实验，我有两个文件：
gbk.txt 我爱你中国		采用gbk编码保存  	16进制为：ced2 b0ae c4e3 d6d0 b9fa
utf8.txt 我爱你中国	采用UTF8编码保存	16进制为：e688 91e7 88b1 e4bd a0e4 b8ad e59b bd
那么我的目标是，从utf8.txt中读取文件，然后将其转换为gbk编码的byte[]，将这个byte[]与gbk.txt中的16进制比较，若一致则达到我的目的。

####实现
---
见代码com.rui.encodetest.CodeTest

####误区
一开始我以为，gbk的字节数组通过 编码(new String(xx,"GBK"))得到的String就是一个gbk编码的String，这样再通过 str.getBytes("UTF8")拿到的字节数组就一定是错误的，是gbk的字节数组的编码。但是，我大错特错了。
通过查阅了一些资料，其实应该是这样的：<br>
	
GBK的byte[]数组---new String(xxx,"GBK")-->str1<br>
这个str1其实是Unicode编码的<br>
即使我的是<br>
UTF8的byte[]数组---new String(xxx,"UTF8")-->str2<br>
str1.equals(str2)应该返回是true,当然前提是 gbk字节数组和utf8的字节数组表达的含义本来就是一样。<br>
`实现`见：com.rui.encodetest.CodeTest2<br>


