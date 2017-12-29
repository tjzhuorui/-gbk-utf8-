# -gbk-utf8-
gbk字节数组与utf8数组互转

有一个这种需求，我自己有一个系统A，编码格式采用的是UTF8。我需要与系统B交互数据，但是系统B采用GBK编码。
那么我需要将GBK转成UTF8

为了做实验，我有两个文件：
gbk.txt 我爱你中国		采用gbk编码保存  	16进制为：ced2 b0ae c4e3 d6d0 b9fa
utf8.txt 我爱你中国	采用UTF8编码保存	16进制为：e688 91e7 88b1 e4bd a0e4 b8ad e59b bd
那么我的目标是，从utf8.txt中读取文件，然后将其转换为gbk编码的byte[]，将这个byte[]与gbk.txt中的16进制比较，若一致则达到我的目的。
