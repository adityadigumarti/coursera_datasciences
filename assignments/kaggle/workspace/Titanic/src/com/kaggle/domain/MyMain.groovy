package com.kaggle.domain

class MyMain {

	static main(args) {
		
		String s = /2,1,1,"Cumings, Mrs. John Bradley (Florence Briggs Thayer)",female,38,1,0,PC 17599,71.2833,C85,C/
		
		println s.replace("Cumings, Mrs. John Bradley (Florence Briggs Thayer)", "Cumings Mrs. John Bradley (Florence Briggs Thayer)")
		
		
		def passengers = []
		
		def train = new File('/Users/kdigu79/development/datasciences/assignments/kaggle/workspace/Titanic/src/com/kaggle/domain/train.csv')
		int count = 0;
		
		train.eachLine {
			count++;
			if (count == 1) {
				return;
			}
		
			passengers.add(new TitanicPassenger(replaceCommasInName(it)))
		
		}
		
		
		print passengers[0]
		
	}
	
	static String replaceCommasInName(String s) {
		s.findAll(/"(.*?)"/).each {
			s = s.replace(it, it.replaceAll(',', ''))
		}
		
		println s
		s
	}

}
