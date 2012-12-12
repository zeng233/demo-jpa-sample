jdk1.6 , maven3 , git , eclipse

1. 	下载jdk1.6.0_27
 	
		1.1 安装 C:\Program Files\Java\jdk1.6.0_27
		
		1.2 配置系统环境变量，
			JAVA_HOME=C:\Program Files\Java\jdk1.6.0_27
		
		1.3 在CLASSPATH中添加
			%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar
			
		1.4 在PATH中添加	
			%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin
			这里注意CLASSPATH之前一定有个点,例如.c:\xx;c:\yy


2.	下载apache-maven-3.0.4

		1.1 安装 C:\Program Files\Apache Software Foundation
		1.2 配置系统环境变量 
			MAVEN_HOME=C:\Program Files\Apache Software Foundation\apache-maven-3.0.4

3.	下载Git-1.8.0-preview20121022

		1.1 安装 C:\Program Files\Git
		1.2 配置系统环境变量
			HOME = C:\Users\xchen7129752.HGSTGLOBAL
			
			之前有人说HOME=%USERPROFILE%,但是在eclipse配置的时候会出错，这里直接写死了
			
4. 	下载eclipse-jee-juno-win32.zip

		1.1 安装 C:\Program Files\eclipse\eclipse.exe
		1.2 安装插件 
			Gradle Integration for Eclipse
			Maven Integration for Eclipse
			Maven Integration for Eclipse WTP(incubation)
			
			Spring Tools Suite(STS) for Eclipse Juno
			JBoss Tools(Juno)
			Groovy-Eclipse for Juno
			Groovy/Grails Tool Suite(GGTS) fir Eclipse Juno
			
			Subclipse
			EGit
			
			Aptana Studio 3
		
		



	
		
	
