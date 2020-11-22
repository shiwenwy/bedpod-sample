#工程 sample

### 工程结构
bedpod-demo: spring boot工程，作为我们的应用。项目开发中一般作为一个单独的领域存在。

demo-sdk: 在领域提供的服务中，可能需要满足多个场景的需求，一种方法是增加if-else代码，另一种是使用工厂模式，但是在我们的demo中使用扩展点
的方式，每个扩展点的实现在单独的maven工程中，这样可以单独开发，也能实现业务或者场景的隔离。demo-sdk就是我们用来定义我们的扩展点的地方。

demo-sdk-impl：扩展点的实现

### 实现


     @RequestMapping(value = "/demo",method = RequestMethod.GET)
     public String say(String name){
         DemoExtPoint demo = getExtPoint("demo");
         return demo.sayHello(name);
     }

     private DemoExtPoint getExtPoint(String extId) {
         return ExtensionLoaderFactory.
             getExtensionLoader(DemoExtPoint.class).getExtension(extId);
     }
     
    
     
 bedpod-demo中DemoController提供了say的服务，在提供服务的过程中，通过getExtPoint，根据extId去获取扩展点的实现。此外我还发布了
 一个DemoAbilityImpl的能力，让具体的扩展点去使用
 
 bedpod-sdk中 DemoExtPoint为提供的扩展点接口，在接口上使用@Extensible注解，定义一个扩展点。此外我们还添加了一个DemoAbility，为什么会
 存在ability，因为我认为单纯的扩展点实现中，可能也会使用系统的一些能力，比如存储、计算等等，之所以没有使用类似springcontext直接获取bean
 的方式，是因为希望系统自己去决定应该开放哪些ability给扩展点，符合开闭原则。
 
 bedpod-sdk-impl是sdk的实现，DemoExtPointImpl使用@Extension注解，注解中value="demo"， demo即扩展点的别名，DemoController通过别名
 获取不同的扩展点实现。另外在resource中，在 META-INF/services目录中，添加了以扩展点接口的全路径为文件名的文件，并将实现的全路径写到文件
 中，这样当 bedpod-demo启动时，就能将扩展点的实现加载进来。
 
 启动bedpod-demo后，效果：
 