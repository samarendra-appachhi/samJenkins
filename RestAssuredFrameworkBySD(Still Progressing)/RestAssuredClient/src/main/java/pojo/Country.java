package pojo;

public class Country {
private int id;
public int getId() {
	return id;
}
public Country() {
	// default 
}
public Country(int id, String countryName, String population) {
	super();
	this.id = id;
	this.countryName = countryName;
	this.population = population;
}
public void setId(int id) {
	this.id = id;
}
public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
public String getPopulation() {
	return population;
}
public void setPopulation(String population) {
	this.population = population;
}
private String countryName;
private String population;
}
