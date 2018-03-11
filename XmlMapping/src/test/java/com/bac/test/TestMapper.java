package com.bac.test;

import org.dozer.DozerBeanMapper;
import org.junit.After;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.bac.bean.Destination;
import com.bac.bean.Destination2;
import com.bac.bean.Source;
import com.bac.bean.Source2;
import com.bac.beans.custom.Person;
import com.bac.beans.custom.Personne;

/**
 * 
 * @author Qais
 *
 */
public class TestMapper {
	
	private static DozerBeanMapper mapper = null;
	private static Source source1 = null;
	private static Source2 source2 = null;
	
	
	@Before
	public void setup() {
		System.out.println("Calling setup()");
		mapper = new DozerBeanMapper();
		source1 = new Source();
		source2 = new Source2();
		
	}
	
	@After
	public void tearDown() {
		System.out.println("Calling tearDown()");
		mapper = null;
		source1 = null;
		source2 = null;
		
	}
	
	private void configureMapper(String... mappingFileUrls) {
	    mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
	}
	
	@Test
	public void testScenario1() {
		source1.setName("ABC");
		source1.setAge(32);
		//Dest dest = new Dest();
		//mapper.map(source, dest);
		Destination dest = mapper.map(source1, Destination.class);
		System.out.println(dest.getName() +" : "+ dest.getAge());
		assertEquals("ABC", dest.getName());
		assertEquals(32, dest.getAge());
		
	}
	
	@Test
	public void testScenario2() {
		source2.setId("1995");
		source2.setPoints(11);
		
		Destination2 dest = mapper.map(source2, Destination2.class);
		System.out.println(dest.getId() +" : "+ dest.getPoints());
		assertEquals(1995, dest.getId());
		assertEquals(11, dest.getPoints());
	}
	
	@Test
	public void testScenario3() {
	    configureMapper("dozer_mapping.xml");
	    Personne frenchAppPerson = new Personne("Sylvester Stallone", "Rambo", 70);
	    Person englishAppPerson = mapper.map(frenchAppPerson, Person.class);
	    System.out.println("Converted Object : "+englishAppPerson.getName()+", "+englishAppPerson.getNickName()+
	    		", "+englishAppPerson.getAge());
	    assertEquals(englishAppPerson.getName(), frenchAppPerson.getNom());
	    assertEquals(englishAppPerson.getNickName(), frenchAppPerson.getSurnom());
	    assertEquals(englishAppPerson.getAge(), frenchAppPerson.getAge());
	}
	
	@Test
	public void testScenario4() {
		configureMapper("dozer_mapping2.xml");
		Person englishAppPerson = new Person("Shawn Corey Carter","Jay Z", 46);
	    Personne frenchAppPerson = mapper.map(englishAppPerson, Personne.class);
	    System.out.println("Converted Object : "+frenchAppPerson.getNom()+", "+frenchAppPerson.getSurnom()+
	    		", "+frenchAppPerson.getAge());
	    assertEquals(frenchAppPerson.getNom(), englishAppPerson.getName());
	    assertEquals(frenchAppPerson.getSurnom(),englishAppPerson.getNickName());
	    assertEquals(frenchAppPerson.getAge(), 0);
	}

}
