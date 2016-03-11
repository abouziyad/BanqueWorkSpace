package akl.banquesi.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	/*association bidirictionel un client peu avoir plusieurs compte
	//la clef etrangere "client" est defini dans la class Compte et elle est en mode Lazy paresseux cad qu'elle ne charge que les info concernant le client pas les compte
	si on met EAGER car sa charge toutes les info du client ainsi que les info compte ce qui charge l'appli (par defaut c'est LAZY
	*/
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client() {
		super();
	}
	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}
	
	
	//Getters & Setters
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
}
