README

This repo is a sample of what I'm trying to acheive using Spring Test DBUnit.

Essentially I have three entities in src/main/java/com/springtests/model

Programme
Episode
Performer

Each has it's own ID field and a many to many relationship with a join table (prog_performer) that has three columns. PROGRAMMEID, EPISODEID and
PERFORMERID

The primary key should be defined as 'PRIMARY KEY (PROGRAMMEID, EPISODEID, PERFORMERID)' <----- MySQL create table snippet, full
creation SQL is

CREATE TABLE IF NOT EXISTS PROG_PERFORMER (
                                      PROGRAMMEID INT NOT NULL, EPISODEID INT NOT NULL, PERFORMERID INT NOT NULL,
                                      FOREIGN KEY (PROGRAMMEID) REFERENCES PROGRAMME(PROGRAMMEID),
                                      FOREIGN KEY (EPISODEID) REFERENCES EPISODE(EPISODEID), FOREIGN KEY (PERFORMERID) REFERENCES PERFORMER(PERFORMERID),
                                      PRIMARY KEY (PROGRAMMEID, EPISODEID, PERFORMERID)
                                  ) ENGINE=INNODB
                                  
I have created a simple test class using Spring Test DBUnit to test the @DatabaseSetup feature using the test data set found in
src/test/java/com/springtests/repo

The test class can be run with JUnit, try running src/test/java/com/springtests/repo/ITRepositoryTest.java

It will fail with the following exception

org.dbunit.DatabaseUnitException: Exception processing table name='prog_performer'
	at org.dbunit.operation.AbstractBatchOperation.execute(AbstractBatchOperation.java:231)
	at org.dbunit.operation.CompositeOperation.execute(CompositeOperation.java:79)
	at com.github.springtestdbunit.DbUnitRunner.setupOrTeardown(DbUnitRunner.java:194)
	at com.github.springtestdbunit.DbUnitRunner.beforeTestMethod(DbUnitRunner.java:66)
	at com.github.springtestdbunit.DbUnitTestExecutionListener.beforeTestMethod(DbUnitTestExecutionListener.java:186)
	at org.springframework.test.context.TestContextManager.beforeTestMethod(TestContextManager.java:368)
	at org.springframework.test.context.junit4.statements.RunBeforeTestMethodCallbacks.evaluate(RunBeforeTestMethodCallbacks.java:73)
	at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:83)
	at org.springframework.test.context.junit4.statements.SpringRepeat.evaluate(SpringRepeat.java:72)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:233)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:87)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:71)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:176)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)
Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '1-1' for key 'PRIMARY'
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)
	at java.lang.reflect.Constructor.newInstance(Unknown Source)
	at com.mysql.jdbc.Util.handleNewInstance(Util.java:408)
	at com.mysql.jdbc.Util.getInstance(Util.java:383)
	at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:1049)
	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:4226)
	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:4158)
	at com.mysql.jdbc.MysqlIO.sendCommand(MysqlIO.java:2615)
	at com.mysql.jdbc.MysqlIO.sqlQueryDirect(MysqlIO.java:2776)
	at com.mysql.jdbc.ConnectionImpl.execSQL(ConnectionImpl.java:2840)
	at com.mysql.jdbc.PreparedStatement.executeInternal(PreparedStatement.java:2082)
	at com.mysql.jdbc.PreparedStatement.execute(PreparedStatement.java:1302)
	at com.jolbox.bonecp.PreparedStatementHandle.execute(PreparedStatementHandle.java:140)
	at org.dbunit.database.statement.SimplePreparedStatement.addBatch(SimplePreparedStatement.java:80)
	at org.dbunit.database.statement.AutomaticPreparedBatchStatement.addBatch(AutomaticPreparedBatchStatement.java:70)
	at org.dbunit.operation.AbstractBatchOperation.execute(AbstractBatchOperation.java:213)
	... 25 more

The prog_performer table that is created as part of the @DatabaseSetup isn't setting the primary key as 'PRIMARY KEY (PROGRAMMEID, EPISODEID, PERFORMERID)'
instead it is doing 'PRIMARY KEY (PROGRAMMEID, EPISODEID)' or something similar. Hence the error :(
