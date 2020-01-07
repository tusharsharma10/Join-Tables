# Join-Tables
Hibernate join tables
    Please check the following entities and the following output appears in console, dont know why the table is unable to create.  
    
     package com.learn.orm.entity;
        
        import java.io.Serializable;
        
        import javax.persistence.Column;
        import javax.persistence.EmbeddedId;
        import javax.persistence.Entity;
        import javax.persistence.Table;
        
        @Entity
        @Table(name="PGMEMBER")
        public class PGMember implements Serializable {
        
        	/**
        	 * 
        	 */
        	private static final long serialVersionUID = 1L;
        	@EmbeddedId
        	private PGMemberId id;
        	
        	
        
        	public PGMember() {
        		super();
        		// TODO Auto-generated constructor stub
        	}
        
        	public PGMember(PGMemberId id) {
        		super();
        		this.id = id;
        		
        	}
        
        	public PGMemberId getId() {
        		return id;
        	}
        
        	public void setId(PGMemberId id) {
        		this.id = id;
        	}
        
        	
        	
        	
        	
        	
        }
        
        
        
        
        
        
        
        
        
        package com.learn.orm.entity;
        
        import java.io.Serializable;
        
        import javax.persistence.Column;
        import javax.persistence.Embeddable;
        
        
        
        @Embeddable
        public class PGMemberId implements Serializable {
        	
        	private static final long serialVersionUID = 1L;
        	
        	@Column
        	private String pgName;
        	@Column	
        	private String member;
        	public PGMemberId() {
        		super();
        		// TODO Auto-generated constructor stub
        	}
        	public PGMemberId(String pgName, String member) {
        		super();
        		this.pgName = pgName;
        		this.member = member;
        	}
        	public String getPgName() {
        		return pgName;
        	}
        	public void setPgName(String pgName) {
        		this.pgName = pgName;
        	}
        	public String getMember() {
        		return member;
        	}
        	public void setMember(String member) {
        		this.member = member;
        	}
        	
        	
        	@Override
        	public boolean equals(Object obj) {
        		// TODO Auto-generated method stub
        		return super.equals(obj);
        	}
        	
        	
        	@Override
        	public int hashCode() {
        		// TODO Auto-generated method stub
        		return super.hashCode();
        	}
        }
        
        
        application.properties:
    spring.datasource.url= jdbc:mysql://localhost:3307/mapping
    
    spring.datasource.username=root
    
    spring.datasource.password=admin
    
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLInnoDBDialect
    
        
        
        
        
        Console:
          .   ____          _            __ _ _
         /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
        ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
         \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
          '  |____| .__|_| |_|_| |_\__, | / / / /
         =========|_|==============|___/=/_/_/_/
         :: Spring Boot ::        (v2.2.1.RELEASE)
        
        2020-01-07 22:43:14.820  INFO 12396 --- [           main] com.learn.orm.LearnOrmApplication        : Starting LearnOrmApplication on LAPTOP-B759SS03 with PID 12396 (E:\learn-space\learn-orm\target\classes started by Lenovo in E:\learn-space\learn-orm)
        2020-01-07 22:43:14.824  INFO 12396 --- [           main] com.learn.orm.LearnOrmApplication        : No active profile set, falling back to default profiles: default
        2020-01-07 22:43:15.437  INFO 12396 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
        2020-01-07 22:43:15.511  INFO 12396 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 64ms. Found 4 repository interfaces.
        2020-01-07 22:43:15.779  INFO 12396 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
        2020-01-07 22:43:16.002  INFO 12396 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
        2020-01-07 22:43:16.010  INFO 12396 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
        2020-01-07 22:43:16.010  INFO 12396 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.27]
        2020-01-07 22:43:16.113  INFO 12396 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
        2020-01-07 22:43:16.113  INFO 12396 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1246 ms
        2020-01-07 22:43:16.285  INFO 12396 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
        2020-01-07 22:43:16.362  INFO 12396 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.4.8.Final}
        2020-01-07 22:43:16.493  INFO 12396 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
        2020-01-07 22:43:16.610  INFO 12396 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
        2020-01-07 22:43:17.746  INFO 12396 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
        2020-01-07 22:43:17.785  INFO 12396 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQLInnoDBDialect
        Hibernate: create table pgmember (member varchar(255) not null, pg_name varchar(255) not null, primary key (member, pg_name)) type=InnoDB
        2020-01-07 22:43:18.682  WARN 12396 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "create table pgmember (member varchar(255) not null, pg_name varchar(255) not null, primary key (member, pg_name)) type=InnoDB" via JDBC Statement
        
        org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "create table pgmember (member varchar(255) not null, pg_name varchar(255) not null, primary key (member, pg_name)) type=InnoDB" via JDBC Statement
        	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67) ~[hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.applySqlString(AbstractSchemaMigrator.java:559) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.applySqlStrings(AbstractSchemaMigrator.java:504) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.createTable(AbstractSchemaMigrator.java:277) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.internal.GroupedSchemaMigratorImpl.performTablesMigration(GroupedSchemaMigratorImpl.java:71) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.performMigration(AbstractSchemaMigrator.java:207) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.doMigration(AbstractSchemaMigrator.java:114) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:184) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:73) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:320) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:462) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1249) [hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58) [spring-orm-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365) [spring-orm-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:391) [spring-orm-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:378) [spring-orm-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341) [spring-orm-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1862) [spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1799) [spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:595) [spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517) [spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323) [spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222) ~[spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321) [spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) [spring-beans-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1108) ~[spring-context-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:868) ~[spring-context-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:550) ~[spring-context-5.2.1.RELEASE.jar:5.2.1.RELEASE]
        	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:141) ~[spring-boot-2.2.1.RELEASE.jar:2.2.1.RELEASE]
        	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:747) ~[spring-boot-2.2.1.RELEASE.jar:2.2.1.RELEASE]
        	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) ~[spring-boot-2.2.1.RELEASE.jar:2.2.1.RELEASE]
        	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-2.2.1.RELEASE.jar:2.2.1.RELEASE]
        	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) ~[spring-boot-2.2.1.RELEASE.jar:2.2.1.RELEASE]
        	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1215) ~[spring-boot-2.2.1.RELEASE.jar:2.2.1.RELEASE]
        	at com.learn.orm.LearnOrmApplication.main(LearnOrmApplication.java:10) ~[classes/:na]
        Caused by: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'member varchar(255) not null, pg_name varchar(255) not null, primary key (member' at line 1
        	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120) ~[mysql-connector-java-8.0.18.jar:8.0.18]
        	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97) ~[mysql-connector-java-8.0.18.jar:8.0.18]
        	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-java-8.0.18.jar:8.0.18]
        	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:764) ~[mysql-connector-java-8.0.18.jar:8.0.18]
        	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:648) ~[mysql-connector-java-8.0.18.jar:8.0.18]
        	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:95) ~[HikariCP-3.4.1.jar:na]
        	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-3.4.1.jar:na]
        	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54) ~[hibernate-core-5.4.8.Final.jar:5.4.8.Final]
        	... 34 common frames omitted
        
        2020-01-07 22:43:18.794  INFO 12396 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
        2020-01-07 22:43:18.801  INFO 12396 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
        2020-01-07 22:43:19.326  WARN 12396 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
        2020-01-07 22:43:19.475  INFO 12396 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
        2020-01-07 22:43:19.673  INFO 12396 --- [           main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
        2020-01-07 22:43:19.679  INFO 12396 --- [           main] ConditionEvaluationReportLoggingListener : 
        
        Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
        2020-01-07 22:43:19.683 ERROR 12396 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 
        
        ***************************
        APPLICATION FAILED TO START
        ***************************
        
        Description:
        
        Web server failed to start. Port 8080 was already in use.
        
        Action:
        
        Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
        
        2020-01-07 22:43:19.686  INFO 12396 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
        2020-01-07 22:43:19.686  INFO 12396 --- [           main] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
        2020-01-07 22:43:19.688  INFO 12396 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
        2020-01-07 22:43:19.692  INFO 12396 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.


