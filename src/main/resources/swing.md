# Java图形界面开发
## Swing组件

### 顶层容器

| # | 组件 | 描述 |
| ---- | ---- | ---- |
| 1    | JFrame | 一个普通窗口(一般作为图形界面的顶层容器) |
| 2 | JDialog | 对话框 |

JFrame

Swing 的基本组件可以直接添加到 `JFrame` 上，但通常建议使用中间容器，如 `JPanel` 或 `JScrollPane`，来帮助组织和布局组件。这样可以在容器内进行组件的位置调整和布局管理。

### 中间容器

中间容器作为基本组件的载体，不可独立显示。中间容器可以添加若干基本组件（也可嵌套添加中间容器），对容器内的组件进行管理，类似于给各种复杂的组件进行分组管理。最顶层的一个中间容器必须依托在顶层容器（窗口）内。

常用的中间容器(面板):

| @    | 组件         | 描述                                     |
| ---- | ------------ | ---------------------------------------- |
| 1    | JPanel       | 一般轻量级面板容器组件                   |
| 2    | JScrollPane  | 带滚动条的，可以水平和垂直滚动的面板组件 |
| 3    | JSplitPane   | 分隔面板                                 |
| 4    | JTabbedPane  | 选项卡面板                               |
| 5    | JLayeredPane | 层级面板                                 |



**特殊的中间容器**

| #    | 组件           | 描述     |
| ---- | -------------- | -------- |
| 1    | JMenBar        | 菜单栏   |
| 2    | JToolBar       | 工具栏   |
| 3    | JPopupMenu     | 弹出菜单 |
| 4    | JInternalFrame | 内部窗口 |

### 基本组件

基本组件是直接实现人机交互的组件

***

常用的简单的基本组件

| #    | 组件           | 描述       |
| ---- | -------------- | ---------- |
| 1    | JLabel         | 标签       |
| 2    | JButton        | 按钮       |
| 3    | JRadioButton   | 单选按钮   |
| 4    | JCheckBox      | 复选框     |
| 5    | JToggleButton  | 开关按钮   |
| 6    | JTextField     | 文本框     |
| 7    | JPasswordField | 密码框     |
| 8    | JTextArea      | 文本区域   |
| 9    | JComboBox      | 下拉列表框 |
| 10   | JList          | 列表       |
| 11   | JProgressBar   | 进度条     |
| 12   | JSlider        | 滑块       |

选取器组件：

| #    | 组件          | 描述       |
| ---- | ------------- | ---------- |
| 1    | JFileChooser  | 文本选取器 |
| 2    | JColorChooser | 颜色选取器 |

其他较为复杂的基本组件：

| #    | 组件   | 描述 |
| ---- | ------ | ---- |
| 1    | JTable | 表格 |
| 2    | JTree  | 树   |

## 布局管理器

把Swing的各种组件(JComponent)添加到面板容器中（JPanel）,需要给面板容器制定布局管理器，明确容器内(Container)内各个组件之间的排列布局方式

| #    | 布局管理器    | 描述                                                         |
| ---- | ------------- | ------------------------------------------------------------ |
| 1    | FlowLayout    | 流式布局，按组件加入顺序，按水平方向排列，排满一行换下一行继续排列 |
| 2    | GridLayout    | 网格布局，把Container按指定行列分隔出若干网格，每一个网格按顺序防止一个控件 |
| 3    | GridBayLayout | 网格袋布局，按网格划分Container,每个组件可占用一个或多个网格，可将组件垂直，水平或者它们的基线对齐 |
| 4    | BoxLayout     | 箱式布局，将Container中的多个组件按水平货垂直的方式排列      |
| 5    | BorderLayout  | 表界布局，把Container按方位分为5各区域(东、西、南、北、中)，每个区域放置一个组件 |
| 6    | null          | 绝对布局，通过设置组件在Container中的坐标位置来放置组件。    |
|      |               |                                                              |
|      |               |                                                              |
|      |               |                                                              |



### 流式布局

![image-20240811133816644](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811133816644.png)



![image-20240811133826708](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811133826708.png)

### 网格布局



表示网格布局管理器的类是GridLayout，它的布局方式是把整个内容面板看成是一个N行M列的二维网格阵列，桌面上的每个组件都占据一个网格，这些网格的大小是均匀的。在创建GridLayout类对象时，如果没有指定N和M的值，那么所有组件将自动排成一行并均匀的占满整个窗体界面。反之，如果在创建GridLayout对象时指定了N和M的值，则组件会排列为N行M列。当组件的数量多于网格数量时，内容面板会增加列来显示多余的组件，但行的数量不会增加。而当组件的数量少于网格数量时，内容面板会优先保证行的数量足够。例如：一个4×4的网格矩阵中如果只有4个按钮，那么这4个按钮会排成纵向的一列以保证“凑够”4行，而不是横向排列以保证“凑够”4列。在默认情况下，网格布局下的组件都是“紧挨”在一起的，如果希望各组件之间有一定的间距，也可以通过构造方法参数进行设置，例如：

![image-20240811134444183](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811134444183.png)

### 网格袋布局

![image-20240811135625503](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811135625503.png)

![image-20240811135705969](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811135705969.png)

![image-20240811135936072](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811135936072.png)

![image-20240811135959332](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811135959332.png)



![image-20240811141021826](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811141021826.png)

![image-20240811141113616](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811141113616.png)

![image-20240811141131871](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811141131871.png)

## JavaSwing面板组件【中间容器】

### JPanel

### JScrollPane（滚动面板）

![image-20240811150112909](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811150112909.png)

![image-20240811150140433](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811150140433.png)

![image-20240811150207614](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811150207614.png)

![image-20240811150233426](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811150233426.png)

### JDialog/JoptionPane(对话框)

![image-20240811180713046](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811180713046.png)

![image-20240811180759149](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811180759149.png)

![image-20240811181612819](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811181612819.png)

![image-20240811181650728](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811181650728.png)

![image-20240811181705551](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811181705551.png)

![image-20240811181849403](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811181849403.png)

![image-20240811181859238](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811181859238.png)

![image-20240811181915640](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811181915640.png)

![image-20240811181930932](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811181930932.png)

#### JDialog

![image-20240811183329090](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811183329090.png)

### JMenuBar(菜单栏)

![image-20240811203159295](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203159295.png)

![image-20240811203306653](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203306653.png)

![image-20240811203535851](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203535851.png)

![image-20240811203625593](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203625593.png)

![image-20240811203547322](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203547322.png)

![image-20240811203707499](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203707499.png)

![image-20240811203736992](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203736992.png)



![image-20240811203823707](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203823707.png)

![image-20240811203840178](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811203840178.png)













### JPopupMenu（弹出菜单）

![image-20240811202821346](C:\Users\hwb\AppData\Roaming\Typora\typora-user-images\image-20240811202821346.png)
