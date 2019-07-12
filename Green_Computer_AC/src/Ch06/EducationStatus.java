package Ch06;

public class EducationStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] info = { 
			{"대구", "홍서준", "90", "89"},
			{"인천", "김형준", "85", "88"},
			{"대구", "박진희", "87", "77"},
		    {"인천", "조규숙", "90", "97"},
		    {"인천", "김지숙",  "0", "87"},		
		    {"인천", "강정미", "90", "74"}	
		};
		
		Manager[] manager = new Manager[info.length];
		
		for(int i = 0; i < manager.length; ++i) {
			manager[i] = new Manager(info[i]);
		}

		System.out.println("지역    담당자     직무능력       의사소통         합계               평균    ");
		System.out.println("==========================================");
		for(Manager ma : manager) {
			System.out.println(ma.toString());
		}
	}

}

class Manager {
	String local;
	String manager;
	int jobAbillity;
	int communication;
	
	public Manager(String... info) {
		this.local = info[0];
		this.manager = info[1];
		this.jobAbillity = Integer.parseInt(info[2]);
		this.communication = Integer.parseInt(info[3]);
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLocal() {
		return this.local;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getManager() {
		return this.manager;
	}
	
	public void setJobAbillity(int jobAbillity) {
		this.jobAbillity = jobAbillity;
	}
	public int getJobAbillity() {
		return this.jobAbillity;
	}
	
	public void setCommunication(int communication) {
		this.communication = communication;
	}
	public int getCommunication() {
		return communication;
	}
	public int getSum() {
		return this.communication + this.jobAbillity;
	}	
	public float getAvg() {
		return getSum() / 2.0f;
	}
	public String toString() {
		return String.format("%2s    %3s         %-3d     %-3d     %-3d     %-3.2f", local, manager, jobAbillity, communication, getSum(), getAvg());
	}
}

