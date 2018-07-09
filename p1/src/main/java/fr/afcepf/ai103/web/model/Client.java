package fr.afcepf.ai103.web.model;

public class Client {
    private String nom;
    private String prenom;
    private String email;
    private Integer age;
    
    
    //+get/set
    //+default constructor
    //+toString()
    
    
    @Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + age + "]";
	}
    
    
	public Client() {
		super();
		this.nom="";
		this.prenom="";
		this.email="...@...fr";
		this.age=0;
	}


	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
   
    
    
}
