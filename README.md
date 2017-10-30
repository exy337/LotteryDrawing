# LotteryDrawing
随机抽奖演示，比如在21个数(球)中抽取5个

核心技巧:
//Math.random()方法返回一个0到1之间(包含0，不包含1）的随机浮点数.
//用n乘以这个数，就可以得到0到n-1之间的一个随机数
int r = (int) (Math.random() * n);
result[i] = numbers[r];

numbers[r] = numbers[n-1];//用最后一个数替换被抽出去的数,并且n减一
n--;
