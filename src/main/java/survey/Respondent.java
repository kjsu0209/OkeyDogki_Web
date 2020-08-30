package survey;

public class Respondent {
	private String dogAge;
	private float dogWeight;
	private String dogName;
	
	
	public String getDogAge() {
		return dogAge;
	}
	public void setDogAge(String dogAge) {
		this.dogAge = dogAge;
	}
	public float getDogWeight() {
		return dogWeight;
	}
	public void setDogWeight(float dogWeight) {
		this.dogWeight = dogWeight;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public static int calculator(float weight, String age) {
		float amount = 0;
		if(age.equals("5개월 미만")) {
			amount = (float) (weight*0.05);
		}else if(age.equals("1살 미만")) {
			amount = (float) (weight*0.03);
		}else if(age.equals("3개월 미만")) {
			amount = (float) (weight*0.06);
		}else if(age.equals("1살 이상")) {
			amount = (float) (weight*0.025);
		}else if(age.equals("5살 이상")) {
			amount = (float) (weight*0.02);
		}else {
			amount = 0;
		}
		
		return (int)(amount*1000);
	}

}
