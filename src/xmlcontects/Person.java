package xmlcontects;




public class Person {

	private String name;
	private String surname;
	private String sex;
	private String tNumber;
	
	public Person(String name, String surname, String sex, String tNumber ){
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.tNumber = tNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String isSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String gettNumber() {
		return tNumber;
	}

	public void settNumber(String tNumber) {
		this.tNumber = tNumber;
	}
	
	public String toString() {
        return "Employee:: Name=" + this.name
        		+ "Surname = "+ this.surname
        		+ "Sex = " + this.sex 
        		+ " Telephone number=" + this.tNumber;
    }
	
}

