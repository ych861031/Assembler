Assembler
===

Main.java
-
主程式

read.java
-
把input.txt讀入程式，用String[]儲存每一行，
-ex:
- string[0] = COPY     START   1000              Comments
- string[1] = FIRST    STL     RETADR            Comments2 

Decompose.java
-
把Read所存的String[]分解成 Label opearation operend comment四個部分，\<br>
ex:\<br>
  Label[0] = COPY   Operation[0] = STL   Operend[0] = RETADR Comments[0] = Comments \<br>
  Label[1] = FIRST  Operation[1] = JSUB  Operend[1] = RDREC  Comments[1] = Comments2 \<br>

到這裡已經完成20% \<br>

MnemonicCode.java
-
用hashMap存助憶碼，\<br>
用法：\<br>
  mnemonicCode.getValue("LDX");\<br>
  可以得到LDX的助憶碼\<br>
 （如果不好用可以換方法做）\<br>

Loc.java
-
目前只寫了，16位元轉2位元，2位元轉16位元。（計算Loc的時候應該會用到）\<br>

目前要做的事
=
算出Loc位址，算出Opcode\<br>
(我晚點會先把input.txt內容改成較簡單的SIC指令）\<br>




