# Registration-and-login
An Android course assignment required to realize the registration login interface and functions

#### 内容简介
本软件实现了用户注册、登录、记住密码、限制密码输错次数的功能并支持中英双语。

#### 难点和解决方案：
**保存密码**：解决方案是保存是否勾选保存密码复选框的布尔值，当程序启动时读取该布尔值，若为真则读取密码并填入编辑框，若为假则不读取。

#### 不足之处：
当剩余尝试次数为0时没有禁用登录按钮。

#### 今后的设想：
当剩余尝试次数为0时禁用登录按钮，不允许用户点击。
