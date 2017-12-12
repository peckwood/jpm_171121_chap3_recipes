Notable files:

- The @Test class are usually in `/src/main/java/com/mybatis3/o?/services/StudentServiceTest.java`
- mapper file: `/src/main/java/com/mybatis3/o2/mappers/StudentMapper.xml`

### o1: Handling enumeration types

#### Store enum name

- Mybatis supports persisting enum type properties out of the box. If table `students` has a `VARCHAR` column `gender`that stores either `MALE` or `FEMALE`, you can create an `Enum` class `Gender` and create a property `gender` in `Student`

  ```
  public enum Gender {
  	FEMALE,
  	MALE
  }

  ```

- MyBatis support it without any extra configuration

#### Store ordinal position

- note it is not the value of the Enum! ordinal position has nothing to do with the value of the value of Enum, it is decided by <u>declaration order</u>.

- register a type handler

  - java

    ```java
    configuration.getTypeHandlerRegistry().register(Gender.class, org.apache.ibatis.type.EnumOrdinalTypeHandler.class);
    ```

  - xml

    ```xml
    <typeHandler handler="org.apache.ibatis.type.EnumOrdinalTypeHandler" javaType="com.mybatis3.o1.domain.Gender"/>
    ```

- Be careful to use ordinal values to store in the DB. Ordinal values
  are assigned to enum values based on their order of declaration. If
  you change the <u>declaration order</u> in Gender enum, the data in the
  database and ordinal values will be mismatched. 

- Also note that since we are using `JDBC` type transaction manager, we need to commit the sessions manually.

  ```java
  	public void insertStudent(Student student){
  		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
  		try {
  			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
  			studentMapper.insertStudent(student);
  			sqlSession.commit();
  		} finally {
  			sqlSession.rollback();
  			sqlSession.close();
  		}
  	}
  ```

### o2: Handling the CLOB/BLOB types

Didn't write any code for this

### o3: Passing multiple input parameters 

1. pass a map containing the input parameters

2. ​

   ```xml
   	<select id="findAllStudentsByNameEmail" resultMap="studentResultMap">
   		select * from students
   			where name = #{param1} and email=#{param2}
   	</select>
   ```

   ​

3. use annotations

   1. mapper interface

      `List<Student> findAllStudentsByNameEmail(@Param("name") String name, @Param("email")String email);`

   2. mapper xml

      ```xml
      <select id="findAllStudentsByNameEmail" resultMap="studentResultMap">
      		select * from students where name = #{param1} and email=#{param2}
      </select>
      ```

### o4: Paginated ResultSets using RowBounds 

Didn't practice on this, PageHelper can do this, and you just need to tell it pageNum(页码) and pageSize(每页显示条数).

```
PageHelper.startPage(pageNum, pageSize);
		List<SiteVo> sites = findSites(siteVo, filter);
		PageInfo<SiteVo> pageInfo = new PageInfo<SiteVo>(sites);
		return pageInfo.getList();
```

### o5: Custom ResultSet processing using ResultSetHandler

### o6: Cache

