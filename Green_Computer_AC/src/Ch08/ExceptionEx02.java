package Ch08;

public class ExceptionEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			install();
		} catch (InstallException ie) {
			// TODO: handle exception
			ie.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException se) {
			// TODO: handle exception
			InstallException ie = new InstallException("설치중 예외 발생");
			ie.initCause(se);
			throw ie;
		} catch (MemoryException me) {
			// TODO: handle exception
			InstallException ie = new InstallException("설치중 예외 발생");
			ie.initCause(me);
			throw ie;
		}
	}
	
	static void startInstall() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("설치공간 부족");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리 부족");
		}
	}
	
	static void copyFiles() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("설치공간 부족");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리 부족");
		}
	}
	
	
	static boolean enoughSpace() {
		return true;
	}
	
	static boolean enoughMemory() {
		return false;
	}
}

class SpaceException extends Exception {
	public SpaceException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}


class InstallException extends Exception {
	public InstallException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

class MemoryException extends Exception {
	public MemoryException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}