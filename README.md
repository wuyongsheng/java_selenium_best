>  最近花了大半个月的时间，用 Java 语言实现了一套 selenium 的自动化测试框架（源代码已提交至GitHub：https://github.com/wuyongsheng/java_selenium_best     ）
，把 selenium 自动化测试常用的一些技术都运用到起来了。话不多说，测试运行的效果见下面的动图：

### 自动化测试运行效果图
下面的动图展示了自动化测试执行的部分操作，包括登录系统、提交bug、退出系统、登录失败后自动重试。

![用户登录并提交bug.gif](https://upload-images.jianshu.io/upload_images/12273007-a36c73a9f4707843.gif?imageMogr2/auto-orient/strip)

### 环境介绍
- 使用 java 作为编程语言
- 使用 Selenium WebDriver3 驱动浏览器
- 使用 eclipse 作为代码编写工具
- 使用 Git 进行版本管理，在 eclipse 中安装了 Git 的插件（EGit）方便代码的上传、更新，使用 Github 作为 Git 的远程仓库
- 使用 Testng 对测试用例进行管理，同时使用 Reportng 对 Testng 生成的测试报告进行美化
- 使用 Maven 对 项目的架包进行管理，同时对项目进行构建
- 使用Jenkins作为自动化持续集成工具，自动拉取代码，自动运行测试脚本，自动构建，自动邮件发送测试报告

### 业务逻辑介绍
- 自动化测试的对象为开源免费版的项目管理软件：禅道系统（之前特意在开源中国上找了一些免费开源的项目，发现很多都功能不全，说明文档也比较简单，操作起来不是很方便）
- 测试的功能相对来说比较简单（由于时间有限）：对禅道系统中的7个用户依次执行登录操作、提交 Bug的一系列操作、退出系统操作。

### 实现的功能
1.  实现了基于Selenium，WebDriver 常用操作方法的二次封装，包括（点击，输入，元素定位）等
2.  实现了失败重试的功能，使用了 Testng 提供的失败重试相关的监听类（IRetryAnalyzer），当测试运行失败时，会重复运行失败的 test 指定的次数，从而减少由于环境的不稳定导致测试运行失败的概率
3.  加入了测试运行失败自动截图的功能（使用了Testng 对测试结果进行监听的类：TestListenerAdapter，当监听到测试运行失败时，会自动调用自定义的截图方法进行截图，方便定位问题）
4.  使用 Java的日志系统：log4j 对测试运行的过程进行记录，同时在控制台和日志文件中生成相应的日志记录，方便调试以及定位问题
5.  使用 Java 的 properties文件对页面元素的定位方式进行存储，当页面元素发生改变时，只用修改 properties 文件，无需改动代码，从而实现了代码与数据的分离
6.  使用 properties 文件对log4j的 日志 进行配置
7.  使用 Testng 的 Dataprovider 对用户输入的数据进行参数化，从 Excel 中读取用户输入的数据，从而实现数据驱动
8.  使用 Reportng 对 Testng 生成的测试报告进行美化
9.  使用 Testng 对提交 Bug 操作前后，系统中的 Bug 数量进行断言
10.  使用 Jenkins 发送邮件的插件，将测试执行的结果发送给指定的接收人
11.  提供对多浏览器的支持（包括 Chrome、Firefox）

### 测试环境的准备
#### 禅道系统
在禅道系统中添加了 7 个用户，并授予了这 7 个用户提交 Bug
的权限，如下图所示：

![禅道.png](https://upload-images.jianshu.io/upload_images/12273007-f755fc6cfd73df3c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 测试数据

将用户登录输入的数据：用户名、密码，以及提交 Bug 输入的数据：Bug 的标题、Bug 的详细信息保存到 Excel 文件中，方便程序读取，如下图：

![用户输入数据png.png](https://upload-images.jianshu.io/upload_images/12273007-e172e81bc2829cbb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 软件工具
1. 搭建测试环境的过程中，需要安装 JDK ，并配置相应的环境变量，这个在网上很容易就能查到，不做介绍
2. 配置 Maven环境，包括 Maven 环境变量的配置， settings.xml 文件的配置，这部分在网上业很容易就能查到，不做介绍，介绍一下 pom.xml 文件的配置：在 pom.xml 文件中配置需要使用的 jar 包（包括 selenium，testng，log4j 等），以及构建过程中需要用到的插件（maven-compiler-plugin、maven-surefire-plugin等），pom.xml 文件 如下：

```
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>wysh</groupId>
	<artifactId>java_selenium_best</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>java_selenium_best</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.11</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.5</version>
		</dependency>
		<!-- <dependency> <groupId>junit</groupId> <artifactId>junit</artifactId> 
			<version>3.8.1</version> </dependency> -->
		<!-- reportNg的依赖包 关联testNg ， 这个包的主要作用就是对testng原生报告的美化 -->
		<dependency>
			<groupId>net.sourceforge.jexcelapi</groupId>
			<artifactId>jxl</artifactId>
			<version>2.6.12</version>
		</dependency>
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>

		<dependency>
			<groupId>org.uncommons</groupId>
			<artifactId>reportng</artifactId>
			<version>1.1.4</version>
			<exclusions>
				<exclusion>
					<groupId>org.testng</groupId>
					<artifactId>testng</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>com.google.inject</groupId>
			<artifactId>guice</artifactId>
			<version>4.0-beta5</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.directory.studio/org.apache.commons.io -->
		<dependency>
			<groupId>org.apache.directory.studio</groupId>
			<artifactId>org.apache.commons.io</artifactId>
			<version>2.4</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.7.1</version>
				<configuration>
					<properties> <property> <name>usedefaultlisteners</name> <value>false</value> 
						</property> <property> <name>listener</name> <value>org.uncommons.reportng.HTMLReporter</value> 
						</property> </properties>
					<testFailureIgnore>true</testFailureIgnore>
					<suiteXmlFiles>
						<suiteXmlFile>src/test/java/testWU.xml</suiteXmlFile>
						<!--此处testng.xml即为要运行的testng.xml文件 -->
					</suiteXmlFiles>
					<!-- <workingDirectory>test-output/</workingDirectory>  -->
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```
3. testng 环境：testng 配置文件的配置如下：
```
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" parallel="false">
  <parameter name ="username" value="admin"/>
	<parameter name ="password" value="Aa1234"/>
  <test name="Test_By_Vincent">
    <classes>
	<!-- <class name="wysh.java_selenium_best.Test1"/> -->
	<!-- <class name="wysh.java_selenium_best.TestLogin"/> -->
	<!-- <class name="wysh.selenium.testcase.TestLogin" />  -->
	<class name="wysh.selenium.testcase.TestLoginAndCommitBug" />
    </classes>
  </test> <!-- Test -->
  <listeners>
    <!--     <listener
 <!-- reportNg的依赖包 关联testNg ，这个包的主要作用就是对testng原生报告的美化-->
    class-name="org.uncommons.reportng.HTMLReporter" /> -->
        <listener class-name="org.uncommons.reportng.JUnitXMLReporter" />
         <listener class-name="wysh.selenium.util.RetryListener" />
        <listener class-name="wysh.selenium.util.TestNGListenerScreen" />
    </listeners>   
</suite> <!-- Suite -->
```
4. Git 环境：在 eclipse 中 安装 Git 插件：点击 help --> MarketPlace，可以通过如下地址安装：http://download.eclipse.org/egit/updates ，选择“Eclipse Git Team Provider”，不需要安装其他插件，直到结束。安装结束后，已经安装的插件会显示在 installed 选项卡中

![egit插件.png](https://upload-images.jianshu.io/upload_images/12273007-ee5403257c71bfef.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

通过 EGit ，可以进行代码的提交，更新操作

![team.png](https://upload-images.jianshu.io/upload_images/12273007-a6ae8ccce6489d84.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![commit.png](https://upload-images.jianshu.io/upload_images/12273007-84fa7472ef532d47.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![push.png](https://upload-images.jianshu.io/upload_images/12273007-17674e8eb34545be.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

5. Jenkins 环境
安装jenkins，同时在管理插件中安装相应的插件（包括Maven Integration plugin插件、邮件通知插件、Git 插件等等）

进入系统管理-->系统设置，设置好Jenkins中的JDK、mavenGithub、邮箱等环境

添加完毕后，我们开始创建Jenkins 项目：在Jenkins上新建一个自由风格的软件项目--> 在构建中选择lnvoke top-level Maven targets，在项目配置界面，配置源码管理，构建管理，构建后管理，如下图所示：

- 源码管理：

![源码管理.png](https://upload-images.jianshu.io/upload_images/12273007-c4097dfd38958dc4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 构建管理

![构建管理.png](https://upload-images.jianshu.io/upload_images/12273007-5ab6dccf8aa44748.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 构建后管理

![构建后管理png.png](https://upload-images.jianshu.io/upload_images/12273007-9bd23d214e140a81.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

同时，在邮箱通知的 Default Content 填写如下内容，发送邮件时，会将下面的内容添加到邮件的正文中：
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ENV, var="JOB_NAME"}-第${BUILD_NUMBER}次构建日志</title>
</head>

<body leftmargin="8" marginwidth="0" topmargin="8" marginheight="4"
    offset="0">
    <table width="95%" cellpadding="0" cellspacing="0"
        style="font-size: 11pt; font-family: Tahoma, Arial, Helvetica, sans-serif">
        <tr>
            <td>(本邮件是程序自动下发的，请勿回复！)</td>
        </tr>
        <tr>
            <td><h2>
                    <font color="#0000FF">${PROJECT_NAME}构建结果 - ${BUILD_STATUS}</font>
                </h2></td>
        </tr>
        <tr>
            <td><br />
            <b><font color="#0B610B">构建信息</font></b>
            <hr size="2" width="100%" align="center" /></td>
        </tr>
        <tr>
            <td>
                <ul>
                    <li>项目名称 ： ${PROJECT_NAME}</li>
                    <li>构建编号 ： 第${BUILD_NUMBER}次构建</li>
                    <li>GIT 版本： ${GIT_REVISION}</li>
                    <li>触发原因： ${CAUSE}</li>
                    <li>项目  Url ： <a href="${PROJECT_URL}">${PROJECT_URL}</a></li>
                    <li>构建日志： <a href="${BUILD_URL}console">${BUILD_URL}console</a></li>
                    <li>构建  Url ： <a href="${BUILD_URL}">${BUILD_URL}</a></li>
          <li>生成HTML报告 ： <a href="${PROJECT_URL}HTML_Report">
          ${PROJECT_URL}HTML_Report</a></li>
                   
                </ul>
            </td>
        </tr>
        <tr>
            <td><b><font color="#0B610B">Changes Since Last
                        Successful Build:</font></b>
            <hr size="2" width="100%" align="center" /></td>
        </tr>
        <tr>
            <td>
                <ul>
                    <li>历史变更记录 : <a href="${PROJECT_URL}changes">${PROJECT_URL}changes</a></li>
                </ul> ${CHANGES_SINCE_LAST_SUCCESS,reverse=true, format="Changes for Build #%n:<br />%c<br />",showPaths=true,changesFormat="
<pre>[%a]<br />%m</pre>",pathFormat="    %p"}
            </td>
        </tr>
        <tr>
            <td><pre
                    style="font-size: 11pt; font-family: Tahoma, Arial, Helvetica, sans-serif">$FAILED_TESTS</pre>
<br /></td>
        </tr>
        <tr>
            <td><b><font color="#0B610B">构建日志 (最后 100行):</font></b>
            <hr size="2" width="100%" align="center" /></td>
        </tr>
        <!-- <tr>
            <td>Test Logs (if test has ran): <a
                href="${PROJECT_URL}ws/TestResult/archive_logs/Log-Build-${BUILD_NUMBER}.zip">${PROJECT_URL}/ws/TestResult/archive_logs/Log-Build-${BUILD_NUMBER}.zip</a>
                <br />
            <br />
            </td>
        </tr> -->
        <tr>
            <td><textarea cols="80" rows="30" readonly="readonly"
                    style="font-family: Courier New">${BUILD_LOG, maxLines=100}</textarea>
            </td>
        </tr>
    </table>
</body>
</html>
```
当项目创建成功后，可以点击立即构建进行构建，点击控制台输出查看构建日志，如下图所示：

![构建.png](https://upload-images.jianshu.io/upload_images/12273007-2285cf40327e5935.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 控制台输出

启动jenkins构建后，会在控制台输出构建日志，如下图：

![控制台日志.png](https://upload-images.jianshu.io/upload_images/12273007-2fbae9473c114df0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 源代码
项目的目录结构如下图所示：

![代码结构.png](https://upload-images.jianshu.io/upload_images/12273007-022040f9c20439ad.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 本项目采用分层的自动化设计模式，以及 PO（页面对象）模型，从下到上依次分为页面（Page）层、操作（Handle）层、业务（Business）层、用例（Case）层，同时还有底层提供支撑的工具（Util）层、浏览器驱动（Base）层，每一层对应一个 Package 。

- 测试运行时，首先执行的是用例层，接着用例层调用业务层，业务层调用操作层，操作层调用页面层，此外，底层的工具（Util）层和浏览器驱动（Base）层为其他各层提供必要的支撑。

- 编写代码时，按照与测试运行逻辑相反的顺序进行编写：先编写底层的工具（Util）层和浏览器驱动（Base）层，接着依次编写页面（Page）层、操作（Handle）层、业（Business）务层、用例（Case）层

### 执行结果及分析
#### 测试报告
启动 jenkins 构建完成之后，会在 target\surefire-reports\html\ 目录下生成测试报告，点击该目录下的 index.html 文件可以打开测试报告，测试报告如下图所示：

![测试报告.png](https://upload-images.jianshu.io/upload_images/12273007-4bca6337a9737e55.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

从测试报告中可以看到，passed 4个，failed 3 个，Skipped	 2个。展开测试报告后，会显示详情信息（admin1、user3、user5执行失败，其他的四个用户执行成功，另外的 2 个跳过的是失败重试执行的）：

![报告_failed.png](https://upload-images.jianshu.io/upload_images/12273007-7fb60d1e8cd0a332.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![报告_passed.png](https://upload-images.jianshu.io/upload_images/12273007-45713ad269bf31e4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

测试报告显示的结果与设计的用例的预期一致，如下图：

![用例分析.jpg](https://upload-images.jianshu.io/upload_images/12273007-677998ff300ca5ec.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 日志

通过日志可以对测试执行的过程进行记录，同时也方便定位问题：


![日志.png](https://upload-images.jianshu.io/upload_images/12273007-d5585588ade116ad.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 邮件通知

在 jenkins 中设置无论构建结果构建结果如何，都会发送邮件，构建完成后，会向指定的邮箱发送邮件：

!![邮件通知.png](https://upload-images.jianshu.io/upload_images/12273007-0da58f438ad2d7a0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![邮件通知1.png](https://upload-images.jianshu.io/upload_images/12273007-281878e2e0e77a9a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

