package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "libros")
public class Book {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String author;
	private int pages;
	private double price;
	private String contact;
	private String editorial;
	private String isbn;
	
	@Transient
	private CommonsMultipartFile portada;
	
	@ManyToOne(cascade = { CascadeType.MERGE }, targetEntity = User.class, optional = false, fetch = FetchType.EAGER)
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "categoria_libro", joinColumns = {
			@JoinColumn(name = "libro_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "categoria_id", nullable = false, updatable = false) })
	private List<Categories> categories = new ArrayList<Categories>();

	public Book(long id, String title, String author, int pages, double price, String contact, String editorial,
			String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.contact = contact;
		this.editorial = editorial;
		this.isbn = isbn;
	}

	public Book(String title, String author, int pages, double price, String contact, String editorial, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.contact = contact;
		this.editorial = editorial;
		this.isbn = isbn;
	}

	public Book(long id, String title, String author, int pages, double price, String contact) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.contact = contact;
	}

	public Book(String title, String author, int pages, double price, String contact) {
		super();
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.contact = contact;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public CommonsMultipartFile getPortada() {
		return portada;
	}

	public void setPortada(CommonsMultipartFile portada) {
		this.portada = portada;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", title=" + title + ", author=" + author + ", pages=" + pages + ", price=" + price
				+ ", contact=" + contact + ", editorial=" + editorial + ", isbn=" + isbn + "]";
	}

}
