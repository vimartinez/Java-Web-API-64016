package jsf;

import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class Person {
	
	@NotBlank(message="El nombre de la persona no puede estar vacio!")
	private String name;
	@NotBlank(message="El mail no puede estar vacio!")
	@Size(min=10, max=50, message = "El mail debe tener entre 10 y 50 caracteres")
	private String mail;
	@Min(18)
	private Integer age;
	private String address;
	
	private Validator validator;
	
	public String validarDatos() {
		System.out.println("Validando datos del usuario");
		FacesContext context = FacesContext.getCurrentInstance();
		ValidatorFactory factory =  Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Set<ConstraintViolation<Person>> violations = validator.validate(this);
		for (ConstraintViolation<Person> violation : violations) {
			System.out.println(violation.getMessage());
			String fieldName = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			context.addMessage(fieldName, new FacesMessage(FacesMessage.SEVERITY_ERROR,message, null));
			return null;
		}
		return "inicio";
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
