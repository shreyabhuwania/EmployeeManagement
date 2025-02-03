package employee;

public class Joinee {
	
		private int id;
		private String name;
		private int dob;
		private String pan_no;
		private long aadhar_no;
		private String address;
		private String highest_education;
		private int passing_year;
		private String skills;
		//private blob pic;
		
		//constructor
		public Joinee() {
			
		}
		public Joinee(int id, String name, int dob, String pan_no,long aadhar_no,String add, String highest_education,
				int passing_year, String skills) {
			super();
			this.id = id;
			this.name = name;
			this.dob = dob;
			this.pan_no = pan_no;
			this.aadhar_no = aadhar_no;
			this.address = add;
			this.highest_education = highest_education;
			this.passing_year = passing_year;
			this.skills = skills;
		}
		
		//getters and setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getDob() {
			return dob;
		}
		public void setDob(int dob) {
			this.dob = dob;
		}
		public String getPan_no() {
			return pan_no;
		}
		public void setPan_no(String pan_no) {
			this.pan_no = pan_no;
		}
		public long getAadhar_no() {
			return aadhar_no;
		}
		public void setAadhar_no(long aadhar_no2) {
			this.aadhar_no = aadhar_no2;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address=address;
		}
		public String getHighest_education() {
			return highest_education;
		}
		public void setHighest_education(String highest_education) {
			this.highest_education = highest_education;
		}
		public int getPassing_year() {
			return passing_year;
		}
		public void setPassing_year(int passing_year) {
			this.passing_year = passing_year;
		}
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		
		//tostring
		@Override
		public String toString() {
			return "Joinee [id=" + id + ", name=" + name + ", dob=" + dob + ", pan_no=" + pan_no + ", aadhar_no="
					+ aadhar_no +", address= " + address + ", highest_education=" + highest_education + ", passing_year=" + passing_year
					+ ", skills=" + skills + "]";
		}
		
}
