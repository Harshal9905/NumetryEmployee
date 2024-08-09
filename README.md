# NumetryEmployee
Create a small project to learn spring boot restApi
Spring boot
Spring Boot is a Java framework that makes it easier to create and run Java applications. It simplifies the configuration and setup process, allowing developers to focus more on writing code for their applications.
Spring Boot, a module of the Spring framework, facilitates Rapid Application Development (RAD) capabilities.
What is Spring Boot?
Spring Boot is an open-source Java framework used to create a Micro Service. Spring boot is developed by Pivotal Team, and it provides a faster way to set up and an easier, configure, and run both simple and web-based applications. It is a combination of Spring Framework and Embedded Servers. The main goal of Spring Boot is to reduce development, unit test, and integration test time and in Spring Boot, there is no requirement for XML configuration.
Spring Boot Architecture
To understand the architecture of Spring Boot, let us first see different layers and classes present in it.
Layers in Spring Boot: There are four main layers in Spring Boot:
Presentation Layer: As the name suggests, it consists of views(i.e. frontend part)
Data Access Layer: CRUD (create, retrieve, update, delete) operations on the database comes under this category.
Service Layer: This consist of service classes and uses services provided by data access layers.
Integration Layer: It consists of web different web services(any service available over the internet and uses XML messaging system).
Then we have utility classes, validator classes and view classes.
All the services provided by the classes are implemented in their corresponding classes and are retrieved by implementing the dependency on those interfaces.
Spring Boot flow architecture
:

Since Spring boot uses all the features/modules of spring-like Spring data, Spring MVC etc. so the architecture is almost the same as spring MVC, except for the fact that there is no need of DAO and DAOImpl classes in Spring boot.
Creating a data access layer needs just a repository class instead which is implementing CRUD operation containing class.
A client makes the https request(PUT/GET)
Then it goes to controller and the controller mapped with that route as that of request handles it, and calls the service logic if required.
Business logic is performed in the service layer which might be performing the logic on the data from the database which is mapped through JPA with model/entity class
Finally, a JSP page is returned in the response if no error occurred.

Spring Boot simplifies Spring development by:
1.Auto-configuration:
2.Rapid application development (RAD):
3.Production-ready features:

SpringBoot Annotations:
 
1.@SpringBootApplication Annotation
This annotation is used to mark the main class of a Spring Boot application. It encapsulates @SpringBootConfiguration, @EnableAutoConfiguration, and @ComponentScan annotations with their default attributes.


2. @SpringBootConfiguration Annotation
It is a class-level annotation that is part of the Spring Boot framework. It implies that a class provides Spring Boot application configuration. It can be used as an alternative to Spring’s standard @Configuration annotation so that configuration can be found automatically. Most Spring Boot Applications use @SpringBootConfiguration via @SpringBootApplication. If an application uses @SpringBootApplication, it is already using @SpringBootConfiguration.




@SpringBootConfiguration
public class Application { 

	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args); 
	} 

	@Bean
	public StudentService studentService() { 
		return new StudentServiceImpl(); 
	} 
}
@EnableAutoConfiguration Annotation
This annotation auto-configures the beans that are present in the classpath. It simplifies the developer’s work by assuming the required beans from the classpath and configure it to run the application. This annotation is part of the spring boot framework. For example, when we illustrate the spring-boot-starter-web dependency in the classpath, Spring boot auto-configures Tomcat, and Spring MVC. The package of the class declaring the @EnableAutoConfiguration annotation is considered as the default. Therefore, we need to apply the @EnableAutoConfiguration annotation in the root package so that every sub-packages and class can be examined.
@Configuration
@EnableAutoConfiguration
public class Application { 

	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args); 
	} 

}
@ComponentScan Annotation
@ComponentScan tells Spring in which packages you have annotated classes that should be managed by Spring. So, for example, if you have a class annotated with @Controller which is in a package that is not scanned by Spring, you will not be able to use it as a Spring controller. So we can say @ComponentScan enables Spring to scan for things like configurations, controllers, services, and other components that are defined. Generally, @ComponentScan annotation is used with @Configuration annotation to specify the package for Spring to scan for components.

Mavren  -- Build tool of Java




@Configuration
@ComponentScan

// Main class 
public class Application { 

	// Main driver method 
	public static void main(String[] args) 
	{ 

		SpringApplication.run(Application.class, args); 
	} 
}

Request Handling and Controller annotations:
Some important annotations comes under this category are:
@Controller
@RestController
@RequestMapping
@RequestParam
@PathVariable
@RequestBody
@ResponseBody
@ModelAttribute

1. @Controller Annotation
This annotation provides Spring MVC features. It is used to create Controller classes and simultaneously it handles the HTTP requests. Generally we use @Controller annotation with @RequestMapping annotation to map HTTP requests with methods inside a controller class.
//Create a Java class and use @Controller annotation to make it controller class 
@Controller
public class MyController{ 
public String GFG(){ 
	//insert code here 
} 
}
2. @RestController Annotation
This annotation is used to handle REST APIs such as GET, PUT, POST, DELETE etc. and also used to create RESTful web services using Spring MVC.
It encapsulates @Controller annotation and @ResponseBody annotation with their default attributes.
@RestController = @Controller + @ResponseBody
//Create a Java class and use @RestController annotation 
// to make the class as a request handler 
@RestController
public class HelloController{ 
public String GFG(){ 
	//insert code here 
} 
}
3. @RequestMapping Annotation
This annotation is used to map the HTTP requests with the handler methods inside the controller class.
//Java program to demonstrate @RequestMapping annotation 
@RestController
public class MyController{ 
@RequestMapping(value=" ",method=RequestMapping.GET) 
public String GFG(){ 
	//insert code here 
} 
}
For handling specific HTTP requests we can use
@GetMapping
@PutMapping
@PostMapping
@PatchMapping
@DeleteMapping
4. @RequestParam Annotation
This annotation is basically used to obtain a parameter from URI. In other words, we can say that @RequestParam annotation is used to read the form data and binds the web request parameter to a specific controller method.

//Java code to demonstrate @RequestParam annotation 
@RestController
public class MyController{ 
	
@GetMapping("/authors") 
public String getAuthors(@RequestParam(name="authorName") String name){ 
	//insert code here 
} 
}
5. @PathVariable Annotation
This annotation is used to extract the data from the URI path. It binds the URL template path variable with method variable.
//Java Program to Demonstrate @PathVariable annotation 
@RestController
public class MyController{ 
	
	@GetMapping("/author/{authorName}") 
	public String getAuthorName(@PathVariable(name = "authorName") String name){ 
	//insert your code here 
	} 
	
}
6. @RequestBody Annotation
This annotation is used to convert HTTP requests from incoming JSON format to domain objects directly from request body. Here method parameter binds with the body of the HTTP request.
// Java Code to Demonstrate @RequestBody annotation 
@RestController
public class MyController{ 
	
@GetMapping("/author") 
public void printAuthor(@RequestBody Author author){ 
	//insert code here 
} 
} 

7. @ResponseBody Annotation
This annotation is used to convert the domain object into HTTP request in the form of JSON or any other text. Here, the return type of the method binds with the HTTP response body.
Java
//Java code to demonstrate @ResponseBody annotation 
@Controller
public class MyController{ 
	
public @ResponseBody Author getAuthor(){ 
	Author author = new Author(); 
	author.setName("GFG"); 
	author.setAge(20); 
	return author; 
} 
} 


