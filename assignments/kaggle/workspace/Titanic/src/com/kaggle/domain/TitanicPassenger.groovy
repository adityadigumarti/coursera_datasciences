package com.kaggle.domain

class TitanicPassenger {
	
	enum AgeEnum {
		CHILD, YOUNG, MIDDLE, OLD
		
		public static AgeEnum getEnum(float age) {
			def AgeEnum ageEnum = MIDDLE
			if(age >= 0 && age <= 5.0) {
				ageEnum = CHILD
			}else if(age <= 15.0) {
			    ageEnum = YOUNG 	    
			} else if(age > 65) {
			    ageEnum = OLD  
			}	 
			
			ageEnum
		}
	}
	
	int id
	boolean survived
	int pClass
	String sex
	AgeEnum ageEnum
	float age 
	int numSiblingsSpouses
	int numParentsChildren
	float fare
	int stationEmbarked
	
	
	public TitanicPassenger(String csv) {
		
			
			def array = csv.split(',')
			
			
			this.id = array[0].toInteger()
			this.survived = array[1].toBoolean()
			this.sex = array[4]
			this.pClass = array[2];
			this.age = array[5].empty? -1 : array[5].toFloat()
			this.ageEnum = AgeEnum.getEnum(age)
			this.numSiblingsSpouses = array[6].toInteger()
			this.numParentsChildren = array[7].toInteger()
			this.fare = array[9].toFloat()
			
			if(array.length == 12)
			this.stationEmbarked = array[11]
		
	}

	@Override
	public String toString() {
		return "TitanicPassenger [id=" + id + ", survived=" + survived + ", pClass=" + pClass + ", sex=" + sex + ", ageEnum="+ ageEnum + ", age=" + age + ", numSiblingsSpouses="
				+ numSiblingsSpouses + ", numParentsChildren="
				+ numParentsChildren + ", fare=" + fare + ", stationEmbarked="
				+ stationEmbarked + "]";
	}

	
	
	

}
