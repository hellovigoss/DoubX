# Doubx

***

## 一个msgpack的rpc，服务端基于java


### 预计特点
* 轻量
* 开发侵入少

***

*参数定义*

```java
package args;

import org.msgpack.annotation.MessagePackMessage;

/**
 * Created by yedai on 15-1-15.
 */
@MessagePackMessage
public class HelloArgs {
    public String name;
    public String words;
}
```

*具体实现*

```java
package api;

 import args.HelloArgs;

 /**
  * Created by yedai on 15-1-14.
  */
 public class Hello extends Api {

     @Override
     protected String work() {
         HelloArgs args = (HelloArgs)this.args;

         return args.name + " says: " + args.words;
     }
 }
 ```
