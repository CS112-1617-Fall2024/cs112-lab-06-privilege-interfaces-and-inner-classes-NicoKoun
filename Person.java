public class Person implements Comparable
{
	/**
    * this class is used to represent you as a person according to multiple labels you provide
    * 
    * @author Nico Koundakjian
    * @version 1.0
    */
	private class Identity {
		/**
		* this class is used to store your identity
		* 
		* @author Nico Koundakjian
		* @version 1.0
		*/
		
		/*Instance Variables
		 * String pronouns: your pronouns
		 * String background: your background
		 */
		private String pronouns;
		private String background;

		//Constructors
    	/*
    	 * Default constructor: sets each of the variables to default values
     	 * @param: none
    	 * @return: none
    	 */
		public Identity() {
			this(DEFAULT_PRONOUNS, DEFAULT_BACKGROUND);
		}
  		/*
    	 * Parameterized constructor: sets each of the variables to the set parameters
    	 * @param: String p: the String that will be set to pronouns, String B: the String that will be set to background
     	 * @return: none
     	*/
		public Identity(String P, String B) {
			this.pronouns = P;
			this.background = B;
		}
		/**
    	 * ToString: the string that will apears when the Identity is printed
    	 * @param none
    	 * @return String: a string printing all of the data
    	*/
		@Override
		public String toString() {
			return "my personal pronouns are " + this.pronouns + " and " + this.background;
		}
		/**
    	 * equals: determines if a Identity has the same values as another object
    	 * @param object o: the other object that will be compaired
    	 * @return boolean: returns true if the objects are equal, returns false otherwise and if o is null or not a Identity
    	 */
		@Override
		public boolean equals(Object other){	
			if(other == null || (!(other instanceof Identity))) {
		    	return false;
			}
		
			Identity otherIdentity = (Identity) other;
			return this.pronouns.equals(otherIdentity.pronouns) && this.background.equals(otherIdentity.background);
		}
	}// end of Identity inner class
	// CONSTANT VARIABLES
	/*
	 * String DEFAULT_NAME: the default name of the person
	 * String DEFAULT_PRONOUNS: the default pronouns of the person
	 * String DEFAULT_BACKGROUND:the default background of the person
	 * int DEFAULT_PRIVILEGE: the default amount of privilege the person has
	 */
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_PRONOUNS = "they/them/theirs";
	public static final String DEFAULT_BACKGROUND =  "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	/*
	 * String name: the name of the person
	 * Identity story: the persons identity that contains pronouns and background
	 * int priviliege: the amount of privilege the person has
	 */
	private String name;
	private Identity story = new Identity();
	private int privilege;

	// CONSTRUCTORS	
	/*
     * Parameterized constructor: sets each of the variables to the set parameters
     * @param: String name: the String that will be set to name, String pronouns: the String that will be set to story.pronouns, String backgrounds: the String that will be set to story.background, int privilege: the int that will be set to privilege
     * @return: none
    */
	
	public Person(String name, String pronouns, String background, int privilege) {
		this.setAll(name, pronouns, background, privilege);
	}
	/*
     * Default constructor: sets each of the variables to default values
     * @param: none
     * @return: none
     */
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
	}
	/**
     * copy constructor: makes a shallow copy of another Person object
     * @param Person original: the Person that will be copied
     * @return: none
     */
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story.pronouns, original.story.background, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	/**
     * setName: will set the name of the Person
     * @param String Name: the new name of the Person
     * @return none
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * setPronouns: will set the pronouns of the Person's story identity
     * @param String pronouns: the new pronouns of the Person's story identity
     * @return none
     */
	public void setPronouns(String pronouns) {
		this.story.pronouns = pronouns;
	}
	/**
     * setBackground: will set the background of the Person's story identity
     * @param String background: the new background of the Person's story identity
     * @return none
     */
	public void setBackground(String background) {
		this.story.background = background;
	}
	/**
     * setPrivilege: will set the privilege of the Person
     * @param String privilege: the new privilege of the Person
     * @return none
     */
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}
	/**
     * setAll: will set the all of the instance variables of the Person
     * @param String Name: the new name of the Person, String pronouns: the new pronouns of the Person's story identity, String background: the new background of the Person's story identity, String privilege: the new privilege of the Person
     * @return none
     */
	public void setAll(String name, String pronouns, String background, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setPronouns(pronouns);
		this.setBackground(background);
	}

	// ACCESSORS / GETTERS
	/**
     * getName: will return the name of Person
     * @param none
     * @return String: name
     */
	public String getName() {
		return this.name;
	}
	
	/**
	 * getBackground: will return the background of Person's story identity
	 * @param none
	 * @return String: background
	 */
	public String getBackground() {
		return this.story.background;
	}
	/**
     * getPronouns: will return the pronouns of Person's story identity
     * @param none
     * @return String: pronouns
     */
	public String getPronouns() {
		return this.story.pronouns;
	}
	/**
     * getName: will return the privilege of Person
     * @param none
     * @return int: privilege
     */
	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	/**
     * ToString: the string that will apears when the Person is printed
     * @param none
     * @return String: a string printing all of the data
    */
	@Override
	public String toString()
	{
		return "My name is "+ this.name + this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	/**
    * equals: determines if a Person has the same values as another object
    * @param object o: the other object that will be compaired
    * @return boolean: returns true if the objects are equal, returns false otherwise and if o is null or not a Person
    */
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		    return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/**
     * compareTo: compares a Person to another Person object based on the natural ordering of people for this project, based on their privilege estimate
     * @param object other: the other object that will be compaired
     * @return int: returns 1 if this person has more privilege than the other, returns 0 if the privileges are equal, returns -1 if this person has less privilege than the other
    */
	@Override
	public int compareTo(Object other) {
		if (other == null || (!(other instanceof Person))) {
			throw new IllegalArgumentException("null given to compareTo method in person or not a person type");
		}
		
		Person otherPerson = (Person) other;

		if (this.privilege > otherPerson.privilege) {
			return 1;
		} else if (this.privilege == otherPerson.privilege) {
			return 0;
		} else {
			return -1;
		}

	}
}
