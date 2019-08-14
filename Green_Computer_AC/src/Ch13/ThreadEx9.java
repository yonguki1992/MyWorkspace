package Ch13;

public class ThreadEx9 {

	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		//ThreadGroup(ThreadGroup parent, String name)
		//스레드 그룹의 하위 그룹을 만들기
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "Sub Group of Group1");
		
		grp1.setMaxPriority(3);//스레드 그룹의 최대 우선 순위를 3으로 제한
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
		};
		
		//Thread(ThreadGroup tg, Runnable r, String name)
		new Thread(grp1, 	r, "th1").start();
		new Thread(subGrp1, r, "th2").start();
		new Thread(grp2, 	r, "th3").start();
		
		System.out.println(">>List of ThreadGroup : "+ main.getName()
						 + ", Active ThreadGroup : " + main.activeGroupCount() 
						 + ", Active Thread : "+ main.activeCount());
		
		System.out.println("main 그룹 정보");		
		main.list();
		
		System.out.println("그룹 1 정보");
		grp1.list();
		
		System.out.println("서브 그룹 1 정보");
		subGrp1.list();
		
		System.out.println("그룹 2 정보");
		grp2.list();
	}

}
