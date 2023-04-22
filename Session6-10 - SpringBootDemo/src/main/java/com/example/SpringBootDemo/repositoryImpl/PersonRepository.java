package com.example.SpringBootDemo.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.SpringBootDemo.model.Person;

@Repository	
public class PersonRepository {
	
	private Connection connection;
	
	public PersonRepository(Connection connection) throws SQLException {
		this.connection = connection;
		createTable();
	}
	
	private static Logger logger = LoggerFactory.getLogger(PersonRepository.class);
	
	private PreparedStatement preparedStatement;
	
	private void createTable() throws SQLException {
		Statement statement = connection.createStatement();
		Boolean result = statement.execute("create table if not exists person (id int primary key auto_increment,"
				+ "first_name varchar(30),last_name varchar(30),age int , dob varchar(10))");
		logger.info("Create Table Operation - {}",result);
	}
	
	public void createPersonStatic(Person person) {
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into person(id,first_name,last_name,age,dob) VALUES "
					+ "(1,'PETER','DAVID',20,'1989-02-12')");
			
			logger.info("Insert Statement result - {} ",result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createPerson(Person person) {
		
		try {
			
			this.preparedStatement =connection.prepareStatement("insert into person(first_name,last_name,age,dob)"
					+ " VALUES(?,?,?,?)");
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setInt(3, person.getAge());
			preparedStatement.setString(4, person.getDob());
			
			int result = preparedStatement.executeUpdate();
			
			logger.info("Dynamic Insert Statement result - {} ",result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Person getPerson(int id) {
		
		try {
			this.preparedStatement =connection.prepareStatement("select * from person where id = ?");
			preparedStatement.setInt(1, id);
			
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				
				return getPersonFromResultset(resultset);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public Boolean deletePerson(int id) {
		try {
			this.preparedStatement =connection.prepareStatement("delete from person where id = ?");
			preparedStatement.setInt(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			logger.info("Delete Statement result - {}",result);
			return result >= 1 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Person> getAllPersons(){
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from person");
			
			List<Person> personList = new ArrayList<Person>();

			while(resultset.next()) {
				
				Person person = getPersonFromResultset(resultset);
				personList.add(person);
				
			}
			return personList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Person getPersonFromResultset(ResultSet resultset) throws SQLException {
		return Person.builder().id(resultset.getInt("id"))
				.firstName(resultset.getString("first_name"))
				.lastName(resultset.getString("last_name"))
				.age(resultset.getInt(4))
				.dob(resultset.getString(5))
				.build();
	}

}
